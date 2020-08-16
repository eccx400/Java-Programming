   package jk.mega.dGun;
   import ags.utils.*;
   import robocode.*;
   import robocode.util.Utils;
   import java.awt.Color;
   import java.awt.geom.*;
   import java.util.*;
   import jk.mega.*;;


    public class DrussGunDC {
      final static boolean TC = false;
   
      AdvancedRobot bot;
      static Point2D.Double myLocation, myNextLocation;
      private static double BULLET_POWER = 1.9;
      ArrayList<Double> lateralVelocities = new ArrayList<Double>(1000);
      ArrayList<Point2D.Double> enemyLocations = new ArrayList<Point2D.Double>(1000);
      ArrayList<Point2D.Double> precisePredictionPoints;
      static ArrayList<DCWave> waveList, removeList;
      double lastDirection = 1, lastVelocity = 0, lastHeading = 0;
      int timeSinceDirChange = 0, timeSinceDecel = 0, timeSinceAccel = 0;
      public static int bulletsPassed = 0;
      public static int bulletsHit = 0;
      boolean firstScan = true;
      public static double currentGF = 0;
      public double nextAbsBearing;
      StoreScan lastStoreScan;
   	
       public DrussGunDC(AdvancedRobot bot){
         waveList = new ArrayList<DCWave>();
         removeList = new ArrayList<DCWave>();
         this.bot = bot;
         System.out.println("My hitrate: " + (double)bulletsHit/bulletsPassed);
         System.out.println("Actual hits: " + bulletsHit);
         System.out.println("DC gun score: " + DCWave.DCHits);
         // System.out.println("PM gun score: " + DCWave.PMHits);
         System.out.println("AS gun score: " + DCWave.ASHits);
         // System.out.println("DC-AS gun score: " + DCWave.DCASHits);
         System.out.println("gun: " 
            + (DCWave.GUN == DCWave.DC?"DC":"") 
            // + (DCWave.GUN == DCWave.PM?"PM":"")
            + (DCWave.GUN == DCWave.AS?"AS":"")
            // + (DCWave.GUN == DCWave.DCAS?"DC-AS":"")
            );
         // DCWave.pmgun.endOfRound();
      }
   
       public void onScannedRobot(ScannedRobotEvent e, 
       Point2D.Double futurePoint, 
       double futureVelocity,
       double futureHeading,
       int timeInFuture){
         myLocation = new Point2D.Double(bot.getX(), bot.getY());
      
         double absBearing = bot.getHeadingRadians() + e.getBearingRadians();
         Point2D.Double enemyLocation = JKDCUtils.project(myLocation, absBearing, e.getDistance());
         
         enemyLocations.add(0,enemyLocation);
      
         boolean rammer =  e.getDistance() < 150 ;
         if(TC)
            BULLET_POWER = Math.min(3,bot.getEnergy());
         else{
            double basePower = 1.95;
            try{
               if((double)bulletsHit/bulletsPassed > 1.0/3.0)
                  basePower = 2.95;}
                catch(Exception ex){}
            double minBP = 0.15;
            double enemyEnergyBP = (e.getEnergy() + 0.09)/4;
            double energyBP = bot.getEnergy()/40;
            BULLET_POWER = rammer?2.95
               :Math.max(minBP,
               Math.ceil(10*(0.05 +
               Math.min(enemyEnergyBP,Math.min(energyBP,basePower)))
               )/10 - 0.05
               
               );
               //creates a stepped function which continues to exploit the x.x5 bug 
         		// even at lower energies
         	//	round(10*(min(1.95,x/20) + 0.05))/10 - 0.05
         }
          
         double velocity = e.getVelocity();
         double offset = Utils.normalAbsoluteAngle(e.getHeadingRadians() - absBearing);
         double lateralVelocity = velocity*FastTrig.sin(offset);
         double advancingVelocity = -velocity*FastTrig.cos(offset);
         double distance = e.getDistance();
         double direction = Math.signum(lateralVelocity);
         if(direction == 0)
            direction = lastDirection;
               
         lastDirection = direction;
      		
      		
         double accel = 1;
         if(Math.abs(velocity) > Math.abs(lastVelocity))
            accel = 2;
         else if(Math.abs(velocity) < Math.abs(lastVelocity))
            accel = 0;
            
         if(direction == lastDirection)
            timeSinceDirChange++;
         else 
            timeSinceDirChange = 0;
            
         if(accel == 0)
            timeSinceDecel = 0;
         else 
            timeSinceDecel++;
            
         if(accel == 2)
            timeSinceAccel = 0;
         else 
            timeSinceAccel++;
      	
         lateralVelocities.add(0,new Double(lateralVelocity));
         
      
         double distLast10 = enemyLocation.distance(enemyLocations.get(Math.min(10,enemyLocations.size() - 1)));
      
         double distLast20 = enemyLocation.distance(enemyLocations.get(Math.min(20,enemyLocations.size() - 1)));
      
         double distLast30 = enemyLocation.distance(enemyLocations.get(Math.min(30,enemyLocations.size() - 1)));
      
      
         double maxEscapeAngle = JKDCUtils.maxEscapeAngle(JKDCUtils.bulletVelocity(BULLET_POWER));
         // double forwardWall = JKDCUtils.wallDistance(distance, absBearing, direction, myLocation)/maxEscapeAngle;
         // double reverseWall = JKDCUtils.wallDistance(distance, absBearing, -direction, myLocation)/maxEscapeAngle;
         
         double BFT = e.getDistance()/JKDCUtils.bulletVelocity(BULLET_POWER);
         precisePredictionPoints = new ArrayList<Point2D.Double>(6);
         double[] preciseMEAs = PreciseMinMaxGFs.getPreciseMEAs(
            enemyLocation,e.getHeadingRadians(),e.getVelocity(),
            myLocation,BULLET_POWER,direction,
            precisePredictionPoints);
         double forwardWall = preciseMEAs[1]/maxEscapeAngle;
         double reverseWall = preciseMEAs[0]/maxEscapeAngle;
         // double[] preciseMEAs = new double[]{maxEscapeAngle,maxEscapeAngle};  
      	
      	   
         Point2D.Double centerPoint = new Point2D.Double(
            (enemyLocation.x + myLocation.x)*0.5,
            (enemyLocation.y + myLocation.y)*0.5);
      	
         Point2D.Double mirrorTarget = new Point2D.Double(2*centerPoint.x - futurePoint.x,
            2*centerPoint.y - futurePoint.y);
            
         double mirrorBearing = JKDCUtils.absoluteBearing(myLocation, mirrorTarget);
      		
         double mirrorOffset = Utils.normalRelativeAngle(mirrorBearing - absBearing)
            *direction;
      	
      	
         DCRobotState rs = new DCRobotState();
         rs.direction = direction;
         rs.latVel = lateralVelocity;
         rs.advVel= advancingVelocity;
         rs.vel = e.getVelocity();
         rs.deltaHeading = firstScan?0:Utils.normalRelativeAngle(e.getHeadingRadians() - lastHeading);
         rs.heading = e.getHeadingRadians();
         rs.offset = offset;
         rs.distance = distance;
         rs.timeSinceDirChange = timeSinceDirChange;
         rs.accel = accel;
         rs.timeSinceDecel = timeSinceDecel;
         rs.timeSinceAccel = timeSinceAccel;
         rs.distLast30 = Math.abs(distLast30);
         rs.distLast20 = Math.abs(distLast20);
         rs.distLast10 = Math.abs(distLast10);
         rs.forwardWall = forwardWall;
         rs.reverseWall = reverseWall;
         rs.location = myLocation;
         rs.enemyLocation = enemyLocation;
         rs.time = bot.getTime();
         rs.firstScan = firstScan;
         rs.currentGF = currentGF;
         rs.mirrorOffset = mirrorOffset;
         rs.BFT = BFT;  
         rs.MEA_pos = preciseMEAs[1];
         rs.MEA_neg = preciseMEAs[0];
         
         double myVel = bot.getVelocity();
         double maxTurn = Math.PI/18 - (Math.PI/240)*Math.abs(myVel);
         double turn = JKDCUtils.limit(-maxTurn,bot.getTurnRemainingRadians(), maxTurn);
         double heading = bot.getHeadingRadians() + turn;
         double distRem = bot.getDistanceRemaining();
         if(myVel < 0){
            myVel = -myVel;
            heading += Math.PI;
            distRem = -distRem;
         }
         double nextVel;
         if(myVel >= 0 && distRem > JKDCUtils.decelDistance(Math.abs(myVel)))
            nextVel = JKDCUtils.limit(0,Math.abs(myVel) + 1, 8);
         else if(distRem < JKDCUtils.decelDistance(Math.abs(myVel)))
            nextVel = JKDCUtils.limit(-1.9999999,Math.abs(myVel) - 2, 6);
         else
            nextVel = Math.abs(bot.getVelocity());
         
         myNextLocation = JKDCUtils.project(myLocation,heading,nextVel);
         // Point2D.Double nextEnemyLocation = 
            // JKDCUtils.project(enemyLocation,e.getVelocity(),e.getHeadingRadians());
         nextAbsBearing = JKDCUtils.absoluteBearing(myNextLocation,enemyLocation);
      	
         DCWave wave = new DCWave(bot);
         wave.gunLocation = myNextLocation;
         DCWave.targetLocation = enemyLocation;
         wave.lateralDirection = direction;
         wave.bulletPower = BULLET_POWER;
         wave.setSegmentations(rs);
         wave.bearing = nextAbsBearing;
         wave.bulletFired = false;
         if(lastStoreScan == null)
            lastStoreScan = wave.storeScan;
         wave.storeScan.previous = lastStoreScan;
         lastStoreScan = wave.storeScan;
         
         boolean gunAimed = false;
         boolean gunFinishedTurning = 0 == bot.getGunTurnRemainingRadians();
         if( ((TC && bot.getEnergy() != 0.0) || bot.getEnergy() > wave.bulletPower) && maxEscapeAngle/(Math.PI/9 - Math.PI/18) + 0.99> bot.getGunHeat()/bot.getGunCoolingRate() && e.getEnergy() > 0){
           
            double mostVisitedOffset =  wave.mostVisitedBearingOffset();
            
            bot.setTurnGunRightRadians(Utils.normalRelativeAngle(bot.getHeadingRadians() + e.getBearingRadians()
               - bot.getGunHeadingRadians() + mostVisitedOffset));
            if(Math.abs(bot.getGunTurnRemainingRadians()) < Math.abs(18/e.getDistance()))
               gunAimed = true;
            bot.setTurnGunRightRadians(Utils.normalRelativeAngle(nextAbsBearing
               - bot.getGunHeadingRadians() + mostVisitedOffset));  
         	
         }
         else
            bot.setTurnGunRightRadians(Utils.normalRelativeAngle(absBearing - bot.getGunHeadingRadians()));
      
         boolean dataExists = wave.heapTree.size() > 0;
         Bullet b = null;
         if (!TC && bot.getEnergy() > wave.bulletPower) {
            // if(gunAimed
            // ||( Math.max(Math.max(DCWave.DCHits, DCWave.PMHits),DCWave.ASHits)
            //  <= 1.1*bulletsHit && gunFinishedTurning)
            //  ||  Math.max(Math.max(DCWave.DCHits, DCWave.PMHits),DCWave.ASHits)
            //  <= .9*bulletsHit
            //  )
            if(gunFinishedTurning)
               if(dataExists)
                  b = bot.setFireBullet(wave.bulletPower);
                     //wave.bulletFired = true;
               
            waveList.add(0,wave);
            if(b != null){
               DCWave w = waveList.get(1);
               w.bulletFired = true;
               w.bullet = b;
            }
         }
         if(TC && bot.getEnergy() != 0.0){
            if(gunAimed && dataExists)
               b = bot.setFireBullet(wave.bulletPower);
                     //wave.bulletFired = true;
               
            waveList.add(0,wave);
            if(b != null){
               DCWave w = waveList.get(1);
               w.bulletFired = true;
               w.bullet = b;
            }
         }    
      	
      
         Iterator<DCWave> it = waveList.iterator();
      
         while(it.hasNext()){
            if(it.next().test())
               it.remove();
         }
      
         
         lastVelocity = velocity;
         lastHeading = e.getHeadingRadians();
         firstScan = false;
      
      }
      
       public void onBulletHit(BulletHitEvent e){
         bulletsHit++;
         
         Iterator<DCWave> it = waveList.iterator();
      
         while(it.hasNext()){
            DCWave w = it.next();
            if(w.bullet != null && e.getBullet() == w.bullet){
               double normAngle = Utils.normalRelativeAngle(w.bullet.getHeadingRadians() - w.bearing)
                  *w.lateralDirection;
               double GF = normAngle/w.MEA_norm;
               // if(normAngle > 0)
                  // GF = normAngle/w.MEA_pos;
               // else
                  // GF = normAngle/w.MEA_neg;
               w.logASBuffer(GF,-3);
            }  
         	
         }
      	
      	//log negative 'hit' to that wave, weight -2, for AS gun
      }
       public void onBulletHitBullet(BulletHitBulletEvent e){   
         Iterator<DCWave> it = waveList.iterator();
      
         while(it.hasNext()){
            DCWave w = it.next();
            if(w.bullet != null && e.getBullet() == w.bullet){
               double normAngle = Utils.normalRelativeAngle(w.bullet.getHeadingRadians() - w.bearing)
                  *w.lateralDirection;
                  
               double GF = normAngle/w.MEA_norm;
               // if(normAngle > 0)
                  // GF = normAngle/w.MEA_pos;
               // else
                  // GF = normAngle/w.MEA_neg;
                  
               w.logASBuffer(GF,-3);
               w.bullet = null;
               w.bulletFired = false;
            }  
         	
         }
      	
      	//log negative 'hit' to that wave, weight -2, for AS gun
      }
      
       public void onPaint(java.awt.Graphics2D g) {
      
         for(int i = 0, j = waveList.size(); i < j; i++){
            DCWave w = waveList.get(i);
            if(i == 0){
               g.setColor(Color.green);
               Point2D.Double nmea = JKDCUtils.project(w.gunLocation,w.bearing - w.lateralDirection*w.MEA_neg,1000);
               g.drawLine((int)w.gunLocation.x, (int)w.gunLocation.y,(int)nmea.x, (int)nmea.y);
               g.setColor(Color.red);
               Point2D.Double pmea = JKDCUtils.project(w.gunLocation,w.bearing + w.lateralDirection*w.MEA_pos,1000);
               g.drawLine((int)w.gunLocation.x, (int)w.gunLocation.y,(int)pmea.x, (int)pmea.y);
              
               g.setColor(Color.red);
               if(precisePredictionPoints != null)
                  for(int k = 0; k < precisePredictionPoints.size(); k++){
                     Point2D.Double p = precisePredictionPoints.get(k);
                     g.drawOval((int)(p.x - 2),(int)(p.y - 2), (int)(2*2),(int)(2*2));
                  }
            
            
            }
            if(w.bulletFired){
               Point2D.Double center = w.gunLocation;
               double radius = (DCWave.currentTime - w.fireTime)*JKDCUtils.bulletVelocity(w.bulletPower);
               g.setColor(Color.red);
               g.drawOval((int)(w.gunLocation.x - radius),(int)(w.gunLocation.y - radius), (int)(radius*2),(int)(radius*2));
               double lastRadius = radius - JKDCUtils.bulletVelocity(w.bulletPower);
               g.setColor(Color.green);
               g.drawOval((int)(w.gunLocation.x - lastRadius),(int)(w.gunLocation.y - lastRadius), (int)(lastRadius*2),(int)(lastRadius*2));
               
            
               g.setColor(Color.gray);
               double ASAngle = w.ASOffset + w.bearing;
               Point2D.Double ASLoc = JKDCUtils.project(w.gunLocation,ASAngle,radius);
               g.drawLine((int)w.gunLocation.x, (int)w.gunLocation.y,(int)ASLoc.x, (int)ASLoc.y);
               
               g.setColor(Color.orange);
               double mainGunAngle = w.DCOffset + w.bearing;
               Point2D.Double mgLoc = JKDCUtils.project(w.gunLocation,mainGunAngle,radius);
               g.drawLine((int)w.gunLocation.x, (int)w.gunLocation.y,(int)mgLoc.x, (int)mgLoc.y);
               
               
               g.setColor(Color.cyan);
               if(DCWave.paintPoints.size() > 1){
                  Point2D.Double p = (Point2D.Double)(DCWave.paintPoints.get(0));
                  for(int x = 1; x < DCWave.paintPoints.size(); x++){
                     Point2D.Double pp = (Point2D.Double)(DCWave.paintPoints.get(x));
                  //    g.drawOval((int)(pp.x - 1), (int)(pp.y - 1), 2, 2);
                     g.drawLine((int)p.x, (int)p.y,(int)pp.x, (int)pp.y);
                     p = pp;
                  }
               }
               
               if(w.intersecting){
                  g.setColor(Color.white);
                  double angle1 = w.storeScan.range.min;
                  if(angle1 > 0)
                     angle1 = angle1*w.MEA_pos*w.lateralDirection + w.bearing;
                  else
                     angle1 = angle1*w.MEA_neg*w.lateralDirection + w.bearing;
                     
                  double angle2 = w.storeScan.range.max;
                  if(angle2 > 0)
                     angle2 = angle2*w.MEA_pos*w.lateralDirection + w.bearing;
                  else
                     angle2 = angle2*w.MEA_neg*w.lateralDirection + w.bearing;
                  
                  Point2D.Double p1 = JKDCUtils.project(w.gunLocation,angle1,radius);
                  Point2D.Double p2 = JKDCUtils.project(w.gunLocation,angle2,radius);
                  g.drawLine((int)w.gunLocation.x, (int)w.gunLocation.y,(int)p1.x, (int)p1.y);
                  g.drawLine((int)w.gunLocation.x, (int)w.gunLocation.y,(int)p2.x, (int)p2.y);
               
               
               }
               
            }
         }
         if(enemyLocations.size() > 0){
            g.setColor(Color.white);
            Point2D.Double enemyLocation = enemyLocations.get(0);
            g.drawRect((int)enemyLocation.x - 18, (int)enemyLocation.y - 18, 36,36);
         
         
         }
      }
   }
    class DCRobotState {
      double direction,
      deltaHeading,
      vel,
      heading,
         latVel, 
         advVel, 
      	offset,
         distance, 
         timeSinceDirChange,
         accel,
         distLast30,
         distLast20,
         distLast10,
         forwardWall,
         reverseWall,
         timeSinceDecel,
         timeSinceAccel,
      	BFT,
      	currentGF,
      	mirrorOffset,
      	MEA_pos,
      	MEA_neg;
         
      double hitGF;
         
      Point2D.Double location, enemyLocation;
      long time;
      
      boolean firstScan;
    
      	
       public double[] location(){
      
         return  new double[]{
                  Math.abs(latVel/8)*10, 
                  JKDCUtils.limit(0,advVel/16 + 0.5,1)*2, 
               // 	JKDCUtils.limit(0,offset/Math.PI, 1),
                 JKDCUtils.limit(0,distance/900,1)*5, 
               	accel/2.0*10,
                 //  JKDCUtils.limit(0,distLast30/(8*30),1)*2, 
                 // JKDCUtils.limit(0,distLast20/(8*20),1)*2, 
                  JKDCUtils.limit(0,distLast10/(8*10),1)*3,
                  JKDCUtils.limit(0,forwardWall/1.5,1)*5,
                  JKDCUtils.limit(0,reverseWall,1)*2,
                  1/(1 + 2*timeSinceDirChange/BFT) * 3,
                  1/(1 + 2*timeSinceDecel/BFT)*3
               	,
               	JKDCUtils.limit(0,currentGF + 1,2)/2*3
               	,
                 	JKDCUtils.limit(0,mirrorOffset + 1,2)/2*2
                 //   timeSinceAccel*4
               	}
            ;
      }
      // public double[] ASLocation(){
      // 
         // return  new double[]{
               //    Math.abs(latVel/8)*10, 
               //  //   JKDCUtils.limit(0,advVel/16 + 0.5,1)*2, 
               // // 	JKDCUtils.limit(0,offset/Math.PI, 1),
               //   JKDCUtils.limit(0,distance/900,1)*5, 
               // 	accel/2.0*10,
               //   //  JKDCUtils.limit(0,distLast30/(8*30),1)*2, 
               //   // JKDCUtils.limit(0,distLast20/(8*20),1)*2, 
               // //    JKDCUtils.limit(0,distLast10/(8*10),1)*3,
               //    JKDCUtils.limit(0,forwardWall/1.5,1)*5,
               //   //  JKDCUtils.limit(0,reverseWall,1)*2,
               //  //   1/(1 + 2*timeSinceDirChange/BFT) * 3,
               //   //  1/(1 + 2*timeSinceDecel/BFT)*3,
               // 	// JKDCUtils.limit(0,currentGF + 1,2)/2*3
               //   //   timeSinceAccel*4
               // 	}
            // ;
      // }   	
      
   }
    class GFRange implements Comparable{
      double max = -1,min = 1,center = 0,width = 0;
       public int compareTo(Object g){
         if(center < ((GFRange)g).center)
            return -1;
         return 1;
      }
   }  
    class StoreScan{
      GFRange range = new GFRange();
      double[] location;// ,ASLocation;
      StoreScan previous;
   }
	
	
    class DCWave  {
      static ArrayList paintPoints = new ArrayList();
    
      public static final double ANGLE_SCALE = 24;
    
      static int ASHits,DCHits, actualHits, DCASHits;// PMHits, 
      static Point2D.Double targetLocation;
      static double targetHeading;
      static int GUN = 0;
      static final int DC = 0, PM = 1, AS = 2, DCAS = 3;
     
      long fireTime;
      double bulletPower;
      Point2D.Double gunLocation;
      double bearing;
      double lateralDirection;
      double MEA_pos, MEA_neg, MEA_norm;;
      double BFT;
      boolean bulletFired = false;
      double[] currentASBuffer;
      int[] ASIndexes;
      Bullet bullet;
   
      // static MyTree<StoreScan> tree;
   //       static Brutus<StoreScan> brutus;
      static KdTree<StoreScan> heapTree;//, ASTree;
      
      static double[][][][] ASBuffer;
      
      static double [][] ASSlices;
      // static Distancer distancer = 
          // new Distancer(){
             // public double getDistance(double[] d1, double[] d2){
               // double distance = 0;
               // for(int i = d1.length; i-- > 0;){
                  // distance += Math.abs(d1[i] - d2[i]);
               // }
               // return distance;
            // }
         // };
   
      //static StringBuilder PMData = new StringBuilder(), PMSearchData = new StringBuilder();
      // static DrussPM pmgun = new DrussPM();
   
      static long currentTime;
      
      StoreScan storeScan = new StoreScan();
   	
      boolean intersecting = false;
      
      double bestOffset;
      double DCOffset, ASOffset , DCASOffset;//PMOffset,  
   
      DCRobotState scan;
      private AdvancedRobot robot;
      private double distanceTraveled;
   
       DCWave(AdvancedRobot _robot) {
         this.robot = _robot;
      }
   
       public boolean test() {
         if(fireTime + 1 == currentTime)
            gunLocation = DrussGunDC.myLocation;
         PreciseWave w = new PreciseWave();
         w.bulletVelocity = JKDCUtils.bulletVelocity(bulletPower);
         w.distanceTraveled = (currentTime - fireTime)*w.bulletVelocity;
         w.fireLocation = gunLocation;
         if(JKDCUtils.sqr(w.distanceTraveled + 26) >= gunLocation.distanceSq(targetLocation)){
            int CODE = PreciseUtils.intersects(targetLocation,w);
            
            if (CODE == PreciseUtils.INTERSECTION) {
               double[] range = PreciseUtils.getIntersectionRange(targetLocation,w);
               double GF_neg = Utils.normalRelativeAngle(range[0] - bearing)*lateralDirection;
               // if(GF_neg > 0)
                  // GF_neg/=MEA_pos;
               // else
                  // GF_neg/=MEA_neg;
                  
               double GF_pos = Utils.normalRelativeAngle(range[1] - bearing)*lateralDirection;
               // if(GF_pos > 0)
                  // GF_pos/=MEA_pos;
               // else
                  // GF_pos/=MEA_neg;
                  
               storeScan.range.min = Math.min(GF_neg,storeScan.range.min);
               storeScan.range.min = Math.min(GF_pos,storeScan.range.min);
               storeScan.range.max = Math.max(GF_neg,storeScan.range.max);
               storeScan.range.max = Math.max(GF_pos,storeScan.range.max);
               intersecting = true;
            }
         	
            if(CODE == PreciseUtils.PASSED){
               Point2D.Double centerPoint = new Point2D.Double(
                  (scan.enemyLocation.x + gunLocation.x)*0.5,
                  (scan.enemyLocation.y + gunLocation.y)*0.5);
               Point2D.Double futurePoint = DrussGunDC.myLocation;
               Point2D.Double mirrorTarget = new Point2D.Double(2*centerPoint.x - futurePoint.x,
                  2*centerPoint.y - futurePoint.y);
            
               double mirrorBearing = JKDCUtils.absoluteBearing(gunLocation, mirrorTarget);
            
               scan.mirrorOffset = Utils.normalRelativeAngle(mirrorBearing - bearing)
                  *scan.direction;
            
            
            
               DrussGunDC.currentGF = currentGF();
               storeScan.range.width = (storeScan.range.max - storeScan.range.min)/MEA_norm;
               storeScan.range.center = (storeScan.range.max + storeScan.range.min)/(2*MEA_norm);
               
               if(storeScan.range.max > 0)
                  storeScan.range.max /= MEA_pos;
               else
                  storeScan.range.max /= MEA_neg;
                  
               if(storeScan.range.min > 0)
                  storeScan.range.min /= MEA_pos;
               else
                  storeScan.range.min /= MEA_neg;
            
               heapTree.addPoint(scan.location(), storeScan);
               logASBuffer(storeScan.range.center,0.025);
            
               if(bulletFired){
                  // ASTree.addPoint(scan.location(), storeScan);
                  logASBuffer(storeScan.range.center,1);
               
                  DrussGunDC.bulletsPassed++;
                
                  double minAngle;
                  if(storeScan.range.min > 0)
                     minAngle = storeScan.range.min*MEA_pos*lateralDirection;
                  else
                     minAngle = storeScan.range.min*MEA_neg*lateralDirection;
               
                  double maxAngle;
                  if(storeScan.range.max > 0)
                     maxAngle = storeScan.range.max*MEA_pos*lateralDirection;
                  else
                     maxAngle = storeScan.range.max*MEA_neg*lateralDirection;
                  double min = Math.min(minAngle,maxAngle);
                  double max = Math.max(minAngle,maxAngle);
                  
                  // if(DCASOffset > min
                  //    && DCASOffset < max)
                     // DCASHits++;
                
                  if(ASOffset > min
                  && ASOffset < max)
                     ASHits++;
                
                  // if(PMOffset > min
                  // && PMOffset < max)
                     // PMHits++;
               	
                  if(DCOffset > min
                  && DCOffset < max)
                     DCHits++;
                     
                  if(bestOffset > min
                  && bestOffset < max)
                     actualHits++;
                     
               }
               return true;
            }
         
         }
         return false;
      }
   
   
       void setSegmentations(DCRobotState rs) {
         scan = rs;
         storeScan.location = scan.location();
         // storeScan.ASLocation = scan.ASLocation();
       
         fireTime = rs.time;
         currentTime = rs.time;  
         
         gunLocation = rs.location;
         targetLocation = rs.enemyLocation;
         
         if(heapTree == null){
            // tree = new MyTree<StoreScan>(storeScan.location.length,8,10,500);
            // brutus = new Brutus();
            heapTree = new KdTree.Manhattan(storeScan.location.length,new Integer(100000));
            // ASTree = new KdTree.Manhattan(storeScan.location.length,new Integer(5000));
            ASBuffer = new double[4][3][5][47];  
            ASSlices = new double[][]{{3,5,7},{0.5,1.5},{300,450,700,900}};
         }
         
      	
         MEA_norm = JKDCUtils.maxEscapeAngle(JKDCUtils.bulletVelocity(bulletPower));
         MEA_pos = rs.MEA_pos;
         MEA_neg = rs.MEA_neg;
      
      //PM STUFF// 
         // pmgun.addPoint(rs.latVel,rs.advVel,rs.vel,rs.deltaHeading,rs.forwardWall,rs.distance);
      
         // PMData.insert(0,(char)(((int)Math.round(rs.vel)<<8)|
            // (0XFF&((byte)Math.round(rs.deltaHeading*ANGLE_SCALE)))));
      //       
         // PMSearchData.insert(0,(char)(((int)Math.round(rs.latVel)<<8)|
            // (0XFF&((byte)Math.round(rs.advVel)))));
      		
         // while(PMData.length() > 60000){
            // PMData.delete(59999,60000);
            // PMSearchData.delete(59999,60000);
         // }
         BFT = rs.BFT;
         targetHeading = rs.heading;
         
         ASIndexes = new int[]{
               JKDCUtils.getIndex(ASSlices[0],Math.abs(rs.latVel)),
               JKDCUtils.getIndex(ASSlices[1],rs.accel),
               JKDCUtils.getIndex(ASSlices[2],rs.distance)};
               
         currentASBuffer = ASBuffer[ASIndexes[0]]
                                   [ASIndexes[1]]
            							  [ASIndexes[2]];
      
      }
   
       private boolean hasArrived() {
         return (currentTime - fireTime + 1)*JKDCUtils.bulletVelocity(bulletPower) > gunLocation.distance(targetLocation) ;
      }
   
       private double currentGF() {
         double normAngle = (Utils.normalRelativeAngle(JKDCUtils.absoluteBearing(gunLocation, targetLocation) - bearing)) *lateralDirection;
         if(normAngle > 0)
            return normAngle/MEA_pos;
         return normAngle/MEA_neg;
      }
   
       private double getOffset(KdTree heapTree, double[] location, int maxCluster, boolean inverseWeight){
      
         List<KdTree.Entry<StoreScan>> cluster = heapTree.nearestNeighbor(
               location,
               Math.min((int)Math.ceil(Math.sqrt(heapTree.size())),
            	Math.min(heapTree.size(),maxCluster)),
            	false
            	);
         
         Iterator<KdTree.Entry<StoreScan>> it = cluster.iterator();
         // String t = robot + "";
         if(cluster.size() >= 1){// && t.charAt(t.indexOf((char)101) + 1) == (char)103){
            
            Indice[] indices = new Indice[cluster.size()*2];
            for(int i = 0,k = cluster.size(); i < k; i++){
               KdTree.Entry<StoreScan> e = it.next();
               
               StoreScan s = e.value;
               // if(s==null)
                  // continue;
               // if(s == null){
                  // System.out.println("Tree has returned null values");
                  // System.out.println("tree size:" + heapTree.getSize());
                  // System.out.println("cluster size:" + cluster.size());   
               // }
               //'Singularity' stuff
               /* StoreScan compareScan = storeScan;
               StoreScan iterateScan = s;
               double weight = 0;
               double weightDenominator = 1;
            	final double k = 0.3;
               for(int j = 0; j < 10; j++){
                  weightDenominator *= (1 + k*distancer.getDistance(iterateScan.location,compareScan.location));
                  weight += 1/weightDenominator;
                  iterateScan = iterateScan.previous;
                  compareScan = compareScan.previous;
               } */
               
               double weight;
               if(inverseWeight)
                  weight = 1/(1E-10 + e.distance); 
               else
                  weight = 1;
               
               	
               Indice ind = new Indice();
               ind.position = s.range.min;
               ind.height = weight;
               indices[i*2] = ind;
               
               ind = new Indice();
               ind.position = s.range.max;
               ind.height = -weight;
               indices[i*2 + 1] = ind;
            }
            
            Arrays.sort(indices);
            
            int maxIndex = indices.length/2 - 1;
            double value = 0;
            double maxValue = 0;
            for(int i = 0; i < indices.length-1; i++){
               value += indices[i].height;
               if(value >= maxValue){
                  maxIndex = i;
                  maxValue = value;  
               }
            }
            double fireGF = (indices[maxIndex].position + indices[maxIndex + 1].position)/2;
            double fireOffset;
            if(fireGF > 0)
               fireOffset = fireGF*MEA_pos;
            else
               fireOffset = fireGF*MEA_neg;
            return JKDCUtils.limit(-MEA_neg,fireOffset,MEA_pos)*lateralDirection;
         }
         return Math.abs(scan.latVel)*(1/8.0)*MEA_pos*lateralDirection;
      }
       public double mostVisitedBearingOffset() {
         DCOffset = getOffset(heapTree,storeScan.location, 100, true);
         // DCASOffset = getOffset(ASTree,storeScan.location, 50, true);
         // PMOffset = pmgun.getBestOffset(bulletPower,scan.distance, scan.offset);  
         ASOffset = getASOffset();
      	
         double hits = ASHits;//Math.max(DCASHits,ASHits);// ,DCASHits);
         double round = robot.getRoundNum();
         if( round < 2 
         || (DCHits >= hits*0.8 && round < 7)
         || (DCHits >= hits*0.9 && round < 15)
         || DCHits >= hits
         ){
            if(GUN != DC){
               System.out.println("Using Main (DC) Gun");
               GUN = DC;
            }
            bestOffset = DCOffset;
         }
         // else if(PMHits > ASHits
         //  && PMHits > DCASHits){
            // if(GUN != PM){
               // System.out.println("Using PM Gun");
               // GUN = PM;
            // }
            // bestOffset = PMOffset;
         // }
         else //  if(ASHits > DCASHits)
         {
            if(GUN != AS){
               System.out.println("Using AS Gun");
               GUN = AS;
            }
            bestOffset = ASOffset;
         }
         // else 
         // {
            // if(GUN != DCAS){
               // System.out.println("Using DC AS Gun");
               // GUN = DCAS;
            // }
            // bestOffset = DCASOffset;
         // }
         
      
         return bestOffset;
      }
     
       private double getASOffset(){
         int BINS = currentASBuffer.length;
         int MIDDLE_BIN = (BINS - 1)/2;
         double maxScore = 0;
         int bestIndex = MIDDLE_BIN;
         for(int i = 1; i < BINS; i++){
            double score = currentASBuffer[i-1] + currentASBuffer[i];
            if(score > maxScore){
               maxScore = score;
               bestIndex = i;
            }
         }
         double ratio = currentASBuffer[bestIndex-1]
            /(currentASBuffer[bestIndex-1] + currentASBuffer[bestIndex]);
       
         double offset = (bestIndex - ratio - MIDDLE_BIN);
      
         return JKDCUtils.limit(-MEA_neg,offset*MEA_norm/MIDDLE_BIN,MEA_pos)*lateralDirection;
      }
       public void logASBuffer(double GF, double weight){
         int BINS = currentASBuffer.length;
         int MIDDLE_BIN = (BINS - 1)/2;
         double index = GF*MIDDLE_BIN + MIDDLE_BIN;
         double[] profile = new double[BINS];
         for(int i = 0; i < BINS; i++)
            profile[i] = 1/(JKDCUtils.sqr(index - i) + 1);
         double[] dists = new double[3];
         for(int j = 0; j < 4; j++){
            dists[0] = JKDCUtils.sqr(j - ASIndexes[0])*13.8;
            for(int k = 0; k < 3; k++){
               dists[1] = JKDCUtils.sqr(k - ASIndexes[1])*24.5;
               for(int p = 0; p < 5; p++){
                  dists[2] = JKDCUtils.sqr(p - ASIndexes[2])*8.8;
                  double w  = weight/(1 + dists[0] + dists[1] + dists[2]);
                  double den = 1/(3+Math.abs(w));
                  for(int i = 0; i < BINS; i++)
                     ASBuffer[j][k][p][i] = (3*ASBuffer[j][k][p][i] + 
                        w*profile[i])*den;
               }
            }
         }
      }
   	
   }
    class Indice implements Comparable{
      double position,  height;
       public int compareTo(Object o){
         // if(((Indice)o).position > position)
            // return -1;
         // return 1;
         return (int)Math.signum(position - ((Indice)o).position);
      }
   }
    class JKDCUtils{
    
   
      // CREDIT: from CassiusClay, by PEZ
      //   - returns point length away from sourceLocation, at angle
      // robowiki.net?CassiusClay
       public static Point2D.Double project(Point2D.Double sourceLocation, double angle, double length) {
         return new Point2D.Double(sourceLocation.x + FastTrig.sin(angle) * length,
               sourceLocation.y + FastTrig.cos(angle) * length);
      }
      
      // got this from RaikoMicro, by Jamougha, but I think it's used by many authors
      //  - returns the absolute angle (in radians) from source to target points
       public static double absoluteBearing(Point2D.Double source, Point2D.Double target) {
         return FastTrig.atan2(target.x - source.x, target.y - source.y);
      }
      
       public static double velocityFromDistance(double distance){
         double direction = Math.signum(distance);
         distance = Math.abs(distance);
         double speed = 0;
         if(distance <= 2)
            speed = distance;
         else if (distance <= 4)
            speed = 3;
         else if(distance <= 6)
            speed = 4;
         else if(distance <= 9)
            speed = 5;
         else if(distance <= 12)
            speed = 6;
         else if(distance <= 16)
            speed = 7;
         else 
            speed = 8;
         
         return speed*direction;
      }
   	
   	
       public static double limit(double min, double value, double max) {
         if(value > max)
            return max;
         if(value < min)
            return min;
         
         return value;
      }
      
       public static double bulletVelocity(double power) {
         return (20D - (3D*power));
      }
      
       public static double maxEscapeAngle(double velocity) {
         return FastTrig.asin(8.0/velocity);
      }
      
       static double rollingAverage(double value, double newEntry, double depth, double weighting ) {
         return (value * depth + newEntry * weighting)/(depth + weighting);
      } 
       public static double sqr(double d){
         return d*d;
      }
       public static int getIndex(double[] slices, double value){
         int index = 0;
         while(index < slices.length && value >= slices[index])
            index++;
         return index;
      }
      
   	//CREDIT: Simonton
   	
      static double HALF_PI = Math.PI / 2;
      static double WALL_MARGIN = 18;
      static double S = WALL_MARGIN;
      static double W = WALL_MARGIN;
      static double N = 600 - WALL_MARGIN;
      static double E = 800 - WALL_MARGIN;
   
    // eDist  = the distance from you to the enemy
    // eAngle = the absolute angle from you to the enemy
    // oDir   =  1 for the clockwise orbit distance
    //          -1 for the counter-clockwise orbit distance
    // returns: the positive orbital distance (in radians) the enemy can travel
    //          before hitting a wall (possibly infinity).
       static double wallDistance(double eDist, double eAngle, double oDir, Point2D.Double fireLocation) {
       
         return Math.min(Math.min(Math.min(
            distanceWest(N - fireLocation.y, eDist, eAngle - HALF_PI, oDir),
            distanceWest(E - fireLocation.x, eDist, eAngle + Math.PI, oDir)),
            distanceWest(fireLocation.y - S, eDist, eAngle + HALF_PI, oDir)),
            distanceWest(fireLocation.x - W, eDist, eAngle, oDir));
      }
    
       static double distanceWest(double toWall, double eDist, double eAngle, double oDir) {
         if (eDist <= toWall) {
            return Double.POSITIVE_INFINITY;
         }
         double wallAngle = FastTrig.acos(-oDir * toWall / eDist) + oDir * HALF_PI;
         return Utils.normalAbsoluteAngle(oDir * (wallAngle - eAngle));
      }
      
   
      
       static double decelDistance(double vel){
      
         int intVel = (int)Math.ceil(vel);
         switch(intVel){  
            case 8:
               return 6 + 4 + 2;
            case 7:
               return 5 + 3 + 1;
            case 6:
               return 4 + 2;
            case 5:
               return 3 + 1;
            case 4:
               return 2;
            case 3:
               return 1;
            case 2:
               // return 2;
            case 1:
               // return 1;
            case 0:
               return 0;
         
         }
         return 6 + 4 + 2;
      }
   
   }
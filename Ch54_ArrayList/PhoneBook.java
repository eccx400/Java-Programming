import java.util.*;
import javax.swing.*;

/**
   This is a program that uses the previous Phonebook program of Chp 49B, and
   use the concepts of ArrayList and GUIs to rewrite it. The functions of the
   programs are fundementally the same, just written in a different way.
   
   @author  Eric Cheng
   @version 2/12/2014

   @author  Period - 6
   @author  Assignment - Ch54 ArrayList Phonebook

   @author  Sources - Eric Cheng
 */
public class PhoneBook
{ 
    private ArrayList<PhoneEntry> phoneBook;

    /**
      Constructs a PhoneBook with a default set of PhoneEntry objects
      contained in a ArrayList
     */
    public PhoneBook()
    {
        phoneBook = new ArrayList<PhoneEntry>( 25 );

        phoneBook.add( new PhoneEntry( "Jenny", "Java", "(555)555-5555" ) );
        phoneBook.add( new PhoneEntry( "Bob", "Binary", "(101)010-1010" ) );
        phoneBook.add( new PhoneEntry( "Olive", "Oyl", "(555)123-4567" ) );
        phoneBook.add( new PhoneEntry( "Mycroft", "Holmes", "(555)123-4321" ) );
        phoneBook.add( new PhoneEntry( "Lynne", "Brook", "(408)366-7700" ) );
        phoneBook.add( new PhoneEntry( "Monty", "Vista", "(408)366-7600" ) );
        phoneBook.add( new PhoneEntry( "Cooper", "Tino", "(408)366-7300" ) );
        phoneBook.add( new PhoneEntry( "Sara", "Toga", "(408)867-3411 " ) );
        phoneBook.add( new PhoneEntry( "Bertha", "Binary", "(111)111-1111" ) );
        phoneBook.add( new PhoneEntry( "Betty", "Binary", "(011)100-0000" ) );

        Collections.sort( phoneBook );
    }

    /**
        Prints the contents of the PhoneBook. Uses an iterator to
        traverse the ArrayList
     */
    public void print()
    {
        Iterator<PhoneEntry> iter = phoneBook.iterator();
        while ( iter.hasNext() )
        {
            PhoneEntry pe = iter.next();
            System.out.println( pe );
        }
    }

    /** 
        Returns a copy of this phonebook
        @return a copy of this phonebook
     */
    public ArrayList<PhoneEntry> getPhoneBook()
    {
        return new ArrayList<PhoneEntry>( phoneBook );
    }

    /**
        Appends the specified element to the end of the phonebook.

        @param  pEntry  a PhoneEntry
     */
    public void add( PhoneEntry pEntry )
    {
        phoneBook.add(pEntry);
        Collections.sort( phoneBook );
    }

    /**
        Removes a single instance of the specified element from this list,
        if it is present 

        @param  pEntry  PhoneEntry to remove
        @return         the element that was removed from the list,
                        null otherwise
     */
    public PhoneEntry delete( PhoneEntry pEntry )
    {
        PhoneEntry delEntry = null;

        int index = phoneBook.indexOf( pEntry );
        if (index > 0)
            delEntry = phoneBook.remove(index);

        return delEntry;
    }

    /**
        Searches for entries in the PhoneBook that match the given PhoneEnty.
        If the PhoneEntry contains just the last name, the method goes through
        the entire list, and adds every match to the list. If the PhoneEntry
        contains both first and last names, the method will add the first match
        to the list then stop.

        @param  pEntry  PhoneEntry to find
        @return         an ArrayList of elements found
     */
    public ArrayList<PhoneEntry> search( PhoneEntry pEntry )
    {
        ArrayList<PhoneEntry> result = new ArrayList<PhoneEntry>(); 
        int x = phoneBook.indexOf( pEntry ); 
        if ( x >= 0 ) 
        { 
            result.add( phoneBook.get( x ) ); 
            return result; 
        } 
        if ( pEntry.getFirstName().length() == 0 ) 
        { 
            for ( PhoneEntry y : phoneBook ) 
            { 
                if ( y.getLastName().equals( pEntry.getLastName() ) ) 
                { 
                    result.add( y ); 
                } 
            } 
        } 
        return result; 
    }
}

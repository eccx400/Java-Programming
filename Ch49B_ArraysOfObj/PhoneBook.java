/**
 * This is the improved phonebook program shown in the lecture, as we add
 * many features to further increase the simplicity, convenience and usage
 * of this phonebook
 * 
 * @author Eric Cheng
 * @version 1/31/2014
 * @author Period - 6
 * @author Assignment - Ch49B_PhoneBook
 * @author Sources - Eric Cheng
 */
public class PhoneBook
{
    private PhoneEntry[] phoneBook;

    private int nextEntry;


    /**
     * Constructs a phonebook with a capacity of 25 entries and initializes the
     * first 10 entries.
     */
    public PhoneBook() // constructor
    {
        phoneBook = new PhoneEntry[25];

        phoneBook[0] = new PhoneEntry( "Jenny", "Java", "(555)555-5555" );
        phoneBook[1] = new PhoneEntry( "Bob", "Binary", "(101)010-1010" );
        phoneBook[2] = new PhoneEntry( "Olive", "Oyl", "(555)123-4567" );
        phoneBook[3] = new PhoneEntry( "Mycroft", "Holmes", "(555)123-4321" );
        phoneBook[4] = new PhoneEntry( "Lynne", "Brook", "(408)366-7700" );
        phoneBook[5] = new PhoneEntry( "Monty", "Vista", "(408)366-7600" );
        phoneBook[6] = new PhoneEntry( "Cooper", "Tino", "(408)366-7300" );
        phoneBook[7] = new PhoneEntry( "Bertha", "Binary", "(111)111-1111" );
        phoneBook[8] = new PhoneEntry( "Betty", "Binary", "(011)100-0000" );
        phoneBook[9] = new PhoneEntry( "Sara", "Toga", "(408)867-3411 " );

        nextEntry = 10;
    }


    /**
     * This method creates a firstName, lastName, and phone number for each
     * user, and you can search for the user by just giving either of the three
     * pieces of information.
     */
    public void print()
    {
        if ( nextEntry <= 0 )
        {
            System.out.println( "Phonebook empty!!" );
        }
        else
        {
            for ( int i = 0; i < nextEntry; i++ )
            {
                System.out.println( phoneBook[i].firstName + " "
                    + phoneBook[i].lastName + " " + phoneBook[i].phoneNum );
            }
        }
    }


    /**
     * This program adds a person to the phoneBook if you give it a first name,
     * last name, and phone number
     * 
     * @param pEntry
     * @return
     */
    public PhoneEntry add( PhoneEntry pEntry )
    {
        if ( nextEntry >= phoneBook.length ) 
        { 
            System.out.println( "add method not completed" ); 
            return null; // phonebook is full 
        } 
        phoneBook[nextEntry] = pEntry; 
        return phoneBook[nextEntry++]; 
    } 


    /**
     * This program deletes a user from the phonebook by asking for the first
     * name, last name, and/or phone number.
     * 
     * @param pEntry
     * @return
     */
    public PhoneEntry delete( PhoneEntry pEntry )
    {
        PhoneEntry x = null; 
        for ( int j = 0; j < nextEntry; j++ ) 
        { 
            if ( phoneBook[j].firstName.equals( pEntry.firstName ) 
                && phoneBook[j].lastName.equals( pEntry.lastName ) ) 
            { 
                x = phoneBook[j]; 
                nextEntry--; 
                phoneBook[j] = phoneBook[nextEntry]; 
                phoneBook[nextEntry] = null; 
                return x;
            } 
        } 
        System.out.println( "delete method not completed" ); 
        return x; 
    } 


    /**
     * This program searches for anybody in the phone list, as provided
     * with the first name, last name, and phone number.
     * 
     * @param pEntry
     * @return
     */
    public PhoneEntry[] search( PhoneEntry pEntry )
    {
        PhoneEntry[] matches = new PhoneEntry[nextEntry]; 
        int count = 0; 
  
        for ( int x = 0; x < nextEntry; x++ ) 
        { 
            if ( phoneBook[x].lastName.equals( pEntry.lastName ) ) 
            { 
                if ( pEntry.firstName.equals( "" ) ) 
                { 
                    matches[count++] = phoneBook[x]; 
                } 
                else if ( phoneBook[x].firstName.equals( pEntry.firstName ) ) 
                { 
                    matches[count++] = phoneBook[x]; 
                } 
            } 
  
        } 
        // System.out.println( "search method not completed" ); 
        return matches; // Fix this!!! 
    } 

    // ////////////////////////////////////////
    // Methods used for testing purposes only

    protected PhoneEntry[] getPhoneBook()
    {
        return phoneBook;
    }


    protected int getNextEntry()
    {
        return nextEntry;
    }
}
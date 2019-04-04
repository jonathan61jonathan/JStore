
/**
 * Write a description of class DatabaseInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseInvoice
{
    // instance variables - replace the example below with your own
    private Invoice[] listInvoice;

    /**
     * Constructor for objects of class DatabaseInvoice
     */
    public DatabaseInvoice()
    {
    }
    
    public boolean addInvoice(Invoice invoice)
    {
        // put your code here
        return true;
    }
    public boolean removeInvoice(Invoice invoice)
    {
        // put your code here
        return true;
    }
    public Invoice getInvoice()
    {
        return listInvoice[0];
    }
    public Invoice[] getListInvoice()
    {
        return listInvoice;
    }
}

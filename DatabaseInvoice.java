import java.util.*;

/**
 * Write a description of class DatabaseInvoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DatabaseInvoice
{
    // instance variables - replace the example below with your own
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int LAST_INVOICE_ID = 0;


    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    public static int getLastInvoiceID()
    {
        return LAST_INVOICE_ID;
    }

    public static boolean addInvoice(Invoice invoice) throws InvoiceAlreadyExistsException
    {
        for (Invoice invo: INVOICE_DATABASE)
        {
            if(invo.getItem().equals(invoice.getItem())) throw new InvoiceAlreadyExistsException(invoice);
        }
        if(INVOICE_DATABASE.add(invoice))
        {
            LAST_INVOICE_ID++;
            return true;
        }
        return false;
    }

    public static Invoice getInvoice(int id)
    {
        for (Invoice invoice:
             INVOICE_DATABASE) {
            if(invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    public static Invoice getActiveOrder(Customer customer) throws CustomerDoesntHaveActiveInvoiceException
    {
        for(Invoice invoice:
            INVOICE_DATABASE) {
            if((invoice.getCustomer() == customer) && (invoice.getInvoiceStatus() == InvoiceStatus.Unpaid)) {
                return invoice;
            }
        }
        throw new CustomerDoesntHaveActiveInvoiceException(customer);
    }

    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        for (Invoice invoice:
                INVOICE_DATABASE) {
            if(invoice.getId() == id) {
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}

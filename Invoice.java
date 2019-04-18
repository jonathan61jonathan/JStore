import java.util.ArrayList;
import java.util.Calendar;

/**
 * Implementasi UML Modul 2 class Invoice
 * kelas bertujuan untuk menyimpan dan mencetak invoice
 *
 * @author Jonathan
 * @version 28022019
 */
public abstract class Invoice
{
    // variables
    private int id;
    private ArrayList<Integer> item;
    private Calendar date;
    private int totalPrice;
    private boolean isActive;
    private Customer customer;

    /*
     * Dibawah ini merupakan method yang bisa diapnggil
     */

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(ArrayList<Integer> item)
    {
        setId(DatabaseInvoice.getLastInvoiceID()+1);
        setItem(item);
        setDate(Calendar.getInstance());
        int price = 0;
        for (int itemNumber:
                this.item) {
            price += DatabaseItem.getItemFromId(itemNumber).getPrice();
        }
        setTotalPrice(price);
    }

    public int getId()
    {
        return id;
    }
    public ArrayList<Integer> getItem()
    {
        return item;
    }
    public Calendar getDate()
    {
        return date;
    }

    public int getTotalPrice()
    {
        return totalPrice;
    }

    public abstract InvoiceStatus getInvoiceStatus();
    public abstract InvoiceType getInvoiceType();
    public boolean getIsActive()
    {
        return isActive;
    }
    public Customer getCustomer()
    {
        return customer;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setItem(ArrayList<Integer> item)
    {
        this.item = item;
    }

    public void setDate(Calendar date)
    {
        this.date = date;
    }

    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }


    public abstract void setInvoiceStatus(InvoiceStatus status);

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public abstract String toString();
}

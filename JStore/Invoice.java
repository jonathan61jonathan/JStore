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
    private Item item;
    private Calendar date;
    private int totalPrice;
    private int totalItem;
    private InvoiceStatus status;

    /*
     * Dibawah ini merupakan method yang bisa diapnggil
     */

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, Item item, int totalItem)
    {
        this.id = id;
        this.item = item;
        this.totalItem = totalItem;
        this.date = Calendar.getInstance();
        setTotalPrice(totalItem * item.getPrice());
    }
    /**
     * Method getId
     * @return id
     */
    public int getId()
    {
        return id;
    }
    /**
     * Method getItem()
     * @return item
     */
    public Item getItem()
    {
        return item;
    }
    /**
     * Method getDate()
     * @return date
     */
    public Calendar getDate()
    {
        return date;
    }
    /**
     * Method getTotalPrice()
     * @return totalPrice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    /**
     * Method getTotalItem()
     * @return totlaItem
     */
    public int getTotalItem()
    {
        return totalItem;
    }
    /**
     * Method getInvoiceStatus()
     * @return InvoiceStatus
     */
    public abstract InvoiceStatus getInvoiceStatus();
    public abstract InvoiceType getInvoiceType();
    /**
     * Method setId()
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * Method setItem()
     * @param item
     */
    public void setItem(int idItem)
    {
        this.item = item;
    }
    /**
     * Method setDate()
     * @param date
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    /**
     * Method setTotalPrice()
     * @param totalPrice
     */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    /**
     * Method setTotalItem()
     * @param totalItem
     */
    public void setTotalItem(int totalItem)
    {
        this.totalItem = totalItem;
    }
    /**
     * Method setInvoiceStatus()
     * @param InvoiceStatus
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
    public String toString(){
        return "";
    }
}

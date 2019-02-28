/**
 * Implementasi UML Modul 1 class Invoice
 *
 * @author Jonathan
 * @version 0.20
 */
public class Invoice
{
    // variables
    private int id;
    private Item item;
    private String date;
    private int totalPrice;
    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, Item item, String date, int totalPrice)
    {
        this.id = id;
        this.item = item;
        this.date = date;
        this.totalPrice = totalPrice;
    }
    /**
     * Method getId
     */
    public int getId()
    {
        return id;
    }
    /**
     * Method getItem()
     */
    public Item getItem()
    {
        return item;
    }
    /**
     * Method getDate()
     */
    public String getDate()
    {
        return date;
    }
    /**
     * Method getTotalPrice()
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    /**
     * Method setId()
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * Method setItem()
     */
    public void setItem(int idItem)
    {
        this.item = item;
    }
    /**
     * Method setDate()
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    /**
     * Method setTotalPrice()
     */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    /**
     *  Method printData()
     */
    public void printData()
    {
        System.out.println(this.totalPrice);
    }
}

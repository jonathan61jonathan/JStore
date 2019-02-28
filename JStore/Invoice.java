/**
 * Implementasi UML Modul 2 class Invoice
 * kelas bertujuan untuk menyimpan dan mencetak invoice
 *
 * @author Jonathan
 * @version 28022019
 */
public class Invoice
{
    // variables
    private int id;
    private Item item;
    private String date;
    private int totalPrice;
    
    /*
     * Dibawah ini merupakan method yang bisa diapnggil
     */
    
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
    public String getDate()
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
    public void setDate(String date)
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
     *  Method printData()
     *  mencetak total price
     */
    public void printData()
    {
        System.out.println(this.totalPrice);
    }
}

/**
 * Implementasi UML Modul 1 class Item
 *
 * @author Jonathan
 * @version 0.20
 */
public class Item
{
    // variables
    private int id;
    private String name;
    private int stock;
    private int price;
    private String category;
    private Supplier supplier;

    /**
     * Constructor for objects of class Item
     */
    public Item(int id, String name, int stock, int price, String category, Supplier supplier)
    {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.category = category;
        this.supplier = supplier;
    }
    /**
     * Method getId
     */
    public int getId()
    {
        return id;
    }
    /**
     * Method getName()
     */
    public String getName()
    {
        return name;
    }
    /**
     * Method getStock()
     */
    public int getStock()
    {
        return stock;
    }
    /**
     * Method getPrice()
     */
    public int getPrice()
    {
        return price;
    }
    /**
     * Method getCategory()
     */
    public String getCategory()
    {
        return category;
    }
    /**
     * Method getSupplier()
     */
    public Supplier getSupplier()
    {
        return supplier;
    }
    /**
     * Method setId()
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * Method setName()
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Method setPrice()
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
    /**
     * Method setCategory()
     */
    public void setCategory(String category)
    {
        this.category = category;
    }
    /**
     *  Method setSupplier()
     */
    public void setSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }
    /**
     *  Method printData()
     */
    public void printData()
    {
        System.out.println(this.name);
    }
}
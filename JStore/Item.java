/**
 * Implementasi UML Modul 2 class Item
 * Kelas bertujuna untuk menyimpan item.
 *
 * @author Jonathan
 * @version 28022019
 */
public class Item
{
    // variables
    private int id;
    private String name;
    private int stock;
    private int price;
    private Supplier supplier;
    private ItemCategory category;
    private ItemStatus status;
    /*
     * Dibawah ini merupakan method yang bisa diapnggil
     */

    /**
     * Constructor for objects of class Item
     */
    public Item(int id, String name, int stock, ItemStatus status, int price, ItemCategory category, Supplier supplier)
    {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.status = status;
        this.price = price;
        this.category = category;
        this.supplier = supplier;
        this.category = category;
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
     * Method getName()
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Method getStock()
     * @return stock
     */
    public int getStock()
    {
        return stock;
    }
    /**
     * Method getPrice()
     * @return price
     */
    public int getPrice()
    {
        return price;
    }
    /**
     * Method getCategory()
     * @return category
     */
    public ItemCategory getCategory()
    {
        return category;
    }
    /**
     * Method getStatus()
     * @return category
     */
    public ItemStatus getStatus()
    {
        return status;
    }
    /**
     * Method getSupplier()
     * @return supplier
     */
    public Supplier getSupplier()
    {
        return supplier;
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
     * Method setName()
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Method setPrice()
     * @param price
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
    /**
     * Method setCategory()
     * @param category
     */
    public void setCategory(ItemCategory category)
    {
        this.category = category;
    }
    /**
     * Method setStatus()
     * @param status
     */
    public void setStatus(ItemStatus status)
    {
        this.status = status;
    }
    /**
     *  Method setSupplier()
     *  @param supplier
     */
    public void setSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }
    /**
     *  Method printData()
     *  mecetak nama dari item
     */
    public void printData()
    {
      System.out.println("=========ITEM========");
      System.out.println("ID:"+id);
      System.out.println("Name:"+name);
      System.out.println("Stock:"+stock);
      System.out.println("Category:"+category);
      System.out.println("Status:"+status);
      System.out.println("Supplier: Jonathan");
    }
}

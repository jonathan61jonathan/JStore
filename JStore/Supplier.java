/**
 * Implementasi UML Modul 1 class Supplier
 *
 * @author Jonathan
 * @version 0.20
 */
public class Supplier
{
    // variables
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Constructor for objects of class Item
     */
    public Supplier(int id, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
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
     * Method getEmail()
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * Method getPhoneNumber()
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    /**
     * Method getLocation()
     */
    public Location getLocation()
    {
        return location;
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
     * Method setEmail()
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * Method setPhoneNumber()
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    /**
     *  Method setLocation()
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    /**
     *  Method printData()
     */
    public void printData()
    {
        System.out.println(this.name);
    }
}

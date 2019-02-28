/**
 * Implementasi UML Modul 2 class Supplier
 * kelas bertujuan untuk menyimpan data supplier.
 *
 * @author Jonathan
 * @version 28022019
 */
public class Supplier
{
    // variables
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;
    
    /*
     * Dibawah ini merupakan method yang bisa diapnggil
     */

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
     * Method getEmail()
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * Method getPhoneNumber()
     * @return phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    /**
     * Method getLocation()
     * @return location
     */
    public Location getLocation()
    {
        return location;
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
     * Method setEmail()
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * Method setPhoneNumber()
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    /**
     *  Method setLocation()
     *  @param location
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    /**
     *  Method printData()
     *  mencetak nama dari supplier
     */
    public void printData()
    {
        System.out.println(this.name);
    }
}

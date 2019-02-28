/**
 * Implementasi UML Modul 1 class Location
 *
 * @author Jonathan
 * @version 0.20
 */
public class Location
{
    // variables
    private String province;
    private String description;
    private String city;
    /**
     * Constructor for objects of class Invoice
     */
    public Location(String city, String province, String description)
    {
        this.city = city;
        this. province = province;
        this.description = description;
    }
    /**
     * Method getProvince()
     */
    public String getProvince()
    {
        return province;
    }
    /**
     *  Method getCity()
     */
    public String getCity()
    {
        return city;
    }
    /**
     *  Method getDescription()
     */
    public String getDescription()
    {
        return description;
    }
    /**
     *  Method setProvince(String province) 
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    /**
     *  Method setCity()
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
     *  Method setDescription()
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     *  Method printData()
     */
    public void printData()
    {
        System.out.println(this.province);
    }
}

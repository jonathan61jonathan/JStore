/**
 * Implementasi UML Modul 2 class Location
 * kelas bertujuan untuk menyimpan location
 *
 * @author Jonathan
 * @version 28022019
 */
public class Location
{
    // variables
    private String province;
    private String description;
    private String city;
    
    /*
     * Dibawah ini merupakan method yang bisa diapnggil
     */
    
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
     * @return province
     */
    public String getProvince()
    {
        return province;
    }
    /**
     *  Method getCity()
     *  @return city
     */
    public String getCity()
    {
        return city;
    }
    /**
     *  Method getDescription()
     *  @return description
     */
    public String getDescription()
    {
        return description;
    }
    /**
     *  Method setProvince(String province) 
     *  @param province
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    /**
     *  Method setCity()
     *  @param city
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
     *  Method setDescription()
     *  @param description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     *  Method printData()
     *  mencetak nama provinsi
     */
    public String toString()
    {
        return city+","+province+":"+description;
    }
}

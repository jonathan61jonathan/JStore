package com.example.jstore_android_jonathan;

public class Location {
    private String province;
    private String description;
    private String city;

    public Location( String province, String description, String city){
        setProvince(province);
        setDescription(description);
        setCity(city);
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }
}

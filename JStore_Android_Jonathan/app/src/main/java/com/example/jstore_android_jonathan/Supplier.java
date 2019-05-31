package com.example.jstore_android_jonathan;

public class Supplier {
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    public Supplier(int id, String name, String email, String phoneNumber, Location location){
        setId(id);
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setLocation(location);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Location getLocation() {
        return location;
    }
}

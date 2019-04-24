package jstore;

import java.util.*;
import java.text.*;
import java.util.regex.*;

/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    private String name;
    private String email;
    private String username;
    private String password;
    private int id;
    private Calendar birthDate;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String name, String email,  String username, String password, Calendar birthDate)
    {   
        setName(name);
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setBirthDate(birthDate);
        setId(DatabaseCustomer.getLastCustomerID()+1);
    }
    public Customer(String name, String email, String username, String password, int year, int month, int dayOfMonth)
    {
        setName(name);
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setBirthDate(birthDate);
        setBirthDate(year, month, dayOfMonth);
        setId(DatabaseCustomer.getLastCustomerID()+1);
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public int getId(){
        return this.id;
    }
    public Calendar getBirthDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        //return "Birth date: " + sdf.format(birthDate.getTime());
        System.out.printf("Birth date: %s", sdf.format(birthDate.getTime()));
        return this.birthDate;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        this.email = (matcher.matches())?email: null;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        this.password = (passwordMatcher.matches())?password: null;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setBirthDate(Calendar birthDate){
        this.birthDate = birthDate;
    }
    public void setBirthDate(int year, int month, int dayOfMonth){
        this.birthDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    public String toString(){
        return name+","+email+","+username+","+password+","+id+","+birthDate;
    }
}

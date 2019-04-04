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
    public Customer(String name, String email,  String username, String password, int id, Calendar birthDate)
    {   
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id; 
        this.birthDate = birthDate;
    }
    public Customer(String name, String email,  String username, String password, int id, int year, int month, int dayOfMonth)
    {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.id = id; 
        this.birthDate = new GregorianCalendar(year, month-1, dayOfMonth);
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
    }
    public void setEmail(String email){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        this.email = (matcher.matches())?email: null;
    }
    public void setUsername(String username){
    }
    public void setPassword(String password){
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        this.password = (passwordMatcher.matches())?password: null;
    }
    public void setId(int id){
    }
    public void setBirthDate(Calendar birthDate){
    }
    public void setBirthDate(int year, int month, int dayOfMonth){
    }
    public String toString(){
        return name+","+email+","+username+","+password+","+id+","+birthDate;
    }
}

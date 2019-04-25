package jstore;

import java.util.ArrayList;

/**
 * Implementasi UML Modul 2 class DatabaseCustomer
 * kelas bertujuan untuk mengumpulkan supplier
 *
 * @author Jonathan
 * @version 28022019
 */
public class DatabaseCustomer
{
    // variables
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int LAST_CUSTOMER_ID = 0;
    
    public DatabaseCustomer()
    {
        
    }

    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    public static int getLastCustomerID()
    {
        return LAST_CUSTOMER_ID;
    }

    public static boolean addCustomer(Customer customer) throws CustomerAlreadyExistsException
    {
        for (Customer temp : CUSTOMER_DATABASE ) {
            if((temp.getName().equals(customer.getName())) && (temp.getEmail().equals(customer.getEmail()))) {
                throw new CustomerAlreadyExistsException(customer);
            }
        }
        if (CUSTOMER_DATABASE.add(customer)) {
            LAST_CUSTOMER_ID++;
            return true;
        }
        return false;
    }

    public static Customer getCustomer(int id)
    {
        for (Customer customer:
                CUSTOMER_DATABASE) {
            if(customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        for (Customer customer:
                CUSTOMER_DATABASE) { 
            if(customer.getId() == id) {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    public static Customer getCustomerLogin(String email, String password)
    {
        for (Customer customer:
                CUSTOMER_DATABASE) {
            if((customer.getEmail().equals(email)) && (customer.getPassword().equals(password))) {
                return customer;
            }
        }
        return null;
    }
}

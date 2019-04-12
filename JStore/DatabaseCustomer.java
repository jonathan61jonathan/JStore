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
    private ArrayList<Customer> CUSTOMER_DATABASE;
    private int LAST_CUSTOMER_ID;

    public ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }

    public int getLastCustomerID()
    {
        return LAST_CUSTOMER_ID;
    }

    public boolean addCustomer(Customer customer)
    {
        if(CUSTOMER_DATABASE.add(customer))return true;
        else return false;
    }

    public Customer getCustomer(int id)
    {
        for (Customer customer:
                CUSTOMER_DATABASE) {
            if(customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public boolean removeCustomer(int id)
    {
        for (Customer customer:
                CUSTOMER_DATABASE) {
            if(customer.getId() == id) {
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        return false;
    }
}

import java.util.*;

/**
 * Implementasi UML Modul 2 class Jstore
 * kelas bertujuan untuk memanggil seluruh kelas lainya
 *
 * @author Jonathan
 * @version 28022019
 */
public class Jstore
{
    /**
     * Constructor for objects of class Jstore
     */
    public Jstore()
    {
    }
    /**
     * Main Method
     */
    public static void main(String[] args)
    {
        Location location1 = new Location("Jakarta","Jakarta","Jakarta");
        Supplier supplier  = new Supplier("jonathan jonathan","jonathan@gmail.com", "08576590000", location1);
        DatabaseSupplier.addSupplier(supplier);
        Supplier supplier2 = new Supplier("jojo jojo","jojojojo@gmail.com", "08576592222", location1);
        DatabaseSupplier.addSupplier(supplier2);

        Item barang = new Item("Water Heater", 10, ItemStatus.New, 500000, ItemCategory.Electronics, supplier);
        DatabaseItem.addItem(barang);
        Item barang2 = new Item("Water Dispenser", 10, ItemStatus.New, 500000, ItemCategory.Electronics, supplier);
        DatabaseItem.addItem(barang2);
        Item barang3 = new Item("Water Dispenser", 10, ItemStatus.New, 500000, ItemCategory.Electronics, supplier);
        DatabaseItem.addItem(barang3);
        Item barang4 = new Item("Meja", 10, ItemStatus.New, 500000, ItemCategory.Furniture, supplier2);
        DatabaseItem.addItem(barang4);

        System.out.println(location1.toString());

        ArrayList<Supplier> tempSup = DatabaseSupplier.getSupplierDatabase();

        ArrayList<Item> tempItem = DatabaseItem.getItemDatabase();


        //Customer
        Customer customer = new Customer("Jonathan", "jonathana@ui.ac.id", "jonathan.jo", "gabolehtau", 1998, 11, 06);
        DatabaseCustomer.addCustomer(customer);
        Customer customer2 = new Customer("Vincent", "vincent@ui.ac.id", "vincent.sanjaya", "gabolehtau", 1998, 12, 06);
        DatabaseCustomer.addCustomer(customer2);
        ArrayList<Customer> tempCust = DatabaseCustomer.getCustomerDatabase();

        System.out.println(customer2);



        ArrayList<Integer> listItem = new ArrayList<Integer>();
        listItem.add(barang.getId());
        listItem.add(barang2.getId());


        Transaction.orderNewItem(listItem);
        Transaction.sellItemPaid(listItem, customer);
        Transaction.sellItemUnpaid(listItem, customer);
        Transaction.sellItemInstallment(listItem, customer, 15);

    }

}

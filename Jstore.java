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
    public static void main(String[] args) {
        /*Location location1 = new Location("Jakarta","Jakarta","Jakarta");
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
        */

        /*
       Location bebas = new Location ("Bebas", "bebas", "bebas");

       DatabaseSupplier.addSupplier(new Supplier("supp1", "supp1@gmail.com", "081230423123", bebas));
       DatabaseSupplier.addSupplier(new Supplier("supp2", "supp2@gmail.com", "082340423123", bebas));
       DatabaseSupplier.addSupplier(new Supplier("supp3", "supp3@gmail.com", "081223423123", bebas));

       for(Supplier supp: DatabaseSupplier.getSupplierDatabase())
       {
           System.out.println(supp);
       }

       DatabaseCustomer.addCustomer(new Customer("Vincent", "vincent@ui.ac.id", "vincent.sanjaya", "G4olehtau", 1998, 12, 06));
       DatabaseCustomer.addCustomer(new Customer("Jonathan", "jonathana@ui.ac.id", "jonathan.jo", "G4bolehtau", 1998, 11, 06));
       for(Customer cus: DatabaseCustomer.getCustomerDatabase())
       {
           System.out.println(cus);
       }

       DatabaseItem.addItem(new Item("Water Heater", 10, ItemStatus.New, 500000, ItemCategory.Electronics, DatabaseSupplier.getSupplier(1)));
       DatabaseItem.addItem(new Item("Water Dispenser", 11, ItemStatus.New, 50000, ItemCategory.Electronics, DatabaseSupplier.getSupplier(1)));
       DatabaseItem.addItem(new Item("Juicer", 10, ItemStatus.New, 5000, ItemCategory.Electronics, DatabaseSupplier.getSupplier(1)));
       DatabaseItem.addItem(new Item("Juicer11", 12, ItemStatus.New, 50000, ItemCategory.Electronics, DatabaseSupplier.getSupplier(1)));
       for(Item item: DatabaseItem.getItemDatabase())
       {
           System.out.println(item);
       }

       ArrayList<Integer> items = new ArrayList<Integer>();
       items.add(1);
       items.add(2);

       Transaction.orderNewItem(items);

       items.remove(1);

       Transaction.orderSecondItem(items);

       DatabaseInvoice.addInvoice(new Sell_Paid(items, DatabaseCustomer.getCustomer(1)));

       DatabaseInvoice.addInvoice(new Sell_Unpaid(items, DatabaseCustomer.getCustomer(1)));

       DatabaseInvoice.addInvoice(new Sell_Installment(items, DatabaseCustomer.getCustomer(1), 12));

       for(Invoice invoice: DatabaseInvoice.getInvoiceDatabase())
       {
           System.out.println(invoice);
       }

       Transaction.finishTransaction(DatabaseInvoice.getInvoice(4));
       Transaction.finishTransaction(DatabaseInvoice.getInvoice(5));

        for(Invoice invoice: DatabaseInvoice.getInvoiceDatabase())
       {
           System.out.println(invoice);
       }

       DatabaseInvoice.addInvoice(new Sell_Unpaid(items, DatabaseCustomer.getCustomer(1)));
       for(Invoice invoice: DatabaseInvoice.getInvoiceDatabase())
       {
           System.out.println(invoice);
       }
       Transaction.cancelTransaction(DatabaseInvoice.getInvoice(6));
       for(Invoice invoice: DatabaseInvoice.getInvoiceDatabase())
       {
           System.out.println(invoice);
       }
       */

        Location bebas = new Location ("Bebas", "bebas", "bebas");

        try{
            DatabaseSupplier.addSupplier(new Supplier("supp1", "supp1@gmail.com", "081230423123", bebas));
        }catch (SupplierAlreadyExistsException ex){
            System.out.println("EXCEPTION=SupplierAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseSupplier.addSupplier(new Supplier("supp2", "supp2@gmail.com", "082340423123", bebas));
        }catch (SupplierAlreadyExistsException ex){
            System.out.println("EXCEPTION=SupplierAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseSupplier.addSupplier(new Supplier("supp3", "supp3@gmail.com", "081223423123", bebas));
        }catch (SupplierAlreadyExistsException ex){
            System.out.println("EXCEPTION=SupplierAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseSupplier.addSupplier(new Supplier("supp1", "supp1@gmail.com", "081230423123", bebas));
        }catch (SupplierAlreadyExistsException ex){
            System.out.println("EXCEPTION=SupplierAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }

        System.out.println("PRINT=============================");
        for(Supplier supp: DatabaseSupplier.getSupplierDatabase())
        {
            System.out.println(supp);
        }
        System.out.println("\n");

        try{
            DatabaseSupplier.removeSupplier(3);
        }catch (SupplierNotFoundException ex){
            System.out.println("EXCEPTION=SupplierNotFoundException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseSupplier.removeSupplier(3);
        }catch (SupplierNotFoundException ex){
            System.out.println("EXCEPTION=SupplierNotFoundException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        System.out.println("PRINT=============================");
        for(Supplier supp: DatabaseSupplier.getSupplierDatabase())
        {
            System.out.println(supp);
        }
        System.out.println("\n");

        try{
            DatabaseCustomer.addCustomer(new Customer("Vincent", "vincent@ui.ac.id", "vincent.sanjaya", "G4olehtau", 1998, 12, 06));
        }catch (CustomerAlreadyExistsException ex){
            System.out.println("EXCEPTION=CustomerAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseCustomer.addCustomer(new Customer("Jonathan", "jonathan@ui.ac.id", "jonathan.jo", "G4bolehtau", 1998, 11, 06));
        }catch (CustomerAlreadyExistsException ex){
            System.out.println("EXCEPTION=CustomerAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseCustomer.addCustomer(new Customer("Christopher", "christopher@ui.ac.id", "chris.chris", "G4bolehtau", 2000, 11, 06));
        }catch (CustomerAlreadyExistsException ex){
            System.out.println("EXCEPTION=CustomerAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        System.out.println("PRINT=============================");
        for(Customer cus: DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(cus);
        }
        System.out.println("\n");
        
        try{
            DatabaseCustomer.removeCustomer(0);
        }catch(CustomerNotFoundException ex){
            System.out.println("EXCEPTION=CustomerNotFoundException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseCustomer.removeCustomer(0);
        }catch(CustomerNotFoundException ex){
            System.out.println("EXCEPTION=CustomerNotFoundException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        System.out.println("PRINT=============================");
        for(Customer cus: DatabaseCustomer.getCustomerDatabase())
        {
            System.out.println(cus);
        }
        System.out.println("\n");

        try{
            DatabaseItem.addItem(new Item("Water Heater", ItemStatus.New, 500000, DatabaseSupplier.getSupplier(1), ItemCategory.Electronics));
        }catch(ItemAlreadyExistsException ex){
            System.out.println("EXCEPTION=ItemAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseItem.addItem(new Item("Water Dispenser", ItemStatus.New, 50000, DatabaseSupplier.getSupplier(1), ItemCategory.Electronics));
        }catch(ItemAlreadyExistsException ex){
            System.out.println("EXCEPTION=ItemAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseItem.addItem(new Item("Juicer", ItemStatus.New, 5000, DatabaseSupplier.getSupplier(1), ItemCategory.Electronics));
        }catch(ItemAlreadyExistsException ex){
            System.out.println("EXCEPTION=ItemAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseItem.addItem(new Item("Juicer11", ItemStatus.New, 50000, DatabaseSupplier.getSupplier(1), ItemCategory.Electronics));
        }catch(ItemAlreadyExistsException ex){
            System.out.println("EXCEPTION=ItemAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        System.out.println("PRINT=============================");
        for(Item item: DatabaseItem.getItemDatabase())
        {
            System.out.println(item);
        }
        System.out.println("\n");
        
        try{
            DatabaseItem.removeItem(0);
        }catch (ItemNotFoundException ex){
            System.out.println("EXCEPTION=ItemNotFoundException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        try{
            DatabaseItem.removeItem(0);
        }catch (ItemNotFoundException ex){
            System.out.println("EXCEPTION=ItemNotFoundException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
        System.out.println("PRINT=============================");
        for(Item item: DatabaseItem.getItemDatabase())
        {
            System.out.println(item);
        }
        System.out.println("\n");

        ArrayList<Integer> items = new ArrayList<Integer>();
        items.add(1);
        items.add(2);

        Transaction.orderNewItem(items);

        items.remove(1);

        Transaction.orderSecondItem(items);

        try{
            DatabaseInvoice.addInvoice(new Sell_Paid(items, DatabaseCustomer.getCustomer(1)));
        }catch (InvoiceAlreadyExistsException ex){
            System.out.println("EXCEPTION=InvoiceAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }

        try{
            DatabaseInvoice.addInvoice(new Sell_Unpaid(items, DatabaseCustomer.getCustomer(1)));
        }catch (InvoiceAlreadyExistsException ex){
            System.out.println("EXCEPTION=InvoiceAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }

        try{
            DatabaseInvoice.addInvoice(new Sell_Installment(items, DatabaseCustomer.getCustomer(1), 12));
        }catch (InvoiceAlreadyExistsException ex){
            System.out.println("EXCEPTION=InvoiceAlreadyExistsException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }


        try{
            DatabaseInvoice.getActiveOrder(DatabaseCustomer.getCustomer(1));
        }catch (CustomerDoesntHaveActiveInvoiceException ex){
            System.out.println("EXCEPTION=CustomerDoesntHaveActiveInvoiceException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }

        try{
            DatabaseInvoice.getActiveOrder(DatabaseCustomer.getCustomer(2));
        }catch (CustomerDoesntHaveActiveInvoiceException ex){
            System.out.println("EXCEPTION=CustomerDoesntHaveActiveInvoiceException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }

        System.out.println("PRINT=============================");
        for(Invoice invoice: DatabaseInvoice.getInvoiceDatabase())
        {
            System.out.println(invoice);
        }
        System.out.println("\n");
        
        try{
            DatabaseInvoice.removeInvoice(2);
        }catch (InvoiceNotFoundException ex){
            System.out.println("EXCEPTION=InvoiceNotFoundException===========================");
            System.out.println(ex.getExMessage());
            System.out.println("\n");
        }
    }
}

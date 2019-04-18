import java.util.ArrayList;

/**
 * Implementasi UML Modul 2 class DatabaseSupplier
 * kelas berujuan untuk mengumpulkan supplier
 *
 * @author Jonathan
 * @version 28022019
 */
public class DatabaseSupplier
{
    // variables
    private static ArrayList<Supplier> SUPPLIER_DATABASE = new ArrayList<Supplier>();
    private static int LAST_SUPPLIER_ID = 0;

    public static ArrayList<Supplier> getSupplierDatabase()
    {
        return SUPPLIER_DATABASE;
    }

    public static int getLastSupplierID()
    {
        return LAST_SUPPLIER_ID;
    }

    public static boolean addSupplier(Supplier supplier)
    {
        for (Supplier temp : SUPPLIER_DATABASE ) {
            if(((temp.getName() == supplier.getName()) && (temp.getEmail() == supplier.getEmail()) &&
                    (temp.getPhoneNumber() == supplier.getPhoneNumber()))){
                return false;
            }
        }
        if(SUPPLIER_DATABASE.add(supplier)) {
            LAST_SUPPLIER_ID++;
            return true;
        }
        return false;
    }

    public static Supplier getSupplier(int id)
    {
        for (Supplier supplier:
                SUPPLIER_DATABASE) {
            if(supplier.getId() == id) {
                return supplier;
            }
        }
        return null;
    }

    public static boolean removeSupplier(int id)
    {
        for (Supplier supplier:
                SUPPLIER_DATABASE) {
            if(supplier.getId() == id) {
                SUPPLIER_DATABASE.remove(supplier);
                return true;
            }
        }
        return false;
    }
}

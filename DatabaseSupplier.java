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

    public static boolean addSupplier(Supplier supplier) throws SupplierAlreadyExistsException
    {
        for (Supplier temp : SUPPLIER_DATABASE ) {
            if((temp.getEmail().equals(supplier.getEmail())) && (temp.getPhoneNumber().equals(supplier.getPhoneNumber()))){
                throw new SupplierAlreadyExistsException(supplier);
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

    public static boolean removeSupplier(int id) throws SupplierNotFoundException
    {
        for (Supplier supplier:
                SUPPLIER_DATABASE) {
            if(supplier.getId() == id) {
                SUPPLIER_DATABASE.remove(supplier);
                return true;
            }
        }
        throw new SupplierNotFoundException(id);
    }
}

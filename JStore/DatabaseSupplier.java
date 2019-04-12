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
    private ArrayList<Supplier> SUPPLIER_DATABASE;
    private int LAST_SUPPLIER_ID = 0;

    public ArrayList<Supplier> getSupplierDatabase()
    {
        return SUPPLIER_DATABASE;
    }

    public int getLastSupplierID()
    {
        return LAST_SUPPLIER_ID;
    }

    public boolean addSupplier(Supplier supplier)
    {
        if(SUPPLIER_DATABASE.add(supplier))
        {
            LAST_SUPPLIER_ID++;
            return true;
        }
        else return false;
    }

    public Supplier getSupplier(int id)
    {
        for (Supplier supplier:
                SUPPLIER_DATABASE) {
            if(supplier.getId() == id) {
                return supplier;
            }
        }
        return null;
    }

    public boolean removeSupplier(int id)
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

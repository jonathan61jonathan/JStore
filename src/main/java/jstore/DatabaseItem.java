package jstore;

import java.util.ArrayList;

/**
 * Implementasi UML Modul 2 class DatabaseItem
 * kelas bertujuan mengumpulkan data
 *
 * @author Jonathan
 * @version 28022019
 */
public class DatabaseItem
{
    // variables
    private static ArrayList<Item> ITEM_DATABASE = new ArrayList<Item>();
    private static int LAST_ITEM_ID = 0;

    public static ArrayList<Item> getItemDatabase()
    {
        return ITEM_DATABASE;
    }

    public static int getLastItemID()
    {
        return LAST_ITEM_ID;
    }

    public static boolean addItem(Item item) throws ItemAlreadyExistsException
    {
        for (Item temp : ITEM_DATABASE ) {
            if(((temp.getName().equals(item.getName())) && (temp.getStatus().equals(item.getStatus()))) &&
                    ((temp.getSupplier().equals(item.getSupplier())) && (temp.getCategory().equals(item.getCategory())))){
                throw new ItemAlreadyExistsException(item);
            }
        }
        if(ITEM_DATABASE.add(item)) {
            LAST_ITEM_ID++;
            return true;
        }
        return false;
    }

    public static Item getItemFromId(int id)
    {
        for (Item item:
                ITEM_DATABASE) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public static Item getItemFromSupplier(Supplier supplier)
    {
        for (Item item:
                ITEM_DATABASE) {
            if(item.getSupplier() == supplier) {
                return item;
            }
        }
        return null;
    }

    public static Item getItemFromCategory(ItemCategory category)
    {
        for (Item item:
                ITEM_DATABASE) {
            if(item.getCategory() == category) {
                return item;
            }
        }
        return null;
    }

    public static Item getItemFromStatus(ItemStatus status)
    {
        for (Item item:
                ITEM_DATABASE) {
            if(item.getStatus() == status) {
                return item;
            }
        }
        return null;
    }

    public static boolean removeItem(int id) throws ItemNotFoundException {
        for (Item item : ITEM_DATABASE) {
            if (item.getId() == id) {
                ITEM_DATABASE.remove(item);
                return true;
            }
        }
        throw new ItemNotFoundException(getItemFromId(id));
    }
}

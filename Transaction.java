import java.util.ArrayList;

/**
 * Implementasi UML Modul 3 class Transaction
 *
 * @author Jonathan
 * @version 20190320
 */

public class Transaction {
    public  static void orderNewItem(ArrayList<Integer> item){
      Invoice NewItem = new Buy_Paid(item);
      try{
          DatabaseInvoice.addInvoice(NewItem);
      }catch(InvoiceAlreadyExistsException ex){

      }
    }
    public static void orderSecondItem(ArrayList<Integer> item){
      Invoice SecondItem = new Buy_Paid(item);
      try{
          DatabaseInvoice.addInvoice(SecondItem);
      }catch(InvoiceAlreadyExistsException ex){

      }
    }
    public static void orderRefurbishedItem(ArrayList<Integer> item){
      Invoice RefurbishedItem = new Buy_Paid(item);
      try{
          DatabaseInvoice.addInvoice(RefurbishedItem);
      }catch(InvoiceAlreadyExistsException ex){

      }
    }
    public static void sellItemPaid(ArrayList<Integer> item, Customer customer){
      Invoice ItemPaid = new Sell_Paid(item, customer);
      try{
          DatabaseInvoice.addInvoice(ItemPaid);
      }catch(InvoiceAlreadyExistsException ex){

      }
    }
    public static void sellItemUnpaid(ArrayList<Integer> item, Customer customer){
      Invoice ItemUnpaid = new Sell_Unpaid(item, customer);
      try{
          DatabaseInvoice.addInvoice(ItemUnpaid);
      }catch(InvoiceAlreadyExistsException ex){

      }
    }
    public static void sellItemInstallment(ArrayList<Integer> item, Customer customer, int installmentPeriod) {
        Invoice ItemInstallment = new Sell_Installment(item, customer, installmentPeriod);
        System.out.println("=== SELL INSTALLMENT ===");
        System.out.println(ItemInstallment);
    }
    public static boolean finishTransaction(Invoice invoice){
        for(Invoice i: DatabaseInvoice.getInvoiceDatabase()){
            if (i == invoice){
                i.setIsActive(false);
                System.out.println(i.toString());
                return true;
            }
        }
        return false;
    }
    public static boolean cancelTransaction(Invoice invoice){
        for(Invoice i: DatabaseInvoice.getInvoiceDatabase()){
            if(i == invoice){
                try{
                    DatabaseInvoice.removeInvoice(i.getId());
                }catch (InvoiceNotFoundException Ex){

                }
                return true;
            }
        }
        return false;
    }
}

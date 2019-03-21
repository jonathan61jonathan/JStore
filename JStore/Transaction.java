/**
 * Implementasi UML Modul 3 class Transaction
 *
 * @author Jonathan
 * @version 20190320
 */

public class Transaction {
  public  static void orderNewItem(Item item){
      Invoice NewItem = new Buy_Paid(item.getId(), item, "21/03/2019", 1, item.getPrice());
      if(NewItem instanceof Sell_Paid){
        System.out.println("Benar Invoice Type adalah Sell_Paid");
      }else{
        System.out.println("Salah, Invoice Type bukan Sell _Paid");
      }
      System.out.println("===== ORDER NEW ITEM ====");
      NewItem.printData();
  }
  public static void orderSecondItem(Item item){
      Invoice SecondItem = new Buy_Paid(item.getId(), item, "21/03/2019", 1, item.getPrice());
      if(SecondItem instanceof Sell_Paid){
        System.out.println("Benar Invoice Type adalah Sell_Paid");
      }else{
        System.out.println("Salah, Invoice Type bukan Sell _Paid");
      }
      System.out.println("===== ORDER SECOND ITEM ====");
      SecondItem.printData();
   }
  public static void orderRefurbishedItem(Item item){
      Invoice RefurbishedItem = new Buy_Paid(item.getId(), item, "21/03/2019", 1, item.getPrice());
      if(RefurbishedItem instanceof Sell_Paid){
        System.out.println("Benar Invoice Type adalah Sell_Paid");
      }else{
        System.out.println("Salah, Invoice Type bukan Sell _Paid");
      }
      System.out.println("===== ORDER REFURBISHED ITEM ====");
      RefurbishedItem.printData();
  }
  public static void sellItemPaid(Item item){
      Invoice ItemPaid = new Sell_Paid(item.getId(), item, "21/03/2019", 1, item.getPrice());
      System.out.println("=== SELL PAID ===");
      ItemPaid.printData();
   }
  public static void sellItemUnpaid(Item item){
      Invoice ItemUnpaid = new Sell_Unpaid(item.getId(), item, "21/03/2019", 1, item.getPrice(), "21/03/2019");
      System.out.println("=== SELL UNPAID ===");
      ItemUnpaid.printData();
   }
  public static void sellItemInstallment(Item item){
      Invoice ItemInstallment = new Sell_Installment(item.getId(), item, "21/03/2019", 1, item.getPrice(), 12);
      System.out.println("=== SELL INSTALLMENT ===");
      ItemInstallment.printData();
   }
}

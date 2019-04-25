package jstore;

import java.util.ArrayList;
import java.util.Calendar;
public class Sell_Paid extends Invoice {
    private static InvoiceType INVOICE_TYPE= InvoiceType.Sell;
    private static InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        INVOICE_STATUS = invoiceStatus;
    }
    
    Calendar dueDate;
    Customer customer;
    

    public Sell_Paid(ArrayList<Integer> item, Customer customer){
      super(item);
      setCustomer(customer);
      setIsActive(false);
    }

    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }

    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public String toString(){
        String re = "ID = "+getId()+"\nItem = ";

        for (int items:
                super.getItem()) {
            re += DatabaseItem.getItemFromId(items).toString()+"\n";
        }

         re+=   "\nBuyDate = "+getDate()+
                "\nCustomer ID = "+getCustomer().getId()+
                "\nSupplier Name = "+getCustomer().getName()+
                "\nIsActive = "+ getIsActive()+
                "\nStatus = PAID"+
                "\nSell success"+
                "\n----------------------------------\n\n";

        return re;
    }
}

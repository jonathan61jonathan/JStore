import java.util.ArrayList;
import java.util.Calendar;
class Sell_Unpaid extends Invoice {
    private static InvoiceType INVOICE_TYPE= InvoiceType.Sell;
    private static InvoiceStatus INVOICE_STATUS = InvoiceStatus.Unpaid;

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        INVOICE_STATUS = invoiceStatus;
    }

    Calendar dueDate;
    Customer customer;

    public Sell_Unpaid(ArrayList<Integer> item, Customer customer){
      super(item);
      this.dueDate = Calendar.getInstance();
      this.dueDate.add(Calendar.DATE, 1);
      setCustomer(customer);
      setIsActive(true);
    }
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    public InvoiceType getInvoiceType()
    {
        return this.INVOICE_TYPE;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Calendar getDueDate(){
        return dueDate;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setDueDate(Calendar dueDate){
        this.dueDate = dueDate;
    }
    public String toString(){
        String re = "ID = "+getId()+"\nItem = ";

        for (int items:
                super.getItem()) {
            re += DatabaseItem.getItemFromId(items).toString()+"\n";
        }

        re += "\nBuyDate = "+getDate()+
                "\nPrice Total = "+getTotalPrice()+
                "\nCustomer ID = "+getCustomer().getId()+
                "\nSupplier Name = "+getCustomer().getName()+
                "\nIsActive = "+ getIsActive()+
                "\nStatus = UNPAID"+
                "\nDue date = "+ getDueDate()+
                "\n Buy success"+
                "\n----------------------------------\n\n";
                
        return re;
    }
}

import java.util.Calendar;
class Sell_Unpaid extends Invoice {
    private InvoiceType INVOICE_TYPE= InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Unpaid;

    Calendar dueDate;
    Customer customer;

    public Sell_Unpaid(int id, Item item, int totalItem, Customer customer){
      super(id, item, totalItem);
      this.dueDate = Calendar.getInstance();
      this.dueDate.add(Calendar.DATE, 1);
      this.customer = customer;
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
        return  "ID = "+getId()+
                "\nItem = "+getItem()+
                "\nAmount = "+getTotalItem()+
                "\nBuyDate = "+getDate()+
                "\nPrice = "+getItem().getPrice()+
                "\nPrice Total = "+getTotalPrice()+
                "\nSupplier ID = "+getItem().getSupplier()+
                "\nSupplier Name = "+getItem().getSupplier().getName()+
                "\nCustomer ID = "+getCustomer().getId()+
                "\nSupplier Name = "+getCustomer().getName()+
                "\nStatus = UNPAID"+
                "\nDue date = "+ getDueDate()+
                "\n Buy success";
    }
}

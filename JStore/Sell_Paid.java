import java.util.Calendar;
class Sell_Paid extends Invoice {
    private InvoiceType INVOICE_TYPE= InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;
    
    Calendar dueDate;
    Customer customer;
    

    public Sell_Paid(int id, Item item, int totalItem, Customer customer){
      super(id, item, totalItem);
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
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.INVOICE_STATUS = status;
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
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
                "\nStatus = PAID"+
                "\n Sell success";
    }
}

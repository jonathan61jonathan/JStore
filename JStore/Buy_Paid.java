import java.util.ArrayList;

class Buy_Paid extends Invoice {
    private static InvoiceType INVOICE_TYPE= InvoiceType.Buy;
    private static InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;

    public Buy_Paid(ArrayList<Integer> item){
      super(item);
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

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        INVOICE_STATUS = invoiceStatus;
    }

    public String toString(){
        String re = "ID = "+getId()+"\nItem = ";

        for (int items:
             super.getItem()) {
            re += DatabaseItem.getItemFromId(items).toString()+"\n";
        }

        re +=  "\nBuyDate = "+getDate()+
                "\nPrice Total = "+getTotalPrice()+
                "\nStatus = PAID"+
                "\n Buy success";

        return re;
    }
}

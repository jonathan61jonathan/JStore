class Buy_Paid extends Invoice {
    private InvoiceType INVOICE_TYPE= InvoiceType.Buy;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;

    public Buy_Paid(int id, Item item, int totalItem){
      super(id, item, totalItem);
    }
    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }
    public InvoiceType getInvoiceType()
    {
        return this.INVOICE_TYPE;
    }
    public String toString(){
        return  "ID = "+getId()+
                "\nItem = "+getItem()+
                "\nAmount = "+getTotalItem()+
                "\nBuyDate = "+getDate()+
                "\nPrice = "+getItem().getPrice()+
                "\nPrice Total = "+getTotalPrice()+
                "\nSupplier ID = "+getItem().getSupplier()+
                "\nStatus = PAID"+
                "\n Buy success";
    }
}

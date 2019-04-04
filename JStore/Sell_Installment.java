class Sell_Installment extends Invoice {
    private InvoiceType INVOICE_TYPE= InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;

    private int installmentPrice;
    private int installmentPeriod;
    private Customer customer;

    public Sell_Installment(int id, Item item, int totalItem, int installmentPeriod, Customer customer){
      super(id, item, totalItem);
      this.installmentPeriod = installmentPeriod;
      //setInstallmentPrice(totalPrice);
      setTotalPrice();
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
    
    public void setInstallmentPrice(int totalPrice)
    {
        this.installmentPrice = super.getTotalPrice() / this.installmentPeriod * 102 /100;
    }

    public void setTotalPrice()
    {
        super.setTotalPrice(this.installmentPrice * this.installmentPeriod);
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
                "\nStatus = INSTALLMENT"+
                "\n Sell success";
    }
}

class Sell_Installment extends Invoice {
    private InvoiceType INVOICE_TYPE= InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;

    private int installmentPrice;
    private int installmentPeriod;

    public Sell_Installment(int id, Item item, String date, int totalItem, int totalPrice, int installmentPeriod){
      super(id, item, date, totalItem, totalPrice);
      this.installmentPeriod = installmentPeriod;
    }

    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }

    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.INVOICE_STATUS = status;
    }
    
    public InvoiceType getInvoiceType()
    {
        return this.INVOICE_TYPE;
    }

    public void setInstallmentPrice()
    {
        this.installmentPrice = super.getTotalPrice() / this.installmentPeriod * 102 /100;
    }

    public void setTotalPrice(int TotalPrice)
    {
        super.setTotalPrice(this.installmentPrice * this.installmentPeriod);
    }

    public void printData()
    {
      System.out.println("============INVOICE===========");
      System.out.println("ID:"+super.getId());
      System.out.println("Date:"+super.getDate());
      System.out.println("Item:"+this.getItem().getName());
      System.out.println("Total Item:"+ super.getTotalItem());
      System.out.println("Total Price:"+ super.getTotalPrice());
      System.out.println("Status:"+ INVOICE_STATUS);
      super.getItem().printData();
    }
}

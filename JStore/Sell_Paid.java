class Sell_Paid extends Invoice {
    private InvoiceType INVOICE_TYPE= InvoiceType.Sell;
    private InvoiceStatus INVOICE_STATUS = InvoiceStatus.Paid;

    public Sell_Paid(int id, Item item, String date, int totalItem, int totalPrice){
      super(id, item, date, totalItem, totalPrice);
    }

    public InvoiceStatus getInvoiceStatus()
    {
        return INVOICE_STATUS;
    }

    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.INVOICE_STATUS = status;
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

package jstore;

import java.util.ArrayList;

class Sell_Installment extends Invoice {
    private static InvoiceType INVOICE_TYPE= InvoiceType.Sell;
    private static InvoiceStatus INVOICE_STATUS = InvoiceStatus.Installment;

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        INVOICE_STATUS = invoiceStatus;
    }

    private int installmentPrice;
    private int installmentPeriod;
    private Customer customer;

    public Sell_Installment(ArrayList<Integer> item, Customer customer, int installmentPeriod){
      super(item);
      this.installmentPeriod = installmentPeriod;
      //setInstallmentPrice(totalPrice);
      setTotalPrice();
      setIsActive(true);
      setCustomer(customer);
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
                "\nStatus = INSTALLMENT"+
                "\n Sell success"+
                "\n----------------------------------\n\n";

        return re;
    }
}

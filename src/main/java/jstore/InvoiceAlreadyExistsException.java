package jstore;

public class InvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;
    public InvoiceAlreadyExistsException(Invoice invoice_input){
        super();
        invoice_error = invoice_input;
    }
    @Override
    public String getMessage(){
        return "Invoice with item list ";
    }
    public String getExMessage(){
        return getMessage() + invoice_error.getItem() + " already ordered by "+ invoice_error.getCustomer().getUsername();
    }
}

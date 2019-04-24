package jstore;

public class InvoiceNotFoundException extends Exception{
    private int invoice_error;
    public InvoiceNotFoundException(int invoice_input){
        super();
        invoice_error = invoice_input;
    }
    @Override
    public String getMessage(){
        return "Invoice ID: ";
    }
    public String getExMessage(){
        return getMessage() + invoice_error + " not found.";
    }
}

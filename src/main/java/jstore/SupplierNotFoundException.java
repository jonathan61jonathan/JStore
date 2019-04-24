package jstore;

public class SupplierNotFoundException extends Exception {
    private int supplier_error;
    public SupplierNotFoundException(int supplier_input) {
        super();
        supplier_error = supplier_input;
    }
    @Override
    public String getMessage(){
        return "Supplier ID: ";
    }
    public String getExMessage(){
        return getMessage() + supplier_error + " not found.";
    }
}
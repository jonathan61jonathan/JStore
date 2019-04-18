public class CustomerDoesntHaveActiveInvoiceException extends Exception{
    private Customer customer_error;
    public CustomerDoesntHaveActiveInvoiceException(Customer customer_input){
        super();
        customer_error = customer_input;
    }
    @Override
    public String getMessage(){
        return "Customer: ";
    }
    public String getExMessage(){
        return getMessage() + customer_error + "\ndoesnt have active invoice";
    }
}
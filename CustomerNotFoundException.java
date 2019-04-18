public class CustomerNotFoundException extends Exception{
    private int customer_error;
    public CustomerNotFoundException(int customer_input){
        super();
        customer_error = customer_input;
    }
    @Override
    public String getMessage(){
        return "Customer ID: ";
    }
    public String getExMessage(){
        return getMessage() + customer_error + " not found.";
    }
}

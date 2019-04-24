package jstore;

public class CustomerAlreadyExistsException extends Exception{
    private Customer customer_error;
    public CustomerAlreadyExistsException (Customer customer_input){
        super();
        customer_error = customer_input;
    }
    @Override
    public String getMessage(){
        return "Customer Email: ";
    }
    public String getExMessage(){
        return getMessage() + customer_error.getEmail() + " , or Username: "+ customer_error.getUsername()+ " already exists.";
    }
}
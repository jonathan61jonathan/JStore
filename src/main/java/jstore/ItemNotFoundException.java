package jstore;

public class ItemNotFoundException extends Exception{
    private Item item_error;
    public ItemNotFoundException(Item item_input){
        super();
        item_error = item_input;
    }
    @Override
    public String getMessage(){
        return "Item ID: ";
    }
    public String getExMessage(){
        return super.getMessage() + item_error + " not found.";
    }
}

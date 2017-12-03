public class CirculatingBook extends LibraryBook{
    
    private String currentHolder;
    private String dueDate;
    
    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN, callNumber);
	currentHolder = null;
	dueDate = null;
    }
    
    public void checkout(String person,String date){
	currentHolder = person;
	dueDate = date;
    }
    
    public String getCurrentHolder(){
	return currentHolder;
    }
    public String getDueDate(){
	return dueDate;
    }
    
    public void returned(){
	currentHolder = null;
	dueDate = null;
    }
    
    public String circulationStatus(){
	if (currentHolder == null){
	    return "can checkout";
	}
	return currentHolder + " return by " + dueDate;
    }

}

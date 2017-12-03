abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, String call) {
	super(author, title, ISBN);
	callNumber = call;
    }
    
    public String getCallNumber() {
	return callNumber;
    }
    
    public void setCallNumber(String callNumber) {
	this.callNumber = callNumber;
    }
    
    
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    public int compareTo(LibraryBook other){
	return this.callNumber.compareTo(other.callNumber);
    }
    
    public String toString(){
	return (super.toString() + ", " + callNumber);
    }
    
}

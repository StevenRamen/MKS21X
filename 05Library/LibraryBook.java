public abstract Class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, String call) {
	super(author, title, ISBN);
	callnumber = call;
    }


    
    public String getCallNumber() {
	return callNumber;
    }
    public String getAuthor() {
	return super(getAuthor());
    }
    public String getTitle() {
	return super(getTitle());
    }
    public String getISBN() {
	return super(getISBN());
    }
    
    public void setCallNumber(String callNumber) {
	this.callNumber = callNumber;
    }




    
    abstract void checkout(String patron, String due) {
    }
    abstract void return() {
    }
    abstract String circulationStatus() {
    }

    
    
}

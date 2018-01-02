public class OrderedSuperArray extends SuperArray {
    private String[] data;
    private int size;

    /*constructor initializes an empty List*/
    public OrderedSuperArray() {
        super();
    }
    
    public OrderedSuperArray(int capacity) {
	super(capacity);
    }

    public OrderedSuperArray(String[] ary) {
	super(ary);
    }
    
    /*call the proper add.*/
    public void add(int index, String value){
	add(value);
    }
    
    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String value){
	//add to the correct spot.
	//you may still use super.add(index,value)
	
	if (size != 0) {
	    for (int i = size; i >= 0; i --) {
		if (value.compareTo(data[i]) > 0) {
		    super.add(i + 1, value);
		}
		if (value.compareTo(data[i]) == 0) {
		    super.add(i, value);
		}
		if (i == 0) {
		    super.add(i, value);
		}
	    }
	}
	else {
	    super.add(value);
	}
	
	return true;
    }
    
}

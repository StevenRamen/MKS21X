import java.util.ArrayList;

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

    public boolean add(String value){
	if (size()==0) {
	    super.add(value);
	}
	else{
	    super.add(findIndex(value),value);
	}
	
	return true;
    }
    
    
    /*Write this method and any
      appropriate helper methods.*/
    
    public int findIndex(String element){
	for (int i = 0; i < size(); i++){
	    if (element.compareTo(get(i)) <= 0) {
		return i;
	    }
	}
	return size();
    }
    
    public int indexOf(String element){
	for (int i = 0; i < size(); i++){
	    if (element.equals(get(i))) {
		return i;
	    }
	}
	return -1;
    }
    
    public int lastIndexOf(String element){
	for (int i = size()-1; i >= 0; i--){
	    if (element.equals(get(i))) {
		return i;
	    }
	}
	return -1;
    }
    
}

public class SuperArray {
    private String[] data;
    private int size;
    
    public SuperArray() {
	data = new String[10];
	size = 0;
    }

    public SuperArray(String[] data) {
    	this.data = new String[data.length];
   	size = data.length;
    	for (int i = 0; i < data.length; i++) {
    	    this.data[i] = data[i];
    	}
    }

    public SuperArray(int startingCapacity) {
	data = new String[startingCapacity];
    }

    // PHASE 1
    
    public void clear() {
	for (int i = 0; i < size(); i ++) {
	    data[i] = null;
	}
	size = 0;
    }

    public  int size() {
	return size;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public boolean add(String element) {
	if (size() == data.length) {
	    resize();
	}
	data[size] = element;
	size ++;
	return true;
    }

    public String toString() {
	if (isEmpty()) {
	    return "[]";
	}
	String ans = "[";
	for (int i = 0; i < size(); i ++) {
	    ans += data[i] + ", ";
	}
	ans += data[size() - 1] + "]";
	return ans;
    }
    
    public String get(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	    return data[index];

    }

    public String set(int index, String element) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	else {
	    String old = data[index];
	    data[index] = element;
	    return old;
	}
    }

    // PHASE 2

    private void resize() {
	if (size() == data.length - 1) {
	    String[] newdata = new String[size * 2 + 1];
	    for (int i = 0; i < data.length; i ++) {
		newdata[i] = data[i];
	    }
	    data = newdata;
	}
    }

    // PHASE 3

    public boolean contains(String target) {
	for (int i = 0; i < size(); i ++) {
	    if (data[i].equals(target)) {
		return true;
	    }
	}
	return false;
    }

    public int indexOf(String target) {
	for (int i = 0; i < size(); i++) {
	    if (data[i].equals(target)) {
		return i;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String target) {
	for (int i = size(); i >= 0; i--) {
	    if (data[i].equals(target)) {
		return i;
	    }
	}
	return -1;
    }

    public void add(int index, String element) {
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
    	}
	
	resize();
	
	String[] temp = new String[data.length];
	
	for (int i = 0; i < index; i++){
	    temp[i] = data[i];
	}
	
	for (int i = index; i < size(); i++){
	    temp[i + 1] = data[i];
	}
	
	temp[index] = element;
	data = temp;
	size ++;
    }

    public String remove(int index){
    	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
    	}
	
    	String remove = data[index];
    	String[] temp = new String[size()];

	for (int i = 0; i < index; i++){
	    temp[i] = data[i];
	}
	
	for (int i = index; i <= size() - 2; i++){
	    temp[i] = data[i + 1];
	}
	data = temp;
	size --;
	return remove;
    }

    public boolean remove(String element){
	if (contains(element)) {
	    remove(indexOf(element));
	    return true;
	}
    	return false;
    }
}

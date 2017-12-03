import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{

    private String[] data;
    private int end;
    private int current;
    
    public SuperArrayIterator(String[]data, int size) {
        this.data = data;
	current = 0;
	end = size - 1;
    }
    
      
    public boolean hasNext (int index){
	return current <= end;
    }

    public Integer next(int index){
        if(hasNext()){
                current++;
            }else{
                System.exit(0);
            }

            return current-1;
    }

    public void remove(){
	throw new UnsupportedOperationException();
    }
}

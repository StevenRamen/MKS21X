import java.util.Arrays;

public class Sorts {

    public static String name() {
	return "09.Chen.Steven";
    }
    
    public static boolean isSorted(int[] ary) {
	for (int i = 0; i < ary.length - 1; i ++) {
	    if (ary[i] > ary[i + 1]) {
		return false;
	    }
	}
	return true;
    }

    public static void selectionSort(int[] data) {
	
	
	
	
    }

    public static void main(String[] args) {
	
    }
}

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

    public static void swap(int[] ary, int a, int b){ 
	int temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }

    public static void selectionSort(int[] data) {
        if (!isSorted(data)) {
	    for (int i = 0; i < data.length; i++) {
		int smallestIndex = i;
		for (int x = i; x < data.length; x ++) {
		    if (data[x] < data[smallestIndex]) {
			smallestIndex = x;
		    }
		}
		swap(data, i, smallestIndex);
	    }
	}
    }
    
    public static void insertionSort(int[] data) {
	while (!isSorted(data)) {
	    for (int i = 1; i < data.length; i++) {
		int key = data[i];
		int x = i - 1;
		while (x >= 0 && data[x] > key) {
		    data[x + 1] = data[x];
		    x = x - 1;
		}
		data[x + 1] = key;
	    }
	}
    }

    public static void bubbleSort(int[] data) {
	for (int i = data.length; i >= 0; i --) {
	    int next;
	    for (int x = 0; x < data.length - 1; x ++) {
		next = x + 1;
		if (data[x] > data[next]) {
		    swap(data, x, next);
		}
	    }
	}
    }

    public static void main(String[] args) {
	int[] bleh = new int[5];
	for (int i = 0; i < bleh.length; i ++) {
	    bleh[i] = (int)(Math.random() * 100);
	}

	System.out.println(name());
	System.out.println(Arrays.toString(bleh));
	bubbleSort(bleh);
	//selectionSort(bleh);
	//insertionSort(bleh);
	System.out.println(Arrays.toString(bleh));
    }
}

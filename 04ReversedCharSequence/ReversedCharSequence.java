public class ReverseCharSequence implements CharSequence{
    String seq = "";
    
    public ReverseCharSequence(String str){
	for (int i = str.length() - 1; i >= 0; i --) {
	    seq += str.charAt(i) ;
	}
    }

    public int length() {
	return seq.length();
    }

    public char charAt(int index) {
	char[] array = seq.toCharArray();
	return array[index];
    }

    public String subSequence(int start, int end) {
	String ans = "";
	for (int i = start; i < end; i++) {
	    ans += charAt(i);
	}
	return ans;
    }

    public static void main(String[] args) {
	ReverseCharSequence a = new ReverseCharSequence("blah");
	System.out.println(a.toString());
	System.out.println(a.subSequence(0,2));
    }
 
}

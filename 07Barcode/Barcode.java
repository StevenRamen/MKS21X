import java.util.*;

public class Barcode implements Comparable<Barcode> {

    private String[] barcodes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    private String zip;
    
    public Barcode(String zip) {
	this.zip = zip;
    }
    
    public String getZip() {
	return zip;
    }
    public String getCode() {
	String ans = "";
	for (int i = 0; i < zip.length(); i ++) {
	    ans += barcodes[(Integer.valueOf(zip.substring(i, i + 1)))] + " ";
	}
	ans += barcodes[getCheckDigit(zip)];
	
	return ans;
    }

    private int getCheckDigit(String zip) {
	int sum = 0;
	for (int i = 0; i < zip.length(); i ++) {
	    sum += (int)zip.charAt(i);
	}
	return sum % 10;
    }

    public String toString() {
        return "| " + getCode() + " |  (" + getZip() + ")";
    }

    public boolean equals(Barcode bar) {
	return bar.getZip().equals(getZip());
    }

    public int compareTo(Barcode x) {
	return Integer.compare(Integer.valueOf(getZip()), Integer.valueOf(x.getZip()));
    }

    public static void main(String[]args){
	Barcode a = new Barcode("11245");
	Barcode b = new Barcode("38760");
	Barcode c = new Barcode("11245");
	Barcode d = new Barcode("00294");
	
	System.out.println(a.getZip());//11245
	System.out.println(d.getZip());//00234
	System.out.println(a.getCode());// | :::|| :::|| ::|:| :|::| :|:|: ::||: |
	System.out.println(a.toString());// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
	System.out.println(b);// |::||:|::|:|:::|:||::||::::|::|| (38760)
	System.out.println(c);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
	System.out.println(d);// |||:::||:::::|:||:|:::|::|:|:|:| (00294)
	System.out.println(a.compareTo(b));// negative
	System.out.println(a.compareTo(c));// 0
	System.out.println(a.compareTo(d));// positive
	System.out.println(a.equals(b));// false
	System.out.println(a.equals(c));// true
	System.out.println(a.equals(d));// false
    }
}

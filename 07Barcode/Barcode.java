import java.util.*;

public class Barcode implements Comparable<Barcode> {

    private String[] barcodes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    private String zip;
    
    public Barcode(String zip) {
	if (zip.length() != 5) {
	    throw new IllegalArgumentException("Invalid Zipcode.");
	}
	for (int i = 0; i < zip.length(); i++) {
	    if (!Character.isDigit(zip.charAt(i))) {
		throw new IllegalArgumentException("Invalid Zipcode.");
	    }
	}
	this.zip = zip;
    }

    /*public static String toZip(String code) {
	String[] barcodes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
        code = code.substring(1, code.length() - 1);
        String newZip = "";

	
        for (int i = 0; i < 5; i++) {
            for (int x = 0; x < barcodes.length; i++) {
                if (code.substring(5 * i, 5 * (i + 1)).equals(barcodes[x])) {
                    newZip += x;
                }
            }
        }
        return newZip;

	}*/
    
    public String getZip() {
	return zip;
    }
    public String getCode() {
	String ans = "|";
	for (int i = 0; i < zip.length(); i ++) {
	    ans += barcodes[(Integer.valueOf(zip.substring(i, i + 1)))];
	}
	ans += barcodes[getCheckDigit(zip)] + "|";
	
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
        return getCode() + " (" + getZip() + ")";
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

	//System.out.println(a.toZip("|::||:|::|:|:::|:||::||::::|::||"));
    }
}

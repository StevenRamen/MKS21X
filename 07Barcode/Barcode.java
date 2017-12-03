public class Barcode {

    private String[] barcodes;
    private String zip;
    
    public Barcode(String zip) {
	this.zip = zip;
	barcodes = ["||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"];
    }
    
    public String getZip() {
	return zip;
    }
    public String getCode() {
	String ans = "";
	for (int i = 0; i < zip.length() + 1; i ++) {
	    ans += getDigit(i) + " ";
	}
	return ans;
    }

    private String getDigit(int number) {
	return barcodes[number];
    }
    private int getCheckDigit(String zip) {
	int sum = 0;
	for (int i = 0; i < zip.length(); i ++) {
	    sum += (int) zip.charAt(i);
	}
	return sum % 10;
    }

    public String toString() {
        return "| " + getCode() + "(" + getZip() + ") |";
    }
}

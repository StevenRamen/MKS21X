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
	return null;
    }

    private String getDigit(int) {
	return barcodes[int];
    }
    private int getCheckDigit(String zip) {
	return null;
    }
}

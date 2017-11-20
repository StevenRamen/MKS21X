import java.util.*;
import java.io.*;

public class WordSearch {
    private static int seed;
    private char[][] data;
    private ArrayList<String> wordsToAdd = new ArrayList<String>();
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    private Random randgen;
    private static boolean key;
    private int r;
    private int c;
    
    public static void main(String[] args) {
	String instruction = "\n Please type in the format: java WordSearch [rows columns filename [seed [key]]] \n For Answer Key, please put in the seed and 'key'.";
	if (args.length < 3) {
	    System.out.println(instruction);
	} 
	else {
	    
	    int rows = 0,cols = 0;
	    seed = (int)(Math.random()*100000);

	    
	    try {
		rows = Integer.valueOf(args[0]);
		cols = Integer.valueOf(args[1]);
	    } catch (IllegalArgumentException e) {
		System.out.println(instruction);
		System.exit(0);
	    }

	    
	    String fileName = args[2];
	    key = false;
	    if (args.length >= 4) {
		try {
		    seed = Integer.valueOf(args[3]);
		} catch (IllegalArgumentException e) {
		    System.out.println(instruction);
		    System.exit(0);
		}
	    }

	    
	    if (args.length == 5 && args[4].equals("key")) {
	        key = true;
	    }
	    
	    WordSearch wordsearch = new WordSearch(rows, cols, fileName, seed, key);
	    System.out.println(wordsearch);
	    wordsearch.printWordList();
	}
    }
    
    public WordSearch(int r, int c, String fileName, int seed, Boolean key) {
	data = new char[r][c];
	this.r = r;
	this.c = c;
	this.seed = seed;
	this.key = key;
	randgen = new Random(seed);
	clear();
	loadWords(fileName);
	keyCheck();
    }
    
    private void keyCheck() {
	if (key) {
	    // put only words from answers
	    clear();
	    addAllWords();
	} else {
	    // fill the puzzle
	    addAllWords();
	    fillUp();
	}
    }
    
    private void clear() {
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data[i].length; j++) {
		data[i][j] = '_';
	    }
	}
    }
    
    public void fillUp() {
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data[i].length; j++) {
		if (data[i][j] == '_') {
		    data[i][j] = randomAlphabet();
		}
	    }
	}
    }
    
    public String toString() {
	String result = "\n";
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data[i].length; j++) {
		result += data[i][j] + " ";
	    }
	    result += "\n";
	}
	result += "\nYour seed is " + seed + ".\n";
	return result;
    }
    
    private boolean addWordHorizontal(String word,int row, int col) {
	if (data[row].length - col >= word.length() && isEmptyHorizontal(word, row, col)) {
	    for (int i = 0; i < word.length(); i++) {
		data[row][col + i] = word.charAt(i);
	    }
	    return true;
	} else {
	    return false;
	}
    }
    
    private boolean addWordVertical(String word,int row, int col){
	if (data.length - row >= word.length() && isEmptyVertical(word, row, col)) {
	    for (int i = 0; i < word.length(); i++) {
		data[row + i][col] = word.charAt(i);
	    }
	    return true;
	} 
	else {
	    return false;
	}
    }
    
    private boolean addWordRandom(String word,int row, int col, int rDir, int cDir) {
	if (data.length - row >= word.length() && data.length - col >= word.length() && isEmptyRandom(word, row, col, rDir, cDir)) {
	    for (int i = 0; i < word.length(); i++) {
		data[row + i * rDir][col + i * cDir] = word.charAt(i);
	    }
	    return true;
	} 
	else {
	    return false;
	}
    }
    
    private boolean isEmptyHorizontal(String word, int row, int col) {
	boolean result = true;
	for (int i = 0; i < word.length(); i++) {
	    if (data[row][col + i] != '_' && data[row][col + i] != word.charAt(i)) {
		result = false;
	    }
	}
	return result;
    }
    
    
    private boolean isEmptyVertical(String word, int row, int col) {
	boolean result = true;
	for (int i = 0; i < word.length(); i++) {
	    if (data[row + i][col] != '_' && data[row + i][col] != word.charAt(i)) {
		result = false;
	    }
	}
	return result;
    }
    
    private boolean isEmptyRandom(String word, int row, int col, int rDir, int cDir) {
	boolean result = true;
	if (rDir == 0 && cDir == 0) {
	    return false;
	}
	for (int i = 0; i < word.length(); i++) {
	    if (row + i * rDir > r || row + i * rDir < 0 || col + i * cDir > c || col + i * cDir < 0) {
		return false;
	    } 
	    if (data[row + i * rDir][col + i * cDir] != '_' && data[row + i * rDir][col + i * cDir] != word.charAt(i)) {
		return false;
	    }
	}
	return result;
    }
    
    private void loadWords(String fileName) {
	try{
	    Scanner in = new Scanner(new File(fileName));
	    //print each word in the text file:
	    while(in.hasNext()){
		String word = in.next().toUpperCase();
		wordsToAdd.add(word);
	    }
	    
	} catch(FileNotFoundException e) {
	    System.out.println("Invalid filename or path");
	    System.exit(1);
	}
    }
    
    
    private void addAllWords() {
	for (int i = 0; i < wordsToAdd.size(); i++) {
	    String word = wordsToAdd.get(i);
	    boolean pause = false;
	    int counter = 0, randomR, randomC, rDir, cDir;
	    while (!pause && counter <= 300) {
		randomR = randgen.nextInt(r);
		randomC = randgen.nextInt(c);
		rDir = randgen.nextInt(3) - 1;
		cDir = randgen.nextInt(3) - 1;
		// check if ^ are both 0
		if (addWordRandom(word, randomR, randomC, rDir, cDir)) {
		    wordsToAdd.remove(i);
		    wordsAdded.add(word);
		    pause = true;
		    i -= 1;
		}
		counter += 1;
	    }
	}
    }
    
    public void printWordList() {
	System.out.println(wordsAdded + "\n");
    }
    
    private char randomAlphabet() {
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	return alphabet.charAt(randgen.nextInt(alphabet.length()));
    }
}

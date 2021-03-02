/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Git URL:
 * Spring 2020
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {
	
	// static variables and constants only here.
	private static Set<String> dict;
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file, for student testing and grading only
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default input from Stdin
			ps = System.out;			// default output to Stdout
		}
		initialize();
		
		printLadder(parse(kb));
		
		// TODO methods to read in words, output ladder
		
		//this is how you move through the dictionary
		/*
		Iterator<String> it = dict.iterator();
		for(int i = 0; i < 10; i++) {
			System.out.println(it.next());
		}
		*/
	}
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
		dict = makeDictionary();
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		
		String input = keyboard.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		if(input.equals("/quit")) {
			return list;
		}
		else {
			int startOfWhitespace = -1;
			int endOfWhitespace = -1;
			boolean whitespaceFlag = false;
			for(int i = 0; i < input.length(); i++) {
				if(!whitespaceFlag && (input.toLowerCase().charAt(i) <= 96 || input.toLowerCase().charAt(i) >= 123)) {
					whitespaceFlag = true;
					startOfWhitespace = i;
					//System.out.println("Start of whitespace: " + i);
				}
				else if(whitespaceFlag && (input.toLowerCase().charAt(i) >= 96 && input.toLowerCase().charAt(i) <= 123)) {
					endOfWhitespace = i;
					whitespaceFlag = false;
					//System.out.println("End of whitespace: " + i);
				}
			}
			list.add(input.toLowerCase().substring(0, startOfWhitespace));
			list.add(input.toLowerCase().substring(endOfWhitespace));
			return list;
		}
	}
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		//Depth first Search, must use recursion
		
		// Returned list should be ordered start to end.  Include start and end.
		// If ladder is empty, return list with just start and end.
		// TODO some code
		
		return null; // replace this line later with real return
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
    	//Breadth First Search
    	ArrayList<String> returnList = new ArrayList<String>();
    	ArrayList<String> checkedList = new ArrayList<String>();
    	returnList.add(start);
    
    	Iterator<String> iterator = dict.iterator();
		// TODO some code
		
		return returnList;
	}
    
	
	public static void printLadder(ArrayList<String> ladder) {
		for(int i = 0; i < ladder.size(); i++) {
			System.out.println(ladder.get(i));
		}
	}
	// TODO
	// Other private static methods here


	/* Do not modify makeDictionary */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
}

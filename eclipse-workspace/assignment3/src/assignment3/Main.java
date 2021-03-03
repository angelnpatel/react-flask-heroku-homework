/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Angel Patel>
 * <ap54292>
 * <17125>
 * Slip days used: <0>
 * Git URL: https://github.com/EE422C/spring-21-a3-sp21-pr3-pair-22.git
 * Spring 2021
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
		
		//parse(kb);
		
		// TODO methods to read in words, output ladder
		
		ArrayList<String> userInput = parse(kb);
		getWordLadderBFS(userInput.get(0), userInput.get(1));

		//this is how you move through the dictionary
		Iterator<String> it = dict.iterator();
		for(int i = 0; i < 10; i++) {
			System.out.println(it.next());
		}
		
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
		if(input.equals("quit")) {
			return list;
		}
		else {
			String[] strArr = input.split(" ");
			list.add(strArr[0]);
			list.add(strArr[1]);
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
		
    	//Breadth First Search, must use recursion
    	
    	//invalid search
    	if(!(dict.contains(start)) || !(dict.contains(end))){
    		System.out.println("start or end not valid");
    	
    	}
    	
		// TODO some code
		return null; // replace this line later with real return
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

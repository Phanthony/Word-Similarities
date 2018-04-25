package edu.uiowa.cs.similarity;

import java.io.*;
import java.util.Scanner;


public class Main {
	private static void printMenu() {
		System.out.println("Supported commands:");
		System.out.println("help - Print the supported commands");
		System.out.println("quit - Quit this program");
                System.out.println("index FILE - Read in and index the file by given FILE");
	}

    public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print("> ");
			String command = input.readLine();
			if (command.equals("help") || command.equals("h")) {
				printMenu();
                        }
                        if (command.equals("index FILE")){
                            System.out.println("Indexing FILENAME");
                            
			} else if (command.equals("quit")) {
				System.exit(0);
			} else {
				System.err.println("Unrecognized command");
			}
		}
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        
        //file.useDelimiter(",*--:;"); ///use to clean up setences (maybe)
        while (file.hasNext()){
            String string = file.nextLine();
            System.out.println(string);
        }
        
        file.close();
    }
}

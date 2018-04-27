package edu.uiowa.cs.similarity;

import java.io.*;
import java.util.*;

public class Main {
	private static void printMenu() {
		System.out.println("Supported commands:");
		System.out.println("help - Print the supported commands");
		System.out.println("quit - Quit this program");
                System.out.println("index FILE - Read in and index the file give by FILE ");
                System.out.println("Num sentences - Print the number of sentences in the file");
                System.out.println("Sentences - Print the sentences in the file");
                
	}

    public static void main(String[] args) throws IOException {
         ArrayList<ArrayList<String>> Index = new ArrayList<>();
         Map <String, Map> Vectors = new HashMap<>();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print("> ");
			String command = input.readLine();
			if (command.equals("help") || command.equals("h") ){
				printMenu();
                        }
                        if (command.startsWith("index")){
                           String[] inputSplit = command.split(" ");
                           readFile readFile = new readFile();
                           Index = readFile.readFileWithScanner(inputSplit[1]);
                           System.out.println("Indexing " + inputSplit[1]);
                        }
                          
                            if (command.equals("Sentences")){
                               
                               System.out.println(Index);
                            
                            }
                           
                         if (command.equals("Num sentences")){
                              System.out.println(Index.size());
                        
			} 
                         else if (command.equals("quit")) {		
                             System.exit(0);
			} 
                         else {		
                             System.err.println("Unrecognized command");
			}
		}
    }
}

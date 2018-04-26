package edu.uiowa.cs.similarity;

import java.io.*;
import java.util.ArrayList;

public class Main {
	private static void printMenu() {
		System.out.println("Supported commands:");
		System.out.println("help - Print the supported commands");
		System.out.println("quit - Quit this program");
	}

    public static void main(String[] args) throws IOException {
         ArrayList<ArrayList<String>> Index = new ArrayList<>();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print("> ");
			String command = input.readLine();
			if (command.equals("help") || command.equals("h") ){
				printMenu();
                        }
                        if (command.equals("str")){
                           readFile readFile = new readFile();
                           Index = readFile.readFileWithScanner("C:\\Users\\APhan\\Desktop\\CS2HW\\project-team-40\\cleanup_test.txt");
                        }
                          
                            if (command.equals("Sentences")){
                               
                               System.out.println(Index);
                            
                            }
                           
                         if (command.equals("num")){
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

package edu.uiowa.cs.similarity;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	private static void printMenu() {
		System.out.println("Supported commands:");
		System.out.println("help - Print the supported commands");
		System.out.println("quit - Quit this program");
                System.out.println("index FILE - Read in and index the file by given FILE");
	}

    public static void main(String[] args) throws IOException {
         ArrayList<ArrayList<String>> Index = new ArrayList<>();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print("> ");
			String command = input.readLine();
			if (command.equals("help") ){
				printMenu();
                        }
                        if (command.equals("str")){
                           readFile readFile = new readFile();
                           Index = readFile.readFileWithScanner("C:\\Users\\APhan\\Desktop\\CS2HW\\project-team-40\\Final Project\\test.txt");
                        }
                          
                            if (command.equals("Sentences")){
                               
                               System.out.println(Index);
                            
                            }
                           
                         if (command.equals("num")){
                              System.out.println(Index.size());
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
}

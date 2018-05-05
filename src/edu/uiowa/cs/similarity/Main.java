package edu.uiowa.cs.similarity;

import java.io.*;
import java.util.*;
import opennlp.tools.stemmer.PorterStemmer;

public class Main {
	private static void printMenu() {
		System.out.println("Supported commands:");
		System.out.println("help - Print the supported commands");
		System.out.println("quit - Quit this program");
                System.out.println("Index FILE - Read in and index the file give by FILE ");
                System.out.println("Num sentences - Print the number of sentences in the file");
                System.out.println("Sentences - Print the sentences in the file");
                System.out.println("Vectors - Print the vectors for each word");
                System.out.println("Topj WORD NUM - returns NUM number of words most similar to WORD");
                System.out.println("Measure cos - change similarity measure to cosine similarity");
                System.out.println("Measure euc - change similarity measure to negative euclidean distance");
                System.out.println("Measure eucnorm - change similarity measure to negative euclidean distance between norms");
	}

    public static void main(String[] args) throws IOException {
         ArrayList<ArrayList<String>> Index = new ArrayList<>();
         Map <String, Map<String, Double>> Vectors = new HashMap<>();
         CalculationFunction calc = new CosineSim();
         PorterStemmer stem = new PorterStemmer();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print("> ");
			String command = input.readLine();
			if (command.equals("help") || command.equals("h") ){
				printMenu();
                        }
                        else if (command.toLowerCase().equals("vectors")){
                            Vectors = vectors.vectorCreation(Vectors, Index);
                            System.out.println(Vectors.entrySet());
                        }
                        else if (command.toLowerCase().startsWith("index")){
                           String[] inputSplit = command.split(" ");
                           Index = readFile.readFileWithScanner(inputSplit[1]);
                           System.out.println("Indexing " + inputSplit[1]);
                        }
                          
                        else if (command.toLowerCase().equals("sentences")){
                               
                               System.out.println(Index);
                            
                            }
                        
                        else if (command.toLowerCase().startsWith("topj")){
                            String[] inputSplit = command.split(" ");
                            if (Vectors.containsKey(inputSplit[1])){
                            System.out.println(vectors.topJ(Integer.parseInt(inputSplit[2]), stem.stem(inputSplit[1]), Vectors, calc));
                            }
                            else{
                                System.out.println("Cannot Compute top-J similarity to " + inputSplit[1]);
                            }
                        }
                        
                        else if (command.toLowerCase().startsWith("measure")){
                            String[] inputSplit = command.split(" ");
                            if (inputSplit[1].toLowerCase().equals("cos")){
                                calc = new CosineSim();
                                System.out.println("Similarity measure is cosine similarity");
                            }
                            else if (inputSplit[1].toLowerCase().equals("euc")){
                                calc = new EucDistance();
                                System.out.println("Similarity measure is negative euclidean distance");
                            }
                            else if (inputSplit[1].toLowerCase().equals("eucnorm")){
                                calc = new EucDistanceNorm();
                                System.out.println("Similarity measure is negative euclidean distance between norms");
                            }
                            else{
                                System.out.println("Similarity measure not found");
                            }
                            
                        }
                           
                        else if (command.toLowerCase().equals("num sentences")){
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

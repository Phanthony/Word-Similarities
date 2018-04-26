/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uiowa.cs.similarity;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import opennlp.tools.stemmer.PorterStemmer;

/**
 *
 * @author Anthony
 */
public class readFile {
    
    public static ArrayList readFileWithScanner(String fileName) throws FileNotFoundException{
        Scanner stopFile = new Scanner(new File("C:\\Users\\Nghia\\OneDrive\\Desktop\\PRJECT\\project-team-40\\stopwords.txt"));
        ArrayList<String> stopList = new ArrayList<>();
        while (stopFile.hasNextLine()){
            stopList.add(stopFile.nextLine());
        }
        stopFile.close();
        //Turn stopwords into an array
        Scanner file = new Scanner(new File(fileName));
        ArrayList<ArrayList<String>> sentenceList = new ArrayList<>();
        ArrayList<String> builder = new ArrayList<>();
        String sentenceEnd = ".*[.!?].*";
        PorterStemmer stem = new PorterStemmer();
// If the sentence contains ^ then it means its the end of the sentence
        String puncuation = "[,;:\"]";
        // check puncuation and remove it out of words
        while (file.hasNext()){
            int stopCheck = 0;
            // Needs chekcer to hold file.next so you dont end up calling it multiple times moving through the sentences
            String checker = (file.next().toLowerCase());
            if(checker.matches((".*[,;:\"].*"))){
                checker = checker.replaceAll(puncuation, "");
            }
            // Puts the current word into lowercase 
            // checks to see if it is a stop word, if so don't do the rest of the checks
            for(String stopper : stopList){
              if (checker.matches(stopper)){
                  stopCheck = 1;
              }  
            }
            
          if (stopCheck == 0){
              // stem the currnet word
              checker = stem.stem(checker);
              // checks puncuation and removes it
                // check to see if the word you're adding to the building list is the end of the sentence
            if(!checker.matches(sentenceEnd)){
            builder.add(checker);
               System.out.println(checker);
            }
            else{
                checker = checker.replaceAll("[.!?]", "");
                builder.add(checker);
                sentenceList.add(builder);
                builder = new ArrayList<>();
                   System.out.println(checker);
            }

    }
        }
       
return sentenceList;
}
}
    


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

/**
 *
 * @author Anthony
 */
public class readFile {
    public static void readFileWithScanner(String fileName) throws FileNotFoundException{
        Scanner file = new Scanner(new File(fileName));
        ArrayList<ArrayList<String>> sentenceList = new ArrayList<>();
        ArrayList<String> builder = new ArrayList<>();
        String sentenceEnd = ".*[.!?].*";
// If the sentence contains ^ then it means its the end of the sentence
        String puncuation = "[,-;:\"']";
        // check puncuation and remove it out of words
        while (file.hasNext()){
            // check to see if the word you're adding to the building list is the end of the sentence
            String checker = file.next();
            if(checker.matches(puncuation)){
                checker = checker.replaceAll(puncuation, "");
            }
             System.out.println(checker);
            if(!checker.matches(sentenceEnd)){
            builder.add(checker);
            }
            else{
                builder.add(checker);
                sentenceList.add(builder);
                builder = new ArrayList<>();
            }

    }
       
}
}
    


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
    public static void readFileWithScanner(String fileName) throws FileNotFoundException{
        Scanner file = new Scanner(new File(fileName));
        ArrayList<ArrayList<String>> sentenceList = new ArrayList<>();
        ArrayList<String> builder = new ArrayList<>();
        String sentenceEnd = ".*[.!?].*";
        PorterStemmer stem = new PorterStemmer();
// If the sentence contains ^ then it means its the end of the sentence
String puncuation = "[,--;:\"']";
        Pattern puncuationPat = Pattern.compile((".*[,--;:\"'].*"));
        // check puncuation and remove it out of words
        while (file.hasNext()){
            // check to see if the word you're adding to the building list is the end of the sentence
            // Needs chekcer to hold file.next so you dont end up calling it multiple times moving through the sentences
            String checker = stem.stem(file.next().toLowerCase());
            Matcher f = puncuationPat.matcher(checker);
            if(f.find()){
                checker = checker.replaceAll(puncuation, "");
            }
          
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
}
    


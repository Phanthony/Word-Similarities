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

/**
 *
 * @author Nghia
 */
public class readFile {
    public static void readFileWithScanner(String fileName) throws FileNotFoundException{
        Scanner file = new Scanner(new File(fileName));
        String [] sentence;
        ArrayList<String> sentenceList = new ArrayList<String>();
        //file.useDelimiter(",*--:;")// for cleaning up words
        while (file.hasNext()){
            String string = file.nextLine();
            System.out.println(string);
        }
        file.close();
        String[] sentenceToArray = sentenceList.toArray(new String[sentenceList.size()]);
        for (int i = 0 ; i < sentenceToArray.length; i++){
            sentence = sentenceToArray[i].split(".!?");
            for (int j = 0; j<sentence.length;j++){
                System.out.println("Sentence" + (j+1)+" : " + sentence[j]);
            }
        }   
    }
}


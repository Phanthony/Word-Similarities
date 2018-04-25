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
        String str = "Hello World";
        Scanner file = new Scanner(str);
        ArrayList<String> sentenceList = new ArrayList<String>();
        //file.useDelimiter(",*--:;")// for cleaning up words
        while (file.hasNext()){
            sentenceList.add(file.nextLine());
       
    }
    }
}


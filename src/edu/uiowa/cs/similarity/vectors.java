package edu.uiowa.cs.similarity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.*;


public class vectors {
    public static Map vectorCreation(Map<String, Map> master , ArrayList<ArrayList<String>> sentence){
      for (ArrayList<String> sentenceArray : sentence){
          ArrayList<String> seen = new ArrayList<>();
          for (String word : sentenceArray){
              if(!inside(word, seen)){
              if (!master.containsKey(word)){
                  Map <String, Double > vector = new HashMap<>();
                  for(String word2 : sentenceArray){
                      if(!word.equals(word2)){
                          vector.put(word2, 1.0);
                      }
                  }
                  master.put(word, vector);
                  seen.add(word);
              }
              else{
              Map<String, Double> insideVector = master.get(word);
              for (String word2 : sentenceArray){
                  if(!word.equals(word2)){
                      if(insideVector.containsKey(word2)){
                          insideVector.replace(word2, insideVector.get(word2) + 1.0);
                      }
                      else{
                          insideVector.put(word, 1.0);
                      }
                  }
              }
              seen.add(word);
              }
          }
      }
          
    }
      return master;
    }
    
    private static boolean inside (String word, ArrayList<String> seen){
        for (String checker : seen){
            if(word.equals(checker)){
                return true;
            }
        }
        return false;
    }
    
    private static ArrayList similar (int j, String word, Map<String, Map<String, Double>> vectors){
        ArrayList<
        String[] allwords = vectors.keySet().toArray(new String[0]);
        vectors.get(word).keySet().toArray(new String[0]);
        for (String otherwords : allwords){
            if (!word.equals(otherwords)){
                
            }
        }
    }
}



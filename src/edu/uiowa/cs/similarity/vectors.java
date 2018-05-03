package edu.uiowa.cs.similarity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.*;
import java.lang.Math;


public class vectors {
    public static Map vectorCreation(Map<String, Map<String, Double>> master , ArrayList<ArrayList<String>> sentence){
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
                          insideVector.put(word2, 1.0);
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
    
    private static ArrayList<String> mergeList (ArrayList<String> array1, ArrayList<String> array2){
        ArrayList<String> combined = new ArrayList<>(array1);
        combined.removeAll(array2);
        combined.addAll(array2);
        return combined;
    }
    
    private static double addSimValue (ArrayList<Map<String, Double>> masterList, int j, Map<String,Double> sim, Double simValue, Double smallest){
        
        if(masterList.isEmpty()){
            masterList.add(sim);
            smallest = simValue;
        }
        else if (simValue > smallest || masterList.size() < j) {
            for(int x = 0; x < masterList.size(); x++){
                ArrayList<String> simList = new ArrayList<>(masterList.get(x).keySet());
                if (simValue > masterList.get(x).get(simList.get(0))){
                    masterList.add(x, sim);
                    ArrayList<String> last = new ArrayList<>(masterList.get(masterList.size()-1).keySet());
                    smallest = masterList.get(masterList.size()-1).get(last.get(0));
                    break;
                }
            }
        }
        if(masterList.size() > j){
                        masterList.remove(masterList.size()-1);
                        ArrayList<String> last = new ArrayList<>(masterList.get(masterList.size()-1).keySet());
                        smallest = masterList.get(masterList.size()-1).get(last.get(0));
                    }
        return smallest;
    }
    
    
    
    public static ArrayList topJ (int j, String word, Map<String, Map<String, Double>> masterVector){
        ArrayList<Map<String, Double>> simValueList = new ArrayList<>();
        Map<String, Double> wordVector = masterVector.get(word);
       ArrayList<String> wordsinWordVector = new ArrayList<>(wordVector.keySet());
       Set <String> comparingWords = masterVector.keySet();
       Double smallest = 0.0;
       for (String wordinComparingWords : comparingWords){
           if(!wordinComparingWords.equals(word)){
               Map<String, Double> comparingVector = masterVector.get(wordinComparingWords);
                ArrayList<String> wordsinComparingVector = new ArrayList<>(comparingVector.keySet());
                ArrayList<String> combinedLists = new ArrayList<>(mergeList(wordsinWordVector, wordsinComparingVector));
                Double numerator = 0.0;
                Double denominator1 = 0.0;
                Double denominator2 = 0.0;
                for (String wordsinCombinedLists : combinedLists){
                    if (wordVector.containsKey(wordsinCombinedLists) && comparingVector.containsKey(wordsinCombinedLists)){
                        numerator += comparingVector.get(wordsinCombinedLists) * wordVector.get(wordsinCombinedLists);
                    }
                     if (wordVector.containsKey(wordsinCombinedLists)){
                         denominator1 += wordVector.get(wordsinCombinedLists) * wordVector.get(wordsinCombinedLists);
                     }
                     if (comparingVector.containsKey(wordsinCombinedLists)){
                         denominator2 += comparingVector.get(wordsinCombinedLists) * comparingVector.get(wordsinCombinedLists);
                     }
                }
                Double simValue;
                if(numerator == 0.0 || denominator1 == 0.0 || denominator2 == 0.0){
                    simValue = 0.0;
                }
                else{
                     simValue = numerator / Math.sqrt(denominator1 * denominator2);
                }
                Map<String, Double> simWordValue = new HashMap<>();
                simWordValue.put(wordinComparingWords, simValue);
                smallest = addSimValue(simValueList, j, simWordValue, simValue, smallest);
           }
       }
       return simValueList;
    }
}



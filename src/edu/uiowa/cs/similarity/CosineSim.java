/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uiowa.cs.similarity;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author APhan
 */
public class CosineSim implements CalculationFunction{
    @Override
    public Double calculate(Map<String, Map<String, Double>> masterVector, Map<String, Double> wordVector, String wordinComparingWords){
        Map<String, Double> comparingVector = masterVector.get(wordinComparingWords);
                ArrayList<String> wordsinComparingVector = new ArrayList<>(comparingVector.keySet());
                ArrayList<String> combinedLists = new ArrayList<>(vectors.mergeList(new ArrayList<>(wordVector.keySet()), wordsinComparingVector));
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
    return simValue;
}
}

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
public class EucDistance implements CalculationFunction{
    @Override
    public Double calculate(Map<String, Map<String, Double>> masterVector, Map<String, Double> wordVector, String wordinComparingWords){
        Map<String, Double> comparingVector = masterVector.get(wordinComparingWords);
                ArrayList<String> wordsinComparingVector = new ArrayList<>(comparingVector.keySet());
                ArrayList<String> combinedLists = new ArrayList<>(vectors.mergeList(new ArrayList<>(wordVector.keySet()), wordsinComparingVector));
                Double vector1 = 0.0;
                Double vector2 = 0.0;
                Double total = 0.0;
                for (String wordsinCombinedLists : combinedLists){
                    if(wordVector.containsKey(wordsinCombinedLists)){
                        vector1 = wordVector.get(wordsinCombinedLists);
                    }
                    else{
                        vector1 = 0.0;
                    }
                    if(comparingVector.containsKey(wordsinCombinedLists)){
                        vector2 = comparingVector.get(wordsinCombinedLists); 
                    }
                    else{
                        vector2 = 0.0;
                    }
                    total += (vector1 - vector2)*(vector1 - vector2);
                }
                if (total == 0.0){
                    return 0.0;
                }
                else{
                    return Math.sqrt(total) * -1.0;
                }
    }
}

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
public class EucDistnaceNorm implements CalculationFunction{
    @Override
    public Double calculate(Map<String, Map<String, Double>> masterVector, Map<String, Double> wordVector, String wordinComparingWords){
        Map<String, Double> comparingVector = masterVector.get(wordinComparingWords);
                ArrayList<String> wordsinComparingVector = new ArrayList<>(comparingVector.keySet());
                ArrayList<String> combinedLists = new ArrayList<>(vectors.mergeList(new ArrayList<>(wordVector.keySet()), wordsinComparingVector));
                Double vector1 = 0.0;
                Double vector2 = 0.0;
                Double total = 0.0;
                for (String wordsinCombinedLists : combinedLists){
                    
                }
                return total;
}
}

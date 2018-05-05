package edu.uiowa.cs.similarity;

import java.util.Map;

/**
 *
 * @author APhan
 */
public interface CalculationFunction {
    
   public Double calculate(Map<String, Map<String, Double>> vector, Map<String, Double> wordVector, String wordinComparingWords);
}

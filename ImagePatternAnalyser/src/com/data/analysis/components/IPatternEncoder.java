package com.data.analysis.components;

/**
 * Created by chandan on 1/7/14.
 * PatternEncoder interface
 * Based on the pattern(shape or any other metric) appropriate pattern encoders
 * have to implement this interface.
 */
public interface IPatternEncoder {
    public void initialize(int rows,int columns, String[] encodedData);
}

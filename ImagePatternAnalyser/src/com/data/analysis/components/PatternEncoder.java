package com.data.analysis.components;

/**
 * Created by chandan on 1/7/14.
 * Generic PatternEncoder class.
 * This is extended by the appropriate PatternEncoders to include the common functionalities.
 */
public class PatternEncoder {
    private int _rows;
    private int _columns;
    private String[] encodedMatrix;

    public void setRows(int rows) {
        _rows = rows;
    }

    public int getRows(){
        return _rows;
    }

    public void setColumns(int columns) {
        _columns = columns;
    }

    public int getColumns(){
        return _columns;
    }

    public void setEncodedMatrix(String[] value){
        encodedMatrix = value;
    }

    public String[] getEncodedMatrix(){
        return encodedMatrix;
    }
}

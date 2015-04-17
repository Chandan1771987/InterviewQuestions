package com.data.analysis.utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by chandan on 1/7/14.
 * This is an utility class.
 * It has helper methods to construct a 2D Matrix of the provided pattern.
 * This is used by the PatternAdapters and Encoders and Detectors.
 */
public class PatternEncoderUtil {

    private BufferedReader _bufferedReader;
    String[] _pattern;
    private int _rowCount;
    private int colBegin,colEnd;

    public void setData(int rows,int columnBegin,int columnEnd,String[] pattern){
        _rowCount = rows;
        colBegin = columnBegin;
        colEnd = columnEnd;
        _pattern = pattern;
    }

    public void construct2DMatrix(FileReader fileReader){
        int trackNumberOfRows = 0;
        int sIndex = 0;
        boolean rowCountTrackStarted = false;
        String _patternExtracted;
        String sCurrentLine;
        String _convertedPattern="";
        try {
            _bufferedReader = new BufferedReader(fileReader);
            while ((sCurrentLine = _bufferedReader.readLine()) != null  ) {
                if(trackNumberOfRows == _rowCount)
                    break;
                if(sCurrentLine.indexOf('+') !=-1 && rowCountTrackStarted == false){
                    rowCountTrackStarted = true;
                }
                else if(rowCountTrackStarted){
                    // do nothing
                }
                else
                {
                    continue;
                }
                _patternExtracted = sCurrentLine.substring(colBegin,colEnd+1);
                sIndex = 0;
                _convertedPattern="";
                while(sIndex<_patternExtracted.length()){
                    _convertedPattern += (_patternExtracted.charAt(sIndex) == '+'?1:0);
                    sIndex++;
                }
                _pattern[trackNumberOfRows] = String.valueOf(binaryToDecimal(_convertedPattern));
                trackNumberOfRows++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (_bufferedReader != null)_bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void construct2DMatrixFromStringSet(int currentRow,int startIndex,int numRows,int numColumns,List<String> rawData){
        String sCurrentLine="";
        String _convertedPattern="";
        int trackNumberOfRows = 0;
        int sIndex = 0;
        _pattern = new String[numRows];
        while(true){
            sCurrentLine = rawData.get(currentRow).substring(startIndex, startIndex + numColumns);
            sIndex = 0;
            if(trackNumberOfRows == numRows)
                break;
            _convertedPattern="";
            while(sIndex<sCurrentLine.length()){
                _convertedPattern += (sCurrentLine.charAt(sIndex) == '+'?1:0);
                sIndex++;
            }
            _pattern[trackNumberOfRows] = String.valueOf(binaryToDecimal(_convertedPattern));
            trackNumberOfRows++;
        }
    }
    public String[] getPattern(){
        return _pattern;
    }

    private int binaryToDecimal(String binaryNumber){
        int len = binaryNumber.length(),sum =0,c=0;
        int e = 0;
        int multiplier = 0;
        for(int start=0; start<binaryNumber.length(); start++)
        {
            len--;
            e= (int) Math.pow(2,len);
            if(binaryNumber.charAt(start) == '0'){
                multiplier = 0;
            }
            else{
                multiplier = 1;
            }
            c = multiplier * e;
            sum=sum+c;
        }
        return sum;
    }

    public int findNumberOfPixelsDiffering(int a,int b){

        int result = a^b;
        int _variations = 0;
        while (result != 0)
        {
            if(result % 2 == 1){
                _variations++;
            }
            result = result/2;
        }
        return _variations;
    }
}

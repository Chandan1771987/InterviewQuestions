package com.data.analysis.components;

import com.data.analysis.utils.PatternEncoderUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chandan on 1/7/14.
 * This is the ImagePreprocessor
 * It parses the provided rawData and holds the data in memory.
 * It uses the utility class to generate encoded Pattern.
 * Pattern detectors makes use of this imagePreprocessor.
 *
 *  If used in high scalable environments, the encodedData can be stored in persistent storages
 * like memcache, membase/Couchbase or mysqlDatabase.
 *
 */
public class ImagePreprocessor {
    private List<String> _rawData;
    private FileReader fileReader;
    private BufferedReader _bufferedReader;
    private String sCurrentLine="";
    private int index = 0;
    private PatternEncoderUtil patternEncoderUtil;

    private ProtonPatternDetector _protonDetector;
    private RavagePatternDetector _ravageDetector;



    public void initialize(String filePath){
        _rawData = new LinkedList<String>();
        patternEncoderUtil = new PatternEncoderUtil();
        try {
            fileReader = new FileReader(filePath);
            _bufferedReader = new BufferedReader(fileReader);
            while ((sCurrentLine = _bufferedReader.readLine()) != null  ) {
                _rawData.add(sCurrentLine);
                index++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (_bufferedReader != null)_bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String[] preprocessRawData(int currentRow,int startIndex, int numRows,int numColumns){
        List<String> rawData = getRawData();
        String[] pattern;
        patternEncoderUtil.construct2DMatrixFromStringSet(currentRow,startIndex,numRows,numColumns,rawData);
        pattern = patternEncoderUtil.getPattern();
        return pattern;
    }

    public List<String> getRawData(){
        return _rawData;
    }

    public void setProtonDetector(ProtonPatternDetector protonDetector){
        _protonDetector= protonDetector;
    }

    public void setRavageDetector(RavagePatternDetector ravageDetector){
        _ravageDetector = ravageDetector;
    }

}

package com.data.analysis.modules;

import com.data.analysis.components.IPatternEncoder;
import com.data.analysis.utils.PatternEncoderUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by chandan on 1/7/14.
 */
public class PatternModule {
    private BufferedReader _bufferedReader;
    private IPatternEncoder _patternEncoder;
    private int _colCount;
    private int _rowCount;
    private int colBegin;
    private int colEnd;
    private String[] pattern;

    private PatternEncoderUtil patternEncoderUtil;


    protected void setUtil(PatternEncoderUtil value){
        patternEncoderUtil = value;
    }

    protected void analyzePattern(FileReader fileReader){
        boolean rowCountTrackStarted = false;
        String sCurrentLine;
        colBegin = 0;
        colEnd = 0;
        try {
            _bufferedReader = new BufferedReader(fileReader);
            _rowCount = 0 ;
            _colCount = 0;
            while ((sCurrentLine = _bufferedReader.readLine()) != null  ) {
                if(sCurrentLine.indexOf('+') !=-1){
                    if(colBegin==0){
                        colBegin = sCurrentLine.indexOf('+');
                    }
                    else if(colBegin >sCurrentLine.indexOf('+')){
                        colBegin = sCurrentLine.indexOf('+');
                    }
                }

                if(colEnd < sCurrentLine.lastIndexOf('+')){
                    colEnd = sCurrentLine.lastIndexOf('+');
                }
                if(rowCountTrackStarted == false && colBegin!=-1){
                    rowCountTrackStarted = true;
                }
                if(rowCountTrackStarted){
                    _rowCount++;
                }
            }
            if(_rowCount>1){
                _rowCount = _rowCount-2;
            }
            if(colEnd>=colBegin){
                _colCount = colEnd - colBegin +1;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (_bufferedReader != null)_bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        pattern = new String[_rowCount];
        patternEncoderUtil.setData(_rowCount,colBegin,colEnd,pattern);
    }

    public void setPatternEncoder(IPatternEncoder encoder){
        _patternEncoder = encoder;
    }

    protected IPatternEncoder getPatternEncoder(){
        return _patternEncoder;
    }

    protected void initializeEncoderComponents(){
        _patternEncoder.initialize(_rowCount,_colCount,pattern);
    }
}

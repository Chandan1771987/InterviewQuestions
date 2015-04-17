package com.data.analysis.components;

import com.data.analysis.utils.PatternEncoderUtil;

/**
 * Created by chandan on 1/7/14.
 * Detector class for Proton patterns.
 * Calculates the confidence with which proton pattern is found
 * It also houses the x and y coordinates, encodedData.
 */


public class ProtonPatternDetector {

    private ProtonPatternEncoder protonPatternEncoder;
    private PatternEncoderUtil patternEncoderUtil;
    private String[] encodedData;

    private int xCoordinate;
    private int yCoordinate;

    private int _confidence;
    private ImagePreprocessor _imagePreprocessor;

    public ProtonPatternDetector(){
        patternEncoderUtil = new PatternEncoderUtil();
    }

    public void setImagePreprocessor(ImagePreprocessor imagePreprocessor){
        _imagePreprocessor=imagePreprocessor;
    }

    public void setProtonEncoder(ProtonPatternEncoder encoder){
        protonPatternEncoder = encoder;
    }

    public int getConfidence(){
        return _confidence;
    }

    public void calculateConfidence(){
        int variations = 0;
        int startIndex = 0;
        int totalPixels = 0;
        String[] protonData = protonPatternEncoder.getEncodedMatrix();

        while(startIndex<protonPatternEncoder.getRows()){
            variations+=patternEncoderUtil.findNumberOfPixelsDiffering(Integer.parseInt(protonData[startIndex]),Integer.parseInt(encodedData[startIndex]));
            startIndex++;
        }
        totalPixels = protonPatternEncoder.getRows() * protonPatternEncoder.getColumns();
        _confidence = ((totalPixels - variations)*100/totalPixels);
    }

    public void setXYCoordinates(int x,int y){
        xCoordinate = x;
        yCoordinate = y;
    }

    public int getX(){
        return xCoordinate;
    }

    public int getY(){
        return yCoordinate;
    }

    public void initialize(){
       encodedData =  _imagePreprocessor.preprocessRawData(xCoordinate,yCoordinate,protonPatternEncoder.getRows(),protonPatternEncoder.getColumns());
       calculateConfidence();
    }

    public String[] getEncodedData(){
        return encodedData;
    }

}

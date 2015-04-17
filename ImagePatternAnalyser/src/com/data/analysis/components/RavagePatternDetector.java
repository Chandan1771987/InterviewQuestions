package com.data.analysis.components;

import com.data.analysis.utils.PatternEncoderUtil;

/**
 * Created by chandan on 1/7/14.
 * Detector class for Ravage patterns.
 * Calculates the confidence with which ravage pattern is found
 * It also houses the x and y coordinates, encodedData.
 */

public class RavagePatternDetector {
    private RavagerPatternEncoder ravagerPatternEncoder;
    private PatternEncoderUtil patternEncoderUtil;
    private String[] encodedData;

    private int xCoordinate;
    private int yCoordinate;
    private int _confidence;
    private ImagePreprocessor _imagePreprocessor;

    public void setImagePreprocessor(ImagePreprocessor imagePreprocessor){
        _imagePreprocessor=imagePreprocessor;
    }

    public RavagePatternDetector(){
        patternEncoderUtil = new PatternEncoderUtil();
    }

    public void setRavagerPatternEncoder(RavagerPatternEncoder encoder){
        ravagerPatternEncoder = encoder;
    }

    public int getConfidence(){
        return _confidence;
    }

    /**
     * Confidence is calculated based on the numberOfPatterns
     * identical w.r.t the detectedPattern and actualPattern.
     * confidence = (totalPixels - variations )/totalPixels
     */
    public void calculateConfidence(){
        int variations = 0;
        int startIndex = 0;
        int totalPixels = 0;
        String[] ravageData = ravagerPatternEncoder.getEncodedMatrix();
        while(startIndex<ravagerPatternEncoder.getRows()){
            variations+=patternEncoderUtil.findNumberOfPixelsDiffering(Integer.parseInt(ravageData[startIndex]), Integer.parseInt(encodedData[startIndex]));
            startIndex++;
        }
        totalPixels = ravagerPatternEncoder.getRows() * ravagerPatternEncoder.getColumns();
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
        encodedData = _imagePreprocessor.preprocessRawData(xCoordinate, yCoordinate, ravagerPatternEncoder.getRows(), ravagerPatternEncoder.getColumns());
        calculateConfidence();
    }

    public String[] getEncodedData(){
        return encodedData;
    }

}

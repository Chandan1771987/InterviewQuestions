package com.data.analysis.test;

import com.data.analysis.DataAnalysisManager;
import com.data.analysis.components.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chandan on 1/7/14.
 */
public class DataAnalysisManagerTest extends TestCase {
    private DataAnalysisManager dataAnalysisManager;
    private ProtonPatternEncoder protonPatternEncoder;
    private ProtonPatternAdapter protonPatternAdapter;
    private RavagerPatternEncoder ravagerPatternEncoder;
    private RavagerPatternAdapter ravagerPatternAdapter;
    private  ImagePreprocessor imagePreprocessor;
    private List<RavagePatternDetector> ravageDetectedPatterns;
    private List<ProtonPatternDetector> protonDetectedPatterns;
    private int _rows;
    private int _columns;
    private int _tolerance;
    private String filePath;

    private RavagePatternDetector ravagePattern;
    private ProtonPatternDetector protonPattern;


    List<ProtonPatternDetector> foundProtonPatterns;
    List<RavagePatternDetector> foundRavagePatterns ;


    private void bootStrap(){
        initializeVariables();
        filePath = "data\\DetectorOutput.blf";
        imagePreprocessor.initialize(filePath);

        filePath = "data\\Ravager.blf";
        ravagerPatternAdapter.setPatternEncoder(ravagerPatternEncoder);
        ravagerPatternAdapter.initialize(filePath);

        filePath = "data\\ProtonTorpedo.blf";
        protonPatternAdapter.setPatternEncoder(protonPatternEncoder);
        protonPatternAdapter.initialize(filePath);

        dataAnalysisManager.set_tolerance(60);
        dataAnalysisManager.setImagePreprocessor(imagePreprocessor);
        dataAnalysisManager.setProtonPatternAdapter(protonPatternAdapter);
        dataAnalysisManager.setRavagerPatternAdapter(ravagerPatternAdapter);
        dataAnalysisManager.setProtonPatternEncoder(protonPatternEncoder);
        dataAnalysisManager.setRavagerPatternEncoder(ravagerPatternEncoder);
        dataAnalysisManager.initialize();
    }

    private void initializeVariables(){
        dataAnalysisManager = new DataAnalysisManager();
        dataAnalysisManager.set_rows(_rows);
        dataAnalysisManager.set_columns(_columns);
        imagePreprocessor = new ImagePreprocessor();
        protonPatternEncoder = new ProtonPatternEncoder();
        ravagerPatternEncoder = new RavagerPatternEncoder();
        protonPatternAdapter = new ProtonPatternAdapter();
        ravagerPatternAdapter = new RavagerPatternAdapter();
        ravageDetectedPatterns = new LinkedList<RavagePatternDetector>();
        protonDetectedPatterns = new LinkedList<ProtonPatternDetector>();
    }

    private void set_rows(int value){
        _rows = value;
    }

    private void set_columns(int value){
        _columns = value;
    }

    @Test
    public void testRawDataReader(){
        initializeVariables();
        String filePath = "data\\DetectorOutput.blf";
        imagePreprocessor.initialize(filePath);
        List<String> rawData = imagePreprocessor.getRawData();
        Assert.assertEquals(true,rawData.size()>0);
    }

    @Test
    public void testProtonPatternEncoder(){
        initializeVariables();
        filePath = "data\\ProtonTorpedo.blf";
        protonPatternAdapter.setPatternEncoder(protonPatternEncoder);
        protonPatternAdapter.initialize(filePath);
        Assert.assertEquals(11,protonPatternEncoder.getRows());
        Assert.assertEquals(9,protonPatternEncoder.getColumns());
        String[] encodedData = {"16","16","56","254","198","403","443","403","198","254","56"};
        Assert.assertEquals(encodedData[2],protonPatternEncoder.getEncodedMatrix()[2]);
    }

    @Test
    public void testRavagePatternDetector(){
        initializeVariables();
        filePath = "data\\Ravager.blf";
        ravagerPatternAdapter.setPatternEncoder(ravagerPatternEncoder);
        ravagerPatternAdapter.initialize(filePath);
        Assert.assertEquals(9,ravagerPatternEncoder.getRows());
        Assert.assertEquals(12,ravagerPatternEncoder.getColumns());
        String[] encodedData = {"2046","3075","2046","96","96","96","2046","3075","2046"};
        Assert.assertEquals(encodedData[5],ravagerPatternEncoder.getEncodedMatrix()[5]);
    }

    /**
     * Test function to check the dataAnalyzer
     * Tolerance level is set to ?=60 in bootstrap.
     *
     */
    @Test
    public void testDataAnalyzer(){
        set_rows(50);
        set_columns(50);
        bootStrap();
        ravageDetectedPatterns = dataAnalysisManager.getRavageDetectedPatterns();
        protonDetectedPatterns = dataAnalysisManager.getProtonDetectedPatterns();
        Assert.assertEquals(true,protonDetectedPatterns.size()>0);

        foundProtonPatterns = new LinkedList<ProtonPatternDetector>();
        foundRavagePatterns = new LinkedList<RavagePatternDetector>();
        for(int startIndex = 0;startIndex<protonDetectedPatterns.size();startIndex++){
            protonPattern = protonDetectedPatterns.get(startIndex);
            if(protonPattern.getConfidence()>=dataAnalysisManager.get_tolerance()){
                foundProtonPatterns.add(protonPattern);
            }
        }

        for(int startIndex = 0;startIndex<ravageDetectedPatterns.size();startIndex++){
            ravagePattern = ravageDetectedPatterns.get(startIndex);
            if(ravagePattern.getConfidence()>=dataAnalysisManager.get_tolerance()){
                foundRavagePatterns.add(ravagePattern);
            }
        }

        Assert.assertEquals(true,foundProtonPatterns.size()>0);
        Assert.assertEquals(true,foundRavagePatterns.size()>0);
    }

}

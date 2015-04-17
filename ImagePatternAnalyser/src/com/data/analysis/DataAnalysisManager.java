package com.data.analysis;

import com.data.analysis.components.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chandan on 1/7/14.
 * This is the Manager that is responsible for creating the appropraite objects
 * This encodes the patterns.
 * Detector uses the imagePreprocessor and detects the patterns with confidence levels.
 *
 * We do preprocessing before detecting the patterns.
 *      This enhances the time complexity but at the cost of extra memory.
 */


public class DataAnalysisManager {

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



    public DataAnalysisManager(){

    }

    private void initializeVariables(){
        set_rows(50);
        set_columns(50);
        imagePreprocessor = new ImagePreprocessor();
        protonPatternEncoder = new ProtonPatternEncoder();
        ravagerPatternEncoder = new RavagerPatternEncoder();
        protonPatternAdapter = new ProtonPatternAdapter();
        ravagerPatternAdapter = new RavagerPatternAdapter();
        ravageDetectedPatterns = new LinkedList<RavagePatternDetector>();
        protonDetectedPatterns = new LinkedList<ProtonPatternDetector>();
    }

    /**
     * Bootstrap function
     */
    private void bootStrap(){
        initializeVariables();

                /* IMAGE PREPROCESSOR */

        filePath = "data\\DetectorOutput.blf";
        imagePreprocessor.initialize(filePath);

                /*     RAVAGER    */

        filePath = "data\\Ravager.blf";
        ravagerPatternAdapter.setPatternEncoder(ravagerPatternEncoder);
        ravagerPatternAdapter.initialize(filePath);



                /*    PROTON     */

        filePath = "data\\ProtonTorpedo.blf";
        protonPatternAdapter.setPatternEncoder(protonPatternEncoder);
        protonPatternAdapter.initialize(filePath);
        set_tolerance(65);
        setImagePreprocessor(imagePreprocessor);
        setProtonPatternAdapter(protonPatternAdapter);
        setRavagerPatternAdapter(ravagerPatternAdapter);
        setProtonPatternEncoder(protonPatternEncoder);
        setRavagerPatternEncoder(ravagerPatternEncoder);
    }

    public static void main(String[] args) {
        DataAnalysisManager dataAnalysisManager = new DataAnalysisManager();
        dataAnalysisManager.bootStrap();
        dataAnalysisManager.initialize();
         /* DISPLAY THE PATTERN MATCH ANALYSIS */
        dataAnalysisManager.displayPatternMatchAnalysis();
    }

    public void setImagePreprocessor(ImagePreprocessor imagePreprocessor) {
        this.imagePreprocessor = imagePreprocessor;
    }

    public  void initialize(){

        ravageDetectedPatterns = new LinkedList<RavagePatternDetector>();
        protonDetectedPatterns = new LinkedList<ProtonPatternDetector>();

        /* DATA MINING FOR PROTON PATTERNS WITH CUSTOM TOLERANCE LEVEL */
        dataMiningForProtonPatterns();
        /*  DATA MINING FOR RAVAGER PATTERNS WITH CUSTOM TOLERANCE LEVEL */
        dataMiningForRavagePatterns();

    }

    private void dataMiningForProtonPatterns(){
        ProtonPatternDetector protonPatternDetector;
        for(int startRow=0;startRow<get_rows()-protonPatternEncoder.getRows();startRow++){
            for(int startColumn=0;startColumn<get_columns()-protonPatternEncoder.getColumns();startColumn++){
                protonPatternDetector = new ProtonPatternDetector();
                protonPatternDetector.setXYCoordinates(startRow,startColumn);
                protonPatternDetector.setImagePreprocessor(imagePreprocessor);
                protonPatternDetector.setProtonEncoder(protonPatternEncoder);
                protonPatternDetector.initialize();
                protonDetectedPatterns.add(protonPatternDetector);
            }
        }
    }

    private void dataMiningForRavagePatterns(){
        RavagePatternDetector ravagePatternDetector;
        for(int startRow=0;startRow<get_rows()-ravagerPatternEncoder.getRows();startRow++){
            for(int startColumn=0;startColumn<get_columns()-ravagerPatternEncoder.getColumns();startColumn++){
                ravagePatternDetector = new RavagePatternDetector();
                ravagePatternDetector.setXYCoordinates(startRow,startColumn);
                ravagePatternDetector.setImagePreprocessor(imagePreprocessor);
                ravagePatternDetector.setRavagerPatternEncoder(ravagerPatternEncoder);
                ravagePatternDetector.initialize();
                ravageDetectedPatterns.add(ravagePatternDetector);
            }
        }
    }

    private void displayProtonPatternAnalysis(){
        System.out.println("PROTON PATTERN MATCHING ANALYSIS WITH TOLERANCE LEVEL OF "+get_tolerance());
        ProtonPatternDetector protonPattern;
        List<ProtonPatternDetector> foundProtonPatterns = new LinkedList<ProtonPatternDetector>();;
        int startIndex ;
        for(startIndex=0;startIndex<protonDetectedPatterns.size();startIndex++){
            protonPattern = protonDetectedPatterns.get(startIndex);
            if(protonPattern.getConfidence()>=get_tolerance()){
                foundProtonPatterns.add(protonPattern);
            }
        }
        for(startIndex=0;startIndex<foundProtonPatterns.size();startIndex++){
            protonPattern = foundProtonPatterns.get(startIndex);
            System.out.println("Target Type : PROTON TORPEDOS" );
            System.out.println("Coordinates : x -"+protonPattern.getX()+" y - "+protonPattern.getY());
            System.out.println("Degree of Confidence - "+protonPattern.getConfidence());
        }
    }

    private void displayRavagePatternAnalysis(){
        set_tolerance(64);
        System.out.printf("");
        System.out.println();
        System.out.println("SPACESHIP PATTERN MATCHING ANALYSIS WITH TOLERANCE LEVEL OF "+get_tolerance());
        RavagePatternDetector ravagePattern;
        List<RavagePatternDetector> foundRavagePatterns = new LinkedList<RavagePatternDetector>();
        int startIndex = 0;
        for(startIndex=0;startIndex<ravageDetectedPatterns.size();startIndex++){
            ravagePattern = ravageDetectedPatterns.get(startIndex);
            if(ravagePattern.getConfidence()>=get_tolerance()){
                foundRavagePatterns.add(ravagePattern);
            }
        }
        for(startIndex=0;startIndex<foundRavagePatterns.size();startIndex++){
            ravagePattern = foundRavagePatterns.get(startIndex);
                System.out.println("Target Type : SPACESHIP " );
            System.out.println("Coordinates : x -"+ravagePattern.getX()+" y - "+ravagePattern.getY());
            System.out.println("Degree of Confidence - "+ravagePattern.getConfidence());
        }
    }

    public void displayPatternMatchAnalysis(){
       displayProtonPatternAnalysis();
       displayRavagePatternAnalysis();
    }


    public void detectRavagePatternWithConfidence(int startRow,int startColumn,RavagePatternDetector ravagePatternDetector){
        ravagePatternDetector.setXYCoordinates(startRow,startColumn);
        ravagePatternDetector.setImagePreprocessor(getImagePreprocessor());
        ravagePatternDetector.setRavagerPatternEncoder(getRavagerPatternEncoder());
        ravagePatternDetector.initialize();
    }

    public ImagePreprocessor getImagePreprocessor() {
        return imagePreprocessor;
    }

    public void detectProtonPatternWithConfidence(int startRow,int startColumn,ProtonPatternDetector protonPatternDetector){
        protonPatternDetector.setXYCoordinates(startRow,startColumn);
        protonPatternDetector.setImagePreprocessor(getImagePreprocessor());
        protonPatternDetector.setProtonEncoder(getProtonPatternEncoder());
        protonPatternDetector.initialize();
    }

    public ProtonPatternEncoder getProtonPatternEncoder() {
        return protonPatternEncoder;
    }

    public void setProtonPatternEncoder(ProtonPatternEncoder protonPatternEncoder) {
        this.protonPatternEncoder = protonPatternEncoder;
    }

    public ProtonPatternAdapter getProtonPatternAdapter() {
        return protonPatternAdapter;
    }

    public void setProtonPatternAdapter(ProtonPatternAdapter protonPatternAdapter) {
        this.protonPatternAdapter = protonPatternAdapter;
    }

    public RavagerPatternEncoder getRavagerPatternEncoder() {
        return ravagerPatternEncoder;
    }

    public void setRavagerPatternEncoder(RavagerPatternEncoder ravagerPatternEncoder) {
        this.ravagerPatternEncoder = ravagerPatternEncoder;
    }

    public RavagerPatternAdapter getRavagerPatternAdapter() {
        return ravagerPatternAdapter;
    }

    public void setRavagerPatternAdapter(RavagerPatternAdapter ravagerPatternAdapter) {
        this.ravagerPatternAdapter = ravagerPatternAdapter;
    }

    public List<RavagePatternDetector> getRavageDetectedPatterns() {
        return ravageDetectedPatterns;
    }

    public void setRavageDetectedPatterns(List<RavagePatternDetector> ravageDetectedPatterns) {
        this.ravageDetectedPatterns = ravageDetectedPatterns;
    }

    public List<ProtonPatternDetector> getProtonDetectedPatterns() {
        return protonDetectedPatterns;
    }

    public void setProtonDetectedPatterns(List<ProtonPatternDetector> protonDetectedPatterns) {
        this.protonDetectedPatterns = protonDetectedPatterns;
    }

    public int get_rows() {
        return _rows;
    }

    public void set_rows(int _rows) {
        this._rows = _rows;
    }

    public int get_columns() {
        return _columns;
    }

    public void set_columns(int _columns) {
        this._columns = _columns;
    }

    public int get_tolerance() {
        return _tolerance;
    }

    /**
     * Tolerance level - Assumption I have made for writing the code.
     * Pattern is considered to be matched
     * only if the Confidence  >= Given tolerance.
     */
    public void set_tolerance(int _tolerance) {
        this._tolerance = _tolerance;
    }
}



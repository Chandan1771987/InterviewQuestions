package com.data.analysis.components;

import com.data.analysis.modules.IPatternModule;
import com.data.analysis.modules.PatternModule;
import com.data.analysis.utils.PatternEncoderUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *  Created by chandan on 1/7/14.
 *  RavagerPatternAdapter to analyze the provided pattern
 * and encode the data.
 */
public class RavagerPatternAdapter extends PatternModule implements IPatternModule {

    private PatternEncoderUtil patternEncoderUtil;

    @Override
    public void initialize(String filePath){
        patternEncoderUtil = new PatternEncoderUtil();
        try {
            setUtil(patternEncoderUtil);
            analyzePattern(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            patternEncoderUtil.construct2DMatrix(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        initializeEncoderComponents();
    }
}

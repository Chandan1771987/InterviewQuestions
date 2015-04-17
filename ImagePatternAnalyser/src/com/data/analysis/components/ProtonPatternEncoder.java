package com.data.analysis.components;

/**
 * Created by chandan on 1/7/14.
 * Proton pattern encoder class.
 * This encodes the proton pattern and stores it in memory.
 *  If used in high scalable environments, the encodedData can be stored in persistent storages
 *  like memcache, membase/Couchbase or mysqlDatabase.
 */
public class ProtonPatternEncoder extends PatternEncoder implements IPatternEncoder
{
    @Override
    public void initialize(int rows,int columns, String[] encodedData) {
     setData(rows,columns,encodedData);
    }

    private void setData(int rows,int columns,String[] encodedData){
        setRows(rows);
        setColumns(columns);
        setEncodedMatrix(encodedData);
    }
}

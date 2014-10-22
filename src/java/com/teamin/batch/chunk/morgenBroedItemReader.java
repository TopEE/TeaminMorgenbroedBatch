package com.teamin.batch.chunk;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

@Named
public class morgenBroedItemReader extends AbstractItemReader {

    private BufferedReader reader;
    private Integer recordNumber;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        reader = new BufferedReader(
                new InputStreamReader(
                this
                .getClass()
                .getClassLoader()
                .getResourceAsStream("/META-INF/morgenBroed.csv")));
        
        if (checkpoint != null)
            recordNumber = (Integer) checkpoint;
        for (int i=1; i<recordNumber; i++) {   //Skip upto recordNumber
            reader.readLine();
        } 
    }

    @Override
    public String readItem() {
        try {
            recordNumber = Integer.valueOf(recordNumber.intValue() + 1);
            return reader.readLine();
        } catch (IOException ex) {
            recordNumber = Integer.valueOf(recordNumber.intValue() - 1);
            Logger.getLogger(morgenBroedItemReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public Serializable checkpointInfo() throws Exception {
    	return recordNumber;
    }

}
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
        else
            recordNumber = 0;
            
        for (int i=1; i<recordNumber; i++) {   //Skip upto recordNumber
            reader.readLine();
        } 
    }

    @Override
    public String readItem() {
        try {
            recordNumber++;
            return reader.readLine();
        } catch (IOException ex) {
            // Hmm...hvad sker der i ItemWriter?
            recordNumber--;
            Logger.getLogger(morgenBroedItemReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @Override
    public Serializable checkpointInfo() throws Exception {
    	return recordNumber;
    }

}
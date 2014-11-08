package com.teamin.batch.chunk;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class morgenBroedItemReader extends AbstractItemReader {

    private BufferedReader reader;
    private Integer recordNumber;
    
        @Inject
        private JobContext jobContext;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        
       Properties jobParameters = BatchRuntime.getJobOperator().getParameters(jobContext.getExecutionId());

        String filNavn = (String) jobParameters.get("fileName");

        if(filNavn != null && !filNavn.isEmpty())
        {
        	reader = new BufferedReader(new FileReader("C:\\Temp\\testFiler\\"+filNavn));
        }
        else
        {
        	reader = new BufferedReader(new FileReader("C:\\Temp\\testFiler\\morgenBroed.csv"));
        }
        
        if (checkpoint != null)
            recordNumber = (Integer) checkpoint;
        else
            recordNumber = 0;
            
        for (int i=1; i<recordNumber; i++) {   //Skip til recordNumber
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
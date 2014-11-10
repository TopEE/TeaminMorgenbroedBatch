package com.teamin.batch.decision;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.batch.api.Decider;
import javax.batch.runtime.StepExecution;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Henrik
 */
@Named
public class DecisionInkasso implements Decider{
    
        BufferedReader reader;
        int gaeld;

        @Inject
        JobContext jobContext;
 
 @Override
 public String decide(StepExecution[] ses) throws Exception {
    
        try 
        {
            reader = new BufferedReader(new FileReader("C:\\Temp\\testFiler\\saldo.csv"));
            
            String linie = reader.readLine();
            while(linie != null)
            {
                    String[] parts = linie.split(",");
                    String gaeldString = parts[1];             
                    gaeld = Integer.parseInt(gaeldString);
                    if(gaeld > 200)
                    {
                       System.out.println("STOR GAELD");
                       return "STOR_GAELD";
                    }

                linie = reader.readLine();
            }
        } 
        catch (Exception e) 
        {
        }

        System.out.println("LILLE GAELD");
        return "LILLE_GAELD";
 }
}

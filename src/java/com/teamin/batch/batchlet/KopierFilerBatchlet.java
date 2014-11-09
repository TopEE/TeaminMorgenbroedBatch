/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamin.batch.batchlet;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

/**
 *
 * @author Henrik
 */
@Named
public class KopierFilerBatchlet extends AbstractBatchlet {
    
    @Override
    public String process() {

        String kilde = "C:\\Temp\\testFiler\\morgenBroed.csv";
        String destination = "C:\\Temp\\testFiler\\arkiv\\morgenBroed"+new GregorianCalendar().get(Calendar.WEEK_OF_YEAR)+".csv";
        
        try {
            Files.copy(new File(kilde), new File(destination));
            return "COMPLETED";
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
      return "FAILED";    }
    
}



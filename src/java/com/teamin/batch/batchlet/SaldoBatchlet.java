/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamin.batch.batchlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

/**
 *
 * @author Henrik
 */
@Named
public class SaldoBatchlet extends AbstractBatchlet {
    
    private BufferedWriter writer;
    
    @Override
    public String process() {
        System.out.println("Running inside a batchlet : SaldoBatchlet");
        // TODO code application logic here
        
        try {
          	writer = new BufferedWriter(new FileWriter("C:\\Temp\\testFiler\\saldo.csv"));
                writer.append("HVE");
                writer.append(',');
                writer.append("31");
                writer.append('\n');
                
                writer.flush();
                writer.close();
                
        } catch (Exception e) {
        }
        
        
        return "COMPLETED";
    }
    
}

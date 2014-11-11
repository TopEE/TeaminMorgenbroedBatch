/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamin.batch.batchlet;

import com.teamin.entity.Morgenbroed;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Henrik
 */

@Named
public class SaldoBatchlet extends AbstractBatchlet {
    
    @Inject StepContext stepCtx;
    @PersistenceContext
    EntityManager em;
     
    private BufferedWriter writer;
    
    @Override
    public String process() {
        List<Morgenbroed> mbListe = em.createNamedQuery("Morgenbroed.findAll").getResultList();
        
        try {
          	writer = new BufferedWriter(new FileWriter("C:\\Temp\\testFiler\\saldo.csv"));
                for(Morgenbroed mb : mbListe)
                {
                    writer.append(mb.getUserId());
                    writer.append(',');
                    writer.append(""+(mb.getBetalt()- mb.getBestilt()));
                    writer.append('\n');
                }
                
                writer.flush();
                writer.close();
                
        } catch (Exception e) {
        }
        
        
        return "COMPLETED";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamin.batch.batchlet;

import javax.batch.api.AbstractBatchlet;
import javax.inject.Named;

/**
 *
 * @author Henrik
 */
@Named
public class InfoMailBatchlet extends AbstractBatchlet {
    
    @Override
    public String process() {
        System.out.println("Running inside a batchlet : InfoMailBatchlet");
        // TODO code application logic here
        return "COMPLETED";
    }
    
}

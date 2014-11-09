/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamin.batch.decision;

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
    
    @Inject
 JobContext jobContext;
 
 @Override
 public String decide(StepExecution[] ses) throws Exception {
  
   if (Math.random() > 0.5) {
               System.out.println("STOR GÆLD");
   return "STOR_GAELD";
  } else {
               System.out.println("LILLE GÆLD");
   return "LILLE_GAELD";
  } 
 }
}

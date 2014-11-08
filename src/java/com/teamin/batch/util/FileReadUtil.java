/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamin.batch.util;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Henrik
 */
public class FileReadUtil {
    
        boolean found;
        BufferedReader reader; 
        int returnValue;

        public int hentSaldo(String userId)
    {

        try {
            reader = new BufferedReader(new FileReader("C:\\Temp\\testFiler\\saldo.csv"));
            String linie = reader.readLine();
            while(!found && linie != null)
            {
                if(linie.contains(userId.toUpperCase()))
                {
                    String[] parts = linie.split(",");
                    String gaeldString = parts[1];             
                    returnValue = Integer.parseInt(gaeldString);
                    found = true;
                }

                linie = reader.readLine();
            }
        } catch (Exception e) {
        }
        
        return returnValue;
    }
}

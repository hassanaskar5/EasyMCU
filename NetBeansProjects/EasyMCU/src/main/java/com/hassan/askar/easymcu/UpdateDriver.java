/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hassan.askar.easymcu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * A superclass used for update (DIO, ADC, USART) drivers by updateDriver method
 * that's called in every Driver class.
 *
 * @author Askar
 * @version 1.0
 *
 */
abstract class UpdateDriver {

    /**
     * updateDriver method update each driver according to the parameters.
     *
     * @param driverFile The driver name with extension EX: DIO_config.h
     * @param indexNum The elements number that'll configured.
     * @param element An array contains Elements Names.
     * @param config An array has the default values and the changes will apply
     * on it.
     */
    
    protected void updateDriver(String driverFile, int indexNum, String element[], String config[],String CurrentFile) {
        String Path="";
        List<String> lines = new ArrayList<>();
        String line = null;
        try {
            File f1 = new File(CurrentFile+"/" + driverFile);
            File f2 = new File(Path + driverFile);
            
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            int Index = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains(element[Index])) {
                    line = line.replace(line, "#define " + element[Index] + "\t\t\t\t" + config[Index]);
                    if (Index < indexNum-1) {
                        Index++;
                    }
                }
                lines.add(line + "\n");
            }
            fr.close();
            br.close();
            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for (String s : lines) {
                out.write(s);
            }
            out.flush();
            out.close();
        } catch (IOException ex) {
        }
    }
    
    
    
    
    
    
    
    protected  String[] getDriverInfo(String driverFile, int indexNum, String element[],String CurrentFile) {
       System.out.println(CurrentFile);
        String Path="";
        String config[]=new String[indexNum];
        String line = null;
        try {
            System.out.println(CurrentFile);
            File f1 = new File(CurrentFile+"/" +driverFile);
            
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            int Index = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains(element[Index])) {
                      String[] dataRow=line.split("\t\t\t\t");
                     config[Index] = dataRow[1];
                    if (Index < indexNum-1) {
                        Index++;
                    }
                }
            }
            fr.close();
            br.close();
            
        } catch (IOException ex) {
        }
        return config;
    }

}

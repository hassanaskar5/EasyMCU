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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author askar
 */
public class AskarFile {

    public void insertDataToTable(JTable table) {
        String askarFilePath = "EasyMCU.askar";
        List<String> lines = new ArrayList<>();
        String line = null;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            File f1 = new File(askarFilePath);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            int Index = 0;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split(",");
                File f2 = new File(dataRow[1]);
                if (f2.exists()) {
                    model.addRow(dataRow);
                }
            }
            fr.close();
            br.close();

        } catch (IOException ex) {
        }
    }

    public void saveIntoAAskarFile(String name, String location, String version) {
        String askarFilePath = "EasyMCU.askar";
        List<String> lines = new ArrayList<>();
        String line = null;
        try {
            File f1 = new File(askarFilePath);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {

                lines.add(line + "\n");
            }
            lines.add(name + "," + location + "/" + name + "," + version + "," + "\n");
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

}

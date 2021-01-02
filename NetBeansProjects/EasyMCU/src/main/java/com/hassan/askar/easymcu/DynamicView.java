/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hassan.askar.easymcu;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author askar
 */
public class DynamicView {

    private Color mainPanelColorBeforeChange, labelColorBeforeChange;
    private Boolean isClicked = false;
    private int pinNum;
    private Color pinColors[] = new Color[32];
    
    public void setLabelColorBeforeChange(Color labelColorBeforeChange) {
        this.labelColorBeforeChange = labelColorBeforeChange;
    }


    public Color getLabelColorBeforeChange() {
        return labelColorBeforeChange;
    }

    public void movingMouseStyle(JPanel mainPanel, JPanel pointerPanel, JLabel label, Color panelMovingColor, Color labelMovingColor) {
        mainPanelColorBeforeChange = mainPanelColorBeforeChange == null ? mainPanel.getForeground() : mainPanelColorBeforeChange;
        labelColorBeforeChange = labelColorBeforeChange == null ? label.getForeground() : labelColorBeforeChange;
        mainPanel.setBackground(panelMovingColor);
        pointerPanel.setOpaque(true);
        label.setForeground(labelMovingColor);
    }
    
    public void movingMouseStyle(JLabel label, Color labelMovingColor, Color labelColorBeforeChange) {
        this.labelColorBeforeChange = labelColorBeforeChange;
        label.setForeground(labelMovingColor);
    }


    public void exiteMouseStyle(JPanel mainPanel, JPanel pointerPanel, JLabel label) {
        mainPanel.setBackground(mainPanelColorBeforeChange);
        pointerPanel.setOpaque(false);
        label.setForeground(labelColorBeforeChange);
    }



    public void exiteMouseStyle(JLabel label) {

            label.setForeground(labelColorBeforeChange);
        
    }

    public void switchPanelTo(JPanel generalPanel, JPanel panel) {
        generalPanel.removeAll();
        generalPanel.repaint();
        generalPanel.revalidate();
        generalPanel.add(panel);
        generalPanel.repaint();
        generalPanel.revalidate();
    }

}

package com.hassan.askar.easymcu;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author askar
 */
public class DynamicView {

    private Color mainPanelColorBeforeChange, LabelColorBeforeChange;
    private Boolean isClicked = false;
    private int pinNum;
    private Color labelColorBeforeChange[] = new Color[32];

    public void setLabelColorBeforeChange(Color labelColorBeforeChange, int pinNum) {
        this.labelColorBeforeChange[pinNum] = labelColorBeforeChange;
    }

    public Color getLabelColorBeforeChange() {
        return labelColorBeforeChange[pinNum];
    }

    public void movingMouseStyle(JLabel label, Color labelMovingColor, Color labelColorBeforeChange, int pinNum) {
        this.labelColorBeforeChange[pinNum] = labelColorBeforeChange;
        label.setForeground(labelMovingColor);
    }

    public void exiteMouseStyle(JLabel label, int pinNum) {

        label.setForeground(labelColorBeforeChange[pinNum]);

    }

// changes for panel
    public void exiteMouseStyle(JPanel mainPanel, JPanel pointerPanel, JLabel label) {
        mainPanel.setBackground(mainPanelColorBeforeChange);
        pointerPanel.setOpaque(false);
        label.setForeground(LabelColorBeforeChange);
    }

    public void movingMouseStyle(JPanel mainPanel, JPanel pointerPanel, JLabel label, Color panelMovingColor, Color labelMovingColor) {
        mainPanelColorBeforeChange = mainPanelColorBeforeChange == null ? mainPanel.getForeground() : mainPanelColorBeforeChange;
        LabelColorBeforeChange = LabelColorBeforeChange == null ? label.getForeground() : LabelColorBeforeChange;
        mainPanel.setBackground(panelMovingColor);
        pointerPanel.setOpaque(true);
        label.setForeground(labelMovingColor);
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

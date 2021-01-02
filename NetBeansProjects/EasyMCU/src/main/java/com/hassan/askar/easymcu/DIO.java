/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hassan.askar.easymcu;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * Enum for Pin Direction Values
 */
enum PIN_DIR {
    DIO_u8_INPUT,
    DIO_u8_OUTPUT
}

/**
 * A class used to configure DIO Driver by setting each pin value (input,
 * output) and update DIO driver by updateDIODriver method that's called from
 * UpdateDriver superclass.
 *
 * @author Askar
 * @version 1.0
 *
 */
public class DIO extends UpdateDriver {

    //DIO Attributes
    //32 ATMega32 Controller Pins set by defualt as the following values 
    private String config[] = {PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString()};
    //32 ATMega32 Controller Pins Names
    private String element[] = {"DIO_u8_PIN_DIR_0", "DIO_u8_PIN_DIR_1", "DIO_u8_PIN_DIR_2", "DIO_u8_PIN_DIR_3", "DIO_u8_PIN_DIR_4", "DIO_u8_PIN_DIR_5", "DIO_u8_PIN_DIR_6", "DIO_u8_PIN_DIR_7", "DIO_u8_PIN_DIR_8", "DIO_u8_PIN_DIR_9", "DIO_u8_PIN_DIR_10", "DIO_u8_PIN_DIR_11", "DIO_u8_PIN_DIR_12", "DIO_u8_PIN_DIR_13", "DIO_u8_PIN_DIR_14", "DIO_u8_PIN_DIR_15", "DIO_u8_PIN_DIR_16", "DIO_u8_PIN_DIR_17", "DIO_u8_PIN_DIR_18", "DIO_u8_PIN_DIR_19", "DIO_u8_PIN_DIR_20", "DIO_u8_PIN_DIR_21", "DIO_u8_PIN_DIR_22", "DIO_u8_PIN_DIR_23", "DIO_u8_PIN_DIR_24", "DIO_u8_PIN_DIR_25", "DIO_u8_PIN_DIR_26", "DIO_u8_PIN_DIR_27", "DIO_u8_PIN_DIR_28", "DIO_u8_PIN_DIR_29", "DIO_u8_PIN_DIR_30", "DIO_u8_PIN_DIR_31"};
    private String CurrentFile;

    public DIO(String currentFile) {
        CurrentFile = currentFile;
    }

    //DIO Methods
    /**
     * setPinValue method Sets pin value by determining pin number and its value
     *
     *
     * @param pinNum The pin number that'll change
     * @param pinValue The pin value that'll change
     */
    public Color togglePinValue(int pinNum, JLabel PinDirectionLabel, Color labelColorBeforeChange) {
       Color labelColorAfterChange=labelColorBeforeChange;
        if (labelColorBeforeChange == Color.WHITE) {
            config[pinNum] = PIN_DIR.DIO_u8_OUTPUT.toString();
            PinDirectionLabel.setText(PinDirectionLabel.getName() + " OUTPUT");
            PinDirectionLabel.setForeground(Color.BLACK);
            labelColorAfterChange = Color.BLACK;
            System.out.println(config[pinNum]);
        } else if (labelColorBeforeChange == Color.BLACK) {
            config[pinNum] = PIN_DIR.DIO_u8_INPUT.toString();
            PinDirectionLabel.setText(PinDirectionLabel.getName() + " INPUT");
            PinDirectionLabel.setForeground(Color.WHITE);
            labelColorAfterChange = Color.WHITE;
            System.out.println(config[pinNum]);
        }
        return labelColorAfterChange;
    }

    public void getDriverElementsValues() {
        System.out.println(CurrentFile);
        config = getDriverInfo("DIO_config.h", element.length, element, CurrentFile);

    }

    public String[] setPinDirectionColor(JLabel[] PinDirectionLabel) {
        for (int i = 0; i < PinDirectionLabel.length; i++) {
            //System.out.println(config[i]);
            if (config[i].contains("DIO_u8_OUTPUT")) {
                PinDirectionLabel[i].setText(PinDirectionLabel[i].getName() + " OUTPUT");
                PinDirectionLabel[i].setForeground(Color.BLACK);
            } else if (config[i].contains("DIO_u8_INPUT")) {
                PinDirectionLabel[i].setText(PinDirectionLabel[i].getName() + " INPUT");
                PinDirectionLabel[i].setForeground(Color.WHITE);
            }

        }
        return config;
    }

    /**
     * To apply changes on driver by calling updateDriver method from superclass
     * and determining the specific parameter for DIO driver
     */
    public void updateDIODriver() {
        super.updateDriver("DIO_config.h", element.length, element, config, CurrentFile);
    }

}

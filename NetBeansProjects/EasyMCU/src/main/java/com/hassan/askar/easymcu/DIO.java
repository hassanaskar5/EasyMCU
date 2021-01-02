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
    //32 ATMega32 Controller Pins Names
    private String element[] = {"DIO_u8_PIN_DIR_0", "DIO_u8_PIN_DIR_1", "DIO_u8_PIN_DIR_2", "DIO_u8_PIN_DIR_3", "DIO_u8_PIN_DIR_4", "DIO_u8_PIN_DIR_5", "DIO_u8_PIN_DIR_6", "DIO_u8_PIN_DIR_7", "DIO_u8_PIN_DIR_8", "DIO_u8_PIN_DIR_9", "DIO_u8_PIN_DIR_10", "DIO_u8_PIN_DIR_11", "DIO_u8_PIN_DIR_12", "DIO_u8_PIN_DIR_13", "DIO_u8_PIN_DIR_14", "DIO_u8_PIN_DIR_15", "DIO_u8_PIN_DIR_16", "DIO_u8_PIN_DIR_17", "DIO_u8_PIN_DIR_18", "DIO_u8_PIN_DIR_19", "DIO_u8_PIN_DIR_20", "DIO_u8_PIN_DIR_21", "DIO_u8_PIN_DIR_22", "DIO_u8_PIN_DIR_23", "DIO_u8_PIN_DIR_24", "DIO_u8_PIN_DIR_25", "DIO_u8_PIN_DIR_26", "DIO_u8_PIN_DIR_27", "DIO_u8_PIN_DIR_28", "DIO_u8_PIN_DIR_29", "DIO_u8_PIN_DIR_30", "DIO_u8_PIN_DIR_31"};
    //32 ATMega32 Controller Pins set by defualt as the following values 
    private String config[] = {PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_INPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString(), PIN_DIR.DIO_u8_OUTPUT.toString()};
    private Color pinColors[] = new Color[32];
    private String CurrentFile;

    public void setCurrentFile(String currentFile) {
        CurrentFile = currentFile;
    }

    //DIO Methods
    public void getDriverElementsValues() {
        config = getDriverInfo("DIO_config.h", element.length, element, CurrentFile);
        setPinColors();
    }

    private void setPinColors() {
        for (int pinNum = 0; pinNum < config.length; pinNum++) {
            if (config[pinNum].equals(PIN_DIR.DIO_u8_INPUT.toString())) {
                pinColors[pinNum] = Color.WHITE;
            } else if (config[pinNum].equals(PIN_DIR.DIO_u8_OUTPUT.toString())) {
                pinColors[pinNum] = Color.BLACK;
            }
        }
    }

    public Color getPinColor(int pinNum) {
        return pinColors[pinNum];
    }

    public void setPinDirectionColor(JLabel[] PinDirectionLabel) {

        for (int i = 0; i < PinDirectionLabel.length; i++) {
            if (config[i].contains("DIO_u8_OUTPUT")) {
                PinDirectionLabel[i].setText(PinDirectionLabel[i].getName() + " OUTPUT");
                PinDirectionLabel[i].setForeground(pinColors[i]);
            } else if (config[i].contains("DIO_u8_INPUT")) {
                PinDirectionLabel[i].setText(PinDirectionLabel[i].getName() + " INPUT");
                PinDirectionLabel[i].setForeground(pinColors[i]);
            }

        }
    }

    public Color togglePinDirection(int pinNum, JLabel PinDirectionLabel) {
        Color labelColorBeforeChange=null;
        //processing
        if (config[pinNum].equals(PIN_DIR.DIO_u8_INPUT.toString())) {
            config[pinNum] = PIN_DIR.DIO_u8_OUTPUT.toString();
            pinColors[pinNum] = Color.BLACK;
            labelColorBeforeChange = Color.BLACK;
            PinDirectionLabel.setText(PinDirectionLabel.getName() + " OUTPUT");
        } else if (config[pinNum].equals(PIN_DIR.DIO_u8_OUTPUT.toString())) {
            config[pinNum] = PIN_DIR.DIO_u8_INPUT.toString();
            pinColors[pinNum] = Color.WHITE;
            labelColorBeforeChange = Color.WHITE;
            PinDirectionLabel.setText(PinDirectionLabel.getName() + " INPUT");
        }
        return labelColorBeforeChange;
    }

    /**
     * To apply changes on driver by calling updateDriver method from superclass
     * and determining the specific parameter for DIO driver
     */
    public void updateDIODriver() {
        System.out.println("updateDIODriver method start" + CurrentFile);

        super.updateDriver("DIO_config.h", element.length, element, config, CurrentFile);
    }

}

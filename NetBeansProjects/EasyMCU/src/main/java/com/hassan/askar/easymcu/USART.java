/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hassan.askar.easymcu;

/**
 * Enum for MODE_OF_OPERATION Values
 */
enum MODE_OF_OPERATION {
    ASYNCHRONOUS,
    SYNCHRONOUS
}

/**
 * Enum for SPEED_OPERATION Values
 */
enum SPEED_OPERATION {
    NORMAL_SPEED_MODE,
    DOUBLE_SPEED_MODE
}

/**
 * Enum for PARITY_MODE Values
 */
enum PARITY_MODE {
    DISABLED,
    EVEN,
    ODD
}

/**
 * Enum for STOP_BIT_SELECT Values
 */
enum STOP_BIT_SELECT {
    ONE_BIT,
    TWO_BIT
}

/**
 * Enum for CLOCK_POLARITY Values
 */
enum CLOCK_POLARITY {
    RISING,
    FALLING
}

/**
 * A class used to configure USART Driver by setting each element value
 * (MODE_OF_OPERATION,SPEED_OPERATION,PARITY_MODE,STOP_BIT_SELECT,CLOCK_POLARITY,
 * F_CPU,FRAME_SIZE,BAUD_RATE ) and update DIO driver by updateDIODriver method
 * that's called from UpdateDriver superclass.
 *
 * @author Askar
 * @version 1.0
 *
 */
public class USART extends UpdateDriver {
    //DIO Attributes
    //Set each element to congif by defualt as the following values 

    private String config[] = {MODE_OF_OPERATION.ASYNCHRONOUS.toString(), SPEED_OPERATION.DOUBLE_SPEED_MODE.toString(), PARITY_MODE.DISABLED.toString(), STOP_BIT_SELECT.ONE_BIT.toString(), CLOCK_POLARITY.RISING.toString(), "8000000L", "8", "9600L"};
    //Elements Names

    private String element[] = {"MODE_OF_OPERATION", "SPEED_OPERATION", "PARITY_MODE", "STOP_BIT_SELECT", "CLOCK_POLARITY", "F_CPU", "FRAME_SIZE", "BAUD_RATE"};
     private String CurrentFile;
    /**
     * Constructor Sets element value by determining pin number and its value
     *
     * @param modOp An MODE_OF_OPERATION enum object that will hold the new
     * value.
     * @param spdOp An SPEED_OPERATION enum object that will hold the new value.
     * @param prtyOp An PARITY_MODE enum object that will hold the new value.
     * @param stpBtSlct An STOP_BIT_SELECT enum object that will hold the new
     * value.
     * @param clkPlrty An CLOCK_POLARITY enum object that will hold the new
     * value.
     * @param F_CPU An F_CPU enum object that will hold the new value.
     * @param FRAME_SIZE An FRAME_SIZE enum object that will hold the new value.
     * @param BAUD_RATE An BAUD_RATE enum object that will hold the new value.
     */
    public USART(MODE_OF_OPERATION modOp, SPEED_OPERATION spdOp, PARITY_MODE prtyOp, STOP_BIT_SELECT stpBtSlct, CLOCK_POLARITY clkPlrty, int F_CPU, int FRAME_SIZE, int BAUD_RATE,String  currentFile ) {
        config[0] = modOp.toString();
        config[1] = spdOp.toString();
        config[2] = prtyOp.toString();
        config[3] = stpBtSlct.toString();
        config[4] = clkPlrty.toString();
        config[5] = F_CPU + "L";
        config[6] = FRAME_SIZE + "";
        config[7] = BAUD_RATE + "L";
        CurrentFile=currentFile;
    }

    /**
     * To apply changes on driver by calling updateDriver method from superclass
     * and determining the specific parameter for USART driver
     *
     */
    public void updateUSARTDriver() {
        super.updateDriver("USART_config.h", element.length, element, config,CurrentFile);
    }
    public void getDriverElementsValues() {
        config = getDriverInfo("USART_config.h", element.length, element,CurrentFile);

    }
}

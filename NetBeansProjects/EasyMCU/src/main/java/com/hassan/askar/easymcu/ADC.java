/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hassan.askar.easymcu;

/**
 * Enum for ADC VOLTAGE REFERENCE Values
 */
enum ADC_VOLTAGE_REFERENCE {
    AVCC,
    AREF,
    INTERNAL
}

/**
 * Enum for ADC_ADJUSTMENT Values
 */
enum ADC_ADJUSTMENT {
    RIGHT_ADJUSTMENT,
    LEFT_ADJUSTMENT
}

/**
 * Enum for ADC_AUTO_TRIGGER_SOURCE Values
 */
enum ADC_AUTO_TRIGGER_SOURCE {
    FREE_RUNNING_MODE,
    ANALOG_COMPARATOR,
    EXTERNAL_INTERRPUT_REQUEST_0,
    TIMER_COUNTER_0_COMPARE_MATCH,
    TIMER_COUNTER_0_OVERFLOW,
    TIMER_COUNTER_COMPARE_MATCH_B,
    TIMER_COUNTER_1_OVERFLOW,
    TIMER_COUNTER_1_CAPTURE_EVENT

}

/**
 * Enum for ADC_PRESCALLER Values
 */
enum ADC_PRESCALLER {
    DIVID_BY_2,
    DIVID_BY_4,
    DIVID_BY_8,
    DIVID_BY_16,
    DIVID_BY_32,
    DIVID_BY_64,
    DIVID_BY_128,

}

/**
 * Enum for ADC_CHANNEL_NUMBER Values
 */
enum ADC_CHANNEL_NUMBER {
    DIO_U8_PIN_0,
    DIO_U8_PIN_1,
    DIO_U8_PIN_2,
    DIO_U8_PIN_3,
    DIO_U8_PIN_4,
    DIO_U8_PIN_5,
    DIO_U8_PIN_6,
    DIO_U8_PIN_7

}

/**
 * A class used to configure ADC Driver by setting each element value
 * (VOLTAGE_REFERENCE,ADJUSTMENT,ADC_AUTO_TRIGGER_SOURCE,ADC_PRESCALLER,
 * ADC_CHANNEL_NUMBER ) and update DIO driver by updateDIODriver method that's
 * called from UpdateDriver superclass.
 *
 *
 * @author Askar
 * @version 1.0
 *
 */
public class ADC extends UpdateDriver {

    //DIO Attributes
    //Set each element to congif by defualt as the following values 
    private String config[] = {ADC_VOLTAGE_REFERENCE.AVCC.toString(), ADC_ADJUSTMENT.RIGHT_ADJUSTMENT.toString(), ADC_AUTO_TRIGGER_SOURCE.FREE_RUNNING_MODE.toString(), ADC_PRESCALLER.DIVID_BY_128.toString(), ADC_CHANNEL_NUMBER.DIO_U8_PIN_0.toString()};
    //Elements Names
    private String element[] = {"VOLTAGE_REFERENCE", "ADJUSTMENT", "ADC_AUTO_TRIGGER_SOURCE", "ADC_PRESCALLER", "ADC_CHANNEL_NUMBER"};
     private String CurrentFile;

    /**
     * Constructor Sets element value by determining pin number and its value
     *
     * @param voltRef An ADC_VOLTAGE_REFERENCE enum object that will hold the
     * new value.
     * @param adj An ADC_ADJUSTMENT enum object that will hold the new value.
     * @param trig An ADC_AUTO_TRIGGER_SOURCE enum object that will hold the new
     * value.
     * @param presclr An ADC_PRESCALLER enum object that will hold the new
     * value.
     * @param chnl An ADC_CHANNEL_NUMBER enum object that will hold the new
     * value.
     */
    ADC(ADC_VOLTAGE_REFERENCE voltRef, ADC_ADJUSTMENT adj, ADC_AUTO_TRIGGER_SOURCE trig, ADC_PRESCALLER presclr, ADC_CHANNEL_NUMBER chnl,String  currentFile ) {
        config[0] = voltRef.toString();
        config[1] = adj.toString();
        config[2] = trig.toString();
        config[3] = presclr.toString();
        config[4] = chnl.toString();
        CurrentFile=currentFile;
    }

    /**
     * To apply changes on driver by calling updateDriver method from superclass
     * and determining the specific parameter for ADC driver
     *
     */
    public void updateADCDriver() {
        super.updateDriver("ADC_config.h", element.length, element, config,CurrentFile);
    }
    public void getDriverElementsValues() {
        config = getDriverInfo("ADC_config.h", element.length, element,CurrentFile);

    }
}

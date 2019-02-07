package com.itstep.naumovich;

import com.itstep.naumovich.flashlight.AccumulatorFlashLight;
import com.itstep.naumovich.flashlight.FlashLight;
import com.itstep.naumovich.radio.IRadio;
import com.itstep.naumovich.radiowithlight.IRadioWithLight;

/**
 * Created by admin on 15.01.2019.
 */
public interface FlashlightFactory {

    FlashLight createFlashLight(String lightType, String batteryType);
    FlashLight createFlashLiteWithTwoBattery(String lightType,String batteryType1,String batteryType2);
    AccumulatorFlashLight createFlashLight(String lightType);
    IRadio createRadio (String batteryType);
    IRadioWithLight createFlashLiteWithRadio (String lightType,String batteryType1,String batteryType2);
    AccumulatorFlashLight createSimpleTreeAccFlashLigh (String lightType);
}

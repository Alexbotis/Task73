package com.itstep.naumovich;

import com.itstep.naumovich.battery.*;
import com.itstep.naumovich.flashlight.*;
import com.itstep.naumovich.light.GlowLamp;
import com.itstep.naumovich.light.LedLamp;
import com.itstep.naumovich.light.Light;
import com.itstep.naumovich.radio.IRadio;
import com.itstep.naumovich.radio.SimpleRadio;
import com.itstep.naumovich.radio.SimpleRadioWithTwooBattery;
import com.itstep.naumovich.radiowithlight.IRadioWithLight;
import com.itstep.naumovich.radiowithlight.SimpleFlashLiteWithRadio;

/**
 * Created by admin on 25.01.2019.
 */
public class FlashLightFullCycleFactory implements FlashlightFactory {

    //batteries
    public static final String CHINESE_BATTERY = "chinese_battery";
    public static final String DURACELL_BATTERY = "duracell_battery";
    public static final String ACCUMULATOR_700_BATTERY = "accumulator";

    //lamps
    public static final String GLOW_LAMP = "glow_lamp";
    public static final String LED_LAMP = "led_lamp";

    @Override
    public FlashLight createFlashLight(String lightType, String batteryType) {
        Light lamp = getLamp(lightType);
        Battery battery = getBattery(batteryType);
        if (lamp != null && battery != null) {
            return new SimpleFlashLight(battery, lamp);
        } else {
            return null;
        }
    }
    @Override
    public FlashLight createFlashLiteWithTwoBattery(String lightType,String batteryType1,String batteryType2) {
        Light lamp = getLamp(lightType);
        Battery battery1 = getBattery(batteryType1);
        Battery battery2 = getBattery(batteryType2);
        if (lamp != null && battery1 != null && battery2 != null ) {
            return new SimpleFlashLiteWithTwoBattery(battery1,battery2, lamp);
        } else {
            return null;
        }
    }
    @Override
    public AccumulatorFlashLight createFlashLight(String lightType) {
        Light lamp = getLamp(lightType);

        if (lamp != null) {
            return new SimpleAccFlashLight(new SimpleAccumulator(700), lamp);
        }
        return null;
    }
    @Override
    public IRadio createRadio (String batteryType){
        Battery battery = getBattery(batteryType);
        if ( battery != null) {
            return new SimpleRadio(battery);
        } else {
            return null;
        }

    }
    @Override
    public IRadioWithLight createFlashLiteWithRadio(String lightType, String batteryType1, String batteryType2) {
        Light lamp = getLamp(lightType);
        Battery battery1 = getBattery(batteryType1);
        Battery battery2 = getBattery(batteryType2);
        if (lamp != null && battery1 != null && battery2 != null ) {
            return new SimpleFlashLiteWithRadio(battery1,battery2, lamp,new SimpleRadioWithTwooBattery(battery1,battery2));
        } else {
            return null;
        }
    }

   public AccumulatorFlashLight createSimpleTreeAccFlashLigh (String lightType){

       Light lamp = getLamp(lightType);

       if (lamp != null) {
           return new SimpleTreeAccFlashLigh(new SimpleAccumulator(700),lamp,new SimpleAccumulator(700),new SimpleAccumulator(700));
       }
       return null;
   }



    private Battery getBattery(String batteryType) {
        switch (batteryType) {
            case CHINESE_BATTERY:
                return new ChineseNoNameBattery();
            case DURACELL_BATTERY:
                return new DuracellBattery();
            case ACCUMULATOR_700_BATTERY:
                return new SimpleAccumulator(700);
            default:
                return null;
        }

    }

    private Light getLamp(String lightType) {
        switch (lightType) {
            case GLOW_LAMP:
                return new GlowLamp();
            case LED_LAMP:
                return new LedLamp();
            default:
                return null;
        }

    }
}

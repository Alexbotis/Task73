package com.itstep.naumovich.radiowithlight;

import com.itstep.naumovich.battery.Battery;
import com.itstep.naumovich.flashlight.SimpleFlashLiteWithTwoBattery;
import com.itstep.naumovich.light.Light;
import com.itstep.naumovich.radio.IRadio;

public class SimpleFlashLiteWithRadio extends SimpleFlashLiteWithTwoBattery implements IRadioWithLight {

private IRadio SimpleRadioWithTwooBattery;

   public SimpleFlashLiteWithRadio (Battery battery1, Battery battery2, Light light,IRadio SimpleRadioWithTwooBattery){

       super(battery1,battery2,light);
       this. SimpleRadioWithTwooBattery= SimpleRadioWithTwooBattery ;
   }

 public IRadio getSimpleRadioWithTwooBattery(){
       return SimpleRadioWithTwooBattery;
 }


 public boolean turnOnRadio() {
    return  SimpleRadioWithTwooBattery.turnOn();
 }
    public void turnoffRadio() {
         SimpleRadioWithTwooBattery.turnOff();
    }

    public boolean turnOnFlashLite() {
        return super.turnOn();
    }
    public void turnoffFlashLite() {
        super.turnOff();
    }

    }

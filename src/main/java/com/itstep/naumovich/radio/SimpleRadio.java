package com.itstep.naumovich.radio;

import com.itstep.naumovich.battery.Battery;
import com.itstep.naumovich.light.GlowLamp;
import com.itstep.naumovich.light.Light;

public class SimpleRadio implements IRadio {

    private Battery battery;
    private int chargesToTurnOn ;

    private boolean enabled;

    public SimpleRadio() {
    }

    public SimpleRadio(Battery battery ) {
        this.battery = battery;
        Light lite = new GlowLamp();
        this.chargesToTurnOn = (int)(2*lite.chargesToTurnOn())/3;
        //расход энергии меньше в 1,5 раза чем в фонарике
    }
public int getChargesToTurnOn(){
        return chargesToTurnOn;
}
    @Override
    public boolean turnOn() {

        if (!enabled) {
            enabled = battery.getCharge(chargesToTurnOn);
            return enabled;
        } else {
            return enabled;
        }
    }

    @Override
    public void turnOff() {
        enabled = false;
    }

public Battery getBattery(){

        return battery;
}


}

package com.itstep.naumovich.flashlight;

import com.itstep.naumovich.battery.Battery;
import com.itstep.naumovich.light.Light;

/**
 * Created by admin on 25.01.2019.
 */
public class SimpleFlashLight implements FlashLight {

    private Battery battery;
    private Light light;

    private boolean enabled;

    public SimpleFlashLight() {
    }

    public SimpleFlashLight(Battery battery, Light light) {
        this.battery = battery;
        this.light = light;
    }

    @Override
    public boolean turnOn() {
        if (!enabled) {
            enabled = battery.getCharge(light.chargesToTurnOn());
            return enabled;
        } else {
            return enabled;
        }
    }

    @Override
    public void turnOff() {
        enabled = false;
    }

    public Battery getBattery() {
        return battery;
    }

    public Light getLight() {
        return light;
    }
}

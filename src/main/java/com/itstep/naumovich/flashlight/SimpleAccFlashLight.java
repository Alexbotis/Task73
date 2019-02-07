package com.itstep.naumovich.flashlight;

import com.itstep.naumovich.battery.Accumulator;
import com.itstep.naumovich.light.Light;

/**
 * Created by admin on 25.01.2019.
 */
public class SimpleAccFlashLight extends SimpleFlashLight implements AccumulatorFlashLight {

    private Accumulator accumulator;

    public SimpleAccFlashLight(Accumulator battery, Light light) {
        super(battery, light);
        this.accumulator = battery;
    }

    @Override
    public Accumulator getAccumulator() {
        return accumulator;
    }

    @Override
    public int getAccCharge() {
        return accumulator.getCharge();
    }

}

package com.itstep.naumovich.flashlight;

import com.itstep.naumovich.battery.Accumulator;

/**
 * Created by admin on 25.01.2019.
 */
public interface AccumulatorFlashLight extends FlashLight {

    Accumulator getAccumulator();

    int getAccCharge();
}

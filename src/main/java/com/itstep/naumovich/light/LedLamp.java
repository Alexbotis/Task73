package com.itstep.naumovich.light;

public class LedLamp extends GlowLamp {

    @Override
    public int chargesToTurnOn() {

        return(super.chargesToTurnOn()/3);
    }

}

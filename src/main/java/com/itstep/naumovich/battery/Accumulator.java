package com.itstep.naumovich.battery;

/**
 * Created by admin on 25.01.2019.
 */
public interface Accumulator extends Battery {

    int getCharge();

    void recharge();

}

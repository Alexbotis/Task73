package com.itstep.naumovich.battery;

/**
 * Created by admin on 25.01.2019.
 */
public interface Battery {

    /**
     * Returns true if internal charge is enough and reduces internal charge for given value.
     * If not enough - return false.
     *
     * @param charges
     * @return
     */
    boolean getCharge(int charges);

}

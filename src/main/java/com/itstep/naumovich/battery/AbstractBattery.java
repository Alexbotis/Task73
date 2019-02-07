package com.itstep.naumovich.battery;

/**
 * Created by admin on 25.01.2019.
 */
public abstract class AbstractBattery implements Battery {

    private int charges;

    public AbstractBattery(int charges) {
        this.charges = charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

   public int getCharges() {
        return charges;
    }

    @Override
    public boolean getCharge(int charges) {
        if (charges > 0 && this.charges >= charges) {
            this.charges -= charges;
            return true;

        }
        return false;
    }
}

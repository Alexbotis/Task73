package com.itstep.naumovich.battery;

/**
 * Created by admin on 25.01.2019.
 */
public class SimpleAccumulator extends AbstractBattery implements Accumulator {

    private int capacity;

    public SimpleAccumulator(int chargesCapacity) {
        super(chargesCapacity);
        this.capacity = chargesCapacity;
    }

    @Override
    public int getCharge() {
        return getCharges();
    }

    @Override
    public void recharge() {
        setCharges(capacity);
    }

}

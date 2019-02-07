package com.itstep.naumovich.flashlight;

import com.itstep.naumovich.battery.Accumulator;
import com.itstep.naumovich.light.Light;

public class SimpleTreeAccFlashLigh extends SimpleAccFlashLight {

    private Accumulator accumulator2;
    private Accumulator accumulator3;

    private boolean enabled;

public SimpleTreeAccFlashLigh (Accumulator battery1, Light light,Accumulator accumulator2,Accumulator accumulator3) {

    super(battery1, light);
    this.accumulator2=accumulator2;
    this.accumulator3=accumulator3;
}

    @Override
    public boolean turnOn() {
        boolean enabled1 = false;
        boolean enabled2 = false;
        boolean enabled3 = false;
        if (!enabled) {
            // если фонарь не выключен
            enabled1 = super.getAccumulator().getCharge((getLight().chargesToTurnOn()) / 3);
            enabled2 = accumulator2.getCharge((getLight().chargesToTurnOn()) / 3);
            enabled3 = accumulator3.getCharge((getLight().chargesToTurnOn()) / 3);
            // уменьшаем заряд поровну у трех батарей на величину light.chargesToTurnOn()) / 3

            if (enabled1 == true && enabled2 == true && enabled3 == true) {
                // если половину заряда взять можем у каждой из 2-ч батарей
                enabled=true;
                return ( enabled);// то и включить фонарь можем

            } else {

                enabled=false;
                return enabled;// иначе включить нельзя
            }
        }
        else {
            return enabled;// фонарь включен первоначально
        }
    }
    @Override
    public void turnOff() {
        enabled = false;
    }

    @Override
    public int getAccCharge()// получить заряд от трех аккамуляторов
    {
        return (super.getAccumulator().getCharge()+accumulator2.getCharge()+accumulator3.getCharge());
    }


    public void recharge() {

        accumulator2.recharge();
        accumulator3.recharge();
        super.getAccumulator().recharge();

    }

}




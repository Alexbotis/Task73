package com.itstep.naumovich.radio;

import com.itstep.naumovich.battery.Battery;

public class SimpleRadioWithTwooBattery extends SimpleRadio  {

    private Battery battery2;
    boolean enabled;

    public  SimpleRadioWithTwooBattery (Battery battery1,Battery battery2) {
        super(battery1);
        this.battery2 = battery2;
    }

        public boolean turnOn() {

            boolean enabled1 = false;
            boolean enabled2 = false;

            if (!enabled) {
                // если радио выключен
                enabled1 = getBattery().getCharge(getChargesToTurnOn() / 2);
                enabled2 = battery2.getCharge(getChargesToTurnOn() / 2);
                // уменьшаем заряд поровну у двух батарей на величину getChargesToTurnOn() / 2

                if (enabled1 == true && enabled2 == true) {
                    // если половину заряда взять можем у каждой из 2-ч батарей

                    enabled=true;
                    return enabled;// то и включить радио можем
                } else {

                    enabled=false;
                    return enabled;// иначе включить нельзя
                }
            }
            else {
                return enabled;// радио включен первоначально
            }
        }
    }


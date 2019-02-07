package com.itstep.naumovich.flashlight;

import com.itstep.naumovich.battery.AbstractBattery;
import com.itstep.naumovich.battery.Battery;
import com.itstep.naumovich.light.Light;

public class SimpleFlashLiteWithTwoBattery implements FlashLight {
    //!!! соответствующий тест метод  public void FlashlightWithTwoBatteryTest() throws Exception падает
    private Battery battery2;
    private Battery battery1;
    private Light light;
    private boolean enabled;


    public SimpleFlashLiteWithTwoBattery() {
    }

    public SimpleFlashLiteWithTwoBattery(Battery battery1, Battery battery2, Light light) {

        this.battery2 = battery2;
        this.light = light;
        this.battery1 = battery1;
    }


    @Override
    public boolean turnOn() {

        boolean enabled1 = false;
        boolean enabled2 = false;

        if (!enabled) {
            // если фонарь не выключен
            enabled1 = battery1.getCharge((light.chargesToTurnOn()) / 2);
            enabled2 = battery2.getCharge((light.chargesToTurnOn()) / 2);
            // уменьшаем заряд поровну у двух батарей на величину light.chargesToTurnOn()) / 2

            if (enabled1 == true && enabled2 == true) {
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
        public void turnOff () {
            enabled = false;
        }

    }

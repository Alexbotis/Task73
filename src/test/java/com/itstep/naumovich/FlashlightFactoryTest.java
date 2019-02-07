package com.itstep.naumovich;

import com.itstep.naumovich.battery.DuracellBattery;
import com.itstep.naumovich.flashlight.AccumulatorFlashLight;
import com.itstep.naumovich.flashlight.FlashLight;
import com.itstep.naumovich.flashlight.SimpleTreeAccFlashLigh;
import com.itstep.naumovich.radio.IRadio;
import com.itstep.naumovich.radiowithlight.IRadioWithLight;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 15.01.2019.
 */
public class FlashlightFactoryTest {

    private FlashlightFactory factory = new FlashLightFullCycleFactory();

    @Test
    public void chineseFlashlightTest() throws Exception {

        FlashLight flashLight = factory.createFlashLight(
                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.CHINESE_BATTERY);

        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        Assert.assertFalse(flashLight.turnOn());
        flashLight.turnOff();
        Assert.assertFalse(flashLight.turnOn());
        flashLight.turnOff();
    }

    @Test
    public void duracellFlashlightTest() throws Exception {

        FlashLight flashLight = factory.createFlashLight(
                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.DURACELL_BATTERY);

        for (int i = 0; i < 50; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        Assert.assertFalse(flashLight.turnOn());
        flashLight.turnOff();
        Assert.assertFalse(flashLight.turnOn());
        flashLight.turnOff();
    }

    @Test
    public void accumulatorFlashlightTest() throws Exception {

        AccumulatorFlashLight flashLight = factory.createFlashLight(
                FlashLightFullCycleFactory.GLOW_LAMP);

        for (int i = 0; i < 70; i++) {
            Assert.assertTrue(flashLight.turnOn());
            flashLight.turnOff();
        }
        Assert.assertFalse(flashLight.turnOn());
        flashLight.turnOff();

        Assert.assertEquals(0, flashLight.getAccCharge());

        flashLight.getAccumulator().recharge();

        Assert.assertEquals(700, flashLight.getAccCharge());

        Assert.assertTrue(flashLight.turnOn());
    }

    @Test
    public void duracellRadioTest() throws Exception {

        IRadio radio = factory.createRadio(
                FlashLightFullCycleFactory.DURACELL_BATTERY);

        for (int i = 0; i < 83; i++) { //потребляемый заряд равен 6
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
         Assert.assertFalse(radio.turnOn());
        radio.turnOff();
        Assert.assertFalse(radio.turnOn());
         radio.turnOff();
    }

    @Test
    public void accumulatorRadioTest() throws Exception {

        IRadio radio = factory.createRadio(
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY);

        for (int i = 0; i < 116; i++) { //потребляемый заряд равен 6
            Assert.assertTrue(radio.turnOn());
            radio.turnOff();
        }
         Assert.assertFalse(radio.turnOn());
        radio.turnOff();
        Assert.assertFalse(radio.turnOn());
         radio.turnOff();
    }



    @Test
    public void FlashlightWithTwoBatteryTest() throws Exception {

        FlashLight flashLightWithTwoBattery = factory.createFlashLiteWithTwoBattery(

                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.CHINESE_BATTERY,
                FlashLightFullCycleFactory.CHINESE_BATTERY);

        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(flashLightWithTwoBattery.turnOn());
            flashLightWithTwoBattery.turnOff();
        }

       Assert.assertFalse(flashLightWithTwoBattery.turnOn());
        flashLightWithTwoBattery.turnOff();
         Assert.assertFalse(flashLightWithTwoBattery.turnOn());
        flashLightWithTwoBattery.turnOff();
    }
    @Test
    public void FlashlightWithRadioTest1() throws Exception {

        IRadioWithLight flashLightWithRadio = factory.createFlashLiteWithRadio(

                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY);

        for (int i = 0; i < 140; i++) {
            Assert.assertTrue(flashLightWithRadio.turnOnFlashLite());
            flashLightWithRadio.turnoffFlashLite();
        }
        Assert.assertFalse(flashLightWithRadio.turnOnFlashLite());
        flashLightWithRadio.turnoffFlashLite();
        Assert.assertFalse(flashLightWithRadio.turnOnFlashLite());


    }
    @Test
    public void FlashlightWithRadioTest2() throws Exception {

        IRadioWithLight flashLightWithRadio = factory.createFlashLiteWithRadio(

                FlashLightFullCycleFactory.GLOW_LAMP,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY,
                FlashLightFullCycleFactory.ACCUMULATOR_700_BATTERY);

        for (int i = 0; i < 233; i++) {
            Assert.assertTrue(flashLightWithRadio.turnOnRadio());
            flashLightWithRadio.turnoffRadio();
        }
        // почему позволяет больше вллючений ???
        Assert.assertTrue(flashLightWithRadio.turnOnRadio());



    }
    @Test
    public void accumulatorTreeFlashlightTest() throws Exception {

        AccumulatorFlashLight treeAccFflashLight = factory.createSimpleTreeAccFlashLigh(
                FlashLightFullCycleFactory.LED_LAMP);

        for (int i = 0; i < 700; i++) {// три аккамулятора по 70 включений каждый
            Assert.assertTrue(treeAccFflashLight.turnOn());
            treeAccFflashLight.turnOff();
        }
        Assert.assertFalse(treeAccFflashLight.turnOn());
        treeAccFflashLight.turnOff();

        Assert.assertEquals(0, treeAccFflashLight.getAccCharge());


    }


}


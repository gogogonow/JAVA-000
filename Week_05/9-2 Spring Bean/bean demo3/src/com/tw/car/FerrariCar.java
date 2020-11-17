package com.tw.car;

import com.tw.itf.CarInterface;

/**
 * @author 61404
 */
//@Component
public class FerrariCar implements CarInterface {
    @Override
    public void drive() {
        System.out.println("You Are Driving Super Fast Ferrari Car!");
    }
}

package com.tw.car;

import com.tw.itf.CarInterface;

/**
 * @author 61404
 */
public class BMWCar implements CarInterface {
    @Override
    public void drive() {
        System.out.println("You Are Driving Fast BMW Car!");
    }
}

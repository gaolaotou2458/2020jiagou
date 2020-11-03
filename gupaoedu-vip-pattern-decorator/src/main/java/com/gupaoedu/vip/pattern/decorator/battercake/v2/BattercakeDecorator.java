package com.gupaoedu.vip.pattern.decorator.battercake.v2;

/**
 * 2.建一个扩展套餐的抽象装饰者 BattercakeDecotator类.
 */
public abstract class BattercakeDecorator extends Battercake {

    //静态代理，委派
    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}

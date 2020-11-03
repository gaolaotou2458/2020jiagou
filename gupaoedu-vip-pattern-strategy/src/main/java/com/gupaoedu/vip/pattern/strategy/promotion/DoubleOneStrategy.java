package com.gupaoedu.vip.pattern.strategy.promotion;

/**
 * 拼团优惠
 * Created by Tom
 */
public class DoubleOneStrategy implements PromotionStrategy{

    public void doPromotion() {
        System.out.println("双11");
    }
}

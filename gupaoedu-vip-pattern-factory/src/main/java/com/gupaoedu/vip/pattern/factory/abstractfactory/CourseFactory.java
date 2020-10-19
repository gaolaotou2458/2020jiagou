package com.gupaoedu.vip.pattern.factory.abstractfactory;

/**
 * 抽象工厂是用户的主入口
 * 在Spring中应用得最为广泛的一种设计模式
 * 易于扩展
 * Created by Tom.
 */
//抽象工厂不符合开闭原则，但是易于扩展
public interface CourseFactory {

    INote createNote();

    IVideo createVideo();

}

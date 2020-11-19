package com.imooc.java.escape;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <h1>数值计算和时间计算</h1>
 * */
@SuppressWarnings("all")
public class NumberAndTime {
    private static void scaleProblem() {
        BigDecimal decimal = new BigDecimal("12.222");
//        BigDecimal restult = decimal.setScale(2);//设置精度
//        System.out.println(result);
        //四舍五入调整精度
        BigDecimal result = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(result);
    }

    /**
     *@描述 除法除不尽
     *@参数
     *@返回值
     *@创建人 chenjie
     *@创建时间 2020/11/18
     *@修改人和其它信息
     */
    private static void divideProblem(){
        //System.out.println(new BigDecimal(30).divide(new BigDecimal(7)));
        System.out.println(
                new BigDecimal(30).divide(new BigDecimal(7),2,BigDecimal.ROUND_HALF_UP)
        );
    }

    /**
     *@描述 精度问题导致比较结果和预期不一致
     *@参数
     *@返回值
     *@创建人 徐小康
     *@创建时间 2020/11/18
     *@修改人和其它信息
     */
    private static void equalProblem(){
        BigDecimal decimal1 = new BigDecimal("0");
        BigDecimal decimal2 = new BigDecimal("0.0" );
        System.out.println(decimal1.equals(decimal2));
        System.out.println(decimal1.compareTo(decimal2) == 0);
    }

    /**
     * SimpleDateFormat 可以即系大于/等于它定义的事件精度
     * @throws Exception
     */
    private static void formatPrecision() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time_x = "2020-03-01 10:00:00";
        String time = "2020-03";

        System.out.println(sdf.parse(time_x));
        System.out.println(sdf.parse(time));
    }

    /**
     * SimpleDateFormat 存在线程安全问题.
     */
    private static void threadSafety(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(1000));

        while(true){
            threadPoolExecutor.execute(() -> {
                String dateString = "2020-03-01 10:00:00";
                try{
                    Date parDate = sdf.parse(dateString);
                    String dataString2 = sdf.format(parDate);
                    System.out.println(dateString.equals(dataString2));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            });
        }
    }



    public static void main(String[] args) throws Exception {

 //      scaleProblem(); //经度丢失错误，大于原先精度不会报错
        // divideProblem();
//        equalProblem();

        formatPrecision();
//        threadSafety();
    }
}

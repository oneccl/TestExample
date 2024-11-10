package com.cc;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2024/11/4
 * Time: 21:57
 * Description:
 */
public class Test01 {

    private static final Logger logger = Logger.getLogger(Test01.class);

    public static void main(String[] args) {
        Test01.logger.info("This is a test.");

        // 解析
        String dtStr = "01-十一月-2024";
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.CHINESE);
        // 格式化
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf1.parse(dtStr);
            System.out.println(date);
            String dtFormat = sdf2.format(date);
            System.out.println(dtFormat);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("解析异常！");
        }


        String dtStr1 = "中文";
        String dtStr2 = "flow_job_01";
        String dtStr3 = "2024-12-01";
        String dtStr4 = "";

        System.out.println(cnDateToEn(dtStr));
        System.out.println(cnDateToEn(dtStr1));
        System.out.println(cnDateToEn(dtStr2));
        System.out.println(cnDateToEn(dtStr3));
        System.out.println(cnDateToEn(dtStr4));

    }

    // 中文日期转换为英文日期
    public static String cnDateToEn(String cnStr){
        SimpleDateFormat cnDtSdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.CHINA);
        SimpleDateFormat enDtSdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = cnDtSdf.parse(cnStr);
            return enDtSdf.format(date);
        } catch (ParseException e) {
            return cnStr;
        }
    }


}

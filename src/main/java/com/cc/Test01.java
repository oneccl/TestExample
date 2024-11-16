package com.cc;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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


        // 正则提取
        String text = "abc10de178fg6";
        System.out.println(getRegexStr(text, "[0-9]+", 0));
        System.out.println(getRegexStr(text, "[0-9]+", 1));

        String text1 = "abc(10)de(8,5)";
        System.out.println(getRegexStr(text1, "\\([0-9,]*\\)", 0));
        System.out.println(getRegexStr(text1, "\\([0-9,]*\\)", 1));

        String text2 = "Today is 2024-11-16, tomorrow is 2024-11-17.";
        System.out.println(getRegexStr(text2, "(\\d{4})-(\\d{2})-(\\d{2})", 0));
        System.out.println(getRegexStr(text2, "(\\d{4})-(\\d{2})-(\\d{2})", 1));

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

    // 正则提取字符串中的子串，可指定提取第n个
    public static String getRegexStr(String str, String regex, Integer n){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        List<String> list = new ArrayList<>();
        // 除了以下写法，其它写法都不对
        while (matcher.find()){
            list.add(matcher.group());
        }
        //System.out.println(list);
        return list.get(n);
    }


}

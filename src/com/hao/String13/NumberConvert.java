package com.hao.String13;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chen Yonggui on 2017/8/17.
 */
public class NumberConvert {
    public static void main(String[] args) {
        String x = dataToUpper("2017-02-23");
        System.out.println(x);
        String x1 = numToUpper(20170223);
        System.out.println(x1);
//        Float xdf = (Float)(Math.round(23.223*100)/100);
        System.out.print(Math.round(23.23*100)/300);

        //    方法1:用Math.round计算,这里返回的数字格式的.
        float price=89.89f;
        int itemNum=3;
        float totalPrice=price*itemNum;
        Float x2 = (float)Math.round(totalPrice*100);
        float num=(float)(x2/100);//如果要求精确4位就*10000然后/10000
//    方法2:用DecimalFormat 返回的是String格式的.该类对十进制进行全面的封装.像%号,千分位,小数精度.科学计算.
        float price1=1.2f;
        DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p= decimalFormat.format(price);//format 返回的是字符串
//    个人觉得在前台显示金额方面的还是用第二种方式.理由很简单是字符串格式的.
    }


    // 日期转化为大小写
    public static String dataToUpper(String dateStr) {
        String res="";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (Exception e) {
            // 日期型字符串格式错误
            System.out.println("日期型字符串格式错误");
        }
        if(date!=null){
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            int year = ca.get(Calendar.YEAR);
            int month = ca.get(Calendar.MONTH) + 1;
            int day = ca.get(Calendar.DAY_OF_MONTH);
            res=numToUpper(year) + "年" + monthToUppder(month) + "月"+dayToUppder(day) + "日";
        }
        return res;
    }

    // 将数字转化为大写
    public static String numToUpper(int num) {
         String u[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
//        String u[] = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        char[] str = String.valueOf(num).toCharArray();
        System.out.println(str);
        String rstr = "";
        for (int i = 0; i < str.length; i++) {
            rstr = rstr + u[Integer.parseInt(str[i] + "")];
        }
        return rstr;
    }

    // 月转化为大写
    public static String monthToUppder(int month) {
        if (month < 10) {
            return numToUpper(month);
        } else if (month == 10) {
            return "十";
        } else {
            return "十" + numToUpper(month - 10);
        }
    }

    // 日转化为大写
    public static String dayToUppder(int day) {
        if (day < 20) {
            return monthToUppder(day);
        } else {
            char[] str = String.valueOf(day).toCharArray();
            if (str[1] == '0') {
                return numToUpper(Integer.parseInt(str[0] + "")) + "十";
            } else {
                return numToUpper(Integer.parseInt(str[0] + "")) + "十"
                        + numToUpper(Integer.parseInt(str[1] + ""));
            }
        }
    }
}

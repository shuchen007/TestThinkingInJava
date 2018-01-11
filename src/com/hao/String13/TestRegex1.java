package com.hao.String13;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/7/8.
 */
public class TestRegex1
{
    public static void main(String[] args){
        Random rand = new Random();
        String s= "+911";
        String str = "hi man, you are pig!";
        String x = "abcabcabc";
        String x1 = "Java now has regular expressions Java";

//        System.out.println(s.matches("(-|\\+)?\\d+"));
//        System.out.println(s.matches("[+,-]?\\d+"));
//        System.out.println(str.replaceFirst("a\\w+", "do"));
//        System.out.println(str.replaceAll("[a,i]", "do"));
//        System.out.println(x.matches("abc*";))
        Pattern p = Pattern.compile("s\\s ");
      Matcher m = p.matcher(x1);
        System.out.println(Pattern.matches(".+",x1));
        System.out.println(m.find());
        System.out.println(m.lookingAt());
        System.out.println(Arrays.toString(p.split(x1)));
        System.out.println(m.replaceAll("dog"));
        System.out.println(x1.matches("^Java"));
        String x2 = "004,12358";
        System.out.println(x2.split(",").length);
        System.out.println(x2.contains("004"));
        System.out.println(1==2-1);

        if(2==3){
            System.out.println("d");
        }
        if(2==4){
            System.out.println("ds");
        }
    }
}

package com.hao.String13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String [] args){
        String a ="0755-23328861";
        String b ="ThisisRegex";
        String c =" ddd";
        String d ="dfsweeed";
        String str = "sAver_vice23dsD_s@xso*-ftlab.n*et.";

//        Object t1 = a.matches("0\\d{4,}-\\d+");
        Object t2 = b.matches("\\bT.+x\\b");
//        Object t3 = c.matches("d.*?q");
//        Object t4 = d.matches("[a-z]+");
        Object t5 = str.matches("^[a-zA-Z]{1,32}\\w{1,31}@[a-zA-Z_0-9-*]{1,}.[a-zA-Z-*]{1,5}.?[a-zA-Z]{0,3}");

        Pattern pattern = Pattern.compile("\\s{0,}\\w+");
        Matcher matcher = pattern.matcher(c);
        System.out.println(matcher.matches());//匹配整个字符串是否符合规则。
        System.out.println(matcher.find());//在字符串中查询字符或者字符串是否包含。
    }
}

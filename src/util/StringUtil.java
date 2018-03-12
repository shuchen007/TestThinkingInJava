package util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Wang Chuanming
 * Date: 2016/8/18 15:45
 * To change this template use File | Settings | File Templates.
 */
public class StringUtil {
    public static String getDecodeString(String str) {
        String result = "";
        try {
            result = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean isEmptyOrNull(Object str) {
        if (str == null || ((str instanceof String) && "".equals(((String)str))) || (!(str instanceof String) && "".equals(str.toString())) ) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmptySpaceOrNull(Object str) {
        if (str == null || ((str instanceof String) && "".equals(((String)str).trim())) || (!(str instanceof String) && "".equals(str.toString().trim())) ) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean equal(Object str1, Object str2) {
        if (str1 == null && str2 == null) {
            return true;
        } else if (str1 != null && str2 != null && str1.toString().equals(str2.toString())) {
            return true;
        }else
        {
            return false;
        }
    }

    public static BigDecimal chineseNumToArabic(String str) {
        List<Map<String, String>> repNum = new ArrayList();
        repNum.add(new HashMap<String, String>());
        repNum.add(new HashMap<String, String>());
        repNum.get(0).put("一", "1");
        repNum.get(0).put("二", "2");
        repNum.get(0).put("两", "2");
        repNum.get(0).put("三", "3");
        repNum.get(0).put("四", "4");
        repNum.get(0).put("五", "5");
        repNum.get(0).put("六", "6");
        repNum.get(0).put("七", "7");
        repNum.get(0).put("八", "8");
        repNum.get(0).put("九", "9");
        repNum.get(0).put("零", "0");
        repNum.get(0).put("十", "a");
        repNum.get(0).put("百", "b");
        repNum.get(0).put("千", "c");
        repNum.get(0).put("万", "A1");
        repNum.get(0).put("亿", "B1");
        repNum.get(0).put("兆", "C");
        repNum.get(1).put("万亿", "C");

        for (int i = repNum.size()-1; i >= 0; i--)
        {
            for (String key : repNum.get(i).keySet())
            {
                str = str.replace(key, repNum.get(i).get(key));
            }
        }
        BigDecimal total = new BigDecimal(0);
        BigDecimal temp = new BigDecimal(0);
        BigDecimal tmp = new BigDecimal(0);
        for (char c : str.toCharArray())
        {
            if (c >= '0' && c <= '9')
            {
                tmp = tmp.add(new BigDecimal(c-'0'));
                continue;
            }
            if (c >= 'a' && c <= 'z')
            {
                if (tmp.equals(new BigDecimal(0)))
                {
                    tmp = new BigDecimal(1);
                }
                tmp = tmp.multiply(new BigDecimal(Math.pow(10, c - 'a' + 1)));
                temp = temp.add(tmp);
                tmp = new BigDecimal(0);
                continue;
            }
            if (c >= 'A' && c <= 'Z')
            {
                temp = temp.add(tmp);
                tmp = new BigDecimal(0);
                temp = temp.multiply(new BigDecimal(Math.pow(10000, c-'A'+1)));
                total = total.add(temp);
                temp = new BigDecimal(0);
                continue;
            }
        }
        total = total.add(tmp);
        total = total.add(temp);
        return total;

    }
    public static void main(String[]args)
    {
        chineseNumToArabic("十八");
    }
}

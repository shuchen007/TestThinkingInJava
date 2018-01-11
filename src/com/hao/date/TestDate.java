package com.hao.date;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestDate {
    public static void main(String[] args) {
        String x = "";
        for (int i = 0; i < 3; i++) {
            List<Map> valueList = new ArrayList();
            Map resultMap = new HashMap();
            resultMap.put("CLRC","34");
            valueList.add(resultMap);
//            valueList.add(null);
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            System.out.println("mDateTime0="+sdf.format(c.getTime()));
            c.add(Calendar.WEEK_OF_MONTH,-i);
            c.add(Calendar.DAY_OF_MONTH,-i);
            c.add(Calendar.MINUTE,-i);
            c.add(Calendar.HOUR,-i);
            c.add(Calendar.HOUR_OF_DAY,-i);
            c.add(Calendar.YEAR,-i);
            String mDateTime = sdf.format(c.getTime());
//            String trqtlclStr = requestTrqtlcl(mDateTime);//soap request.
//            jsonArray = JSON.parseArray(trqtlclStr);
//            if(null!=((JSONObject)(jsonArray.get(0))).get("CLRC")&&!"".equals(((JSONObject)(jsonArray.get(0))).get("CLRC"))){
//                break;
//            }
            System.out.println("mDateTime="+mDateTime);
            System.out.println("mDateTime1="+sdf.format(new Date()));
            boolean flag = valueList.get(0).get("CLRC") instanceof String;//确定引用的对象类型
            System.out.println("valueList="+flag);
//            if(valueList.get(0).get("CLRC").equals("34")) break;
            Float y =2f;
            String y1 = y+"";
            System.out.println(y1 instanceof String);
        }
    }
}

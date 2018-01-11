package com.hao.Control04;

import com.hao.operation03.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/8/26.
 */
public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(2)+random.nextFloat()+" "+random.nextDouble());
        System.out.println(Math.random());

        System.out.println(Character.isLowerCase(97));;

        for (int i = 0; i <8 ; i++) {
            int xa = random.nextInt(3);
            switch (xa){
                case 1 :break;
                case 2 :
                    System.out.println("2");
                default:
                    System.out.println("wan");
            }
        }

        char re = 'a';
        if(re=='a')
        System.out.println(re+1);

        String rw ="dof";
        System.out.println(rw.charAt(1));
        System.out.println(rw.toCharArray()[2]);

        Apple df = new Apple();
        List list = new ArrayList();
        Double da[]  = {23d,32d,2433d};
        System.out.println(df);
        System.out.println(list);
        System.out.println(da);
    }

}

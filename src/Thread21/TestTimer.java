package Thread21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/4/14.
 */
public class TestTimer {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static Timer timer = new Timer();//构造函数true设置为守护线程。
    static class MyTime extends TimerTask{
        @Override
        public void run() {
            System.out.println("I do");
//            this.cancel();//将自身任务线程移除，其他线程不受影响。
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTime tsk = new MyTime();
        String refTime = "2018-04-14 17:02:20";
        Date refDate = sdf.parse(refTime);
        System.out.println("1=" + refTime + ",2=" + new Date());
        timer.schedule(tsk, refDate,5000);
//        timer.cancel();//全部任务停止，进程销毁。
    }
}

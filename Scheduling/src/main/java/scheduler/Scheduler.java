package scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Habib, on 19/11/2020
 */
@Component
public class Scheduler {

    /*
    he field order of the cronExpression is
        1.Seconds
        2.Minutes
        3.Hours
        4.Day-of-Month
        5.Month
        6.Day-of-Week
        7.Year (optional field)
Ensure you have at least 6 parameters or you will get an error (year is optional)
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void scheduledByCron() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        System.out.println("spring boot cron scheduler: " + simpleDateFormat.format(date));
    }

    @Scheduled(fixedDelay = 1000)
    public void scheduledByFixedDelay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        System.out.println("spring boot fixedDelay scheduler: " + simpleDateFormat.format(date));
    }

    @Scheduled(fixedRate = 2000)
    public void scheduledByFixedRate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        System.out.println("spring boot fixedRate scheduler: " + simpleDateFormat.format(date));
    }
}

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import scheduler.Scheduler;

/**
 * Created by Habib, on 05/11/2020
 */


@SuppressWarnings("SpringBootApplicationSetup")
@SpringBootApplication
@ComponentScan(basePackageClasses = Scheduler.class)
@EnableScheduling
public class SpringBootSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSchedulingApplication.class, args);
    }

}

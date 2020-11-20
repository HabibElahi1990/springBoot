import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Habib, on 05/11/2020
 */
@SuppressWarnings("SpringBootApplicationSetup")
@SpringBootApplication
@ComponentScan({"config","model","controller"})
public class SpringBootInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInterceptorApplication.class, args);
    }

}

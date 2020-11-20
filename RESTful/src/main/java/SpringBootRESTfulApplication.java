import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Habib, on 05/11/2020
 */


@SuppressWarnings("SpringBootApplicationSetup")
@SpringBootApplication
@ComponentScan({"controller","service"})
public class SpringBootRESTfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRESTfulApplication.class, args);
    }

}

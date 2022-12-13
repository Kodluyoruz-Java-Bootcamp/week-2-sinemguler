package emlakcepte;

import emlakcepte.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}

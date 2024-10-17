package lk.ijse.pos_system_spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.possystemapispring")
@EnableWebMvc
public class webAppConfig {

}

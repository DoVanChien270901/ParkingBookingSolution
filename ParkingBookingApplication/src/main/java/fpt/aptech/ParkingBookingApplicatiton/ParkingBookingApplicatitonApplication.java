package fpt.aptech.ParkingBookingApplicatiton;

import fpt.aptech.ParkingBookingApplicatiton.Configuration.FilterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.*;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ParkingBookingApplicatitonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingBookingApplicatitonApplication.class, args);
    }

    @Bean
    FilterRegistrationBean<FilterConfig> speFilterRegistrationBean() {
        final FilterRegistrationBean<FilterConfig> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new FilterConfig());
        filterRegistrationBean.addUrlPatterns("/home/index");
        return filterRegistrationBean;
    }
}

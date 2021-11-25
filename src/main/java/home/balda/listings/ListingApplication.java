package home.balda.listings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ListingApplication {
    private static final Logger log = LoggerFactory.getLogger(ListingApplication.class);
    public static void main(String[] args){
        SpringApplication.run(ListingApplication.class, args);
    }

}

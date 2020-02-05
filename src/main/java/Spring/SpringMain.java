package Spring;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringMain extends AddressBookController{

    private static final Logger log = LoggerFactory.getLogger(SpringMain.class);


    public static void main(String[] args) {
        SpringApplication.run(SpringMain.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringMain.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

    @Bean
    public CommandLineRunner demo (AddressBookRepository repository){
        return args -> {
            repository.save(new AddressBook());

            //repository.save(new BuddyInfo("test", "address", "num"));
            //repository.save(new )

        };


    }

}

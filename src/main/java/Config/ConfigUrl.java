package Config;

import com.zinkworks.bountyhuntersurlshortener.model.bounty_url_table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.Repository;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Configuration
public class ConfigUrl {
    CommandLineRunner commandLineRunner(Repository repository){
        return args -> {
            bounty_url_table url = new bounty_url_table(
                    "wwww.bounty.url.create",
                    "absntu",
                    OffsetDateTime.of(2023,8,23,12,0,0,0, ZoneOffset.UTC)

            );
            repository.saveAll(
                    List.of(url)
            );
        };
    }
}

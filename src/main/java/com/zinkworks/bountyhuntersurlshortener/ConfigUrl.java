package com.zinkworks.bountyhuntersurlshortener;

import com.zinkworks.bountyhuntersurlshortener.model.BountyUrlTable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zinkworks.bountyhuntersurlshortener.repository.RepositoryUrl;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Configuration
public class ConfigUrl {



    private final RepositoryUrl repositoryUrl;


    public ConfigUrl(RepositoryUrl repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    @Bean
    CommandLineRunner commandLineRunner(RepositoryUrl repositoryUrl) {
        return args -> {
            BountyUrlTable url1 = new BountyUrlTable(
                    1l,
                    "Test_1_Original_Url",
                    "",
                    LocalDateTime.of(2023,10,12,10,10,2)
            );
            BountyUrlTable url2 = new BountyUrlTable(
                    2l,
                    "Test_2_Original_Url",
                    "",
                    LocalDateTime.of(2023, 12, 23, 9, 0, 0)

            );

            BountyUrlTable url3 = new BountyUrlTable(
                    3l,
                    "Test_3_Original_Url",
                    "",
                    LocalDateTime.of(2019, 1, 20, 12, 0, 0)

            );


            repositoryUrl.saveAll(
                    List.of(url1, url2, url3)

            );
        };
    }
}
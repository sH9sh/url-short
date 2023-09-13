package com.zinkworks.bountyhuntersurlshortener.service;

import com.zinkworks.bountyhuntersurlshortener.exceptions.UrlNotFoundException;
import com.zinkworks.bountyhuntersurlshortener.model.BountyUrlTable;
import com.zinkworks.bountyhuntersurlshortener.repository.RepositoryUrl;
import org.apache.catalina.LifecycleState;
import org.checkerframework.checker.calledmethods.qual.RequiresCalledMethods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;



@ExtendWith(MockitoExtension.class)
class UrlServiceTest {

    @InjectMocks
    UrlService urlService;
    @Autowired
    private RepositoryUrl repositoryUrl;



//    @Test
//    void canFindOriginalUrlByShortUrl() throws UrlNotFoundException {
//
//        when(urlService.findOriginalUrl("HuuMy3K"))
//                .thenReturn("https://www.youtube.com/watch?v=SDwqcFwvwY0");
//
//    }

    @Test
    @DisplayName("testing expected value")
    void getAllUrlsTest(){
        BountyUrlTable testTable = BountyUrlTable.builder()
                .originalUrl("https://www.youtube.com/watch?v=SDwqcFwvwY0")
                .shortUrl("HuuMy3K")
                .build();

        repositoryUrl.save(testTable);

        List<BountyUrlTable> urlList = repositoryUrl.findAll();

        assertThat(urlList).isNotNull();

        assertThat(urlList.size()).isEqualTo(1);

    }

}
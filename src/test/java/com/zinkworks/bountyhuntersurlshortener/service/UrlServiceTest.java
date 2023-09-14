package com.zinkworks.bountyhuntersurlshortener.service;

import com.zinkworks.bountyhuntersurlshortener.controller.ControllerUrl;
import com.zinkworks.bountyhuntersurlshortener.exceptions.BlackListedUrlException;
import com.zinkworks.bountyhuntersurlshortener.exceptions.InvalidUrlException;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;




@SpringBootTest
class UrlServiceTest {


    @Mock
    private RepositoryUrl repositoryUrl;

    @Mock
    private UrlService urlService;



    @Test
    @DisplayName("Testing for expected value with valid url")
    void canFindOriginalUrlByShortUrlWithUrlStoredInDatabase() throws UrlNotFoundException {

        when(urlService.findOriginalUrl("HuuMy3K"))
                .thenReturn("https://www.youtube.com/watch?v=SDwqcFwvwY0");

    }

    @Test
    @DisplayName("Testing for exception with invalid url")
    void findOriginalUrlThrowExceptionWithUrlNotOnDatabase() throws UrlNotFoundException {
        String shortUrl = "gdsav5p";
        when(urlService.findOriginalUrl(shortUrl))
                .thenThrow( new UrlNotFoundException("No entity with " + shortUrl + " found."));
    }

    @Test
    @DisplayName("Testing for all Urls")

    void getAllUrlsTest(){

        List<BountyUrlTable> urlList = repositoryUrl.findAll();

        assertThat(urlList).isNotNull();

        assertThat(urlList.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Testing to see if a short url is created ")
    void createNewShortUrlValidUrl() throws MalformedURLException, BlackListedUrlException, FileNotFoundException, InvalidUrlException {
        when(urlService.addNewUrl("https://www.youtube.com/"))
                .thenReturn("0xE0O6P");
    }

    @Test
    @DisplayName("Testing for exception when url is blacklisted")
    void createNewShortUrlBlacklistedUrl() throws MalformedURLException, BlackListedUrlException, FileNotFoundException, InvalidUrlException {
        when(urlService.addNewUrl("https://www.cunt.com/"))
                .thenThrow(new BlackListedUrlException("The url you entered is on our blacklist."));
    }

}
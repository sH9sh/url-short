package com.zinkworks.bountyhuntersurlshortener.repository;

import com.zinkworks.bountyhuntersurlshortener.model.BountyUrlTable;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class RepositoryUrlTest {

    @Mock
    private RepositoryUrl repositoryUrl;

    @Mock
    private TestEntityManager testEntityManager;

    @Test
    @Transactional
    public void SaveBountyTableURL_Test(){
        //Arange
        BountyUrlTable newRecord =new BountyUrlTable();

        newRecord.setShortUrl("MD5HasShortURL");
        newRecord.setOriginalUrl("https://www.Test_Original_URL.com");
        newRecord.setCreatedDate(LocalDateTime.now());

        //Act
        BountyUrlTable savedRecord = repositoryUrl.save(newRecord);

        //Assert
        assertNotNull(savedRecord);
        assertNotNull(savedRecord.getShortUrl());
        assertNotNull(savedRecord.getOriginalUrl());
        assertNotNull(savedRecord.getCreatedDate());
    }


    @Test
    public void findByOShortenURL_Test(){


        //Arrange
        BountyUrlTable newRecord =new BountyUrlTable();

        newRecord.setShortUrl("MD5HShortURL");
        newRecord.setOriginalUrl("https://www.Test_Original_URL.com");
        newRecord.setCreatedDate(LocalDateTime.now());

        Optional<BountyUrlTable> foundEntity = repositoryUrl.findByShortUrl("MD5HShortURL");


        assertTrue(foundEntity.isPresent());

        BountyUrlTable foundShortenUrl = foundEntity.get();
        assertEquals("MD5HdShortURL", foundShortenUrl.getShortUrl());
        assertEquals("https://www.Test_Original_URL.com", foundShortenUrl.getOriginalUrl());


    }



}
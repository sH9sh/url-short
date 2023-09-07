package com.zinkworks.bountyhuntersurlshortener.model;

//
//import com.zinkworks.bountyhuntersurlshortener.BountyUrlTable;
import com.zinkworks.bountyhuntersurlshortener.model.BountyUrlTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUrl extends JpaRepository<BountyUrlTable, Long> {
    //findByShort_url = "select short_Url from Url where short_Url = ?"
    @Query(value = "SELECT * FROM bountyurltable WHERE short_url = :shortUrl",  nativeQuery = true)
    Optional<BountyUrlTable> findByShortUrl(String shortUrl);
}
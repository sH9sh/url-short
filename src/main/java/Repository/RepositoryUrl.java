package Repository;


import com.zinkworks.bountyhuntersurlshortener.model.BountyurlTable;
import com.zinkworks.bountyhuntersurlshortener.model.BountyurlTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUrl extends JpaRepository<BountyurlTable, Long> {



    //findByShort_url = "select short_Url from Url where short_Url = ?"
    @Query(value = "SELECT * FROM bountyurltable WHERE short_url = :shortUrl",  nativeQuery = true)
    Optional<BountyurlTable> findByShortUrl(String shortUrl);



}
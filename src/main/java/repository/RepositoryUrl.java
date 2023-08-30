package repository;

import com.zinkworks.bountyhuntersurlshortener.model.BountyUrlTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RepositoryUrl extends JpaRepository<BountyUrlTable, Long> {
    Optional<BountyUrlTable> findByShortUrl(String shortUrl);

}

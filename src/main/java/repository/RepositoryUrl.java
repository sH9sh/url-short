package repository;

import com.zinkworks.bountyhuntersurlshortener.model.bounty_url_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositoryUrl extends JpaRepository<bounty_url_table, Long> {
}

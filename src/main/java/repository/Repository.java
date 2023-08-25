package repository;

import com.zinkworks.bountyhuntersurlshortener.model.bounty_url_table;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<bounty_url_table, Long> {
}

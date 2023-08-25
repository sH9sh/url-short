package repository;

import com.zinkworks.bountyhuntersurlshortener.model.bounty_url_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface Repository extends JpaRepository<bounty_url_table, Long> {
    Optional<Object> findAllById(Long id);

//@Query
//    Optional<bounty_url_table>findBybounty_url_tableShort_Url(String short_Url);
}

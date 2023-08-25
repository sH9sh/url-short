package service;
import com.zinkworks.bountyhuntersurlshortener.model.bounty_url_table;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import repository.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {


    private final Repository repository;


    @Autowired      // used on properties, setters and constructors.
                    // Autowires relationships between collaborating beans
    public Service(Repository repository){
        this.repository = repository;
    }

    // Read or search all fields.

    // Creating a list of type 'bounty_url_table' to hold id, created date, original url and short url.
    public List<bounty_url_table> getAllUrlInfo(){
        return repository.findAll();      // returns all database info from the repository class.
    }

    // Create
    // Add a new short URL.

    @Transactional
    public void addNewUrl(Long id)
    {
        repository.save(id);
    }

    // Delete
    public void deleteUrl(){

    }


    // Update
    @Transactional
    public void updateUrl(Long id, String original_url, String short_url, OffsetDateTime created_date){

    }


    }

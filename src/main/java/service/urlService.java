package service;
import com.zinkworks.bountyhuntersurlshortener.model.bounty_url_table;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RepositoryUrl;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class urlService {


    private final RepositoryUrl repositoryUrl;    // creating object of RepositoryUrl class


    @Autowired      // used on properties, setters and constructors.
                    // Autowires relationships between collaborating beans
    public urlService(RepositoryUrl repositoryUrl){

        this.repositoryUrl = repositoryUrl;
    }

    // Read or search all fields.

    // Creating a list of type 'bounty_url_table' to hold id, created date, original url and short url.
    public List<bounty_url_table> getAllUrlInfo(){
        return repositoryUrl.findAll();      // returns all database info from the repository class.
    }

    // Create
    // Add a new short URL. MD5 conversion will go here (I think)
    public void addNewUrl(bounty_url_table bountyUrlTable)
    {
        repositoryUrl.save(bountyUrlTable);     // used pass along new data entries with id, created date, original url
                                                // and short url to repository class.
    }

    // Delete
    public void deleteUrl(Long id){
        boolean exists = repositoryUrl.existsById(id);      // check if id being deleted is stored on database.
        if(!exists){
            throw new IllegalStateException("Url with id " + id + " does not exist");
        }
        repositoryUrl.deleteById(id);
    }


    // Update
    @Transactional      // only used for update. ensures integrity and consistency of data when making changes.
    public void updateUrl(Long id, String original_url, String short_url, OffsetDateTime created_date){

    }


    }

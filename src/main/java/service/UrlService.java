package service;
import com.zinkworks.bountyhuntersurlshortener.model.BountyUrlTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RepositoryUrl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service
public class UrlService {


    private BountyUrlTable bountyUrlTable;
    private final RepositoryUrl repositoryUrl;    // creating object of RepositoryUrl class


    @Autowired      // used on properties, setters and constructors.
    // Autowires relationships between collaborating beans. Injects dependencies into a class.
    public UrlService(RepositoryUrl repositoryUrl) {

        this.repositoryUrl = repositoryUrl;
    }

    // Read or search all fields.

    // Creating a list of type 'bounty_url_table' to hold id, created date, original url and short url.
    public List<BountyUrlTable> getAllUrlInfo() {
        return repositoryUrl.findAll();      // returns all database info from the repository class.
    }

    // Create
    // Add a new short URL. MD5 conversion will go here (I think)
    public void addNewUrl(String originalUrl) {
<<<<<<< HEAD
        MD5Hash.MD5HashingMethod(originalUrl);
=======
        // Validate url
        // if url is valid, check black list.
        // if its not blacklisted, run Md5Hash

        MD5Hash(originalUrl);
>>>>>>> dc7a091061f1127ce05d303d2545b7cc26c2f799

        Optional<BountyUrlTable> shortenedUrl = repositoryUrl.findByShortUrl(bountyUrlTable.getShortUrl());
        if (shortenedUrl.isPresent()) {
            throw new IllegalStateException("short url already in use");
        }
        repositoryUrl.save(bountyUrlTable);     // used pass along new data entries with id, created date, original url
        // and short url to repository class.
    }


        



        // READ
        public String getOriginalUrl (String shortUrl){

            var entity = repositoryUrl.findByShortUrl(shortUrl)
                    .orElseThrow(() -> new EntityNotFoundException("No entity with " + shortUrl + " found."));


            return entity.getOriginalUrl();
        }



        // Delete
        public void deleteUrl (Long id){
            boolean exists = repositoryUrl.existsById(id);      // check if id being deleted is stored on database.
            if (!exists) {
                throw new IllegalStateException("Url with id " + id + " does not exist");
            }
            repositoryUrl.deleteById(id);
        }



}

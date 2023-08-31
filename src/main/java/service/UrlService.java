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
        MD5Hash(originalUrl);

        Optional<BountyUrlTable> shortenedUrl = repositoryUrl.findByShortUrl(bountyUrlTable.getShortUrl());
        if (shortenedUrl.isPresent()) {
            throw new IllegalStateException("short url already in use");
        }
        repositoryUrl.save(bountyUrlTable);     // used pass along new data entries with id, created date, original url
        // and short url to repository class.
    }

    private static String MD5Hash(String originalUrl) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5"); // Create an instance of Message Digest. Message Digests are secure one-way hash functions
            // it outputs a fixed length hash value.
            // 'getInstance' returns a message digest object which implements the specified algorithm (md5)
            byte[] inputBytes = originalUrl.getBytes();    // convert original url to bytes
            md.update(inputBytes);                         // update the message digest with the input bytes
            byte[] md5Bytes = md.digest();                 // Calculate the MD5 hash, returns an array of bytes 'md5Bytes'
            // digest() performs final hashing computations.

            String base64Encoded = Base64.getEncoder().encodeToString(md5Bytes);   // encodes the byte array 'md5Bytes' to base64
            String finalShortUrl = base64Encoded.substring(0, 7);    // Substring of base64Encoded with first 7 characters

            return finalShortUrl;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();


        }
        
    }



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

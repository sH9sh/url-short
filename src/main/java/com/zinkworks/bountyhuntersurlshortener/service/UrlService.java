package com.zinkworks.bountyhuntersurlshortener.service;

import com.zinkworks.bountyhuntersurlshortener.exceptions.BlackListedUrlException;
import com.zinkworks.bountyhuntersurlshortener.exceptions.InvalidUrlException;
import com.zinkworks.bountyhuntersurlshortener.model.BountyUrlTable;
import com.zinkworks.bountyhuntersurlshortener.exceptions.UrlNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zinkworks.bountyhuntersurlshortener.repository.RepositoryUrl;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UrlService {

    @Autowired
    private RepositoryUrl repositoryUrl;  // creating object of RepositoryUrl class


        // used on properties, setters and constructors.
    // Autowires relationships between collaborating beans. Injects dependencies into a class.


    // Read or search all fields.

    // Creating a list of type 'bounty_url_table' to hold id, created date, original url and short url.
    public List<BountyUrlTable> getAllUrlInfo() {
        return repositoryUrl.findAll();    // returns all database info from the repository class.
    }

    // Create
    // Add a new short URL. MD5 conversion will go here (I think)
//    public String addNewUrl(String originalUrl) throws InvalidUrlException, MalformedURLException, BlackListedUrlException {
//
//        boolean blackList = BlackList.checkBlackList(originalUrl);
//        String createdShortUrl = "";
//        if (UrlValiditation.isValid(originalUrl)) {
//            if (blackList) {
//                throw new BlackListedUrlException("The url you entered is on our blacklist.");
//            }
//            else{
//                createdShortUrl = UriComponentsBuilder.fromHttpUrl(originalUrl)
//                        .replaceQuery(null)
//                        .build()
//                        .toUriString();
//
//                createdShortUrl = MD5Hash.MD5HashingMethod(originalUrl);
//
//                BountyUrlTable newRecord = new BountyUrlTable();
//                newRecord.setShortUrl(createdShortUrl);
//                newRecord.setOriginalUrl(originalUrl);
//
//
//                repositoryUrl.save(newRecord);
//            }
//        }
//        else{
//            throw new InvalidUrlException("The url you entered is invalid");
//        }
//        return createdShortUrl;
//    }


    // READ
    public String findOriginalUrl(String shortUrl) throws UrlNotFoundException {

        var entity = repositoryUrl.findByShortUrl(shortUrl)
                .orElseThrow(() -> new UrlNotFoundException("No entity with " + shortUrl + " found."));

        return entity.getOriginalUrl();

    }



}

package com.zinkworks.bountyhuntersurlshortener.controller;


import com.zinkworks.bountyhuntersurlshortener.exceptions.BlackListedUrlException;
import com.zinkworks.bountyhuntersurlshortener.exceptions.InvalidUrlException;
import com.zinkworks.bountyhuntersurlshortener.exceptions.UrlNotFoundException;
import com.zinkworks.bountyhuntersurlshortener.model.BountyUrlTable;
import com.zinkworks.bountyhuntersurlshortener.repository.RepositoryUrl;
import com.zinkworks.bountyhuntersurlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;

import java.util.List;



@RestController
@RequestMapping( path = "api/v1/BountyURL")
public class ControllerUrl {


    //Variable declaration from ServiceUrl
    @Autowired
    private UrlService urlService;
    private RepositoryUrl repositoryUrl;


    @GetMapping
    public List<BountyUrlTable> getAllUrls() {
        return urlService.getAllUrlInfo();
    }


    //Constructor class


//ResponseEntity<String> is class that represent an HTTP response, In here Type of content is String
//GET Method for retrieve information from a server.

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable String shortUrl) throws UrlNotFoundException {
        String originalUrl = urlService.findOriginalUrl(shortUrl);
        if (originalUrl != null) {
            //Retrieve Original URL from server
           // return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
            return ResponseEntity.ok(originalUrl);
        } else {
            //Build Error Message
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createShortUrl(@RequestBody String originalUrl ) throws MalformedURLException, BlackListedUrlException, InvalidUrlException, FileNotFoundException {
        String shortUrl = urlService.addNewUrl(originalUrl);
        if(shortUrl.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Shorten URL not created");
        }
        else {

            return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);
        }
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUrlById(@PathVariable("id") Long id){
        repositoryUrl.deleteById(id);
    }
}
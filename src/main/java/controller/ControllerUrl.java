package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/BountyURL")
public class ControllerUrl {

    private final UrlService urlService;    //Variable declaration from ServiceUrl

    @Autowired

    public ControllerUrl(UrlService urlService) {    //Constructor class
        this.urlService = serviceUrl;
    }

    @GetMapping("{short_url}")    //GET Method for retrieve information from a server.
    //ResponseEntity<String> is class that represent an HTTP response, In here Type of content is String
    public ResponseEntity<String> getOriginalUrl(@PathVariable String short_url) {

        String originalUrl = urlService.getOriginalUrl(short_url);    //Got the Original URL from the ServiceUrl Class.
        if (originalUrl != null) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build(); //Retrieve Original URL from server
        }
        else {
            return ResponseEntity.notFound().build();   //Build Error Message
        }
    }

    @PostMapping    //To send Original URL to server for the creating shorten URL
    public ResponseEntity<String> createShortUrl(@RequestBody String original_url) {

        String shortUrl = urlService.addNewUrl(original_url);  //Got the created Shorten URL from server
        if (shortUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Shorten URL not created");       //Failed created shorten URL
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);            //View the Created shorten URL
        }
    }

    @DeleteMapping("{short_url}")    //Delete Record from the database
    public ResponseEntity<String> deleteShortUrl(@PathVariable String short_url) {

        boolean deleted = urlService.deleteUrl(short_url);   //The URL to delete passed to server and got the responses.
        if (deleted) {
            return ResponseEntity.ok("Short URL deleted");     //Delete successful completed.
        }
        else {
            return ResponseEntity.notFound().build();       //Build error message
        }
    }
}

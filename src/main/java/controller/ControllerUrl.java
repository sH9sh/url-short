package controller;

import com.zinkworks.bountyhuntersurlshortener.model.ServiceUrl;
import com.zinkworks.bountyhuntersurlshortener.UrlShortenerApplication;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.apache.commons.validator.routines.UrlValidator;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "api/v1/BountyURL")
public class ControllerUrl {


    //Variable declaration from ServiceUrl
    private final UrlService urlService;


    @Autowired
    //Constructor class
    public ControllerUrl(UrlService urlService) {
        this.urlService = serviceUrl;
    }



    @GetMapping("{short_url}")

    //ResponseEntity<String> is class that represent an HTTP response, In here Type of content is String
    //GET Method for retrieve information from a server.
    public ResponseEntity<String> getOriginalUrl(@PathVariable String short_url){


        //Got the Original URL from the ServiceUrl Class.
        String originalUrl = urlService.getOriginalUrl(short_url);

        if(originalUrl != null){
            //Retrieve Original URL from server
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
        }
        else{
            //Build Error Message
            return ResponseEntity.notFound().build();
        }

    }
    @PostMapping
    //To send Original URL to server for the creating shorten URL
    public ResponseEntity<String>  createShortUrl(@RequestBody String original_url ){

        //Got the created Shorten URL from server
        String shortUrl = urlService.addNewUrl(original_url);

        if(shortUrl.isEmpty()){
            //Failed created shorten URL
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Shorten URL not created");
        }


        else {
                //View the Created shorten URL
                return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);
        }



    }

    @DeleteMapping("{short_url}")

    //Delete Record from the database
    public ResponseEntity<String> deleteShortUrl(@PathVariable String short_url) {

        //The URL to delete passed to server and got the responses.
        boolean deleted = urlService.deleteUrl(short_url);


        if (deleted) {
            //Delete successful completed.
            return ResponseEntity.ok("Short URL deleted");

        } else {
            //Build error message
            return ResponseEntity.notFound().build();

        }

    }




}

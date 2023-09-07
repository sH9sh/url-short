package controller;

import com.zinkworks.bountyhuntersurlshortener.model.RepositoryUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/BountyURL")
public class ControllerUrl {

    private final UrlService urlService;
    private final RepositoryUrl repositoryUrl;

    @Autowired
    public ControllerUrl(UrlService urlService, RepositoryUrl repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
        this.urlService = serviceUrl;
    }
    @GetMapping("{short_url}")    //GET Method for retrieve information from a server.
    public ResponseEntity<String> getOriginalUrl(@PathVariable String short_url) {

        String originalUrl = urlService.getOriginalUrl(short_url);
        if (originalUrl != null) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping    //To send Original URL to server for the creating shorten URL
    public ResponseEntity<String> createShortUrl(@RequestBody String original_url) {

        String shortUrl = urlService.addNewUrl(original_url);
        if (shortUrl.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Shorten URL not created");
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);
        }
    }
    @DeleteMapping("{id}")    //Delete Record from the database
    public void deleteShortUrl(@PathVariable Long id ){
        repositoryUrl.deleteById(id);
    }
}
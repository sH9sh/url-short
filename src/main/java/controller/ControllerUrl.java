package controller;
// test
// test 2 u

import com.zinkworks.bountyhuntersurlshortener.model.BountyUrlTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UrlService;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/Url")
public class ControllerUrl {
    private final UrlService urlService;

    @Autowired
    public ControllerUrl(UrlService urlService) {
        this.urlService = urlService;
    }

    // Original_New
    @GetMapping
    public List<BountyUrlTable> getUrl(){
        return urlService.getAllUrlInfo();
    }

    @PostMapping    // used to handle HTTP Post requests.
    public void createNewUrl(@RequestBody BountyUrlTable bountyUrlTable){
        urlService.addNewUrl();
    }

}



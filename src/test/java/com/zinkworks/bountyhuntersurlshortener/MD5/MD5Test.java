package com.zinkworks.bountyhuntersurlshortener.MD5;

import com.zinkworks.bountyhuntersurlshortener.controller.ControllerUrl;
import com.zinkworks.bountyhuntersurlshortener.repository.RepositoryUrl;
import com.zinkworks.bountyhuntersurlshortener.service.MD5Hash;
import com.zinkworks.bountyhuntersurlshortener.service.UrlService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class MD5Test {
    @InjectMocks
    private ControllerUrl controllerURL;
    @Mock
    private UrlService urlService;
    private RepositoryUrl repositoryUrl;
    String finalShortURL = "24Awf1i";
    String originalURL = "https://www.youtube.com/watch?v=SDwqcFwvwY0";
    @Test
    @DisplayName("Testing to check returned shortURL is the same every time")
    void MD5HashingMethod_returnsSameShortUrl(){
        String newValue = MD5Hash.MD5HashingMethod(originalURL);
        assertEquals(finalShortURL, newValue);
    }
    @Test
    @DisplayName("Check if string is in base64 Format")
    void MD5HashingMethod_returnsBase64(){
        String validBase64 = "aGVsbG93b3JsZA";
        assertTrue(isBase64(validBase64));

    }
    public boolean isBase64(String originalURL){
        try{
            String newValue = MD5Hash.MD5HashingMethod(originalURL);
            Base64.getDecoder().decode(newValue);
            return true;
        }
         catch (IllegalArgumentException e){
            return false;
        }
    }

}

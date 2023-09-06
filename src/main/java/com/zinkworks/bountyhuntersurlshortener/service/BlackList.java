package com.zinkworks.bountyhuntersurlshortener.service;

import com.zinkworks.bountyhuntersurlshortener.exceptions.BlackListedUrlException;
import com.zinkworks.bountyhuntersurlshortener.exceptions.UrlNotFoundException;

import java.util.*;

public class BlackList {

    public static List<String> blackList = List.of(
            "https://www.tiktok.com/en/",
            "https://truthsocial.com/?",
            "youtube"
    );


    public static boolean checkBlackList(String originalUrl) throws BlackListedUrlException {

        return blackList.contains(originalUrl);
    }
}

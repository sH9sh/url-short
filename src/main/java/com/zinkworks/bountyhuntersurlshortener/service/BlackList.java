package com.zinkworks.bountyhuntersurlshortener.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackList {

//    public static List<String> blackList = List.of(
//            "https://www.tiktok.com/en/",
//            "https://truthsocial.com/?",
//            "youtube"
//    );


//    public static boolean checkBlackList(String originalUrl) throws BlackListedUrlException {
//
//        return blackList.contains(originalUrl);
//    }


    public static boolean checkBlackList(String originalURL) throws FileNotFoundException {
        List<String> blackList = new ArrayList<>();
        Scanner scnr = new Scanner(new FileReader("C:\\Users\\JessicaHoey\\Downloads\\urls.txt"));
        String str;
        while (scnr.hasNext()) {
            str = scnr.next();
            blackList.add(str);
        }
        for (String substring : blackList) {
            if (originalURL.contains(substring)) {
                return true;
            }
        }
        return false;
    }
}

//    private static boolean checkBlackList(String originalURL) throws BlackListedUrlException {
//        for (String substring:blackList) {
//            if (originalURL.contains(substring)){
//                return true;
//            }
//        }
//        return false;
//    }




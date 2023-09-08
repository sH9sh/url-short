package com.zinkworks.bountyhuntersurlshortener.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackList {


    public static boolean checkBlackList(String originalURL) throws FileNotFoundException{
        List<String> blackList = new ArrayList<>();
        Scanner scnr = new Scanner(new FileReader("urls.txt"));
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

//Need to add a keywords check, can comment out the url constraint if no longer needed or get program to check both simultaneously.
public static boolean checkBlacklistKeywords(String originalURL) throws FileNotFoundException{
    List<String> blacklistKeywords = new ArrayList<>();
    Scanner scnr = new Scanner(new FileReader("urls.txt"));
    String str;
    while (scnr.hasNext()) {
        str = scnr.next();
        blacklistKeywords.add(str);
    }
    for (String substring : blacklistKeywords) {
        if (originalURL.contains(substring)) {
            return true;
        }
    }
    return false;
}

}






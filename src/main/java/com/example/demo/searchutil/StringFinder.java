package com.example.demo.searchutil;


import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringFinder {
    String[] searchData;
    Logger logger
            = Logger.getLogger(
            StringFinder.class.getName());
    public StringFinder(String[] data){
        this.searchData = data;
    }

    public String[] find(String value) {
        logger.log(Level.INFO,()->"String to be searched: "+value);
        //Convert string to character array
        char[] compareString = value.toCharArray();
        //sort character array
        Arrays.sort(compareString);
        List<String> result = new ArrayList<>();
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        //logic to find desired string in array
        for(String search: searchData){
            char[] ch = search.toCharArray();
            Arrays.sort(ch);
            if(Arrays.equals(ch,compareString)){
                result.add(search);
            }
        }
        stopwatch.stop();
        logger.info("Time taken for search String: "+stopwatch.getTotalTimeMillis()+" ms");
        return result.stream().toArray(String[]::new);
    }
}

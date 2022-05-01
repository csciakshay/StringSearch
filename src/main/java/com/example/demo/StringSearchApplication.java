package com.example.demo;

import com.example.demo.exception.NoDataFoundException;
import com.example.demo.searchutil.StringFinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class StringSearchApplication {
	private static String[] data = {"asd","asdd","fre","glk","lkm","rfe"};
	private static String searchString = "efr";
	public static void main(String[] args) throws NoDataFoundException {

		SpringApplication.run(StringSearchApplication.class, args);

		StringFinder stringFinder = new StringFinder(data);
		//use searchString variable to pass static text
		String[] result = stringFinder.find(args[0]);
		if(result.length > 0) {
			Arrays.stream(result).forEach(System.out::println);
		}
		else{
			throw new NoDataFoundException("Search string "+searchString+" not found in a list");
		}

	}

}

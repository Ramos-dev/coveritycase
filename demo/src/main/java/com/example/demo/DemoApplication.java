package com.example.demo;

import com.example.demo.util.XMLParse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@SpringBootApplication
public class DemoApplication {

	//http://localhost:8080/xxe?str=%3C%3fxml%20version%3d%221%2e0%22%3f%3E%3C%21DOCTYPE%20root%20%5b%3C%21ENTITY%20test%20SYSTEM%20%27http%3a%2f%2flocalhost%3a1234%2fq%27%3E%5d%3E%3Croot%3E%26test%3b%3C%2froot%3E
	@RequestMapping(value = "xxe")
	@ResponseBody
	public Object xxe(@RequestParam String str){
		//str = "<?xml version=\"1.0\"?><!DOCTYPE root [<!ENTITY test SYSTEM 'http://localhost:1234/q'>]><root>&test;</root>";
		try {
			Map map = XMLParse.xmlToMap(str);
			return  map;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";

	}

	@RequestMapping(value = "xxesafe2")
	@ResponseBody
	public Object xxe2(@RequestParam String str){
		try {
			Map map = XMLParse.xmlToMapfix2(str);
			return  map;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";

	}
	@RequestMapping(value = "xxesafe")
	@ResponseBody
	public Object xxe3(@RequestParam String str){
		try {
			Map map = XMLParse.xmlToMapfix(str);
			return  map;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";

	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

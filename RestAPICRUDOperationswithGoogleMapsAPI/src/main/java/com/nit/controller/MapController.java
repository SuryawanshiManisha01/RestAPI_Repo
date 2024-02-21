package com.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
	 @GetMapping("/showMap")
	    public String Index() {
	        return "Index";
	    }

}

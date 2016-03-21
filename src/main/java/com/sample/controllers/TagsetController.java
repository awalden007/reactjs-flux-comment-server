package com.sample.controllers;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.tags.Tagset;
import com.sample.tags.TagsetUtil;

@RestController
@CrossOrigin
@RequestMapping("/tagsets")
public class TagsetController {

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Tagset> getTagsets() {
		return TagsetUtil.getTagsets();
	}
	
}

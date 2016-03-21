package com.sample.tags;

import java.util.ArrayList;

public class TagsetUtil {

	private TagsetUtil() {
		
	}
	
	public static ArrayList<Tagset> getTagsets() {
		TagsetManager.getInstance();
		return TagsetManager.getTagsets();
	}
	
	public static Tagset getTagset(String id) {
		TagsetManager.getInstance();
		return TagsetManager.getTagset(id);
	}
	
}

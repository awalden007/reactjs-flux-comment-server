package com.sample.tags;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class TagsetManager {
	
	private static TagsetManager instance = null;
	private static ArrayList<Tagset> tagsets = null;

	protected TagsetManager() {
		tagsets = new ArrayList<Tagset>();
		
		Random random = new Random();
		//int numChildTags;// = random.nextInt(10);
		
		Tagset tagset;
		
		for(int x = 0; x < 10; x++) {
			tagset = new Tagset();
			tagset.setId(UUID.randomUUID().toString());
			tagset.setName("Tagset " + x);
			tagset.setDescription("Tagset " + x + " Description");
			
			Tag tag;
			int numChildTags = random.nextInt(10);
			System.out.println("Creating " + numChildTags + " children tags.");
			for(int i = 0; i < numChildTags; i++) {
				tag = new Tag();
				tag.setId(UUID.randomUUID().toString());
				tag.setName("Tag " + i);
				tag.setDescription("Tag " + i + " Description");
				tagset.addChild(tag);
			}
			
			tagsets.add(tagset);
		}
	}
	
	public static TagsetManager getInstance() {
		if(instance == null) {
			instance = new TagsetManager();
		}
		return instance;
	}
	
	public static Tagset getTagset(String id) {
		for(Tagset tagset : tagsets) {
			if(tagset.getId().equals(id)) {
				return tagset;
			}
		}
		return null;
	}
	
	public static void addTagset(Tagset tagset) {
		tagsets.add(tagset);
	}
	
	public static ArrayList<Tagset> getTagsets() {
		return tagsets;
	}
}

package com.sample.tags;

import java.util.ArrayList;

public class Tag {

	private ArrayList<Tag> children;
	private String name;
	private String description;
	private String id;
	private boolean hasChildren = false;
	
	public Tag() {
		this.children = new ArrayList<Tag>();
	}

	public ArrayList<Tag> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Tag> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addChild(Tag childTag) {
		this.children.add(childTag);
		this.hasChildren = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
}

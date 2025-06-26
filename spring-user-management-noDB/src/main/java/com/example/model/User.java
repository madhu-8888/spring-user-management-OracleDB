package com.example.model;

public class User {
	
	private int id;
    private String name;
    private long mobile;
    
 // Constructors
    public User() {}
    
    public User(int id, String name, long mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }

    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}



}

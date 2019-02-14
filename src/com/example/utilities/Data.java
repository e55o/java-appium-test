package com.example.utilities;

public class Data {
	
	private String name;
    private String username;
    private String email;
    private String password;
    private String language;
    private Boolean addReq;
 
    public Data(){}
 
    public void Student(String name, String username, String email, String password, String language, Boolean addReq) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.language = language;
        this.addReq = addReq;
    }
 
    @Override
    public String toString() {
        return name+" "+username+" "+email+" "+password+" "+language+" "+addReq;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getAddReq() {
		return addReq;
	}

	public void setAddReq(Boolean addReq) {
		this.addReq = addReq;
	}

}

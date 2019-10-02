package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	
	public User(int id, String name, String email, String pass) {
		this.id = id;
		this.name = name;
		this.email = email;
		password = pass;
	}

	
	public int getID()
	{
		return id;
	}

	
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
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
	
	@Override
	public String toString() {
		return "User [id = " + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	

}

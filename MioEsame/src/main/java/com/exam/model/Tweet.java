package com.exam.model;

public class Tweet {
	
	protected String data;
	protected int idPost;
	protected String textPost;
	protected int idUser;
	protected String nameUser;
	protected int numPost;
	protected String languagePost;
	protected String userMentions;
	protected String hashtag;
	
	
	//Costruttore del tweet
	public Tweet(String data, int idPost, String textPost, int idUser, String nameUser, int numPost,
			String languagePost, String userMentions, String hashtag) {
		this.data = data;
		this.idPost = idPost;
		this.textPost = textPost;
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.numPost = numPost;
		this.languagePost = languagePost;
		this.userMentions = userMentions;
		this.hashtag = hashtag;
	}

	//Getters and Setters dei tweet
	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public int getIdPost() {
		return idPost;
	}


	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}


	public String getTextPost() {
		return textPost;
	}


	public void setTextPost(String textPost) {
		this.textPost = textPost;
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getNameUser() {
		return nameUser;
	}


	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}


	public int getNumPost() {
		return numPost;
	}


	public void setNumPost(int numPost) {
		this.numPost = numPost;
	}


	public String getLanguagePost() {
		return languagePost;
	}


	public void setLanguagePost(String languagePost) {
		this.languagePost = languagePost;
	}


	public String getUserMentions() {
		return userMentions;
	}


	public void setUserMentions(String userMentions) {
		this.userMentions = userMentions;
	}


	public String getHashtag() {
		return hashtag;
	}


	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	
	
	
}
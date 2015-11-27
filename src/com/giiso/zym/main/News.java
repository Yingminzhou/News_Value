package com.giiso.zym.main;

public class News {
	
	private int news_id;
	//The word count of the news
	private int word_cnt;
	//The position the news appears
	private boolean is_first;
	//The type of the news
	private String type;
	//The time distance between publishing and happening
	private double time;
	//The comprehensive rating for publishing website
	private double ori_rating;
	
	//The highest value of validation degree
	private double validation;
	//The rate of broadcasting within certain time
	private double bro_rate;
	//The total rating of broadcasting website
	private double bro_rating;
	
	
	
	public News(int news_id, int word_cnt, boolean is_first, String type, double time,
			double ori_rating, double validation, double bro_rate,
			double bro_rating) {
		super();
		this.news_id = news_id;
		this.word_cnt = word_cnt;
		this.is_first = is_first;
		this.type = type;
		this.time = time;
		this.ori_rating = ori_rating;
		this.validation = validation;
		this.bro_rate = bro_rate;
		this.bro_rating = bro_rating;
	}	
	
	public Double getTypeMark() {
		return Constants.type_rate.get(this.type);
	}

	public double getTime() {
		return (1-this.time)/24.0;
	}

	public double getOri_rating() {
		return ori_rating;
	}

	public void setOri_rating(double ori_rating) {
		this.ori_rating = ori_rating;
	}


	public double getValidation() {
		return validation;
	}

	public void setValidation(double validation) {
		this.validation = validation;
	}
	
	public double getBro_rate() {
		return bro_rate;
	}

	public void setBro_rate(double bro_rate) {
		this.bro_rate = bro_rate;
	}
	
	public double getBro_rating() {
		return bro_rating;
	}

	public void setBro_rating(double bro_rating) {
		this.bro_rating = bro_rating;
	}

	public double get_word_mark(){
		if(this.word_cnt>2000){
			return 2.0;
		}
		else{
			return this.word_cnt/1000.0;
		}
	}

	public double getPos(){
		if(this.is_first){
			return Constants.pos_first;
		}else{
			return Constants.pos_nofirst;
		}
	}

	public int getNews_id() {
		return news_id;
	}

	public void setNews_id(int news_id) {
		this.news_id = news_id;
	}
	
}

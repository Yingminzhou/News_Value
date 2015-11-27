package com.giiso.zym.main;

public class Main {

	private News news;
	
	
	public Main(News news){
		this.news = news;
	}
	
	public double getInitValue(){
		return Constants.w_1 * news.get_word_mark() + Constants.w_2 * news.getPos()
				+ Constants.w_3 * news.getTypeMark() + Constants.w_4 * news.getTime() 
				+ Constants.w_5 * news.getOri_rating();
	}
	
	public double getA(){
		return news.getBro_rating()*news.getValidation();
	}
	
	public double getB(){
		return news.getBro_rating()*news.getBro_rate();
	}
	
	public double getC(){
		return news.getBro_rating()*0.5;
	}
	
	public double getN(){
		return news.getBro_rating()* this.getInitValue();
	}
	
	
	
	public static void main(String args[]){
		News news = new News(1,460, true, "Comment", 2, 0.7, 0.5, 0.9, 1.2);
		Main main = new Main(news);
		System.out.println("a:"+main.getA());
		System.out.println("b:"+main.getB());
		System.out.println("c:"+main.getC());
		System.out.println("v0:"+main.getInitValue());
		System.out.println("n:"+main.getN());
		
		System.out.println("m:"+ 1.4109/Math.pow(0.7484,0.8));
		
	}
}

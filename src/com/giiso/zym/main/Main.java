package com.giiso.zym.main;

public class Main {
	
	
	
	public static void main(String args[]){
		News news = new News(1,460, true, "Comment", 2, 0.7, 0.5, 0.0, 0.0);
		Model model = new Model(news);
		
		double t = 0.0;
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,0));
		t = 2.0;
		news.setValidation(0.6);
		news.setBro_rate(0.6);
		news.setBro_rating(0.9);
		model.updateModel(news, t/4);
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,0.5));
		t = 4.0;
		news.setValidation(0.6);
		news.setBro_rate(0.8);
		news.setBro_rating(1.0);
		model.updateModel(news, t/4);
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,0.5));
		t = 6.0;
		news.setValidation(0.8);
		news.setBro_rate(0.8);
		news.setBro_rating(1.2);
		model.updateModel(news, t/4);
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,0.5));
		t = 8.0;
		news.setValidation(0.8);
		news.setBro_rate(0.8);
		news.setBro_rating(1.5);
		model.updateModel(news, t/4);
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,0.5));
		t = 10.0;
		news.setValidation(0.8);
		news.setBro_rate(0.0);
		news.setBro_rating(0.0);
		model.updateModel(news, t/4);
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,t/4));
		t = 12.0;
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,t/4));
		t = 14.0;
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,t/4));
		t = 16.0;
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,t/4));
		t = 18.0;
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,t/4));
		t = 20.0;
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,t/4));
		t = 22.0;
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,t/4));
		t = 24.0;
		System.out.println("t: "+ t + " Value:" + model.getCurValue(news,t/4));
	}
}

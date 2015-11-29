package com.giiso.zym.main;

public class Model {
	
	private double initValue;
	private double a;
	private double b;
	private double c;
	private double m;
	private double n;
	private double tmpValue;
	
	public Model(News news){
		this.initValue = Constants.w_1 * news.get_word_mark() + Constants.w_2 * news.getPos()
				+ Constants.w_3 * news.getTypeMark() + Constants.w_4 * news.getTime() 
				+ Constants.w_5 * news.getOri_rating();		
		this.tmpValue = initValue;
	}

	private void updateIncModel(News news,double t){
		this.tmpValue = getIncVal(t) - (-a*Math.pow(t, 3)+b*Math.pow(t, 2)+c*t);
		this.a = news.getBro_rating()*news.getValidation();
		this.b = news.getBro_rating()*news.getBro_rate();
		this.c = news.getBro_rating()*0.5;
		System.out.println("Model:  -"+a+"x^3 + "+b+"x^2 + "+c+"x + "+tmpValue);
	}
	
	private void updateDecModel(News news,double t){
		this.n = this.initValue;
		this.m = getIncVal(0.5)/Math.pow(n, t);		
		System.out.println("Model:  "+ n +"^x * "+m);
	}
	
	
	public double getCurValue(News news,double t){
		if (news.getBro_rate()==0.0) {
			return this.getDecVal(t);
		}else{
			return this.getIncVal(t);
		}
	}
	
	public void updateModel(News news,double t){
		if (news.getBro_rate()==0.0) {
			updateDecModel(news, t);
		}else{
			updateIncModel(news, t);
		}
	}
	
	
	private double getIncVal(double t){
		return -a*Math.pow(t, 3)+b*Math.pow(t, 2)+c*t+tmpValue;
	}
	
	private double getDecVal (double t){
		return Math.pow(n, t)*m;
	}
	
	
}

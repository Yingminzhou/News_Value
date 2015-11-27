package com.giiso.zym.main;

import java.util.HashMap;

public class Constants {

	public static HashMap<String, Double> type_rate = 
			new HashMap<String,Double>(){/**
				 * 
				 */
				private static final long serialVersionUID = -5026110424340680271L;

			{
				put("Comment",1.0);
				put("Overview",0.8);
				put("Other",0.5);
			}};
	
	
	public static double w_1 = 0.2;
	public static double w_2 = 0.2;
	public static double w_3 = 0.2;
	public static double w_4 = 0.2;
	public static double w_5 = 0.2;
	
	public static double pos_first = 1.0;
	public static double pos_nofirst = 0.5;
	
}

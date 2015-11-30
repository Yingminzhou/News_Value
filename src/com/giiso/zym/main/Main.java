package com.giiso.zym.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) {
		if (args.length!=9){
			System.out.println("<Usage>: news_id, word_cnt,  is_first, type, time, ori_rating, validation, bro_rate,bro_rating");
		}else{
			final News news = new News(Integer.parseInt(args[0]),Integer.parseInt(args[1]), 
					Boolean.parseBoolean(args[2]),args[3], Integer.parseInt(args[4]), Double.parseDouble(args[5]), 
					Double.parseDouble(args[6]), Double.parseDouble(args[7]), Double.parseDouble(args[8]));
			final Model model = new Model(news);
			Runnable runnable = new Runnable() {
				public void run() {
					// task to run goes here
					try {
						File file = new File("data.txt");				
						@SuppressWarnings("resource")
						BufferedReader reader = new BufferedReader(new FileReader(file));
						String tmpLine = reader.readLine();
						String[] datas = tmpLine.split(",");						
						double t = Double.parseDouble(datas[0]);
						news.setValidation(Double.parseDouble(datas[1]));
						news.setBro_rate(Double.parseDouble(datas[2]));
						news.setBro_rating(Double.parseDouble(datas[3]));	
						model.updateModel(news, t/4);
						System.out.println("t: "+ t + " Value:" + model.getCurValue(news,t/4));
						model.setPreT(t/4);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			ScheduledExecutorService service = Executors
					.newSingleThreadScheduledExecutor();
			// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
			service.scheduleAtFixedRate(runnable, 1, 10, TimeUnit.SECONDS);
		}
	}
}

package com.xihua.wardrobe.util;

import java.util.Calendar;

public class ClotheslUtil {

	public static int selectByLevel(Integer temp) {
		int level = 1;
		if (temp < 6) {
			level = 8;
		} else if (temp < 10) {
			level = 7;
		} else if (temp < 15) {
			level = 6;
		} else if (temp < 18) {
			level = 5;
		} else if (temp < 21) {
			level = 4;
		} else if (temp < 24) {
			level = 3;
		} else if (temp < 28) {
			level = 2;
		} else {
			level = 1;
		}
		return level;
	}
	
	public static String getSeason () {
		Calendar now = Calendar.getInstance(); 
		int mo = now.get(Calendar.MONTH) + 1; //12，当前月，注意加 1
		
		if (mo>=3 && mo<=5){
			return "春季";
		}else if(mo>=6 && mo<=8){
			return "夏季";
		}else if(mo>=9 && mo<=11){
			return "秋季";
		}else{
			return "冬季";
		}
	}  
}

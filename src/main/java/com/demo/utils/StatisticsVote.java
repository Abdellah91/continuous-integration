package com.demo.utils;

import java.util.Vector;

public class StatisticsVote {
	public static Vector<Double> rates = new Vector<>();
	public static double sum=0f; 
	public static double rate() {
		return sum/rates.size();
	}
}

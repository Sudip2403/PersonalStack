package com.self.amazon.modules.designpattern.interceptingfilter;

public class Target {
	   public void execute(String request){
	      System.out.println("Executing request: " + request);
	   }
	}
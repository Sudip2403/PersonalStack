package com.self.amazon.modules.designpattern.interceptingfilter;

public class AuthenticationFilter implements Filter {
	   public void execute(String request){
	      System.out.println("Authenticating request: " + request);
	   }
	}

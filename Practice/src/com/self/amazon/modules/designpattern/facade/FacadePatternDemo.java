package com.self.amazon.modules.designpattern.facade;

public class FacadePatternDemo {

	public static void main(String[] args) {
	      ShapeMaker shapeMaker = new ShapeMaker();

	      shapeMaker.drawCircle();
	      shapeMaker.drawRectangle();
	   }
}

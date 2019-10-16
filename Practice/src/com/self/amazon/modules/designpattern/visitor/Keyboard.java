package com.self.amazon.modules.designpattern.visitor;

public class Keyboard implements ComputerPart {

	   @Override
	   public void accept(ComputerPartVisitor computerPartVisitor) {
	      computerPartVisitor.visit(this);
	   }
	}
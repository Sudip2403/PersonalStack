package com.self.amazon.modules.designpattern.transferObject;

import java.io.Serializable;

public class StudentVO implements Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	   private int rollNo;

	   StudentVO(String name, int rollNo){
	      this.name = name;
	      this.rollNo = rollNo;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public int getRollNo() {
	      return rollNo;
	   }

	   public void setRollNo(int rollNo) {
	      this.rollNo = rollNo;
	   }
	}

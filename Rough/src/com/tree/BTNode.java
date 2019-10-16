package com.tree;

public class BTNode implements BTPosition {
	 
		private Object element;
		private BTPosition left, right, parent;
	 
		public BTNode(Object element, BTPosition left, BTPosition right, BTPosition parent) {
			super();
			this.element = element;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
		public Object setElement(Object e) {
			Object t = this.element;
			this.element = e;
			return t;
		}
	 
		@Override
		public Object element() throws InvalidPositionException {
			return element;
		}
	 
		@Override
		public BTPosition getLeft() {
			return left;
		}
	 
		@Override
		public void setRight(BTPosition p) {
			this.right = p;
		}
	 
		@Override
		public BTPosition getRight() {
			return right;
		}
	 
		@Override
		public void setParent(BTPosition p) {
			this.parent = p;
		}
	 
		@Override
		public BTPosition getParent() {
			return parent;
		}
	 
		@Override
		public void setLeft(BTPosition p) {
			this.left = p;
	 
		}
	}
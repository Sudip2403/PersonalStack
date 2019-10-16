package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedBinaryTree implements BinaryTree {

	protected Position root;
	protected int size;

	public LinkedBinaryTree() {
		size = 0;
		root = null;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Position root() throws EmptyTreeException{
		if (root == null)
			throw new EmptyTreeException("Tree has no root.");
		return root;
	}


	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public Position addRoot(Object e) throws NonEmptyTreeException {
	    if (!isEmpty())
	        throw new NonEmptyTreeException("Tree already has a root.");
	     size = 1;
	     root = createNode(e, null, null, null);
	    return root;
	}
	
	protected BTPosition createNode(Object element, BTPosition parent, BTPosition left, BTPosition right) {
	    return new BTNode(element, left, right, parent);
	}
	
	public Position insertLeft(BTPosition v, Object e) throws InvalidPositionException {
	    if (hasLeft(v))
	        throw new InvalidPositionException("Node already has a left child.");
	    BTPosition t = createNode(e, v, null, null);
	    v.setLeft(t);
	    size++;
	    return t;
	}
	
	public Position insertRight(BTPosition v, Object e) throws InvalidPositionException {
	    if (hasRight(v))
	        throw new InvalidPositionException("Node already has a right child.");
	    BTPosition t = createNode(e, v, null, null);
	    v.setRight(t);
	    size++;
	    return t;
	}
	
	public void attach(BTPosition v, BinaryTree t1, BinaryTree t2) throws EmptyTreeException, InvalidPositionException, BoundaryViolationException {
	    if (isInternal(v))
	        throw new InvalidPositionException("Cannot attach to internal node.");
			
	    if (!t1.isEmpty()) {
	        v.setLeft((BTPosition) t1.root());
	        ((BTPosition) t1.root()).setParent(v);
	        size = size + t1.size();
	    }
	    if (!t2.isEmpty()) {
	        v.setRight((BTPosition) t2.root());
	        ((BTPosition) t2.root()).setParent(v);
	        size = size + t2.size();
	    }
	}
	
	
	public Object remove(BTPosition v) throws InvalidPositionException, BoundaryViolationException {
	    if (hasLeft(v) && hasRight(v))
	        throw new InvalidPositionException("Cannot remove node with two children.");
	    BTPosition c;
	    if (hasLeft(v))
	        c = (BTPosition) left(v);
	    else if (hasRight(v))
	        c = (BTPosition) right(v);
	    else
	        c = null;
	    if (isRoot(v)) {
	        if (c != null)
	            c.setParent(null);
	        root = c;
	    } else {
	        BTPosition pD = (BTPosition) parent(v);
	        if (hasLeft(pD) && v == left(pD))
	            pD.setLeft(c);
	        else
	            pD.setRight(c);
	        if (c != null)
	            c.setParent(pD);
	    }
	    size--;
	    Object t = v.element();
	    v = null;
	    return t;
	}
	
	@Override
	public Iterator elements() throws InvalidPositionException {
		List elements = new ArrayList();
		if (size != 0)
			try {
				inOrderElements((BTPosition)root, elements);
			} catch (BoundaryViolationException e) {
				e.printStackTrace();
			}
		return elements.iterator();
	}

	@Override
	public Iterator positions() throws InvalidPositionException {
		List positions = new ArrayList();
		if (size != 0)
			try {
				inOrderPositions((BTPosition)root, positions);
			} catch (BoundaryViolationException e) {
				e.printStackTrace();
			}
		return positions.iterator();
	}

	@Override
	public Object replace(Position v, Object e) throws InvalidPositionException {
		if (!(v instanceof BTNode))
			throw new InvalidPositionException("The position is not a valid Position.");
		return ((BTNode) v).setElement(e);
	}

	
	@Override
	public Position parent(Position v) throws InvalidPositionException {
		if (isRoot(v))
			throw new InvalidPositionException("Root has no parent.");
		return ((BTPosition) v).getParent();
	}

	@Override
	public Iterator<Position> children(Position v) throws InvalidPositionException {
		if (!(v instanceof BTPosition))
			throw new InvalidPositionException("The position is not a valid Position.");
		
		List<Position> children = new LinkedList<Position>();
		if (hasLeft((BTPosition) v))
			children.add(left((BTPosition) v));
		if (hasRight((BTPosition) v))
			children.add(right((BTPosition) v));
		return children.iterator();
	}

	@Override
	public boolean isInternal(Position v) throws InvalidPositionException {
		if (!(v instanceof BTPosition))
			throw new InvalidPositionException("The position is not a valid BTPosition.");
		return (hasLeft((BTPosition) v) || hasRight((BTPosition) v));
	}

	@Override
	public boolean isExternal(Position v) throws InvalidPositionException {
		return !isInternal(v);
	}

	@Override
	public boolean isRoot(Position v) throws InvalidPositionException {
		if (v == null)
			throw new InvalidPositionException("The position is null.");
		return v == root;
	}

	@Override
	public BTPosition left(BTPosition p) throws InvalidPositionException {
		if (!hasLeft(p))
			throw new InvalidPositionException("No left child");
		return  p.getLeft();
	}

	@Override
	public BTPosition right(BTPosition p) throws InvalidPositionException {
		if (!hasRight(p))
			throw new InvalidPositionException("No right child");
		return p.getRight();
	}

	@Override
	public boolean hasLeft(BTPosition p) throws InvalidPositionException {
		if (p == null)
			throw new InvalidPositionException("The position is null.");
		return p.getLeft() != null;
	}

	@Override
	public boolean hasRight(BTPosition p) throws InvalidPositionException {
		if (p == null)
			throw new InvalidPositionException("The position is null.");
		return p.getRight() != null;
	}
	
	private void inOrderPositions(BTPosition node, List positions) throws InvalidPositionException, BoundaryViolationException {
		if (hasLeft(node))
			inOrderPositions(left(node), positions);
			
		positions.add(node);
		
		if (hasRight(node))
			inOrderPositions(right(node), positions);
	}
	
	private void inOrderElements(BTPosition node, List elements) throws InvalidPositionException, BoundaryViolationException {
		if (hasLeft(node))
			inOrderElements(left(node), elements);
			
		elements.add(node.element());
		
		if (hasRight(node))
			inOrderElements(right(node), elements);
	}
	
	private void preOrderElements(BTPosition node, List elements) throws InvalidPositionException, BoundaryViolationException {
		
		elements.add(node.element());

		if (hasLeft(node))
			preOrderElements(left(node), elements);		
		
		if (hasRight(node))
			preOrderElements(right(node), elements);
	}
	
	private void postOrderElements(BTPosition node, List elements) throws InvalidPositionException, BoundaryViolationException {
		if (hasLeft(node))
			postOrderElements(left(node), elements);	
		
		if (hasRight(node))
			postOrderElements(right(node), elements);
			
		elements.add(node.element());
	}
}
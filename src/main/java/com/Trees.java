package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;
	protected int pos;

	public Tree(int value, Color color, int depth, int pos) {
		this.value = value;
		this.color = color;
		this.depth = depth;
		this.pos = pos;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth, int pos) {
		super(value, color, depth, pos);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);
		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}

	public ArrayList<Tree> getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return "TreeNode [children=" + children + ", pos=" + pos + "]";
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth, int pos) {
		super(value, color, depth, pos);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}

	@Override
	public String toString() {
		return "TreeLeaf [" + super.pos + "]";
	}
}

abstract class TreeVis {

	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {

	int result = 0;

	public int getResult() {
		return result;
	}

	public void visitNode(TreeNode node) {
	}

	public void visitLeaf(TreeLeaf leaf) {
		result = result + leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {

	long result = 1;
	private final int M = (int) Math.pow(10, 9) + 7;

	public int getResult() {
		return (int) result;
	}

	public void visitNode(TreeNode node) {
		if (node.getColor().equals(Color.RED)) {
			result = (result * node.getValue()) % M;
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor().equals(Color.RED)) {
			result = (result * leaf.getValue()) % M;
		}
	}
}

class FancyVisitor extends TreeVis {

	int result = 0;

	public int getResult() {
		return Math.abs(result);
	}

	public void visitNode(TreeNode node) {
		if (node.getDepth() % 2 == 0) {
			result = result + node.getValue();
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor().equals(Color.GREEN)) {
			result = result - leaf.getValue();
		}
	}
}

public class Trees {

	public static Tree solve() {
		// read the tree from STDIN and return its root as a return value of this
		// function
		Scanner scan = new Scanner(System.in);
		int numberNodes = scan.nextInt();
		int[] nodeAr = new int[numberNodes];
		for (int i = 0; i < numberNodes; i++) {
			nodeAr[i] = scan.nextInt();
		}
		Color[] colorAr = new Color[numberNodes];
		for (int i = 0; i < numberNodes; i++) {
			colorAr[i] = scan.nextInt() == 0 ? Color.RED : Color.GREEN;
		}
		Map<Integer, Set<Integer>> mapEdges = new HashMap<>();
		for (int i = 0; i < numberNodes - 1; i++) {
			Integer node1 = scan.nextInt() - 1; // Le resto 1 para empezar en la pos 0
			Integer node2 = scan.nextInt() - 1; // Le resto 1 para empezar en la pos 0
			Set<Integer> sunNode1 = new HashSet<Integer>();
			if (mapEdges.containsKey(node1)) {
				sunNode1 = mapEdges.get(node1);
			} else {
				mapEdges.put(node1, sunNode1);
			}
			// List<Integer> sunNode1 = mapEdges.computeIfAbsent(node1, l -> new
			// ArrayList<Integer>());
			sunNode1.add(node2);
			Set<Integer> sunNode2 = new HashSet<Integer>();
			if (mapEdges.containsKey(node2)) {
				sunNode2 = mapEdges.get(node2);
			} else {
				mapEdges.put(node2, sunNode2);
			}
			// List<Integer> sunNode2 = mapEdges.computeIfAbsent(node2, l -> new
			// ArrayList<Integer>());
			sunNode2.add(node1);
		}
		scan.close();
		// Guarda el orden en que vamos a recorrer los nodos.
		// Los vamos a recorrer por altura
		int currentNode = 0;
		int depth = 0;
		Tree tree = fillTree(numberNodes, nodeAr, colorAr, mapEdges, currentNode, depth);
		return tree;
	}

	private static Tree fillTree(int numberNodes, int[] nodeAr, Color[] colorAr, Map<Integer, Set<Integer>> mapEdges,
			int currentNode, int depth) {
		Tree tree = null;
		Set<Integer> sunNodes = mapEdges.containsKey(currentNode) ? mapEdges.get(currentNode) : new HashSet<Integer>();
		if (sunNodes.isEmpty()) {
			// tree = new TreeLeaf(nodeAr[currentNode], colorAr[currentNode], depth);
			tree = new TreeLeaf(nodeAr[currentNode], colorAr[currentNode], depth, currentNode);
		} else {
			// tree = new TreeNode(nodeAr[currentNode], colorAr[currentNode], depth);
			tree = new TreeNode(nodeAr[currentNode], colorAr[currentNode], depth, currentNode);
			// Iterator<Integer> it = sunNodes.iterator();
			// while (it.hasNext()) {
			// Integer sunNode = it.next();
			for (Integer sunNode : sunNodes) {
				mapEdges.get(sunNode).remove(currentNode);
				Tree sunTree = fillTree(numberNodes, nodeAr, colorAr, mapEdges, sunNode, depth + 1);
				((TreeNode) tree).addChild(sunTree);
			}
		}
		return tree;
	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();
		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);
		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}
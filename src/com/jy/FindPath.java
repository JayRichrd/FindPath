package com.jy;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

	public static void main(String[] args) {
		// 构建树
		TreeNode treeANode1 = new TreeNode(4, null, null);
		TreeNode treeANode2 = new TreeNode(7, null, null);
		TreeNode treeANode3 = new TreeNode(5, treeANode1, treeANode2);
		TreeNode treeANode4 = new TreeNode(12, null, null);
		TreeNode root = new TreeNode(10, treeANode3, treeANode4);

		System.out.println("===================寻找路径===================");
		findPath(root, 22);
	}

	/**
	 * 寻找路径，路径上的节点值总和为一个给定的值
	 * 
	 * @param root
	 *            树的根节点
	 * @param expectedSum
	 *            路径上节点值总和的期望值
	 */
	public static void findPath(TreeNode root, int expectedSum) {
		if (root == null)
			return;
		// 路径
		List<Integer> path = new ArrayList<Integer>();
		// 当前路径上节点值的和
		int currentSum = 0;
		// 调用重载的函数
		findPath(root, expectedSum, path, currentSum);

	}

	/**
	 * 寻找路径，路径上的节点值总和为一个给定的值
	 * 
	 * @param root
	 *            树的根节点
	 * @param expectedSum
	 *            路径上节点值总和的期望值
	 * @param path
	 *            路径
	 * @param currentSum
	 *            当前路径上节点值的总和
	 */
	public static void findPath(TreeNode root, int expectedSum, List<Integer> path, int currentSum) {
		currentSum += root.mValue;
		path.add(root.mValue);
		// 是否为叶节点
		boolean isLeaf = root.mLeft == null && root.mRight == null;
		if (currentSum == expectedSum && isLeaf) // 找到了一条合适的路径，并打印出来
			System.out.println("找到一条路径，其中各个节点值的总和为" + expectedSum + ":" + path.toString());
		// 用当前节点的左、右节点继续递归
		if (root.mLeft != null)
			findPath(root.mLeft, expectedSum, path, currentSum);
		if (root.mRight != null)
			findPath(root.mRight, expectedSum, path, currentSum);
		// 返回一个节点后，需要将当前节点从路径中删除
		path.remove(path.size() - 1);
	}

}

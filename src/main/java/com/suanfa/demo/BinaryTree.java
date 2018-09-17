package com.suanfa.demo;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree {

    /**
     * 二叉树前序递归调用
     * 中序,后续递归就是顺序不一样
     */
    public static  void recursionPreorderTraversal(TreeNode node) {
        if (null != node) {
            System.out.print(node.getRoot());
            recursionPreorderTraversal(node.getLeft());
            recursionPreorderTraversal(node.getRight());
        }
    }

    /**
     * 非递归调用
     * 深度优先遍历:前序,中序,后序,用栈结构实现
     * 广度优先遍历:层次遍历,用队列结构实现
     * 非递归调用
     */
    public static void preorderTraversal(TreeNode node) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode root = node;
        while (!treeNodes.empty() || root != null) {
            while (root!= null) {
                System.out.print(root.getRoot());
                treeNodes.push(root);
                root =root.getLeft();
            }
            if (!treeNodes.empty()) {
                root = treeNodes.pop();
                root = root.getRight();
            }
        }

    }

    /**
     * 中序遍历
     */
    public static void inorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodes.empty()) {
            while (node != null) {
                treeNodes.push(node);
                node = node.getLeft();
            }
            if (!treeNodes.empty()) {
                node = treeNodes.pop();
                System.out.print(node.getRoot());
                node = node.getRight();
            }
        }
    }

    /**
     * 后续遍历
     */

    public static void postTraversal(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = null;
        while (null != node || !treeNodes.empty()) {
            while (null != node) {
                treeNodes.push(node);
                node = node.getLeft();
            }
            if (!treeNodes.empty()) {
                node = treeNodes.peek();
                TreeNode rightNode = node.getRight();
                if (rightNode == null || rightNode == lastVisit) {
                    node = treeNodes.pop();
                    lastVisit = node;
                    System.out.print(node.getRoot());
                    node = null;
                } else {
                    node = rightNode;
                }
            }
        }
    }

    /**
     * 层次遍历
     */
    public static void hierTraversal(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.removeFirst();
            System.out.print(node.getRoot());
            if (node.getLeft() != null) {
                treeNodes.add(node.getLeft());
            }
            if (node.getRight() != null) {
                treeNodes.add(node.getRight());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        TreeNode node6 = new TreeNode();
        TreeNode node7 = new TreeNode();
        TreeNode node8 = new TreeNode();
        TreeNode node9 = new TreeNode();
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node5.setLeft(node8);
        node8.setRight(node9);
        node1.setRoot(1);
        node2.setRoot(2);
        node3.setRoot(3);
        node4.setRoot(4);
        node5.setRoot(5);
        node6.setRoot(6);
        node7.setRoot(7);
        node8.setRoot(8);
        node9.setRoot(9);
        //recursionPreorderTraversal(node1);
        // preorderTraversal(node1);
        //inorderTraversal(node1);
        //postTraversal(node1);
        hierTraversal(node1);
    }

}

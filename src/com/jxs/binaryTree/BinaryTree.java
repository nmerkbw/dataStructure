package com.jxs.binaryTree;

import com.jxs.stackAndQueue.LinkListStack;

public class BinaryTree {

    // 创建二叉树的结点
    private class TreeNode<T> {

        private T data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode() {}

        public TreeNode(T data) {

            this.data = data;
        }

        public TreeNode(T data, TreeNode leftChild, TreeNode rightChild) {

            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public T getData() {

            return data;
        }

        public void setData(T data) {

            this.data = data;
        }

        public TreeNode getLeftChild() {

            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {

            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {

            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {

            this.rightChild = rightChild;
        }
    }

    /**
     * 创建一棵二叉树
     *          A
     *      B      C
     *   D    E  F    G
     */
    public TreeNode createBinaryTree() {

        TreeNode rootLeftLeft = new TreeNode("D", null, null);
        TreeNode rootLeftRight = new TreeNode("E", null, null);
        TreeNode rootRightLeft = new TreeNode("F", null, null);
        TreeNode rootRightRight = new TreeNode("G", null, null);
        TreeNode rootLeft = new TreeNode("B", rootLeftLeft, rootLeftRight);
        TreeNode rootRight = new TreeNode("C", rootRightLeft, rootRightRight);
        TreeNode root = new TreeNode("A", rootLeft, rootRight);
        return root;
    }

    /**
     * 前序遍历
     * 递归版本
     */
    public void recursePreOderTraverse(TreeNode root) {

        // 若根节点为空则直接结束
        if (root == null) {
            return;
        }
        System.out.println("当前结点数据：" + root.getData());
        recursePreOderTraverse(root.leftChild);
        recursePreOderTraverse(root.rightChild);
    }

    /**
     * 前序遍历
     * 非递归版
     */
    public void preOrderTraverse(TreeNode root) {

        // 若根节点为空则直接结束
        if (root == null) {
            return;
        }
        // 初始化用于存放结点顺序的栈结构
        LinkListStack<TreeNode> stack = new LinkListStack<>();
        // 首先将根节点放入栈中
        stack.push(root);
        while (!stack.isEmpty()) {
            // 取出栈顶结点，并将其暂时存入temp
            TreeNode temp = stack.pop();
            System.out.println("当前数据为：" + temp.getData());
            // 栈是后进先出结构，故先存入右子结点，再存入左子结点
            if (temp.rightChild != null) {
                stack.push(temp.getRightChild());
            }
            if (temp.leftChild != null) {
                stack.push(temp.getLeftChild());
            }
        }
    }

    /**
     * 中序遍历
     * 递归版
     */
    public void recurseInOrderTraverse(TreeNode root) {

        if (root == null) {
            return;
        }
        recurseInOrderTraverse(root.getLeftChild());
        System.out.println("当前结点数据："+root.getData());
        recurseInOrderTraverse(root.getRightChild());
    }

    /**
     * 中序遍历
     * 非递归版本
     */
    public void inOrderTraverse(TreeNode root) {

        if (root == null) {
            return;
        }
        LinkListStack<TreeNode> stack = new LinkListStack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                // 如果根节点存在就将根节点压入栈
                stack.push(root);
                // 更新根节点
                root = root.getLeftChild();
            } else {

                // 如果根结点不存在就弹出栈
                TreeNode temp = stack.pop();
                // 打印弹栈元素
                System.out.println("当前结点数据为：" + temp.getData());
                // 更新根节点
                root = temp.rightChild;
            }
        }
    }

    /**
     * 后序遍历
     * 递归版
     */
    public void recursePostOrderTraverse(TreeNode root) {

        if (root == null) {
            return;
        }
        recursePostOrderTraverse(root.getLeftChild());
        recursePostOrderTraverse(root.getRightChild());
        System.out.println("当前结点数据为："+root.getData());
    }

    /**
     * 后序遍历
     * 非递归版本
     */
    public void postOrderTraverse(TreeNode root) {

        if (root == null) {
            return;
        }
        LinkListStack<TreeNode> stack = new LinkListStack<>();
        stack.push(root);
        // 初始化打印过的结点
        TreeNode printedNode = null;
        while (!stack.isEmpty()) {
            root = stack.peek();
            // 如果一个结点的左子结点存在，且该结点的左右子结点均未被打印，
            // 则说明该结点为新节点，将其压入栈中
            if (root.leftChild != null && printedNode != root.getLeftChild()
                    && printedNode != root.getRightChild()) {
                stack.push(root.getLeftChild());
            } else if (root.rightChild != null && printedNode != root.getRightChild()) {
                stack.push(root.getRightChild());
            } else {
                System.out.println("当前结点数据为：" + stack.pop().getData());
                printedNode = root;
            }
        }
    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        BinaryTree.TreeNode root = bt.createBinaryTree();
        System.out.println("------前序遍历：------");
        System.out.println("递归：");
        bt.recursePreOderTraverse(root);
        System.out.println();
        System.out.println("非递归：");
        bt.preOrderTraverse(root);

        System.out.println("------中序遍历：------");
        System.out.println("递归：");
        bt.recurseInOrderTraverse(root);
        System.out.println();
        System.out.println("非递归：");
        bt.inOrderTraverse(root);

        System.out.println("------后序遍历：------");
        System.out.println("递归：");
        bt.recursePostOrderTraverse(root);
        System.out.println();
        System.out.println("非递归：");
        bt.postOrderTraverse(root);
    }
}

package day06_BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//泛型必须可比较
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

//    //向二分搜索树中添加新的元素e
//    public void add(E e) {
//        //根节点为空的情况下
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            //对用户屏蔽细节，调用真正的add函数
//            add(root, e);
//        }
//    }
//    //向以node为根的二分搜索树中插入元素E，使用递归算法
//    private void add(Node node, E e) {
//        //第一部分：递归终止的条件
//        //检查要插入的e是否等于元素的e
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            //插入左子树
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//        //第二部分 递归调用
//        if (e.compareTo(node.e) < 0)
//            add(node.left, e);
//            //等于的情况在上面已经被排除
//        else
//            add(node.right, e);
//    }

    /*
    * 上面添加操作存在冗余：
    * 用户调用的时候根节点为空插入新元素
    * 而真实的添加操作同样使用了插入操作
    *
    * 进行两轮比较
    * 不仅判断node的大小 同时比较其左右节点是否为空
    *
    * 条件臃肿
    *
    * 空——本身也为一棵二叉树
    * 插入到空 本身也为一个位置节点
    */

    //向二分搜索树中添加新的元素e
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的二分搜索树中插入元素E，使用递归算法
    //返回插入新节点后二叉搜索树的根root
    private Node add(Node node, E e) {
        //第一部分：递归终止的条件
        //检查要插入的e是否等于元素的e
        if (node == null) {
            size++;
            return new Node(e);
        }
        //第二部分 递归调用
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        //不处理相等的逻辑
        //node还是原来的node
        return node;
    }

    //查询是否包含元素
    public boolean contains(E e) {
        return contains(root, e);
    }

    //查询以node 为根的树中是否包含元素e 使用递归算法
    private boolean contains(Node node, E e) {
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else
            return contains(node.right, e);
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //以node为根的前序遍历
    private void preOrder(Node node) {
//        if(node==null){
//            return;
//        }
//        System.out.println(node.e);
//        preOrder(node.left);
//        preOrder(node.right);

        if (node != null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //preOrderNR no recursion非递归写法 前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }


    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    //以node为根的中序遍历
    private void inOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            System.out.println(node.e);
            preOrder(node.right);
        }
    }


    //后序遍历
    public void afterOrder() {
        afterOrder(root);
    }

    //以node为根的后序遍历
    private void afterOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.e);
        }
    }


    //层序遍历（广度优先遍历）
    public void levelOrder() {
        //内置的queue是一个接口，这里选择使用链表来实现
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    //寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("bst is empty!");
        }
        return minimum(root).e;

    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }


    //寻找二分搜索树的最大元素
    public E maxmum() {
        if (size == 0) {
            throw new IllegalArgumentException("bst is empty!");
        }
        return maxmum(root).e;

    }

    private Node maxmum(Node node) {
        if (node.right == null)
            return node;
        return maxmum(node.right);
    }


    //删除最小值所在节点，返回最小值
    public E removeMin() {
        E ret = minimum();
        //根节点更新
        root = removeMin(root);
        return ret;
    }

    //删除以node为根的二分搜索树中的最小节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            //删除原来的最小值，现在接上来的是右子树作为新的根节点
            return rightNode;
        }
        node.left = removeMin(node.left);

        //返回当前的node
        return node;
    }


    //删除最大值所在节点，返回最大值
    public E removeMax() {
        E ret = maxmum();
        //根节点更新
        root = removeMax(root);
        return ret;
    }

    //删除以node为根的二分搜索树中的最大节点
    //返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            //删除原来的最大值，现在接上来的是左子树作为新的根节点
            return leftNode;
        }
        node.right = removeMax(node.right);

        //返回当前的node
        return node;
    }

    //从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        remove(root, e);
    }

    //删除以node为根的二分搜索树中值为e的节点，使用递归
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        //递归到底的情况
        //也就是没找到要删除的元素
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {//e==node.e
            //左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //左右子树都不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
//            size++;
            //拼装后继节点，即删除最小节点
            successor.right = removeMin(node.right);
            successor.left = node.left;

            //回收
            node.left = node.right = null;
//            size--;
            return successor;

            //陷阱：要不要维护size,size--?
            //removeMin中的元素并没有被删除，但是内部size--;
            //同时多了successor,size++
            //同时最后删除了目标节点，因此size--;
            //size++ size-- 互相抵消
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        /*
        * 第一个参数为节点
        * 第二个参数为树的深度也就是层数，第一层为0，第二层为1，以此类推
        * 第三个参数为传入的字符串拼接对象*/
        generateBSTString(root, 0, res);
        return res.toString();
    }

    //生成描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


}

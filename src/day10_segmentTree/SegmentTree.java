package day10_segmentTree;

import java.util.Arrays;

//用数组实现的线段树
public class SegmentTree<E> {
    //用户需要获取数据
    private E[] data;
    //组织成树的形式 因为树的节点更多
    private E[] tree;
    //融合器
    private Merger<E> merger;

    public SegmentTree(E[] arr,Merger<E> merger) {
        this.merger=merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[arr.length * 4];
        buildSegmentTree(0, 0, data.length - 1);
    }

    //在treeIndex的位置创建表示区间【l..r】的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {
        //先考虑递归到底的情况
        if (l == r) {
            tree[treeIndex]=data[l];
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        //(l+r)/2 ==>左边界加上 左右边界的距离/2
        int mid = l+(r-l)/2;
        //现在分成两个区间 （l,mid）(mid+1,r)
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is illeagal.");
        }
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

//    @Override
//    public String toString() {
//        StringBuilder res = new StringBuilder();
//
//    }
}

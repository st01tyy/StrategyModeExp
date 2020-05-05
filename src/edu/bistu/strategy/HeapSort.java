package edu.bistu.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort
{
    /**
     * 堆排序步骤：
     * 1.构建最小堆
     * 2.移除根节点
     * 3.恢复最小堆
     * 4.重复2,3直至没有剩余节点
     */

    public static Comparable[] sort(Comparable[] src)
    {
        Comparable[] arr = Arrays.copyOf(src, src.length);
        List<Comparable> minHeap = createMinHeap(arr);
        List<Comparable> res = new ArrayList<>();
        while(minHeap.size() > 0)
        {
            res.add(removeRootNode(minHeap));
            restoreMinHeap(minHeap);
        }
        return res.toArray(new Comparable[1]);
    }

    private static List<Comparable> createMinHeap(Comparable[] arr)
    {
        List<Comparable> minHeap = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
            insertNodeToMinHeap(minHeap, arr[i]);
        return minHeap;
    }

    private static Comparable removeRootNode(List<Comparable> minHeap)
    {
        Comparable res = minHeap.get(0);
        minHeap.set(0, minHeap.get(minHeap.size() - 1));
        minHeap.remove(minHeap.size() - 1);
        return res;
    }

    private static void restoreMinHeap(List<Comparable> minHeap)
    {
        int i = 0;
        while(i < minHeap.size())
        {
            int leftChildIndex = i * 2 + 1;
            int rightChildIndex = (i + 1) * 2;
            Comparable parent = minHeap.get(i);
            Comparable leftChild = null;
            if(leftChildIndex < minHeap.size())
                leftChild = minHeap.get(leftChildIndex);
            Comparable rightChild = null;
            if(rightChildIndex < minHeap.size())
                rightChild = minHeap.get(rightChildIndex);
            int smallerChildIndex;
            Comparable smallerChild;
            if(leftChild != null && rightChild != null)
            {
                if(leftChild.compareTo(rightChild) < 0)
                {
                    smallerChild = leftChild;
                    smallerChildIndex = i * 2 + 1;
                }
                else
                {
                    smallerChild = rightChild;
                    smallerChildIndex = (i + 1) * 2;
                }
                if(parent.compareTo(smallerChild) > 0)
                {
                    switchValue(minHeap, i, smallerChildIndex);
                    i = smallerChildIndex;
                }
                else
                    break;
            }
            else if(leftChild == null && rightChild == null)
                break;
            else if(leftChild != null)
            {
                if(parent.compareTo(leftChild) > 0)
                {
                    switchValue(minHeap, i, leftChildIndex);
                    i = leftChildIndex;
                }
                else
                    break;
            }
            else
            {
                if(parent.compareTo(rightChild) > 0)
                {
                    switchValue(minHeap, i, rightChildIndex);
                    i = rightChildIndex;
                }
                else
                    break;
            }
        }
    }

    private static void insertNodeToMinHeap(List<Comparable> minHeap, Comparable node)
    {
        minHeap.add(node);
        int i = minHeap.size() - 1;
        while(i > 0)
        {
            int parentIndex = getParentIndex(i);
            Comparable child = minHeap.get(i);
            Comparable parent = minHeap.get(parentIndex);
            //System.out.println("child: " + child + " parent: " + parent);
            if(child.compareTo(parent) < 0)
            {
                switchValue(minHeap, i, parentIndex);
                i = parentIndex;
            }
            else
                break;
        }
    }

    private static int getParentIndex(int i)
    {
        if(i % 2 != 0)
            return i / 2;
        else
            return i / 2 - 1;
    }

    private static void switchValue(List<Comparable> minHeap, int i, int j)
    {
        Comparable t = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, t);
    }
}

package edu.bistu.strategy;

import java.util.Arrays;

public class QuickSort
{
    public static Comparable[] sort(Comparable[] src)
    {
        Comparable[] arr = Arrays.copyOf(src, src.length);
        arrange(arr, 0, arr.length - 1);
        return arr;
    }

    private static void arrange(Comparable[] arr, int left, int right)
    {
        int res = function(arr, left, right);

        if(res - left > 1)
            arrange(arr, left, res - 1);
        if(right - res > 1)
            arrange(arr, res + 1, right);
    }


    private static int function(Comparable[] arr, int left, int right)
    {
        Comparable target = arr[left];
        int i = left + 1;
        int j = right;
        Comparable t;
        while(i < j)
        {
            while(j > i && arr[j].compareTo(target) >= 0)
                j--;
            if(i < j)
            {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            while(i < j && arr[i].compareTo(target) < 0)
                i++;
            if(i < j)
            {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int res;
        if(arr[i].compareTo(target) < 0)
        {
            t = arr[i];
            arr[i] = arr[left];
            arr[left] = t;
            res = i;
        }
        else
        {
            if(i - 1 > left)
            {
                t = arr[i - 1];
                arr[i - 1] = arr[left];
                arr[left] = t;
                res = i - 1;
            }
            else
                res = left;
        }
        return res;
    }
}

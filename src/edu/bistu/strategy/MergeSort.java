package edu.bistu.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort
{
    public static Comparable[] sort(Comparable[] src)
    {
        Comparable[] arr = Arrays.copyOf(src, src.length);
        function(arr, 0, arr.length - 1);
        return arr;
    }

    private static void function(Comparable[] arr, int left, int right)
    {
        int middle = (left + right) / 2;
        if(middle != left && middle != right)
        {
            function(arr, left, middle);
            function(arr, middle + 1, right);
            int i = left;
            int j = middle + 1;
            List<Comparable> list = new ArrayList<>();
            while(i <= middle && j <= right)
            {
                if(arr[i].compareTo(arr[j]) <= 0)
                {
                    list.add(arr[i]);
                    i++;
                }
                else
                {
                    list.add(arr[j]);
                    j++;
                }
            }
            while(i <= middle)
            {
                list.add(arr[i]);
                i++;
            }
            while(j <= right)
            {
                list.add(arr[j]);
                j++;
            }
            i = left;
            j = 0;
            while(i <= right)
            {
                arr[i] = list.get(j);
                i++;
                j++;
            }
        }
        else
        {
            if(left == right)
                return;
            if(arr[right].compareTo(arr[left]) < 0)
            {
                Comparable t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
            }
        }
    }
}

package edu.bistu.strategy;

import java.util.Arrays;

public class BubbleSort
{
    public static Comparable[] sort(Comparable[] src)
    {
        Comparable[] arr = Arrays.copyOf(src, src.length);
        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = 0; j < arr.length -1 - i; j++)
            {
                if(arr[j].compareTo(arr[j + 1]) > 0)
                {
                    Comparable t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }
}

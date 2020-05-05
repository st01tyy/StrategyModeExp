package edu.bistu.strategy;

public class HeapSortStrategy implements SortStrategy
{
    private static HeapSortStrategy strategy;

    private HeapSortStrategy(){}

    @Override
    public Comparable[] sort(Comparable[] src)
    {
        return HeapSort.sort(src);
    }

    public static HeapSortStrategy getInstance()
    {
        if(strategy == null)
            strategy = new HeapSortStrategy();
        return strategy;
    }
}

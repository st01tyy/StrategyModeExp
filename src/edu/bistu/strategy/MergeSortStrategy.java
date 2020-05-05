package edu.bistu.strategy;

public class MergeSortStrategy implements SortStrategy
{
    private static MergeSortStrategy strategy;

    private MergeSortStrategy(){}

    @Override
    public Comparable[] sort(Comparable[] src)
    {
        return MergeSort.sort(src);
    }

    public static MergeSortStrategy getInstance()
    {
        if(strategy == null)
            strategy = new MergeSortStrategy();
        return strategy;
    }
}

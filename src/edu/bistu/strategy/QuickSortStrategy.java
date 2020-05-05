package edu.bistu.strategy;

public class QuickSortStrategy implements SortStrategy
{
    private static QuickSortStrategy strategy;

    private QuickSortStrategy(){}

    @Override
    public Comparable[] sort(Comparable[] src)
    {
        return QuickSort.sort(src);
    }

    public static QuickSortStrategy getInstance()
    {
        if(strategy == null)
            strategy = new QuickSortStrategy();
        return strategy;
    }

}

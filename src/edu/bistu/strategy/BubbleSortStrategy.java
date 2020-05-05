package edu.bistu.strategy;

public class BubbleSortStrategy implements SortStrategy
{
    private static BubbleSortStrategy strategy;

    private BubbleSortStrategy(){}

    @Override
    public Comparable[] sort(Comparable[] src)
    {
        return BubbleSort.sort(src);
    }

    public static BubbleSortStrategy getInstance()
    {
        if(strategy == null)
            strategy = new BubbleSortStrategy();
        return strategy;
    }
}

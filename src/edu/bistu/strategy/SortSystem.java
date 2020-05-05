package edu.bistu.strategy;

public class SortSystem
{
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy)
    {
        this.strategy = strategy;
    }

    public Comparable[] sort(Comparable[] src)
    {
        return strategy.sort(src);
    }

}

package com.company;

public class RequestDay {
    private int mont;
    private int startDay;
    private int endDay;

    public RequestDay(){}

    public void SetDay(int month, int from, int to)
    {
        mont = month;
        startDay = from;
        endDay = to;
    }
    public String getMonth()
    {return Integer.toString(mont);}
    public String getStartDay()
    {return Integer.toString(startDay);}
    public String getEndDay()
    {return Integer.toString(endDay);}
}

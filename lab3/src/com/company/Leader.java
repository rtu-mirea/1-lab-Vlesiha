package com.company;

public class Leader extends User {

    private RequestCoun coun = new RequestCoun();
    private RequestDay day = new RequestDay();

    public Leader(String Name, String Login, String Password) {
        super(Name, Login, Password);
        option = 1;
    }

    public void addRequestCoun(String country) {
        coun.SetCoun(country);
    }
    public String getRequestCoun()
    {
        return coun.getCountry();
    }
    public void addRequestDay(int month, int from, int to)
    {
        day.SetDay(month, from, to);
    }
    public String getMonth()
    {return day.getMonth();}
    public String getStartDay()
    {return day.getStartDay();}
    public String getEndDay()
    {return day.getEndDay();}

}

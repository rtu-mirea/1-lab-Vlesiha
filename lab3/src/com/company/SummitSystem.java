package com.company;

import java.util.ArrayList;

public class SummitSystem {

public ArrayList<Leader> leaders = new ArrayList<>();
public ArrayList<Leader> leadersDays = new ArrayList<>();
public ArrayList<String> country = new ArrayList<>();
public ArrayList<String> days = new ArrayList<>();
public ArrayList<User> users = new ArrayList<>();

    public void adduser(String Name, String login, String password, String repeation,int type){ //добавление пользователей
        if(password.equals(repeation)) {

            if (type == 1) {
                Leader lead = new Leader(Name, login, password);
                users.add(lead);
                leaders.add(lead);
                leadersDays.add(lead);
            }
            if (type == 2) {
                admin administr = new admin(Name, login, password);
                users.add(administr);
            }
        }

    }

    public void addcountry(String country,String log, String pas)  //добавляем данные о стране в ячейку соответствующего лидера
    {
       for (int i = 0;i< leaders.size();i++)
        if(leaders.get(i).getLogin().equals(log)&&leaders.get(i).getPassword().equals(pas)){
        leaders.get(i).addRequestCoun(country);}
    }

    public void setcountry() { //создаем массив из всех стран введенных лидерами
        for (int i = 0; i < leaders.size(); i++) {
            country.add((leaders.get(i)).getRequestCoun());
            System.out.println(leaders.get(i).getRequestCoun());
        }
    }

    public void addDay(int month, int startDay, int endDay, String log, String pas) //добавляем данные о дне в ячейку соответствующего лидера
    {
        for (int i = 0; i< leadersDays.size(); i++)
        {
            if (leadersDays.get(i).getLogin().equals(log)&&leadersDays.get(i).getPassword().equals(pas)) {
                leadersDays.get(i).addRequestDay(month, startDay, endDay);
            }
        }
    }

    public void setDay() { //создаем массив из всех дней введенных лидерами
        for (int i = 0; i < leadersDays.size(); i++) {
            String da = "";
            da = da.concat(((leadersDays.get(i)).getMonth()).concat(((leadersDays.get(i)).getStartDay())).concat((leadersDays.get(i)).getEndDay()));
            days.add(da.concat(((leadersDays.get(i)).getMonth()).concat(((leadersDays.get(i)).getStartDay())).concat((leadersDays.get(i)).getEndDay())));
        }
    }

    public User finduser(String login, String password){ //функция посика пользователя
        for (int i = 0; i< users.size();i++){
            if (users.get(i).enter(login,password)){
                return users.get(i);
            }
        }
        return null;
    }

    public String processRequestsCoun()
    {
        String maxdata= "";//максимальное повторение страны
        int max = 0;// число максимальных повторений
        int s = 0;

        for (int i = 0; i< country.size(); i++){
            s = 0;
            for (int j = 0; j< country.size(); j++){

                if (country.get(i).equals(country.get(j)))
                {s++;}
            }
            if (max<s)
            {max = s; maxdata = (country.get(i));}
        }
        return maxdata;
    }

    public String processRequestsDay()
    {
        StringBuffer MaxData=new StringBuffer();
        String maxdata= "";//максимальная дата которая повторялась постоянно
        int max = 0;// число максимальных повторений
        int s = 0;

        for (int i = 0; i< days.size(); i++){
            s = 0;
            for (int j = 0; j< days.size(); j++){

                if (days.get(i).equals(days.get(j)))
                {s++;}
            }
            if (max<s)
            {max = s; maxdata = (days.get(i));}
        }
        MaxData = MaxData.append(maxdata); //форматируем вывод даты
        MaxData.insert(2, ".");
        MaxData.insert(5, ".");
        maxdata = MaxData.substring(0,8);
        return maxdata;
    }


}

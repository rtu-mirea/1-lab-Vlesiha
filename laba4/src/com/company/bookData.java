package com.company;

import java.util.Date;

public class bookData {//Класс игрушек для №2
    int number;
    String author;
    String name;
    String dateOfGiving;
    String dateOfTaking;

    public bookData(int number, String author, String name, String dateOfGiving, String dateOfTaking){

        this.number = number;
        this.author = author;
        this.name = name;
        this.dateOfGiving = dateOfGiving;
        this.dateOfTaking = dateOfTaking;
    }

    public int comparing(bookData subb) //Определить, один ли автор у двух книг
    {
        if (subb.author == this.author)
        {return 1;}
        return 0;
    }
    public String getDay(int number) //По инвентарному номеру вернуть название и дату возврата книги
    {
        if (this.number == number)
            return this.name + " " + this.dateOfTaking;
        return "Error";
    }

}

package com.company;
import java.util.ArrayList;
import java.io.*;



public class task4 {
    String path;
    ArrayList<Person> people = new ArrayList<Person>();

    public task4(String path){

        this.path = path;
    }

    public  void add(Person person){
        people.add(person);
    }// добавить в список
    public  void addl(ArrayList<Person> people){
        this.people = people;
    }

    public void del(String name){// удалить из списка
        for (int i = 0; i< people.size();i++){
            if (people.get(i).Name ==name)
                people.remove(i);
        }
    }

    public  void put(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))//добавить в файл
        {
            for (int i = 0; i< people.size();i++) {

                oos.writeObject(people.get(i));
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public  void take(){//вывести файл

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            for (int i = 0; i< people.size();i++) {
                Person p=(Person)ois.readObject();
                System.out.printf("Name: %s \t Age: %d \n", p.Name, p.Age);
                
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}


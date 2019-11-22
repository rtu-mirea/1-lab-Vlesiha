package com.company;
import java.io.*;

public class Person implements Serializable {// класс для задания 4

        String  Name;
        int Age;
        int height;
        public Person(String name, int age, int height){
            Name = name;
            Age = age;
            this.height= height;
        }

}

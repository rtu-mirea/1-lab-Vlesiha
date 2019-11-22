package com.company;
import java.util.Scanner;
import java.io.*;
public class Main {


    public static void main(String[] args) throws IOException, Exception, FileNotFoundException{


        try {
            //exer 1
            File F1 = new File("MyFile1.txt");
            F1.createNewFile(); //Создать файл в папке приложения с именем MyFile1.txt.
            File F2 = new File("D://", "MyFile2.txt");
            F2.createNewFile(); //Создать файл с именем MyFile2.txt в корне определенного диска.
            File F3 = new File("D://ооп2 курс", "MyFile3.txt");
            F3.createNewFile(); //Создать файл с именем MyFile3.txt
            File F4 = new File("D://ооп2 курс//laba2//new");
            F4.mkdir();//Создать папку третьего уровня, например, Первая\\Вторая\\Третья

            //exer 2
            if (F2.isFile()){ //	Проверить, что вызывающий объект содержит имя файла, а не папки и отобразить имя файла, вызывающего объекта и его родительскую папку.

                        System.out.println("Имя "+F2.getName() + " Родительская папка " + F2.getParent());
            }
            if (F1.exists()){//Проверить, что в папке приложения существует файл с именем MyFile1.txt.
                System.out.println("file(MyFile1.txt) exists");
            }
            System.out.println("Полный путь к файлу MyFile3.txt: " + F3.getPath());//Отобразить полный путь к файлу или папке объекта.
            System.out.println("Размер файла MyFile3.txt: " + F3.length() + " byte");//Отобразить размер файла

            // 3 exer
            File newfold = new File("D");//1.	Добавить в папку приложения еще одну папку.
            newfold.mkdir();

            File newf = new File("D://ооп2 курс//laba4");//2.	Сформировать массив файлов, находящихся в папке приложения, используя метод list(). Отобразить содержимое массива.
            String[] mass;
            mass = newf.list();
            for (int i  = 0; i<mass.length; i++){
                System.out.println(mass[i]+ ' ');
            }


            File[] mass1;//3.	Сформировать массив файлов, находящихся в папке приложения, используя метод listFiles( ). Отобразить содержимое массива.
            mass1 = newf.listFiles();
            int S = 0;
            for (int i  = 0; i<mass.length; i++){
                System.out.println(mass1[i].toString() + ' ');
                if(mass1[i].isDirectory())//Определить количество папок, содержащихся в файле приложения.
                    S++;
            }
            System.out.println("Кол-во папок: "+ S);

            F1.delete();//4.	Удалить папки и файлы созданные во всех трех упражнениях
            F2.delete();
            F3.delete();
            F4.delete();
            newfold.delete();



         } finally {

            System.out.println("ПРОГРАММА ВЫПОЛНЕНА");

        }



        // упражнение 2
        System.out.print("Введите название файла");
        Scanner in = new Scanner(System.in);
        String name = in.next();

        Filee f = new Filee(name);
        bookData t1 = new bookData(1, "Alan", "World" ,"02/12/2018", "01/01/2019");
        f.add3(t1);
        bookData t2 = new bookData(2, "Pushkin", "Onegin", "03/06/2017", "02/07/2017");
        f.add3(t2);
        System.out.println(f.get1());
// Упражнение 3
        task3 t = new task3();
        File f1 = new File("aa.txt");
        File f2 = new File("b.txt");
        t.ex3(f1);
//Упражнение 4
        textfor4task ex4text = new textfor4task("inf.txt");
        task4 tsk = new task4("per.dat");
        tsk.addl(ex4text.transcript());
        tsk.put();
        tsk.take();


        }

}

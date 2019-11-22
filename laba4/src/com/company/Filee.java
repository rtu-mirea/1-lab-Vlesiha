package com.company;
import java.io.RandomAccessFile;
import java.io.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Filee {
    File  file;
    int size;
    public Filee(String name)throws IOException, Exception, FileNotFoundException{
        file = new File(name);
       try {
           file.createNewFile();
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
    public void add(bookData smth)throws IOException, Exception, FileNotFoundException{//Перезапись
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath(),true)))
        {
            // записываем значения
            dos.writeInt(smth.number);
            dos.writeUTF(smth.author);
            dos.writeUTF(smth.name);
            dos.writeUTF(smth.dateOfGiving);
            dos.writeUTF(smth.dateOfTaking);
            size = 1;
            dos.close();

        }

    }
    public void add2(bookData smth)throws IOException, Exception, FileNotFoundException{//Запись в конец
        try(FileOutputStream dos = new FileOutputStream(file.getPath(),true))
        {
            // записываем значения
            dos.write(smth.name.getBytes());
            dos.write(smth.author.getBytes());
            dos.write(smth.number);
            dos.write(smth.dateOfGiving.getBytes());
            dos.write(smth.dateOfTaking.getBytes());
            size++;
            dos.close();
        }

    }
    public String findbyname()throws IOException, Exception, FileNotFoundException{  //Список книг, не сданных в срок
        try(DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath())))
        {
            byte[] buffer = new byte[dos.available()];
            int i = 0;
            int number = 0;
            String author = "";
            String name = "";
            String dateOfGiving = "";
            String dateOfTaking ="";

            Date today = new Date();


            String S = "";

            while(i<size) {
                number = dos.readInt();
                author = dos.readUTF();
                name = dos.readUTF();
                dateOfGiving = dos.readUTF();
                dateOfTaking = dos.readUTF();
                Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dateOfTaking);

                i++;
                if (date.before(today))
                    S += "Номер "+ number + " Автор " + author + " Название " + name +" Дата выдачи "+ dateOfGiving + " Дата возврата " + dateOfTaking + "\n" ;
            }

            return S;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return null;
    }
    public void newDatas(int perNumber)throws IOException, Exception, FileNotFoundException{   // записать в поле Дата возврата текущую дату у книг, номера записей которых указал пользователь
        bookData[] mass = new bookData[size];
        try(DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath())))
        {
            int i = 0;
            int number = 0;
            String author = "";
            String name = "";
            String dateOfGiving = "";
            String dateOfTaking ="";

            Date today = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd/MM/yyyy");

            String S = "";

            while(i<size) {
                number = dos.readInt();
                author = dos.readUTF();
                name = dos.readUTF();
                dateOfGiving = dos.readUTF();
                dateOfTaking = dos.readUTF();

                if (number == perNumber)
                {
                    String newDateOfTaking = formatForDateNow.format(today);
                    mass[i] = new bookData(number, author, name, dateOfGiving, newDateOfTaking);
                }
                else
                    mass[i] = new bookData(number, author, name, dateOfGiving, dateOfTaking);

            }


        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath(),true)))
        {
            size =0;
            // записываем значения
            dos.writeInt(mass[0].number);
            dos.writeUTF(mass[0].author);
            dos.writeUTF(mass[0].name);
            dos.writeUTF(mass[0].dateOfGiving);
            dos.writeUTF(mass[0].dateOfTaking);
            size = 1;
            dos.close();

        }
        for (int i = 1; i<mass.length;i++){
        try(FileOutputStream dos = new FileOutputStream(file.getPath(),true))
        {
            // записываем значения
            dos.write(mass[i].number);
            dos.write(mass[i].author.getBytes());
            dos.write(mass[i].name.getBytes());
            dos.write(mass[i].dateOfGiving.getBytes());
            dos.write(mass[i].dateOfTaking.getBytes());
            size++;
            dos.close();
        }
        }

    }


    public String get()throws IOException, Exception, FileNotFoundException{ //распечатать файл
         try(DataInputStream dos = new DataInputStream(new FileInputStream(file.getPath())))
        {
            byte[] buffer = new byte[dos.available()];
            int i = 0;
            int number = 0;
            String author = "";
            String name = "";
            String dateOfGiving = "";
            String dateOfTaking ="";

            String S = "";

            while(i<size) {
                number = dos.readInt();
                author = dos.readUTF();
                name = dos.readUTF();
                dateOfGiving = dos.readUTF();
                dateOfTaking = dos.readUTF();

                i++;
                S += "Номер "+ number + " Автор " + author + " Название " + name +" Дата выдачи "+ dateOfGiving + " Дата возврата " + dateOfTaking + "\n" ;
            }

            return S;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return null;
    }




    public String get1() throws IOException {//вывести файл RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "r");

        raf.seek(0);
        String text1 = raf.readLine();
        raf.close();
        return text1;
    }

    public void add(int i,bookData smth) throws IOException {//вставить в определенное место файла RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "r");

        raf.seek(i*42);
        String text1 = raf.readLine();
        raf.close();
        RandomAccessFile raf1 = new RandomAccessFile("file.txt", "rw");
        raf1.seek(i*42);
        raf.writeBytes(" Number:  " );
        raf.writeBytes(String.valueOf(smth.number));
        raf.writeBytes((" Author: "+ smth.author));
        raf.writeBytes((" Name: "+ smth.name));
        raf.writeBytes((" Date of giving book: "+ smth.dateOfGiving));
        raf.writeBytes((" Date of taking book: "+ smth.dateOfTaking));

        raf.writeBytes(text1);


    }

    public void add3(bookData smth) throws IOException{//добавить в конец RandomAccessFile
        RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
        raf.seek(raf.length());
        raf.writeBytes(" Number:  " );
        raf.writeBytes(String.valueOf(smth.number));
        raf.writeBytes((" Author: "+ smth.author));
        raf.writeBytes((" Name: "+ smth.name));
        raf.writeBytes((" Date of giving book: "+ smth.dateOfGiving));
        raf.writeBytes((" Date of taking book: "+ smth.dateOfTaking));
        raf.close();

    }

}

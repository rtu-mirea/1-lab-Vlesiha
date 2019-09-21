package com.company;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class Array1 {
    private int n;
    private long mass1[];

    public Array1() {
        mass1 = null;
        n = 0;
    }

    public Array1(int n){
        this.n = n;
        mass1 = new long[n];
    }
    public void swap(int i,int x){
        long temp = mass1[x];
        mass1[x] = mass1[i];
        mass1[i] = temp;
    }
    void hand_mass(Scanner in) //ввод вручную
    {
        //try {
            for (int i = 0; i < n; i++) {
                System.out.println("Введите " + (i + 1) + " элемент массива: ");
                mass1[i] = in.nextLong();

            }
        //}
//        catch (IOException e)
//        {
//            System.out.println("");
//        }
        System.out.println("Массив введен: ");
    }
    void random_mass() //ввод рандомно
    {
        for (int i = 0; i<n;i++) {
            mass1[i] = (long)(Math.random()*1000000000);
        }
        System.out.println("Массив введен: ");
    }
    void cifri(int nu){
        int sum = 0;
        int prom;
        String cha2;
        for (int i = 0; i<this.n;i++)
        {
            cha2 = Long.toString(this.mass1[i]).substring(0,1); //переводим элемент массива в строку и выделяем первый символ
            prom = Integer.parseInt(cha2); //переводим его в число
            if(prom == nu)
            {
                sum++;
            }
        }
        System.out.println("Ответ: "+ sum);
    }
    static long[] addElement(long[] a, int e,int n) //создаем новый массив
    {
        if(a.length < n) {
            a  = Arrays.copyOf(a, n);
        }
        else a  = Arrays.copyOf(a, a.length);
        a[n-1] = e;
        return a;
    }
    void addition (int place, int num) //добавление элемента в массив
    {
        mass1 = addElement(mass1, num,place);
        for (long i:mass1){
            System.out.print(i + " ");
        }
    }

    void output_left(){
        for (long i:mass1){
            System.out.print(i + " ");
        }
    }
    void output_right(){
        for (int i = n-1; i>=0;i--){
            System.out.print(mass1[i]+ " ");
        }
    }
    void sort_new () {
        Arrays.sort(mass1);
        System.out.println(Arrays.toString(mass1));
    }
}



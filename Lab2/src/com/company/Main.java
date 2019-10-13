package com.company;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        boolean OK = true;
        while(true) {
            while(OK) {
                System.out.println("Введите номер задания:\n1. String\n2. StringBuilder\n3. Регулярные выражения (Разбить числа строки по разрядам)");
                Scanner in = new Scanner(System.in);
                int num = in.nextInt();
                switch (num){
                    case 1:
                        System.out.println("Введите номер задания:\n1. Предложение из слов, начинающихся и заканчивающихся с гласных \n2. Кол-во слов по длинне больше вводимого \n3. Все слова с приставками пре и при \n4. Кол-во чисел, принадлежащих диапазону\n ");
                        int numz = in.nextInt();
                        string1 mainStr = new string1();
                        switch (numz){
                            case 1:
                                mainStr.vowel();
                                break;
                            case 2:
                                System.out.println("Введите строку для сравнения: ");
                                String enter = in.next();
                                mainStr.wordlen(enter);
                                break;
                            case 3:
                                mainStr.prefix();
                                break;
                            case 4:
                                System.out.println("Введите перове число интервала: ");
                                int enternum1 = in.nextInt();
                                System.out.println("Введите второе число интервала: ");
                                int enternum2 = in.nextInt();
                                mainStr.numbers(enternum1,enternum2);
                                break;

                        }
                        break;
                    case 2:
                        System.out.println("Введите номер задания:\n1. Удалить из строки все слова на пре и при \n2. Заменить числа некратные 7 на результат этого деления \n3. Добавить перед каждым словом семь нолей\n");
                        int numza = in.nextInt();
                        string2 mainStr2 = new string2();
                        switch (numza){
                            case 1:
                                mainStr2.deleting();
                                break;
                            case 2:
                                mainStr2.nums7();
                                break;
                            case 3:
                                mainStr2.zero7();
                                break;
                        }
                        break;
                    case 3:
                        string3 mainStr3 = new string3();
                        mainStr3.strangeNumeric();
                        break;
                }
                System.out.println("Если хотите запустить программу заново нажмите 1, иначе нажмите 0: ");
                int check = in.nextInt();
                while(check != 0 || check != 1) {
                    if (check == 0) {
                        OK = false;
                        break;
                    }
                }
            }
            return;
        }
    }
}

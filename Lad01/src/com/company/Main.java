package com.company;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        boolean OK = true;

        while(true) {
            while(OK) {
                System.out.println("Введите длинну массива: ");
                Scanner in = new Scanner(System.in);
                int n = in.nextInt();
                Array1 mass1 = new Array1(n);
                System.out.println("Введите 1 если хотите вручную ввести массив,иначе нажмите 0: ");

                int check;
                while(OK) {
                    check = in.nextInt();
                    if (check == 1) {
                        mass1.hand_mass(in);
                        OK = false;
                    } else if (check == 0) {
                        mass1.random_mass();
                        OK = false;
                    } else {
                        System.out.println("Оно того стоило? \n 1 - ручной ввод, 0 - рандомный ввод: ");
                    }
                }

                OK = true;
                mass1.output_left();
                System.out.println("\nМассив справа налево: ");
                mass1.output_right();
                System.out.println("\nВведите число для проверки: ");
                int numeric = in.nextInt();
                mass1.cifri(numeric);
                System.out.println("Введите номер места нового числа: ");
                int plc = in.nextInt();
                System.out.println("А теперь новое число: ");
                int num = in.nextInt();
                mass1.addition(plc, num);
                System.out.println("\nОбычная сортировка: ");
                mass1.sort_new();
                System.out.println("Если хотите запустить программу заново нажмите 1, иначе нажмите 0: ");
                check = in.nextInt();

                while(check != 0 || check != 1) {
                    if (check == 0) {
                        OK = false;
                        break;
                    }

                    if (check != 0 & check != 1) {
                        System.out.println("ЗАчеем нажимать другие кнопки? 1 - продолжение, 0 - окончание: ");
                        check = in.nextInt();
                    } else if (check == 1) {
                        break;
                    }
                }
            }

            return;
        }
    }
}

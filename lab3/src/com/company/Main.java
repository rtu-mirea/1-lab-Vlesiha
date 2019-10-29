package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User curentuser = new User();
        boolean OK = false;
        SummitSystem summit = new SummitSystem();
        Scanner in = new Scanner(System.in);
        if (!OK){
            System.out.println("Регистрация администратора");
            System.out.println("Введитте имя");
            String name = in.nextLine();
            System.out.println("Введитте login");
            String login = in.nextLine();
            System.out.println("Введитте пароль");
            String password = in.nextLine();
            System.out.println("Повторите пароль");
            String reppass = in.nextLine();

            summit.adduser(name, login, password, reppass, 2 );
            OK = true;
        }

        while(OK) {
            System.out.println("1 - Регистрация\n2 - Вход\n3 - Выход");

            int num = in.nextInt();
            switch (num) {
                case 0:
                {
                    OK = false;
                    break;
                }
                case 1:{
                    System.out.println("Введитте имя");
                    String name = in.next();
                    System.out.println("Введитте login");
                    String login = in.next();
                    System.out.println("Введитте пароль");
                    String password = in.next();
                    System.out.println("Повторите пароль");
                    String reppass = in.next();

                    summit.adduser(name, login, password, reppass, 1 );
                    break;
                }
                case 2: {

                    System.out.println("Введитте login");
                    String login = in.next();
                    System.out.println("Введитте пароль");
                    String password = in.next();

                    curentuser =summit.finduser(login, password);

                    if (curentuser!= null){
                        int resreq = curentuser.getOption();
                        switch(resreq){
                            case 1:{

                                System.out.println("Введите месяц проведения саммита (двумя цифрами): ");
                                int startMonth = in.nextInt();
                                System.out.println("Введите день начала (двумя цифрами): ");
                                int startDay = in.nextInt();
                                System.out.println("Введите день конца (двумя цифрами): ");
                                int endDay = in.nextInt();
                                summit.addDay(startMonth, startDay, endDay, login, password);
                                System.out.println("Введите страну: ");
                                String country = in.next();
                                summit.addcountry(country, login, password);
                                break;
                            }
                            case 2:{
                                int ext = 1;
                                while (ext == 1){                               {

                                    System.out.println("1 - Определение страны \n2 - Определение даты\n0 -  Выход");
                                    int registrselect= in.nextInt();
                                    switch(registrselect) {
                                        case 0: {
                                            ext = 0;
                                            break;
                                        }
                                        case 1: {
                                            summit.setcountry();
                                            System.out.println("Страна проведения саммита: " + summit.processRequestsCoun());
                                            break;
                                        }
                                        case 2: {
                                            summit.setDay();
                                            System.out.println("Дата проведения: " + summit.processRequestsDay());

                                            break;
                                        }
                                    }

                                }
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
}

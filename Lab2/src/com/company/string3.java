package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class string3 {
    private String sentence3;
    private String mainStr3 = new String();

    public string3() {
        sentence3 = "Цифры 11112345678, 1234634, 2524623523542, 3452523";
        mainStr3 = new String(sentence3);
    }
    String strangeNumeric()
    {
        Pattern pattern = Pattern.compile("\\s*\\d*\\s*"); //поиск цифр
        String[] words = mainStr3.split("[,\\s]"); //обрезаем строку
        boolean found;
        String newstr = "";
        for (int i = 0; i<words.length;i++)
        {
            Matcher matcher = pattern.matcher(words[i]);
            found=matcher.matches();
            if (found)
            {
                StringBuilder strBild = new StringBuilder(words[i]);
                for (int j = strBild.length(); j>0;j--)
                {
                    if ((strBild.length()-j)%4==0) // проверяем разряд
                    {
                        strBild.insert(j,".");
                    }
                }
                words[i]=strBild.toString();
            }
            newstr+=words[i]+ " ";
        }
        return newstr;
    }

}

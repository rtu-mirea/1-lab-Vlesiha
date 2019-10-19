package com.company;

import java.util.ArrayList;
import java.util.regex.*;

public class string1 {
    private String sentence;
    private String mainStr = new String();

    public string1() {
        sentence = "Мальчик в своем путешествии сделал большую ошибку. Он доверился незнакомому разбойнику. Разбойник отобрал все его ценности. она никогда не прощает. Цифры для примера 2, 5, 1, 7, 14, 15, 21";
        mainStr = new String(sentence);
    }
    String vowel()
    {
        String[] copystr = mainStr.split(" ");
        String substr = "";
        for(String word : copystr) //проверяем все слова на начло и конец с гласной буквы
        {
            if ((word.startsWith("а") || word.startsWith("о") || word.startsWith("э") || word.startsWith("у") || word.startsWith("я") || word.startsWith("е") || word.startsWith("ю") || word.startsWith("и"))&&((word.endsWith("а") || word.endsWith("о") || word.endsWith("э") || word.endsWith("у") || word.endsWith("я") || word.endsWith("е") || word.endsWith("ю") || word.endsWith("и"))))
            {
                substr = substr + word + " ";
            }
        }
        return substr;
    }
    int wordlen(String in)
    {
        int count= 0;
        String[] copystr = mainStr.split(" ");
        String substr = "";
        for(String word : copystr) //сравниваем длину слова с длинной вводимого слова
        {
            if (word.length() > in.length())
            {
                count++;
            }
        }
        return count;
    }
    String prefix()
    {
        String[] copystr = mainStr.split(" ");
        String substr = "";
        for(String word : copystr) //проверяем текст на слова с пирставками на пре и при
        {
            if (word.startsWith("пре") || word.startsWith("при") || word.startsWith("При")||word.startsWith("Пре"))
            {
                substr = substr + word + " ";
                substr.toLowerCase();
            }
        }
        return  substr;
    }
    int numbers(int num1, int num2)
    {
        int count=0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Pattern pat=Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Matcher matcher=pat.matcher(mainStr); //выделяем из текста все числа
        while (matcher.find())
        {
            arrayList.add(Integer.parseInt(matcher.group())); //и добавляем в массив
        }
        for(int s : arrayList) //проверяем на принадлежность диапазону
        {
            if (s>num1 && s<num2)
            {
                count++;
            }
        }
        return count;
    }
}

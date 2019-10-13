package com.company;

public class string2 {
    private String sentence2;
    private String mainStr2 = new String();

    public string2() {
        sentence2 = "Мальчик в своем путешествии сделал большую ошибку. Он доверился незнакомому разбойнику. Разбойник отобрал все его ценности. Цифры для примера 2, 5, 1, 7, 14, 15, 21";
        mainStr2 = new String(sentence2);
    }
    void deleting()
    {
        String[] copystr = mainStr2.split(" ");
        StringBuilder strBilder = new StringBuilder(mainStr2);
        for(String word : copystr) //проверяем текст на слова с пирставками на пре и при
        {
            if (word.startsWith("пре") || word.startsWith("при") || word.startsWith("При") || word.startsWith("Пре"))
            {
                int start = strBilder.indexOf(word);
                if (start<0) return;
                strBilder.delete(start,start+word.length());
            }
        }
        System.out.println("Строка с удаленными словами на пре и при: \n" + strBilder);
    }
    void nums7()
    {
        StringBuilder strBilder2 = new StringBuilder(mainStr2);
        String numberOnly= mainStr2.replaceAll("[^,0-9]", ""); //оставляем в строке только цифры и запятые
        String[] numberOnlyStr = numberOnly.split(","); //заносим цифры в массив строк

        for (String w : numberOnlyStr) {
            int wr = Integer.parseInt(w);
            int rod = wr % 7;
            if (rod != 0) {
                int resultDivision = wr/7;
                String res = Integer.toString(resultDivision);
                int start = strBilder2.indexOf(w); //индекс первого вхождения числа в строку
                if (start < 0) return;
                strBilder2.replace(start, start + w.length(), res); //заменяем число на результат деления
            }
        }
        System.out.println("Ваш ответ (строка, где цифры не кратные 7 заменены результатом деления на 7):\n"+ strBilder2);
    }
    void zero7()
    {
        StringBuilder strBilder2 = new StringBuilder(mainStr2);
        String charOnly= mainStr2.replaceAll("[^ А-Яа-я]", ""); //оставляем в строке только слова и пробелы
        String[] charOnlyStr = charOnly.split(" "); //заносим слова в массив строк
        for (String word : charOnlyStr)
        {
            int start = strBilder2.indexOf(word);
            if (start<0)return;
            strBilder2.insert(start, "0000000 ");
        }
        System.out.println("Измененная строка:\n" + strBilder2);
    }

}

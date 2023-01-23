// захватываем строку
// проверяем/перебираем символы (2 проверки: праильность ввода, )
// если только латынь - переводим в объукт CalcObjLatin
// если только цыфры - переводим в объект CalcObjArabic
// если смесь или какие-то другие символы возвращаем цикл к вводу
// возвращаем результат


import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        String input;
        Scanner userInput = new Scanner(System.in);
        do{
            System.out.println("Введите выражение для подсчета. Допустимы целые числа от 1 до 10 включительно. Допустим ввод римскими цифрами.");
            System.out.println("Смешивать арабские и латинские цифры нельзя. Допустимы действия +, - , / , *. Нажмите Q для выхода. Ожидаю данные для подсчета...");
            input = userInput.nextLine();// ввод пользователя
            input = input.replaceAll(" ", "");// убираем все пробелы
            System.out.println(calc(input));
        }while (!input.equals("q") & !input.equals("Q"));
        userInput.close();
    }

    public static String calc(String input){
        int calcresult = 0;
        String result = "";
        int calcnum1 = 0;
        int calcnum2 = 0;
        char calcMathAct;
        StringChecker checker = new StringChecker(input);// создаем объект для проверки строки

        if (!input.equals("q") & !input.equals("Q")) {
            if (checker.inputChecker()){  // проверяем, что введены допустимые символы

                if(checker.checkArabRoman()){ // проверяем, что введены только арбские или только римские символы
                    Converter obj = new Converter(input);// создаем объект для конвертирования
                    obj.numDetermine();// конвертируем строку в числа
                    if(obj.checkStringLengh()){
                        calcnum1 = obj.num1;
                        calcnum2 = obj.num2;
                        calcMathAct = obj.mathAct;
                        Calculator obj2 = new Calculator(calcnum1, calcnum2, calcMathAct);
                        calcresult = obj2.getCalc();
                        if (checker.ara == true) result = result.concat(obj.backToStringArab(calcresult));
                        if (checker.lat == true) result = result.concat(obj.backToStringLat(calcresult));
                    }// полученные числа запускаем в объект калькулятор
                    else {
                        result = result.concat("Вы ввели некорректные значения! Попробуйте снова!");
                    }
                }
            }
        }
        else System.out.println("Пока!!");

        return result;
    }


}

package org.example.homework;

import java.sql.SQLOutput;

public class Homework1 {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
    }

    public static void ex1() {
        //Дана строка
        String name = "     ПЕтРов Олег Иванович     ";
        //Необходимо
        //1. убрать лишние пробелы,
        //2. перевести текст в верхний регистр
        //3. Если содержит "ова " то печатаем на экран: Уважаемая {name}
        // Если содержит "ов " то печатаем на экран: Уважаемый {name}
        // В иных случаях печатаем на экран: Неизвестное лицо {name}
        name = name.trim();
        name = name.toUpperCase();
        if (name.contains("ОВА")) {
            System.out.println("Уважаемая " + name);
        } else if (name.contains("ОВ")) {
            System.out.println("Уважаемый " + name);
        } else {
            System.out.println("Неизвестное лицо " + name);
        }
    }

    public static void ex2() {
        //У нас есть машина. В данной машине есть есть перечень проверок, перед запуском
        //Количество топлива
        double fuel = 10;
        //Проверка двигателя
        boolean isEngineWork = true;
        //Проверка отсутствия ошибок (false - ошибок нет)
        boolean hasErrors = false;
        //Датчики давления шин
        boolean isWheelWork1 = true;
        boolean isWheelWork2 = true;
        boolean isWheelWork3 = true;
        boolean isWheelWork4 = true;

        //Поменять(убрать, поставить) логические операторы так, чтобы машина запускалась:
        // когда топлива не меньше 10 литров, двигатель работает, колеса все работают, нет ошибок
        //В ином случае, машина не должна запускаться
        if (
                fuel >= 10
                &&  (isWheelWork1 && isWheelWork2 && isWheelWork3 && isWheelWork4)
                && !hasErrors
                && isEngineWork
        ) {
            System.out.println("Машина работает");
        } else {
            System.out.println("Машина не работает");
        }
    }

    public static void ex3() {
        //Работа на самостоятельное изучение методов.
        //Заменить в строке все 'this is' на 'those are', получить индекс (число) второй буквы 'o' в строке
        //Распечатать полученный индекс
        String simply = "this is simply. This is my favorite song.";
        simply = simply.replaceAll("this is", "those are");
        simply = simply.replaceAll("This is", "Those are");
        int index = simply.indexOf("o", simply.indexOf("o") + 1);
        System.out.println("Индекс второй буквы 'о' в строке: " + index);
    }

    public static void ex4() {
        //Компания Рога и Копыта производит мясные продукты.
        //Перечень производимых товаров :
        //Колбаса - стоимость 800 руб,
        //себестоимость при производстве меньше 1000 кг - 412руб,
        //себестоимость при производстве от 1000 до 2000 (не включая) - 408 руб
        //себестоимость при производстве от 2000кг - 404 руб

        //Ветчина - стоимость 350 руб
        //себестоимость при производстве - 275 руб

        //Шейка - стоимость 500 руб
        //себестоимость при производстве меньше 500кг - 311 руб
        //себестоимость при производстве больше или равно 500кг - 299 руб

        //Финансовые показатели
        //Доход компании считается как умножение стоимости на количество проданных кг
        //Расход компании считается как умножение себестоимости на количество проданных кг + миллион рублей
        //Прибыль до налогов считается как: доход - расход
        //Налоги считаются так:
        // прибыль до налогов больше 2_000_000, облагается ставкой 13%
        // прибыль до налогов больше 1_000_000 от 2_000_000, облагается ставкой 10%
        // прибыль до налогов меньше 1_000_000, облагается ставкой 8%
        //пример расчета налогов для прибыли до налогов 2_500_000:
        //1_000_000 - налог 80_000 - по ставке 8%
        //1_000_000 - налог 100_000 - по ставке 10%
        //500_000 - 65_000 - по ставке 13%
        //Итоговый налог: 80_000 + 100_000 + 65_000 = 245_000
        //Прибыль после налогов: прибыль до налогов - налог.

        //Необходимо создать универсальную систему расчетов прибыли после налогов,
        //Т.е на вход подаются данные по количеству произведенных продуктов
        // и печатается прибыль после налогов компании
        //Узнать прибыль после налогов, при продаже:
        //Колбасы 2000кг
        //Ветчины 8511кг
        //Шейки 6988кг
        profitCalculator(2000, 8511, 6988);
    }

    private static void profitCalculator(int sausage, int ham, int porkNeck) {
        int incomeSausage = 800 * sausage;
        int incomeHam = 350 * ham;
        int incomePorkNeck = 500 * porkNeck;
        int incomeCompany = incomeSausage + incomeHam + incomePorkNeck;
        int costPriceSausage;
        int costPriceHam;
        int costPricePorkNeck;
        if (sausage < 1000) {
            costPriceSausage = sausage * 412;
        } else if (sausage < 2000) {
            costPriceSausage = sausage * 408;
        } else {
            costPriceSausage = sausage * 404;
        }
        costPriceHam = ham * 275;
        if (porkNeck < 500) {
            costPricePorkNeck = porkNeck * 311;
        } else {
            costPricePorkNeck = porkNeck * 299;
        }
        int expensesCompany = costPriceSausage + costPriceHam + costPricePorkNeck + 1_000_000;
        int profitCompany = incomeCompany - expensesCompany;
        double netProfit;
        if (profitCompany >= 1_000_000) {
            netProfit = 1_000_000 * 0.08;
            if (profitCompany > 2_000_000) {
                netProfit = netProfit + 1_000_000 * 0.1;
                netProfit = netProfit + (profitCompany - 2_000_000) * 0.13;
            } else {
                netProfit = netProfit + (profitCompany - 1_000_000) * 0.1;

            }
        } else {
            netProfit = profitCompany * 0.13;
        }
        System.out.println("Прибыль компании после налогов: " + (profitCompany - netProfit));
    }
}

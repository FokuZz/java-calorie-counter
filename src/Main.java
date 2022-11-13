import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        while (true){
            printMenu("оснМеню");
            try {
                int command = scanner.nextInt();

                switch (command){
                    case(1):
                    printMenu("Меню1");
                    int mouthAdd =scanner.nextInt();
                    if (mouthAdd<0||mouthAdd>12){
                        System.out.println("Вы ввели недопустимое число!");
                        continue;
                    } else if (mouthAdd==0) {
                        continue;
                    }// Проверка если пользователь введёт меньше или больше допустимого числа 1
                    printMenu("Меню1_2");
                    int dayAdd =scanner.nextInt();
                    if (dayAdd<0||dayAdd>30){
                        System.out.println("Вы ввели недопустимое число!");
                        continue;
                    }else if (dayAdd==0) {
                        continue;
                    }// Проверка если пользователь введёт меньше или больше допустимого числа 2
                    System.out.println("Сколько шагов вы хотите добавить?");
                    int stepsInDay = scanner.nextInt();
                    tracker.addStepsDay(stepsInDay,mouthAdd,dayAdd);
                    continue;
                    case(2):
                    printMenu("Меню2");
                    int mouthStatistic = scanner.nextInt();
                    if (mouthStatistic<1||mouthStatistic>12){// Проверка если пользователь введёт меньше или больше допустимого числа 3
                        System.out.println("Вы ввели недопустимое число!");
                        continue;
                    }
                    tracker.printStatistic(mouthStatistic);
                    continue;
                    case(3):// Тут к сожалению я не могу использовать метот printMenu т.к. в данном методе создан обьект другого класса
                    System.out.println("Цель по количеству шагов на данный момент - "+tracker.avrInDay+" - хотите поменять?\n 1. Да   2. Отмена");
                    int answ =scanner.nextInt();
                    if (answ<1||answ>2){// Проверка если пользователь введёт меньше или больше допустимого числа 4
                        System.out.println("Вы ввели недопустимое число!");
                        continue;
                    } else if( answ == 1){
                        System.out.println("Введите желаемое количество шагов в день");
                        int newGoal = scanner.nextInt();
                        tracker.changeGoal(newGoal);
                        printMenu("Success");
                    }
                    continue;
                    case(4):
                        //scanner.close(); конкретно тут у меня не получилось закрыть сканнер, был бы рад если бы оставили коментарий как делать это в цикле, он закрывается после while
                        System.out.println("Выключаем....");
                        return;
                    default:
                    System.out.println("\nТакого пункта не существует\n");
                }
            }catch(Exception InputMismatchException){// Ловлю ошибку в случае если пользователь ввёл какой-то символ
                System.out.println("////////////ERROR///////////\nОшибка - Вводить можно только цифры\n////////////ERROR///////////\n");
                scanner.nextLine();
            }
            scanner.close();
        }

    }
    public static void printMenu(String type){
        switch (type) {
            case ("оснМеню"):
                System.out.println("Выберите что вы хотите сделать");
                System.out.println("1. Ввести количество шагов за определённый день");
                System.out.println("2. Напечатать статистику за определённый месяц ");
                System.out.println("3. Изменить цель по количеству шагов в день ");
                System.out.println("4. Выйти из приложения");
                break;
            case ("Меню1"):
                System.out.println("В какой месяц вы бы хотели добавить шаги?");
                System.out.println(" 1.Январь 2. Февраль 3. Март 4. Апрель 5. Май. 6. Июнь ");
                System.out.println(" 7. Июль 8. Август 9. Сенятбрь 10. Октябрь 11. Ноябрь 12. Декабрь");
                System.out.println("0. ОТМЕНА");
                break;
            case ("Меню1_2"):
                System.out.println("В какой день необходимо добавить шаги? В этой версии возможно ввести только от 1 до 30 дней\n" +
                        "0. ОТМЕНА");
                break;
            case ("Меню2"):
                System.out.println("За какой месяц вы хотите получить статистику?");
                System.out.println(" 1.Январь 2. Февраль 3. Март 4. Апрель 5. Май. 6. Июнь ");
                System.out.println(" 7. Июль 8. Август 9. Сенятбрь 10. Октябрь 11. Ноябрь 12. Декабрь");
                break;
            case ("Success"):
                System.out.println("Операция успешно выполнена!\n");
                break;
            default:
                System.out.println("ОШИБКА, НЕПРАВИЛЬНО НАЗВАЛ МЕНЮ");
                break;
        }
    }
}
// Надо исправить

/*

public class StepTracker {
Переменную trackArray лучше сделать final, так как это константа

double sum = 0;
если хочешь использовать тип данных double, то надо присваивать значение с дробной части, иначе они будут считаться Int и перменная avr обрежется до int,
как и результат методов в конвертере обрежется до int.
То есть надо писать: double sum = 0.0;


 */
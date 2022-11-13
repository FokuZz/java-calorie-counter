public class StepTracker {
    final int[][] trackArray = new int[12][30]; // Вводим двумерны массив где 12 это месяц, а 30 это дни. В месяц мы будем суммировать шаги
    int avrInDay = 10000;
    void addStepsDay(int steps, int mouth, int day){ // Вводит количество шагов за определённый день
        trackArray[mouth-1][day-1]+=steps;
    }
    void printStatistic(int mouth){
            double sum = 0.0;
            int[] maxDay = {0,0};
            int nMax = 0;
            int countMax = 0;
            hrText(1);
            for (int i=0;i<trackArray[mouth-1].length;i++){
                System.out.print((i+1)+" день: "+trackArray[mouth-1][i]);
                if (i==14){ // Условие чтобы всё можно было прочитать в одной строчке и чтобы не было запитой в конце
                    System.out.print(",\n");
                }else if (i!=29){
                    System.out.print(", ");
                }
                if (trackArray[mouth-1][i]>maxDay[0]){ // Ищет самое большое кол-во шагов
                    maxDay[0]=trackArray[mouth-1][i];
                    maxDay[1]=i+1;
                }
                sum+=trackArray[mouth-1][i];
                if (trackArray[mouth-1][i]>=avrInDay){ // Условие для нахождения лучшей серии
                    nMax++;
                    if (nMax>countMax){
                        countMax=nMax;
                    }
                } else {
                    nMax=0;
                }
            }
            System.out.print("\n");
            hrText(3);
            double avr=sum/trackArray[mouth-1].length; // Вычесляем среднее кол-во шагов
            textStatistic(maxDay,sum,avr,countMax);
            hrText(2);

    }
    void changeGoal(int newGoal){
        if (newGoal<0) {
            System.out.println("ОШИБКА ВЫ ВВЕЛИ ОТРИЦАТЕЛЬНОЕ ЧИСЛО");
            return;
        }
        avrInDay = newGoal;
    }
    void textStatistic(int[] maxDay, double sum, double avr, int countMax){
        Converter converter = new Converter();
        System.out.print("------------------------------- В этом месяце вы проходили "+String.format("%.0f", sum)+" шагов\n"); // String.format("%.2f", num ) для более красивого отображения
        System.out.print("----------- Самое большое количество шагов вы сделали в "+maxDay[1]+" день, вы прошли "+maxDay[0]+ " шагов!\n");
        System.out.print("---------------------------- Среднее количество шагов = "+String.format("%.2f", avr)+"\n");
        System.out.print("----------------------- Пройденная дистанция (в км) = "+String.format("%.2f", converter.kmInSteps(sum))+"\n");//Я считаю 1км = 1333 шагов
        System.out.print("-------------------- Лучшая серия дней = "+countMax+"\n");
        System.out.println("----------------- Количество сожжённых килокалорий = "+String.format("%.2f", converter.kKalInSteps(sum))); //1 км = 55 ккал
    }
    void hrText(int number){
        switch (number) {
            case(1):
                System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
                break;
            case(2):
                System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                break;
            case(3):
                System.out.println("____________________________________________________________________________________________________________________________________");
                break;
        }
    }
}

/*
Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования
1.	Создайте несколько экземпляров Pharmacy, причем, чтобы среди них было хотя бы два экземпляра
с полностью идентичными значениями полей.
2.	Сделать так, чтобы после выполнения кода ниже, в сете result были только уникальные объекты.
Set<Pharmacy> result = new HashSet<>(множество из нескольких лекарств);
System.out.println(result.size()); // тут вывод должен быть равен количеству УНИКАЛЬНЫХ экземпляров Pharmacy!
3.	Добавить интерфейс Copmparable<Pharmacy> к классу Pharmacy. Переопределить метод compareTo()
подсказка: можно добавить, а можно не добавлять в класс поля;
ссылка на статью о equals и hashCode: https://javarush.com/groups/posts/2179-metodih-equals--hashcode-praktika-ispoljhzovanija
Формат сдачи дз: ссылка на гит

 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
//создаем несколько компонентов для лекарства
        PharmancyComponent ciprofloxacin250 = new Ciprofloxacin("Ciprofloxacin", 250, 250);
        PharmancyComponent ciprofloxacin500 = new Ciprofloxacin("Ciprofloxacin", 500, 500);
        PharmancyComponent ciprofloxacin750 = new Ciprofloxacin("Ciprofloxacin", 750, 750);
        PharmancyComponent cellulose = new Сellulose("Сellulose", 10, 0);
        PharmancyComponent talc = new Talc("Talc", 10, 0);

//создаем лекарство 1, 2, 3 с разными компонентами и лекарство №4 и №5 дублирующие №3 и друг друга (итого 3 лекарства уникальных)
        Pharmacy pharmacy1 = new Pharmacy().addComponent(ciprofloxacin250).addComponent(cellulose).addComponent(talc);
        Pharmacy pharmacy2 = new Pharmacy().addComponent(ciprofloxacin500).addComponent(cellulose).addComponent(talc);
        Pharmacy pharmacy3 = new Pharmacy().addComponent(ciprofloxacin750).addComponent(cellulose).addComponent(talc);
        Pharmacy pharmacy4 = new Pharmacy().addComponent(ciprofloxacin750).addComponent(cellulose).addComponent(talc);
        Pharmacy pharmacy5 = new Pharmacy().addComponent(ciprofloxacin750).addComponent(cellulose).addComponent(talc);


        //Создаем список лекарств
        List<Pharmacy> pharmacies = new ArrayList<>();
        pharmacies.add(pharmacy1);
        pharmacies.add(pharmacy2);
        pharmacies.add(pharmacy3);
        pharmacies.add(pharmacy4);
        pharmacies.add(pharmacy5);
        System.out.println(pharmacies); //при выводе данного списка будут отображены все оекарства


          Set<Pharmacy> result = new HashSet<>(pharmacies);
          System.out.println(result); //вывод данного списка отображает только уникальные лекарства
          System.out.println(result.size()); // вывод количества УНИКАЛЬНЫХ экземпляров Pharmacy!

        System.out.println(pharmacy3.compareTo(pharmacy3));


    }
}



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

//Лекарство
public class Pharmacy implements Iterable<PharmancyComponent>, Comparable<Pharmacy> { //Iterable - это надстройка над итератором, в которой есть один нереализованный метод иттератор.иттератор по <PharmancyComponent>.
    //Можно было бы вместо Iterable поставить итератор Iterator
    //Comparable - сравнение объектов для сортировки. Нужно указывать почему мы сравниваем, у нас по <Pharmacy>. 1 нереализованный мпетод compareTo
    private List<PharmancyComponent> components = new ArrayList<>();
    private int index = 0;

    public Pharmacy addComponent(PharmancyComponent component){ //добавление компонентов
        components.add(component);
        return this; //возвращаем объект типа Pharmancy, но в обновленном виде. Упрощает написание кода
    }

    public List<PharmancyComponent> getComponents() {
        return components;
    }

    public void setComponents(List<PharmancyComponent> components) {
        this.components = components;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    //Методы Итератора
//у итератора есть два метода, которые нужно переопределить hasNext и next.
//    @Override
//    public boolean hasNext() {
//        return index < components.size(); //если индекс меньше длины списка, то есть следующий компонент.
//    }
//
//    @Override //возвращает следующий элемент
//    public PharmancyComponent next() {
//        return components.get(index++);
//    }

    //переопределяем метод toString для вывода нужного нам вида
    @Override
    public String toString() {
        return "Pharmacy{" +
                "components =" + components +
                ", index = " + index +
                '}';
    }

    // вынесенный класс Iterable - для IteratorComponent(когда выносим итератор в отдельный класс)
//    @Override
//    public Iterator<PharmancyComponent> iterator() {
//        return new IteratorComponent(this);
//    }


    //В Iterable есть один нереализованный метод Iterator. Как раз его переопределяем
    //расписываем как оно должно работать см выше мтоды Итератора
    //Расписали итератор в виде анонимного класса Iterable
    @Override
    public Iterator<PharmancyComponent> iterator() {
        return new Iterator<PharmancyComponent>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public PharmancyComponent next() {
                return components.get(index++);
            }
        };
    }

//метод для Comparable
    //нужно реализовывать таким образом, чтобы если 1й объект < 2го, то возвращается всегда -1
    //Если 1й объект == объекту 2, то возвращается 0
    //если 1й объект > 2го, то возвращается всегда 1
    @Override
    public int compareTo(Pharmacy o) {
        if (this.index > o.index) {
            return 1;
        } else if (this.index < o.index) {
            return -1;
        }
        else
            return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pharmacy pharmacy = (Pharmacy) obj;
        return index == pharmacy.index && Objects.equals(components, pharmacy.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components, index);

    }

}

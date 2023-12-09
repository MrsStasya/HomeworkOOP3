
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//Реализация итератора в отдельном классе
//Далее нужно перейти в Pharmacy См выделенный класс
//Нужна если много классов, в которых нужны иттераторы одного и того же типа.
//Если для каждого класса нужен свой иттератор, то пишем через анонимный класс(см Pharmacy)
public class IteratorComponent implements Iterator<PharmancyComponent>{

    private List<PharmancyComponent> components;
    private int index; //можно index получать в цикле while

    private Pharmacy pharmacy; //конструктор

    public IteratorComponent(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
        components = pharmacy.getComponents();
        index = pharmacy.getIndex();
    }

    @Override
    public boolean hasNext() {
        return index < components.size();
    }

    @Override
    public PharmancyComponent next() {
        return components.get(index++);
    }
}

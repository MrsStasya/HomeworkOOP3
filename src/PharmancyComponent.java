//Ингридиенты
public class PharmancyComponent implements Comparable<PharmancyComponent> {

    private String name; //название
    private int weight; //вес
    private int power; //сила лекарства.


    public PharmancyComponent(String name, int weight, int power) { //конструктор
        this.name = name;
        this.weight = weight;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    //переопределяем метод toString
    @Override
    public String toString() {
        return "PharmancyComponent{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", power=" + power +
                '}';
    }
//для Comparable<PharmancyComponent>
    //Сортировка по силе лекарства(power)
    @Override
    public int compareTo(PharmancyComponent o) {
        if (this.power > o.power){
            return -1;
        } else if (this.power < o.power){
            return 1;
        }
        return 0;
    }

}

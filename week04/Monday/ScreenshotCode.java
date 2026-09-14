public class Car {

    private Car next;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car getNext() {
        return next;
    }

    public void setNext(Car next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Car{name='" + name + "'}";
    }
}

class CarExample {

    public static void main(String[] args) {

        Car car1 = new Car("Car 1");
        Car car2 = new Car("Car 2");
        Car car3 = new Car("Car 3");

        car1.setNext(car2);
        car2.setNext(car3);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }
}

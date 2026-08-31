public class InterfaceReview {
    public static void main(String[] args) {
        Animal seabiscuit = new Horse();
    }
}

abstract class Mammal implements Animal {
    private int age;

    public Mammal() {
        age = 0;
    }

    public void born() {
        age = 0;
    }
}

class Horse extends Mammal {
    @Override
    public void die() {

    }
}

interface Animal {
    void born();

    void die();
}


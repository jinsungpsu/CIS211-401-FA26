public class RefVarReview {
    public static void main(String[] args) {
        Cereal applejack = new Cereal("Apple Jacks", 300, null);
        applejack.setName("Apple Jacks");

        Cereal cheerios = new Cereal("Cheerios", 290, null);
        applejack.setName("Cheerios");

        Cereal superCerealCool = new Cereal("custom awesome cereal", 280, applejack);

        int num = 5;
        int num2 = num;

        System.gc(); // <<-- just a suggestion to JVM.. doesn't actually guarantee garbage collection
    }
}

class Cereal {
    private String name;
    private int calories;

    private Cereal addin;

    public Cereal(String name, int calories, Cereal cereal) {
        this.name = name;
        this.calories = calories;
        this.addin = cereal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Cereal{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}

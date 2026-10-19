package mod7;
class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

public class Examples {
    static String[] hashTable = new String[100];
    static int hash(Object key) {
        return key.toString().charAt(0)%hashTable.length;
    }
    public static void main(String[] args) {

        // lab
        String[] pokemons = {
                "Pikachu",
                "Charizard",
                "Bulbasaur",
                "Ivysaur",
                "Venusaur",
                "Charmander",
                "Charmeleon",
                "Squirtle",
                "Wartortle",
                "Blastoise",
                "Caterpie",
                "Metapod",
                "Butterfree",
                "Weedle",
                "Kakuna",
                "Beedrill",
                "Pidgey",
                "Pidgeotto",
                "Pidgeot",
                "Rattata",
                "Raticate",
                "Spearow",
                "Fearow",
                "Ekans",
                "Arbok",
                "Raichu",
                "Sandshrew",
                "Sandslash",
                "NidoranF",
                "Nidorina",
                "Nidoqueen",
                "NidoranM",
                "Nidorino",
                "Nidoking",
                "Clefairy",
                "Clefable",
                "Vulpix",
                "Ninetales",
                "Jigglypuff",
                "Wigglytuff",
                "Zubat",
                "Golbat",
                "Oddish",
                "Gloom",
                "Vileplume",
                "Paras",
                "Parasect",
                "Venonat",
                "Venomoth",
                "Diglett"
        };

        int collisions = 0;
        for (int i = 0; i < pokemons.length; i++) {
           int where = hash(pokemons[i]);
           if (hashTable[where] == null) {
               // means no collision
                hashTable[where] = pokemons[i];
            } else {
                // a collision has occurred
                collisions++;
            }
        }

        System.out.println("Importing 50 pokemon into hash table of 100 with my hash function has resulted in " + collisions + " collisions.");

        Object rock = new Object();
        System.out.println(rock.hashCode());

        String[] students = {"john", "alex", "lucy"};
        int[] studentID = {700123341, 700193847, 70019847};

        Student[] studentsArr = {
                new Student("John", 12124),
                new Student("Lucy", 19483741)
        };

        System.out.println(studentsArr[0].name + "'s hashcode is: " + studentsArr[0].hashCode());
        System.out.println(studentsArr[1].name + "'s hashcode is: " + studentsArr[1].hashCode());

        int[] nums = {1,2,3};

        System.out.println(nums[1]);

        String[] raceWinners = {"Alex", "Lucy", "John"};
        // i can look up who came in first... in O(1)
        // sout"Winner is raceWinners[0]"
        // i can also look up who came in .... any position


        Map<String, Double> myPhoneBook = new ArrayMap<>();

        myPhoneBook.insert("Taytay", 3021234678D);
        myPhoneBook.insert("Jason", 61023948714D);

        System.out.println("Jason's phone number is: " + myPhoneBook.get("Jason"));

        myPhoneBook.remove("Taytay");
    }
}

interface Map<K, V> {
    public void insert(K key, V value);
    public void remove(K key);
    public V get(K key);
}

class ArrayMap<K, V> implements Map<K, V> {
    private final int DEFAULT_CAPACITY = 10;

    private K[] keys;
    private V[] values;

    public ArrayMap() {
        keys = (K[])new Object[DEFAULT_CAPACITY];
        values = (V[])new Object[DEFAULT_CAPACITY];
    }

    public ArrayMap(int size) {
        keys = (K[])new Object[size];
        values = (V[])new Object[size];
    }

    @Override
    public void insert(K key, V value) {

    }

    @Override
    public void remove(K key) {

    }

    @Override
    public V get(K key) {
        return null;
    }
}

class LinkedMap <K, V>{
    private Node head, tail;


    class Node {
        K key;
        V value;
        Node prev, next;
    }
}

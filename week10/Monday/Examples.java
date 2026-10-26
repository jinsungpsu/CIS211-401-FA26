package mod7;

import java.util.LinkedList;

class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public boolean equals(Student obj) {
        return this.id == obj.id;
    }
}

public class Examples {
    static final int TABLE_SIZE = 70;
    static String[] hashTable = new String[TABLE_SIZE];
    static int hash(Object key) {
        // super dumb
        // return 0;

        // slightly better
        // return key.toString().charAt(0)%hashTable.length;

        // slightly better still, take 2 letters

        // int index = key.toString().charAt(0) * key.toString().charAt(1) * key.toString().charAt(2) * key.toString().charAt(3);

        /*
        int index = 1;
        for (int i = 0; i < key.toString().length(); i++) {
            index *= key.toString().charAt(i);
        }
        */
        // best given our constraints, use all letters

        /*
        index = Math.abs(index);
        index %= hashTable.length;
        return index;

         */

        /*
        document this!:
        table size = 70
        1 char addition: 31
        2 char addition: 26
        3 char addition: 24
        4 char: 24
        all chars: 15

        multiply?
        1: 31
        2: 27
        3: 29 <-- went up!!! ???????
        4: 34 <--- huh?
        all letters: 24

         table size 71
         multiply 4: 24

         multiplication method
         table size still 70

         */

        final double A = 0.1974391;
        int k=0;
        for (int i = 0; i < key.toString().length(); i++) {
            k += key.toString().charAt(i);
        }
        double product = k * A;
        double fraction = product - Math.floor(product);

        int hashValue = (int) (fraction * hashTable.length);
        return hashValue;
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

class ArrayMaptest {
    public static void main(String[] args) {
        String[][] urbanDictionarySrc = {
                {"Yeet", "An expression used when throwing something forcefully or showing excitement."},
                {"Sus", "Short for suspicious; something that seems questionable."},
                {"Flex", "To show off or brag about something."},
                {"Ghosting", "Stopping all communication with someone without explanation."},
                {"Mood", "A relatable feeling or situation."},
                {"Salty", "Being upset, irritated, or bitter about something."},
                {"Low-key", "Somewhat, secretly, or moderately."},
                {"High-key", "Openly, obviously, or strongly."},
                {"Cap", "A lie or false statement."},
                {"No Cap", "For real; not lying."},
                {"Bet", "Okay, agreed, or challenge accepted."},
                {"W", "A win, success, or good outcome."},
                {"L", "A loss, failure, or bad outcome."},
                {"Fire", "Excellent, impressive, or very good."},
                {"Drip", "Stylish clothing or appearance."},
                {"NPC", "Someone acting predictably or without independent thought."},
                {"Rizz", "Charm or flirting ability."},
                {"Touch Grass", "Get offline and experience the real world."},
                {"Main Character", "Someone acting as if they are the center of attention."},
                {"Cooked", "In trouble, exhausted, or doomed."}
        };
        Map<String, String> urbanDictionary = new ArrayMap<>();

        for (int i = 0; i < urbanDictionarySrc.length; i++) {
            urbanDictionary.insert(urbanDictionarySrc[i][0], urbanDictionarySrc[i][1]);
        }
    }
}

class ArrayMap<K, V> implements Map<K, V> {
    private final int DEFAULT_CAPACITY = 5;

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
        int startingIndex = hash(key);

        // if statement below asks 2 question
        // 1) is that spot empty
        // 2) is that spot taken up by the key that i'm currently trying to insert
        if (keys[startingIndex] == null || keys[startingIndex].equals(key)) {
            // currently empty spot!
            // no collision!
            // we still need to talk about tombstones... that's next!
            keys[startingIndex] = key;
            values[startingIndex] = value;
            return;
        } else {
            // yes collision
            // linear probing
            // just one strategy we can use...!
            for (int i = 0; i < keys.length-1; i++) {
                int index = (startingIndex+i+1)%keys.length;
                if (keys[index] == null|| keys[index].equals(key)) {
                    keys[index] = key;
                    values[index] = value;
                    return;
                }
            }
        }
    }

    @Override
    public void remove(K key) {
        // how do I remove an association????
        // hash the key
        int startingIndex = hash(key);
        if (keys[startingIndex].equals(key)) {
            // found the thing i'm looking for!
            /*
            keys[startingIndex] = null;
            values[startingIndex] = null;
            doing this would cause issues for the hash table

            use a tombstone!!!

            memory inefficient... if a lot of deletions
             */
            values[startingIndex] = null;
        }
    }

    @Override
    public V get(K key) {
        return null;
    }

    private int hash(K key) {
        int index = Math.abs(key.hashCode()) % keys.length;

        return index;
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

class OpenHashingMap<K, V> implements Map<K, V> {
    private final int DEFAULT_CAPACITY = 5;
    private LinkedList<Entry>[] table;

    public OpenHashingMap() {
        table = new LinkedList[DEFAULT_CAPACITY];
    }

    @Override
    public void insert(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            // nothing has been mapped to this spot.. yet
            // aka... no collisions
            table[index] = new LinkedList<>();
            // it's empty... but now I have linked list
            Entry entry = new Entry();
            entry.key = key;
            entry.value = value;

            table[index].add(entry);
        } else {
            // collision!!
            // if there's already a linked list in that array spot???
            // search the array to see if key already exists.. if it does.. update the value
        }

    }

    @Override
    public void remove(K key) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    private int hash(K key) {
        int index = Math.abs(key.hashCode()) % table.length;

        return index;
    }

    class Entry {
        K key;
        V value;
    }
}

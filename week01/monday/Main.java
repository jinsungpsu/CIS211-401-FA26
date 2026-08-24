import java.util.Random;

/* code that might be helpful as a starting point
aka starter code
for cis211
lab 1
 */
class Pokemon {
    private String name;
    private int hp;

    public int getHp() {
        return hp;
    }

    public void attack(Pokemon opponent) {
        // placeholder
        int attack = 5;

        // "this" is p1, opponent is p2
        opponent.hp -= attack;
    }
}

class PokemonBattleOOP {
    public static void main(String[] args) {
        // battle logic goes here!

        Pokemon p1 = new Pokemon();
        Pokemon p2 = new Pokemon();

        while (p1.getHp() > 0 && p2.getHp() > 0) {
            // keep looping as long as
            // both pokemon have not fainted yet
            p1.attack(p2);
        }

    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        mashed
        fried
        scalloped
        loaded
         */
        String[] potatoStyles;
        // how do i tell the computer how big this array is?
        // explicit
        potatoStyles = new String[5];

        // or implicit
        String[] potatoStyles2 = {"Fried", "Mashed"};

        potatoStyles[0] = "fried";
        /*
        reference variable for an array of String objects

        I can't do
        potatoStyles[0] = "fried";

        contiguous > immutable
        > random access
        >>> i need to tell the computer how big my array is
        >>>> ahead of time
         */
    }
}

class Driver {
    public static void main(String[] args) {

    }
}


// citation
// copilo!
class PokemonBattle {
    public static void main(String[] args) {
        Random random = new Random();

        String pokemon1 = "Pikachu";
        String pokemon2 = "Charmander";

        int hp1 = 100;
        int hp2 = 100;

        System.out.println("A battle begins!");
        System.out.println(pokemon1 + " vs " + pokemon2);
        System.out.println();

        boolean pokemon1Turn = true;

        while (hp1 > 0 && hp2 > 0) {

            int damage = random.nextInt(16) + 5; // 5-20 damage

            if (pokemon1Turn) {
                hp2 -= damage;
                if (hp2 < 0) hp2 = 0;

                System.out.println(pokemon1 + " attacks!");
                System.out.println(pokemon2 + " takes " + damage + " damage.");
                System.out.println(pokemon2 + " HP: " + hp2);
            } else {
                hp1 -= damage;
                if (hp1 < 0) hp1 = 0;

                System.out.println(pokemon2 + " attacks!");
                System.out.println(pokemon1 + " takes " + damage + " damage.");
                System.out.println(pokemon1 + " HP: " + hp1);
            }

            System.out.println();

            pokemon1Turn = !pokemon1Turn;
        }

        if (hp1 > 0) {
            System.out.println(pokemon2 + " fainted!");
            System.out.println(pokemon1 + " wins!");
        } else {
            System.out.println(pokemon1 + " fainted!");
            System.out.println(pokemon2 + " wins!");
        }
    }
}

// citation
// copilo!
class PokemonBattleArray {
    public static void main(String[] args) {
        Random random = new Random();

        String[] pokemonNames = {"Pikachu", "Charmander"};
        int[] pokemonHP = {100, 100};

        int attacker = 0;
        int defender = 1;

        System.out.println("A battle begins!");
        System.out.println(pokemonNames[0] + " vs " + pokemonNames[1]);
        System.out.println();

        while (pokemonHP[0] > 0 && pokemonHP[1] > 0) {

            int damage = random.nextInt(16) + 5;

            pokemonHP[defender] -= damage;

            if (pokemonHP[defender] < 0) {
                pokemonHP[defender] = 0;
            }

            System.out.println(pokemonNames[attacker] + " attacks!");
            System.out.println(pokemonNames[defender] + " takes " + damage + " damage.");
            System.out.println(pokemonNames[0] + " HP: " + pokemonHP[0]);
            System.out.println(pokemonNames[1] + " HP: " + pokemonHP[1]);
            System.out.println();

            // Swap attacker and defender
            int temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (pokemonHP[0] > 0) {
            System.out.println(pokemonNames[1] + " fainted!");
            System.out.println(pokemonNames[0] + " wins!");
        } else {
            System.out.println(pokemonNames[0] + " fainted!");
            System.out.println(pokemonNames[1] + " wins!");
        }
    }
}

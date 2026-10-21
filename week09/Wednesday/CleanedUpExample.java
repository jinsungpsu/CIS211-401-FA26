package mod7;

public class MultCluster {
    static final int TABLE_SIZE = 70;
    static String[] hashTable = new String[TABLE_SIZE];
    static int hash(Object key) {
        int index = 1;

        for (int i = 0; i < key.toString().length(); i++) {
            index *= key.toString().charAt(i);
        }

        System.out.print("Calculated hash value of: " + index);

        index = Math.abs(index) % TABLE_SIZE;

        System.out.println(" stored at index: " + index);

        return index;
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

        System.out.println("Importing 50 pokemon into hash table of " + TABLE_SIZE +" with my hash function has resulted in " + collisions + " collisions.");
    }
}

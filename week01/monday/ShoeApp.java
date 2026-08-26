/*
You can get the shoe csv file from: https://drive.google.com/drive/folders/1u6lFHDG0dNFlPLxy_DP3eHYsAEe37ffu?usp=drive_link

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShoeApp {
    public static void main(String[] args) {
        final int SHOE_ARRAY_SIZE = 10000;
        String filename = "Datafiniti_Womens_Shoes.csv";

        Shoe[] shoes = new Shoe[SHOE_ARRAY_SIZE];
        int shoeCount = 0;


         Scanner keyboard = new Scanner(System.in);

         File myfile = new File(filename);

        try {
            // code that might throw an exception
            Scanner fileInput = new Scanner(myfile);
            Scanner fileInput2 = new Scanner(new File(filename)); // <- anonymous object
            String header = fileInput.nextLine();

            while (fileInput.hasNextLine()) {
                String shoeInfo = fileInput.nextLine();

                // v1
                // split one single line of shoe info

                // this one will not deal with commas inside values: String[] shoeData = shoeInfo.split(",");
                String[] shoeData = shoeInfo.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                // 4 is brand, 16 = price min, 17 = availability
                //System.out.printf("This shoe's id is %s and date added is %s\n", shoeData[0], shoeData[1]);
                // System.out.printf("Brand: %s, PriceMin: %s, Availability: %s\n", shoeData[4],shoeData[16],shoeData[17] );

                Shoe myshoe = new Shoe(shoeData[4],shoeData[16],shoeData[17]);

                shoes[shoeCount++] = myshoe;

                System.out.println(myshoe);


//                System.out.println("###### ONE SHOE'S DATA #######");
//                for (int i = 0; i < shoeData.length; i++) {
//                    System.out.print(shoeData[i] + " | ");
//                }



            }

        } catch (FileNotFoundException e) {
            // deal with the exception
            // IF it occurs

            System.out.println("Couldn't find the file?");
            System.out.printf("Give new file location?: ");
            String newfile = keyboard.next();
            // throw new RuntimeException(e);
        }

         /*
         Scanner class
         fileInput <- ref var, object
          */

        System.out.println("End of program");
    }
}
class Shoe {
    private String brand;
    private double priceMin;
    private boolean availability;

    public Shoe(String brand, double priceMin, boolean availability) {
        this.brand = brand;
        this.priceMin = priceMin;
        this.availability = availability;
    }

    public Shoe(String brand, String priceMin, String availability) {
        this.brand = brand;
        this.priceMin = Double.parseDouble(priceMin.trim());
        if (availability.trim().equals("In Stock")) {
            this.availability = true;
        } else {
            this.availability = false;
        }


    }

    public boolean isInStock() {
        return availability;
    }

    public double getPrice() {
        return priceMin;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "brand='" + brand + '\'' +
                ", priceMin=" + priceMin +
                ", availability=" + availability +
                '}';
    }
}

class ShoeMenu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Sample data
        Shoe[] shoes = {
                new Shoe("Nike Air", 45.99, true),
                new Shoe("Adidas Run", 60.00, true),
                new Shoe("Puma Sport", 39.99, false),
                new Shoe("Skechers Walk", 49.99, true)
        };

        int choice;

        do {
            System.out.println("\n=== SHOE MENU ===");
            System.out.println("1. Show in-stock shoes under $50");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nIn-stock shoes under $50:");

                    boolean found = false;

                    for (Shoe shoe : shoes) {
                        if (shoe.isInStock() && shoe.getPrice() < 50.00) {
                            System.out.println(shoe);   // assumes toString() exists
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matching shoes found.");
                    }
                    break;

                case 2:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 2);

        input.close();
    }
}

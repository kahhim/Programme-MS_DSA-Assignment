package programme.ms.assignment;

import java.util.Scanner;
import static programme.ms.assignment.ProgrammeMSAssignment.*;
import entity.Faculty;

/**
 *
 * @author kahhim
 */
public class SortingDriver {

    public static Scanner scanner = new Scanner(System.in);

    public static void sortmenu() {
        boolean exit = false;
        String selection;

        do {
//            faculty.display();
            System.out.println("\nPlease select a list that you want to add and sort\n"
                    + "1. View Faculties\n"
                    + "2. Add new Faculty\n"
                    + "3. Sort Faculties\n"
                    + "0. Main Menu\n");
            System.out.printf("> ");

            selection = scanner.nextLine();
            switch (selection) {
                case "0":
                    exit = true;
                    break;
                case "1":
                    faculty.display();
                    System.out.println("");
                    entContinue();
                    break;
                case "2":
                    Faculty();
                    break;
                case "3":
                    sortfaculty();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        } while (!exit);
    }

    public static void Faculty() {
        System.out.println("Faculty list:");
        faculty.display();
        String selection = "";
        boolean again = true;

        do {
            System.out.println("\nEnter a add new Faculty code:");
            String code = scanner.nextLine();

            System.out.println("\nEnter a add new Faculty name:");
            String name = scanner.nextLine();
            faculty.add(new Faculty(code, name));

            boolean validOption;
            do {
                faculty.display();
                System.out.println("\n Do you wish to add more? (Y/N)");
                System.out.printf("> ");
                selection = scanner.nextLine();

                switch (selection.toUpperCase()) {
                    case "Y":
                        validOption = true;
                        break;
                    case "N":
                        again = false;
                        validOption = true;
                        break;
                    case "":
                        validOption = false;
                        break;
                    default:
                        System.out.println("Invalid Option");
                        validOption = false;
                        break;
                }

            } while (!validOption);
        } while (again);
    }

    public static void sortfaculty() {
        faculty.bubbleSort();
        faculty.display();
        System.out.println("");
        entContinue();
    }
}

import java.util.Scanner;


/*
  Useful resources:
  - https://www.aleph.se/Trans/Individual/Body/ascii.html

  DNA in binary
    00 -> A
    01 -> T
    10 -> G
    11 -> C
*/

public class DNA {

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    String structure = "";
    options();
    structure = input.nextLine();

    switch(structure) {
      case "DNA":

      break;

      default:
        System.out.println("Please enter the correct options...");
    }


  }

  public static void encode() {

  }

  public static void options() {
    System.out.println("Type \"DNA\": to view structure in DNA");
  }

}

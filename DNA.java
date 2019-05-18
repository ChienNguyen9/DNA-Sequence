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
    String structure = options();
    //String result = ""; // store the answer

    switch(structure) {
      case "DNA":
        System.out.print("Enter arbitrary ACSII text for DNA: ");
        String sequence = input.nextLine();
        encode(sequence);
      break;

      default:
        System.out.println("Please enter the correct options...");
      break;
    }


  }

  public static void encode(String input) {
    String result = "";
    int acsiiValue;

    for(int x = 0; x < input.length(); x++) {
      acsiiValue = (int)input.charAt(x);
      StringBuilder binary = new StringBuilder(Integer.toBinaryString(acsiiValue));
      result += convertBinaryToDNA(binary);
    }
    System.out.println(input + ": " + result);
  }

  // Convert binary into sequence DNA
  public static String convertBinaryToDNA(StringBuilder binary) {
    String result = "";

    // Ensure that the binary is 8-bit long
    for(int x = binary.length(); x < 8; x++) {
      binary.insert(0, "0");
    }

    // Convert 2 bit to a character
    for(int i = 0; i < binary.length(); i+=2) {
      String data = binary.substring(i, i+2);

      switch(data) {
        case "00":
          result += "A";
        break;
        case "01":
          result += "T";
        break;
        case "10":
          result += "G";
        break;
        case "11":
          result += "C";
        break;
        default:
          System.out.println("Binary is not found!!!");
        break;
      }

    }

    return result;
  }

  public static String options() {
    Scanner input = new Scanner(System.in);
    System.out.println("Type \"DNA\": to view structure in DNA");
    System.out.println("Type \"RNA\": to view structure in RNA");


    return input.nextLine();
  }

}

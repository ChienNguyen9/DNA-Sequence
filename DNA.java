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
    Scanner in = new Scanner(System.in);
    String structure = options().toUpperCase();
    String input="", output;

    switch(structure) {
      case "DNA":
      case "RNA":
        System.out.print("Enter arbitrary ACSII text: ");
        input = in.nextLine();
        output = encode(input, structure);
      break;
      case "IDEN":
        System.out.print("Enter encoded DNA as ASCII: ");
        input = in.nextLine();
        output = identify(input.toUpperCase());
      break;
      case "CDNA":
        System.out.print("Enter complementary strand of DNA: ");
        input = in.nextLine();
        output = decode(input);
      break;

      default:
        System.out.println("Please enter the correct options...");
        output = "Error: Incorrect input!!!";
      break;
    }

    System.out.println("Input: "+input+"\nOutput: "+output);
  }

  public static String encode(String input, String structure) {
    String result = "";
    int acsiiValue;

    for(int x = 0; x < input.length(); x++) {
      acsiiValue = (int)input.charAt(x);
      StringBuilder binary = new StringBuilder(Integer.toBinaryString(acsiiValue));
      result += convertBinaryToDNA(binary);
    }

    // RNA replace T with U
    if(structure.equals("RNA"))
      result = result.replace('T', 'U');

    return result;
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

  public static String decode(String strand) {
    String result = "", binary = "";

    for(int c = 0; c < strand.length(); c++) {
      // Complement the characters
      switch(strand.charAt(c)) {
        case 'A':
          binary += "01";
        break;
        case 'T':
          binary += "00";
        break;
        case 'G':
          binary += "11";
        break;
        case 'C':
          binary += "10";
        break;
        default:
          System.out.println("Cannot find DNA base...");
        break;
      }

      if((c+1)%4==0) {
        result += (char)Integer.parseInt(binary, 2);
        binary = "";  // new strand of DNA
      }
    }
    return result;
  }

  public static String identify(String input) {
    String output = "";
    for(int i = 0; i < input.length(); i++) {
      if(input.charAt(i)=='A' || input.charAt(i)=='T' ||
        input.charAt(i)=='G' || input.charAt(i)=='C') {
        output += "DNA "+input.charAt(i)+" found at index "+i+".\n";
      }
    }

    if(output.equals(""))
      output = "(-1) Does not exist";

    return output;
  }

  public static String options() {
    Scanner input = new Scanner(System.in);
    System.out.println("Type \"DNA\": to view structure in DNA");
    System.out.println("Type \"RNA\": to view structure in RNA");
    System.out.println("Type \"IDEN\": to identify ACSII as DNA");
    System.out.println("Type \"CDNA\": to complement DNA");


    return input.nextLine();
  }

}

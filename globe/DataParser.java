import java.io.*;
import java.util.Scanner;

public class DataParser {

    public static void main(String[] args) throws Exception{

        Scanner scan = new Scanner(new File("Earthquake data csv.csv"));

        File file = new File("earthquake_formatted.json");
        if(!file.exists())
            file.createNewFile();
        FileOutputStream oFile = new FileOutputStream(file, false);
        System.setOut(new PrintStream(new BufferedOutputStream(oFile), true));

        System.out.print("[[\"data\",[");
        String line;
        int i = 0;
        line = scan.nextLine();
        while(true) {
            line = scan.nextLine();
            i++;

            System.out.print(line);

            if(!scan.hasNextLine())
                break;
            if(!line.equals("")&&line.charAt(line.length()-1)!=',')
                System.out.println(",");
        }
        System.out.print("]]]");

    }

}
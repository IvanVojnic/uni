import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static boolean tryParse(String str, int radix) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            br = new BufferedReader(new FileReader("input.txt"));
            bw = new BufferedWriter(new FileWriter("output.txt"));
            String line;
            float sum = 0;
            while((line=br.readLine())!=null){
                String smas[] = new String[100];
                StringTokenizer st = new StringTokenizer(line, " /n/,/;");
                int i = 0;
                int counter = st.countTokens();
                String[] numbers = new String[counter];
                int j = 0;
                int k = 0;
                while (st.hasMoreTokens()) {
                    // Получаем слово
                    smas[i] = st.nextToken();
                    if (tryParse(smas[i], 10)) {
                        sum += Double.parseDouble(smas[i]);
                    }
                    i++;
                }

            }
            if (sum != 0) {
                bw.write(sum + "\n");
            }
            else{
                bw.write("0");
            }
        } catch(IOException e){
            System.out.println("No such file");
        } finally{
            try{
                br.close();
                bw.close();
            }
            catch(IOException e){
                System.out.println("Error" + e);
            }
        }
    }
}


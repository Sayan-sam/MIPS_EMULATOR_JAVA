import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Main{
    public String[][] codes;
    public static void main(String[] args){

        File file = new File("D:\\Codes\\MIPS\\MIPS Using MIPS\\test.txt");
        try {
            Main m = new Main();
            m.fileRead(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    public String[][] fileRead(File file) throws FileNotFoundException
    {
        int lines = 0;
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
            {sc.nextLine();
            lines++;}
        codes = new String[lines][4];
        sc = new Scanner(file);

        for(int i = 0; i<lines; i++)
        {
            String temp[] = sc.nextLine().split(" ", 4);
            for(int j = 0; j < 4; j++)
            {
                codes[i][j] = temp[j];
            }
        }

        for(int i = 0; i < lines; i++)
        {
            for (int j = 0; j < 4; j++) {
                System.out.print(" "+codes[i][j]);
            }
            System.out.println();
        }

        return codes;
    }
}
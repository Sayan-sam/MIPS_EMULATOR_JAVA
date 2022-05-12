import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
class Main{
    public ArrayList<String>[] codes;
    public static void main(String[] args){
        
    }

    public void fileRead() throws FileNotFoundException
    {
        int lines = 0;
        File file = new File("D:\\Codes\\MIPS\\MIPS Using MIPS\\test.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
            {sc.nextLine();
            lines++;}
        codes = new ArrayList[lines];
        for(int i = 0; i < lines; i++)
        {
            codes[i] = new ArrayList<String>();
        }

        for(int i = 0; i<lines; i++)
        {
            String temp[] = sc.nextLine().split(" ", 3);
        }
    }
}
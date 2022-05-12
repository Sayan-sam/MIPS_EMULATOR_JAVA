import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class Main{
    public String[][] codes;
    public int[] register = new int[8];
    Main()
    {
        for(int i = 0; i < 8; i++)
        {  
            register[i] = 0;
        }
    }
    public static void main(String[] args){

        File file = new File("D:\\Codes\\MIPS\\MIPS_EMULATOR_JAVA\\test.txt");
        Main m = new Main();
        try {
            
            m.fileRead(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < m.codes.length; i++)
        {
            m.binToInstruction(m.codes[i]);
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

    public int binToRegister(String s)
    {
        switch(s)
        {
            case "10000001":
                return 0;
            case "10000010":
                return 1;
            case "10000011":
                return 2;
            case "10000100":
                return 3;
            case "10000101":
                return 4;
            case "10000110":
                return 5;
            case "10000111":
                return 6;
            case "10001000":
                return 7;
            default:
                return -1;
        }
    }

    public void binToInstruction(String[] arr)
    {
        switch(arr[0])
        {
            case "00000001":
                ADD(arr[1],arr[2],arr[3]);
            // case "00000010":
            //     return 1;
            // case "00000011":
            //     return 2;
            // case "00000100":
            //     return 3;
            // case "00000101":
            //     return 4;
            // case "00000110":
            //     return 5;
            // case "00000111":
            //     return 6;
            // default:
            //     return -1;
        }
    }

    public String decToBinary(int num)
    {
        String result = "";
        int  k = num;
        while(k != 0)
        {
            if(k%2 == 1)
            {
                result = "1"+result;
            }
            else if(k%2==0)
            {
                result = "0"+result;
            }
            k = k/2;
        }
        return result;
    }

    public String Adder(String )
    public String ADD(String s1, String s2, String s3)
    {

        register[1] = 5;
        register[2] = 4;
 
        register[binToRegister(s1)] = register[binToRegister(s2)] + register[binToRegister(s3)];
        System.out.println("R1: " + register[binToRegister(s1)]);
        System.out.println("R2: " + register[binToRegister(s2)]);
        System.out.println("R3: " + register[binToRegister(s3)]);
         
        return "";
    }
}
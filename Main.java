import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
class Main{


    public String[][] codes;
    public int[] register = new int[8];
    public int iterator;


    Main()
    {
        for(int i = 0; i < 8; i++)
        {  
            register[i] = 0;
        }
    }

    public static void main(String[] args){

        File file = new File("test.txt");
        Main m = new Main();
            
            try {
                m.fileRead(m.deCodeFile(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        for(m.iterator = 0; m.iterator < m.codes.length; m.iterator++)
        {
            m.binToInstruction(m.codes[m.iterator]);
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
        sc.close();
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
        if(arr[0].charAt(0) == '#')
            return;
        switch(arr[0])
        {
            case "00000001":
                ADD(arr[1],arr[2],arr[3]);
                break;
            case "00000010":
                ADDI(arr[1],arr[2],arr[3]);
                break;
            case "00000011":
                SUB(arr[1], arr[2], arr[3]);
                break;
            case "00000100":
                SUBI(arr[1], arr[2], arr[3]);
                break;
            case "00000101":
                MOV(arr[1], arr[2]);
                break;
            case "00000110":
                MOVI(arr[1], arr[2]);
                break;
            case "00000111":
                DISP(arr[1]);
                break;
            case "00001000":
                JMP(arr[1]);
                break;
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

    public int binToDecimal(String num)
    {
        return Integer.parseInt(num, 2);
    }

    public void ADD(String s1, String s2, String s3)
    {
        register[binToRegister(s1)] = register[binToRegister(s2)] + register[binToRegister(s3)];
    }

    public void SUB(String s1, String s2, String s3)
    {
        register[binToRegister(s1)] = Math.abs(register[binToRegister(s2)] - register[binToRegister(s3)]);
    }

    public void MOV(String s1, String s2)
    {
        register[binToRegister(s1)] = register[binToRegister(s2)]; 
    }

    public void MOVI(String s1, String s2)
    {
        register[binToRegister(s1)] = binToDecimal(s2);
    }

    public void ADDI(String s1, String s2, String s3)
    {
        register[binToRegister(s1)] = register[binToRegister(s2)] + binToDecimal(s3);
    }

    public void SUBI(String s1, String s2, String s3)
    {
        register[binToRegister(s1)] = register[binToRegister(s2)] - binToDecimal(s3);
    }

    public void DISP(String s1)
    {
        String output = "";
        int temp = binToRegister(s1);
        if(temp<= 3)
            output = output + "$S" + temp;
        else
        {
            output = output + "$t" + (temp-4);
        }
        System.out.println(output+":  "+register[temp]);
    }

    public void JMP(String label)
    {
        while(iterator > 0)
        {   iterator--;
            if(codes[iterator][0].equals(label))
                return;
        }
        System.out.println("Label Not Found!!");
        System.exit(0);
    }

    public File deCodeFile(File file) throws IOException
    {
        Scanner s = new Scanner(file);
        File output = new File("a.regi");
        FileWriter result = new FileWriter("a.regi");
        while(s.hasNextLine())
        {
            String[] temp = s.nextLine().split(" ", 2);
            if(temp.length == 1)
            {
                result.write(temp[0]);
                continue;
            }
            for(int i = 0; i < 2; i++)
            {
                temp[i] = temp[i].toUpperCase();
            }
            String[] temp2 = temp[1].split(",",3);
            result.write(temp[0]);
            for(int i = 0; i < temp2.length;i++)
            {
                result.write(" "+temp2[i].trim());
            }
            result.write("/n");
        }
        s.close();
        result.close();
        return output;
    }

    public String decodedString(String s)
    {

        switch(s)
        {
            case "ADD":
                return "00000001";
            case "ADDI":
                return "00000010";
            case "SUB":
                return "00000011";
            case "SUBI":
                return "00000001";
            case "MOV":
                return "00000001";
            case "MOVI":
                return "00000001";
            case "DISP":
                return "00000001";
            case "JMP":
                return "00000001";
            case "S0":
                return "00000001";
            case "S1":
                return "00000001";
            case "S2":
                return "00000001";
            case "S3":
                return "00000001";
            case "T0":
                return "00000001";
            case "T1":
                return "00000001";
            case "T2":
                return "00000001";
            case "T3":
                return "00000001";
            default:
                return "";
        }
    }


}
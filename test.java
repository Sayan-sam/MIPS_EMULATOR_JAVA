public class test {
    public static void main(String[] args) {
        String s = "Hello World this";
        String[] temp = s.split(" ",5);
        for(int i = 0; i < temp.length; i++)
        {
            System.out.println(temp[i]);
        }
    }   
}

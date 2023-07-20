import java.util.Random;

public class RandomPassGEn 
{
    public static void main(String[] args)
    {
        int length = 10;
        System.out.println(rand_Pass(length));
    }    
    static char[] rand_Pass(int len)
    {
        System.out.println("Generating password using random");
        System.out.println("Your new Password is :");
        String Capital_char = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_char = "abcdefghijklmnopqurstuvwxyz";
        String num = "0123456789";
        //String symbols = "!@#$%^&*()-_+=/<>";
        String values = Capital_char + Small_char + num ;//symbols;
        Random rand_method = new Random();
        char[] password = new char[len];
        for(int i = 0 ; i<len ; i++ )
        {
            password[i] = values.charAt(rand_method.nextInt(values.length()));
        }
        return password;
    }
}

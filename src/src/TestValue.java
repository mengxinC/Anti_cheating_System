import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

public class TestValue
{
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
//        var r1 = SecureRandom.getInstance("SHA1PRNG");
//        var r2 = SecureRandom.getInstance("PKCS11");

        var r3 = SecureRandom.getInstance("DRBG");
        var r4 = SecureRandom.getInstance("Windows-PRNG");
        var r5 = SecureRandom.getInstance("SHA1PRNG");
//        System.out.println(r1.toString());
//        System.out.println(r2.toString());
        System.out.println(r3.nextInt());
        r3.setSeed(r5.generateSeed(8));
//        System.out.println(r3);
//        System.out.println(r4);
//        System.out.println(r5);
//        System.out.println(Arrays.toString(Security.getProviders()));
//        System.out.println(Arrays.toString(r3.generateSeed(10)));
        System.out.println(r3.nextInt());
        System.out.println(r3.nextInt());
        System.out.println(r4.nextInt());
        System.out.println(r5.nextInt());
        System.out.println(SecureRandom.getInstanceStrong().nextInt());
    }
}

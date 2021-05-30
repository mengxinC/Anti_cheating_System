import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author 千年
 * @version 1.0.0
 * @since 2021-5-30
 */
public class Test
{
    public Test() throws NoSuchAlgorithmException
    {
    }

    public static void main(String[] args) throws NoSuchAlgorithmException
    {

        final var data = new Test();
        var in = new Scanner(System.in);
        var mode = 0;
        while (true)
        {
            System.out.println("请选择模式: 1.直接查看数据   2.通过公共api查看数据   3.正常修改value   4.恢复被修改的value   5.输出一个随机数");
            mode = in.nextInt();
            switch (mode)
            {
                case 1:
                    System.out.println("-".repeat(65));
                    System.out.println("key:" + data.key);
                    System.out.println("真实的value: " + (data.value ^ data.key));
                    System.out.println("存储的value: " + data.getStoredValue());
                    System.out.println("-".repeat(65));
//                    System.out.println("现在的value: " + (data.key ^ data.valueLock));
                    break;
                case 2:
                    System.out.println("-".repeat(65));
                    System.out.println("真实的value: " + data.getActualValue());
                    System.out.println("-".repeat(65));
                    break;
//                    System.out.println("现在的value: " + (data.getKey() ^ data.getValueLock()));
                case 3:
                    System.out.println("-".repeat(65));
                    System.out.print("模拟正常修改: ");
                    try
                    {
                        data.setValue(in.nextInt());
                    }
                    catch (InputMismatchException e)
                    {
                        System.out.println("您的输入超过上限, 请重新输入");
                    }

                    System.out.println("正常修改后的value:" + data.getActualValue());
                    System.out.println("-".repeat(65));
                    break;
                case 4:
                    System.out.println("暂停");
                    break;
                case 5:
                    System.out.println("-".repeat(65));
                    System.out.println(ThreadLocalRandom.current().nextInt());
                    System.out.println("-".repeat(65));
                    break;
                default:
                    System.out.println("错误, 请重新输入");
                    break;
            }
        }
    }

//    private int value = ThreadLocalRandom.current().nextInt();
    private final SecureRandom v = SecureRandom.getInstance("Windows-PRNG");
    private final int key = v.nextInt();


    private int value = 100 ^ key;

    public int getActualValue()
    {
        return value ^ key;
    }

    public int getStoredValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value ^ key;
    }

    public int getKey()
    {
        return key;
    }

//     public int getActualValue()
//     {
//        return valueLock ^ key;
//     }
}

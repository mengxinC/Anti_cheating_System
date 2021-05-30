import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author 千年
 * @version 1.0.0
 * @since 2021-5-30
 */
public class Test
{
    public static void main(String[] args)
    {
        final var data = new Test();
        var in = new Scanner(System.in);
        var mode = 0;
        while (true)
        {
            System.out.println("请选择模式: 1.直接查看数据   2.通过公共api查看数据   3.正常修改value");
            mode = in.nextInt();
            switch(mode)
            {
                case 1:
                    System.out.println("-".repeat(65));
                    System.out.println("现在的valueLock: " + data.valueLock);
                    System.out.println("现在的value: " + data.value);
//                    System.out.println("现在的value: " + (data.key ^ data.valueLock));
                    break;
                case 2:
                    System.out.println("-".repeat(65));
                    System.out.println("现在的valueLock: " + data.getValueLock());
                    try
                    {
                        System.out.println("现在的value: " + data.getValue());
                    }
                    catch (VariableModificationException e)
                    {
                        System.out.println("检测到异常修改数据");
                    }
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

                    try
                    {
                        System.out.println("正常修改后的value:" + data.getValue());
                    }
                    catch (VariableModificationException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("错误, 请重新输入");
                    break;
            }

//            System.out.print("模拟非法修改: ");
//
//            try
//            {
//                data.value = in.nextInt();
//            }
//            catch (InputMismatchException e)
//            {
//                System.out.println("您的输入超过上限, 请重新输入");
//            }

//            try
//            {
//                System.out.println("非法" + data.getValue());
//            }
//            catch (VariableModificationException e)
//            {
//                System.out.println("不允许的修改");
//            }
        }
    }

//    private int value = ThreadLocalRandom.current().nextInt();
    private int value = 100;
    private final int key = 3275851;
    private int valueLock = value ^ key;

    public int getValue() throws VariableModificationException
    {
        if ((valueLock ^ key) != value)
        {
            throw new VariableModificationException("疑似作弊!!!");
        }
        return value;
    }

    public void setValue(int value)
    {
        valueLock = value ^ key;
        this.value = value;
    }

    public int getKey()
    {
        return key;
    }

    public int getValueLock()
    {
        return valueLock;
    }

    public void setValueLock(int valueLock)
    {
        this.valueLock = valueLock;
    }
}

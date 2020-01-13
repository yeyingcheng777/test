import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author cyf
 * 2020/1/13
 */

public class RandomTest {
    public static void main(String[] args) {
        int number = 100;
        Random random = new Random();
        String[] n = new String[100];
        int m ;
        for (int i = 0;i < number;i++){
            m = random.nextInt(number);
            n[i] = "第"+ i +"个是" + m;
        }
        File file = new File("D:/dev/test/RandomTest.txt");
        if (!file.exists()){
            try {
                boolean exist = file.createNewFile();
                if (exist){
                    System.out.println("创建该文件");
                }
                FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (String s: n) {
                    bufferedWriter.write(s);
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("失败");
            }
        }
    }
}

import java.io.RandomAccessFile;

public class RandomFile {
    public static void main(String[] args) {
        String path = "D:/data.txt";
        int pointe = 0;
        RandomAccessFile randomAccessFile;

        {
            try {
                randomAccessFile = new RandomAccessFile(path,"r");
                //获取RandomAccessFile对象文件指针的位置，初始位置是0
                System.out.println("RandomAccessFile文件指针的初始位置:"+randomAccessFile.getFilePointer());
                //移动文件指针位置
                randomAccessFile.seek(pointe);
                byte[] buff = new byte[1024];
                //用于保存实际读取的字节数
                int hasRead = 0;
                //循环读取
                while ((hasRead=randomAccessFile.read(buff))>0){
                    System.out.println(new String(buff,0,hasRead));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

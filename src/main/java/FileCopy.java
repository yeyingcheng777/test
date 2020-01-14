import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String postfix = "jpg";
        File startFile = new File("E:/picture/2.jpg");
        String startFileName = startFile.getName();
        String start = startFile.getPath();
        //从   .开始取
        int position = startFileName.indexOf(".");
        //后缀名从.的后一位开启
        String suffixName = startFileName.substring(position+1);
        try {
            if (suffixName.equals(postfix)){
                BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(start));
                BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream("E:/picture/3"+"."+suffixName));
                int len;
                //判断是否读取完毕
                while ((len = fileInputStream.read())!=-1){
                    fileOutputStream.write(len);
                }
                fileOutputStream.close();
                fileInputStream.close();
            }else {
                BufferedReader br = new BufferedReader(new FileReader(start));
                BufferedWriter bw = new BufferedWriter(new FileWriter("E:/picture/FileCopy"+"."+suffixName));
                String line;
                while ((line = br.readLine())!=null){
                    bw.write(line);
                }
                bw.close();
                br.close();
            }
        }catch (IOException e){
            System.out.println("失败");
        }

    }
}

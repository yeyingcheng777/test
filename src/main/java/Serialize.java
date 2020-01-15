import java.io.*;

/**
 * @author cyf
 */
public class Serialize {
    private static String filePath = "D:\\student.txt";
    public static void  SerializeStudent(Student student)throws FileNotFoundException, IOException {
        //把输出流存到本地
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
    }
    public static Student DeserializeStudent()throws ClassNotFoundException,IOException {
        //将文本内的东西输入进来，输入流，反序列
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        Student student = (Student) objectInputStream.readObject();
        objectInputStream.close();
        return student;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //对象序列化
        Student student = new Student("1","小明","男","18");
        SerializeStudent(student);
        //对象反序列化
        Student student1 = DeserializeStudent();
        System.out.println(student1);

    }
}

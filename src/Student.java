import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Student implements Comparable<Student>{
	private Integer num;
	private String name;
	private Integer age;
	//ʡ��getter��setter����
	//ʡ�Թ��췽��
	public int compareTo(Student stu) {
		return this.age-stu.age;
	}
	public String toString() {
		return "Student [age=" + age + ", name=" + name + 
", num=" + num + "]";
	}
}
public class Test {
	public static void main(String[] args) {
		Set<Student> stuSet = saveStudentInfo();
		outputInfo(stuSet);
	}
	private static Set<Student> saveStudentInfo() {
		Scanner input = new Scanner(System.in);
		// ����ѧ����Ϣ��TreeSet���϶���
		Set<Student> stuSet = new TreeSet<Student>();
		while (true) {
			// ������ʾ
			System.out.println("������ѧ����Ϣ:(ѧ��#����#����)");
			String inputData = input.nextLine();
			// �ж��Ƿ��˳� inputData.equals("exit")
			if ("exit".equals(inputData)) {
				break;
			}
			// ���û������ѧ����Ϣ�ָ�ΪString[]
			String[] info = inputData.split("#");
			// ��������Ϣ��װ��Student������
			Student stu = new Student(Integer.parseInt(info[0]), info[1],Integer.parseInt(info[2]));
			// ��ѧ��������뼯��
			stuSet.add(stu);
		}
		return stuSet;
	}
	private static void outputInfo(Set<Student> stuSet) {
		File file = new File("e:/student.txt");
		// �����ļ����������
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			Iterator<Student> it = stuSet.iterator();
			while (it.hasNext()) {
				String info = it.next().toString();
				// ��info�ַ�����д����±�
				fw.write(info);
				// ��ɻ��й���
				fw.write("\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
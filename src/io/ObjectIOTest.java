package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

import com.my.dto.Product;

class A implements Serializable{ // 객체직렬화를 위해서 구현해야함.
	int i;
	A(int i){
		this.i = i;
	}
}

public class ObjectIOTest {
	public static void write(String fileName) {
		/*
		 * dest : fileName
		 * node stream: FileOutputStream
		 * filter stream : ObjectOutputStream
		 */
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
//			oos.writeObject(new Date());
//			A a =new A(7);
//			oos.writeObject(a);
			
			Product p = new Product("D0001", "아메리카노", 1000);
			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void read(String fileName) {
		/*
		 * filename 
		 * FileInputStream
		 * ObjectInputStream
		 */
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			Object obj = ois.readObject();
			System.out.println(obj);
			
			Object obj1 = ois.readObject();
			A a = (A)obj1;
			System.out.println(a.i);
			
//			Product p = (Product)ois.readObject();
			Object obj2 = ois.readObject();
			System.out.println(obj2.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("객체쓰기 -1, 객체읽기 -2, 종료 -9");
		int opt = sc.nextInt();
		String fileName = "a.ser";
		switch(opt) {
		case 1:
			write(fileName);
			break;
		case 2:
			read(fileName);
			break;
			
		}
	}

}

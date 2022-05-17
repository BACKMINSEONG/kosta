package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {
	public static void readnWriteByChar() {
		/*
		 * resource : a.txt
		 * node stream : FileReader
		 */
		String fileName = "a.txt";
		FileReader fr = null;
		/*
		 * dest : acopy1.txt
		 * node stream : FileWriter
		 */
		String copyFileName = "acopy1.txt";
		FileWriter fw = null;
		try {
			fr = new FileReader(fileName);
			fw = new FileWriter(copyFileName);
			int readValue = -1;
			while((readValue = fr.read()) != -1) {
				fw.write(readValue);
			}
//			fw.flush(); //jvm 내부 버퍼에 적은것들을내보내라
//			fw.close(); // flush() ; + 연결 끊기 가 포함되어있는 메서드. 따라서 finally구문에 적절한 위치.
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fr != null) { // fr = new FileReader(fileName); ㅇ여기서 오류날때를 위해 작성.
				
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void readNWrite() {
		/*
		 * resource: a.txt 파일
		 * noed stream: FileInpustStream
		 */
		String fileName = "a.txt";
		//"직접 위치를 찍는것 은 절대경로라고한다"
		//"..\\..\\a.txt"; // 부모의 부모경로를 찾을때 상대경로.현재경로..상위경
		FileInputStream fis = null;
		/*출력
		 * dest : acopy.txt
		 * node stream : FileOutputStream
		 */
		String copyFileName = "a.txt";
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(fileName); // 파일 자원과의 연결
//			fos = new FileOutputStream(copyFileName); // 파일 목적지와의 연결 파일이 만들어짐.
			fos = new FileOutputStream(copyFileName, true); //파일이 존재하면  파일의 끝에 이어짐.
			
			int readValue = -1;
			while((readValue =	fis.read()) != -1) {
//				System.out.println((char)readValue);
				fos.write(readValue);
			}
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("a.txt파일이 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		readNWrite();
		readnWriteByChar();
	}

}

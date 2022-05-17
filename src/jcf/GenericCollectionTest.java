package jcf;

import java.util.ArrayList;
import java.util.List;
/**
 * Element Generic
 * @author minseong
 *
 */
public class GenericCollectionTest {

	public static void main(String[] args) {
		List list1;
		List<String> list2;
	
		list1 = new ArrayList();
		list2 = new ArrayList<>();
		
		list1.add(new String("ABC"));
		list1.add(new Integer(1));
		list1.add(true);
		String s1 = (String)list1.get(0); // 정상 실
		String s2 = (String)list1.get(1); // ClassCastException 발생,프로그램 종료
		String s3 = (String)list1.get(2);
		
		
		list2.add(new String("ABC"));
		list2.add("DEF");
//		list2.add(new Integer(1)); String자료만 저장가능.
	
	
	}

}

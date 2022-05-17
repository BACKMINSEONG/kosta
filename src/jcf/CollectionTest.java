package jcf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

class A{
	int i;
	A(int i){
		this.i = i;
	}
	@Override
	public int hashCode() {
		return Objects.hash(i);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		return i == other.i;
	}
	@Override
	public String toString() {
		return "A [i=" + i + "]";
	}
	
	
}

public class CollectionTest {
	public static void test(Collection c) {
		c.add(new String("one")); // add()의 매개변수 타입은 Object 이다. 
		c.add(new Integer(2)); // Integer가 Object로 업캐스팅
		c.add(3); // 컴파일 시에 c.add(new Integer(3));로 오토박싱 됨.
		c.add(2); //autoboxing
		c.add(new A(5)); 
		c.add(new A(5)); 
		
		
		System.out.println("자료수 :"+ c.size());
		System.out.println(c); // c.toString()자동호출
	}
	public static void test(Map m) {
		m.put("one", "first");
		m.put(new Integer(2), "second");
		m.put(3, "third");
		m.put(2, "fourth");
		m.put(new A(5), "fi");
		m.put(new A(5), "si");
		
		
		System.out.println("자료수 :" + m.size());
		System.out.println(m);
	}
	public static void main(String[] args) {
//		List list = new ArrayList();
//		test(list);
		test(new ArrayList());
		test(new HashSet());
		test(new HashMap()); // HashMap 은 collection 으로 형변환 안됨.
		
		
		
	}

}

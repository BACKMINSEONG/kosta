//import java.util.Scanner;

public class StringEx {

	public static void main(String[] args) {
		
		String s1 = new String("가나다");
		String s2 = new String("가나다");
		String s3 = "가나다";
		String s4 = "가나다";
		System.out.println(s1 == s2); // f
		System.out.println(s1 == s3); // f
		System.out.println(s3 == s4); // t
		
		System.out.println(s1.equals(s2)); //t
		System.out.println(s1.equals(s3)); // t
		System.out.println(s1.equals(s4));// t
		
		System.out.println(s1+"라마");
		s1.substring(1, 3); // 1번 인덱스부터 2번인덱스 까지임
		System.out.println(s1.substring(1, 3)); // 나다
		s1 += "라마"; // s1 = s1 + "라마";
		char c = s1.charAt(0);
		System.out.println(c);//가
//		System.out.println(s1.charAt(c));
		int size = s1.length();
		System.out.println(size); //5
		
		// Palindrome 문자열 : 가나다나가 ABBA
//		System.out.println("입력해라");
//		Scanner sc = new Scanner(System.in);
//		String palindrome = new String();
		String palindrome = "가나다나가";
//		String palindrome = "ABBA";
//		String palindrome = "가나다마나";
//		
		int half = palindrome.length()/2;
		int j = palindrome.length()-1;
		int i = 0;
		for(i = 0; i<half; i++,j--) {
			
			if(palindrome.charAt(i) != palindrome.charAt(j)) {
				System.out.println("no");
				return;
			}
		
		}
		System.out.println("yes");
		
		String str = "https://www.youtube.com/watch?v=3cqJz9hIPD8&list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp&index=107";
		String hostName;
		String path;
		String queryString;
		
		String regex = "\\?";
		/*
		 * regex = regular expresion 은 정규 표현식이다. 따라서 ? 를 사용할수 없고 문자열 임을 알리기위해 '/'를 넣어준다.
		 */
		int limit = 2;
		
		String[]arr = str.split(regex,limit); // ?기준으로 두번 자른다.
		System.out.println(arr[0]);
		if(arr.length >= 2 ) {
			System.out.println(arr[1]);
		}
		String hostNamePath = arr[0];
		System.out.println(hostNamePath.indexOf(":"));//5 https
		System.out.println(hostNamePath.indexOf("/",5+3));//23 https://www.youtube.com
		
		int startIndex = hostNamePath.indexOf(":")+3; // https:// 부터 시작index
		int endIndex = hostNamePath.indexOf("/",startIndex); // 
		hostName = hostNamePath.substring(startIndex, endIndex);
		path = hostNamePath.substring(endIndex+1);
		
		System.out.println(hostName);
		System.out.println(path);
		queryString = arr[1];
		
		String[] queryStringArr = queryString.split("&");
		for(int i1 = 0; i1<queryStringArr.length; i1++) {
			String q = queryStringArr[i1];
			String[] qArr = q.split("=", 2);
			String qName = qArr[0];
			String qValue = qArr[1];
			System.out.println("쿼리스트링 이름은"+qName+",값은"+qValue);
			
			
		}
		
		
		
				
		
	}

}

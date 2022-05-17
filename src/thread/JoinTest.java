package thread;
class Join extends Thread{
	int begin,end;
	int sum;
	Join(int begin, int end){
		this.begin = begin;
		this.end = end;
	}
	public void run() {
		for(int i = begin; i <= end; i++) {
			sum+=i;
		}
	}
}
public class JoinTest {

	public static void main(String[] args) {
		Join j1 = new Join(1,10);
		j1.start();
		try {
			j1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(j1.begin +"부터 "+j1.end+"의 합은"+j1.sum);
	}

}

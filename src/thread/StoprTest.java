package thread;

import java.util.Scanner;

class Stop extends Thread{
	int max;
	int cnt;
	Stop(){
		cnt = 0;
		max = 1000000;
	}

	public void run() {
		for(; cnt < max; cnt++) {
			System.out.println(cnt + "running");
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("stop");
	}
}	
public class StoprTest {
	public static void main(String[] args) {
		Stop st = new Stop();
		st.start();
		if(st.cnt > 20) {
			st.max = 0;
		}
		Scanner sc = new Scanner(System.in);
		st.max = sc.nextInt();
	}
	
} 

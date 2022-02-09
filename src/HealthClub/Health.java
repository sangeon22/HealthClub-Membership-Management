package HealthClub;

import java.awt.EventQueue;

public class Health {
	public static void main(String[] args) {

		int i=0;
		int sum = 0;
		while(i<10){
			i++;
			if(i%2==1)
				continue;
			sum += i;
		}
		System.out.println(sum);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

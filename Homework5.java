import javax.swing.*;
import java.awt.*;
import java.time.*;

public class Homework5 extends JPanel{
	int Width=600;
	int Height=600;
	public Homework5() {
		JFrame homework5= new JFrame();
		homework5.getContentPane().add(this);
		homework5.setSize(Width, Height);
		homework5.setTitle("clock");
		homework5.setVisible(true);
		homework5.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Width, Height);
		g.setColor(Color.yellow);
		g.fillOval(150, 150, 300, 300);
		LocalDateTime now = LocalDateTime.now();
		int r=130;
		int x=235;
		int s=90-now.getSecond()*6;
		int m=90-now.getMinute()*6;
		int h=90-now.getHour()*30;
		//초침,분침,시
		g.setColor(Color.blue);
		g.fillArc(x-40, x-40, r+80, r+80, m, -5);
		g.setColor(Color.orange);
		g.fillArc(x-15, x-15, r+30, r+30, s, -3);
		g.setColor(Color.red);
		g.fillArc(x, x, r, r, h, -9);
		//눈금 3,6,9,12
		int X1=370;
		int Y1=260;
		g.setColor(Color.pink);
		g.fillArc(X1, Y1, 80, 80, 3, -5);//3
		g.fillArc(X1-110, Y1+110, 80, 80, 273, -5);//6
		g.fillArc(X1-220, Y1, 80, 80, 183, -5);//9
		g.fillArc(X1-110, Y1-110, 80, 80, 93, -5);//12
		//눈금 1,4,7,10
		int X2=325;
		int Y2=163;
		g.setColor(Color.pink);
		g.fillArc(X2, Y2, 60, 60, 63, -5);//1
		g.fillArc(X2+50, Y2+155, 65, 60, 333, -5);//4
		g.fillArc(X2-110, Y2+215, 60, 60, 243, -5);//7
		g.fillArc(X2-165, Y2+60, 60, 60, 153, -5);//10
		//눈금 2,5,8,11
		int X3=375;
		int Y3=210;
		g.setColor(Color.pink);
		g.fillArc(X3, Y3, 60, 60, 33, -5);//2
		g.fillArc(X3-45, Y3+162, 65, 60, 303, -5);//5
		g.fillArc(X3-210, Y3+120, 60, 60, 213, -5);//8
		g.fillArc(X3-180, Y3-35, 60, 60, 123, -5);//11
		//디지털 시계
		int hour=now.getHour();
		int minute=now.getMinute();
		int second=now.getSecond();
		String time=(hour+":"+minute+":"+second);
		g.setColor(Color.yellow);
		g.drawString(time, 10, 30);
		int year=now.getYear();
		int month=now.getMonthValue();
		int day=now.getDayOfMonth();
		String Year=(year+"."+month+"."+day);
		g.drawString(Year, 520, 550);
	}
	public static void main(String[] args) {
		new Homework5();
	}
}

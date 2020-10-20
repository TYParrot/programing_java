import javax.swing.*;
import java.awt.*;

public class DiceWriter extends JPanel{
	private int WIDTH=500;
	private int HEIGHT=400;
	String WINNER="";
	String name1="";
	String name2="";
	private int num1;
	private int num2;
	private int num3;
	private int num4;
	
	public DiceWriter() {
		JFrame f=new JFrame();
		f.getContentPane().add(this);
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
		f.setTitle("DICE");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawString("두 참여자가 2개의 주사위를 각각 던집니다.", 0, 15);
		g.drawString("주사위 두개가 같은 수가 나오면 승리하고, 둘 다 같은 수 이면 큰 수가 이깁니다.", 0, 30);
		g.drawString("다른 수 끼리는 두 주사위의 합이 크면 승리합니다.", 0, 45);
		g.drawString("합이 동률인 경우에는 두 수의 차이가 작으면 승리합니다.", 0, 60);
		g.drawString("두 수의 차이도 동률이면 무승부입니다.",0,75);
		g.drawString(WINNER, 170, 300);
		g.drawString(name1+"의 주사위 번호는", 50, 200);
		g.drawString(name2+"의 주사위 번호는", 250, 200);
		g.drawRect(70, 230, 20, 20);
		g.drawString(""+num1, 77, 244);
		g.drawRect(95, 230, 20, 20);
		g.drawString(""+num2, 102, 244);
		g.drawRect(275, 230, 20, 20);
		g.drawString(""+num3, 282, 244);
		g.drawRect(300, 230, 20, 20);
		g.drawString(""+num4, 307, 244);
		
	}
	
	public void showWinner(String winner, String name1, String name2) {
		if(winner=="A") 
			WINNER=name1+"가 우승했습니다.";
		else if(winner=="B")
			WINNER=name2+"가 우승했습니다.";
		else if(winner=="S")
			WINNER="무승부입니다.";
		this.repaint();
	}
	
	public void showNum1(int number1, int number2) {
		num1=number1;
		num2=number2;
		this.repaint();
	}

	public void showNum2(int number1, int number2) {
		num3=number1;
		num4=number2;
		this.repaint();
	}
	
	public void playerName(String player_name1, String player_name2) {
		name1=player_name1;
		name2=player_name2;
		this.repaint();
	}
}

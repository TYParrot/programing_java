import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
public class BankWriter extends JPanel {
	
	private int WIDTH=300;
	private int HEIGHT=200;
	private BankAccount bank;
	String last_transaction="";
	/*BankWriter-출력기 초기화
	 * @param title
	 * @param b*/
	public BankWriter(String title, BankAccount b) {
		bank=b;
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle(title);
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		int text_margin = 50;
		int text_baseline=50;
		g.drawString(last_transaction, text_margin, text_baseline);
		g.drawString("잔액 = " + bank.getBalance()+"원", text_margin, text_baseline+20);
	}
	
	/*showTransaction-거래 결과 표시
	 * @param message - 거래 메세지
	 * @param account - 거래 금액 */
	public void showTransaction(int amount, String message) {
		last_transaction=message;
		this.repaint();
	}
	/*showTransaction-거래 결과 표시
	 * @param message - 거래 메세지 */
	public void showTransaction(String message) {
		last_transaction=message;
		this.repaint();
	}
	
	
	
}

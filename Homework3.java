import java.awt.*;
import javax.swing.*;

public class Homework3 extends JPanel{
	private int width;
	private int height;
	
	public Homework3(int w, int h) {
		width=w;
		height=h;
		
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setSize(width, height);
		f.setTitle("꽃밭");
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public void paintComponent(Graphics g){
		g.setColor(Color.green);
		g.fillRect(0, 0, width, height);
		drawFlower(g, 70, 80, 30, Color.orange, Color.blue);
		drawFlower(g, 110, 260, 70, Color.cyan, Color.white);
		drawFlower(g, 200,100, 50, Color.pink, Color.red);
		drawFlower(g, 340, 300, 90, Color.yellow, Color.black);
		
	}
	
	/*꽃 그리는 메소드
	 *@param1-g 그래픽스 펜
	 *@param2-x,y,r-위치,원의 크기
	 *@param3-c1,c2-꽃의 크기*/
	public void drawFlower(Graphics g, int x, int y, int r, Color c1, Color c2) {
		drawPetal(g, x-r/2, y-r/2, 2*r, 50, c2);
		g.setColor(c1);
		g.fillOval(x, y, r, r);
		g.setColor(Color.black);
		g.drawOval(x, y, r, r);
	
	}
	
	/*꽃잎 그리는 메소드
	 *@param1-g 그래픽스 펜
	 *@param2-x,y,r-위치, 타원의 크기
	 *@param3-angle-타원의 각도
	 *@param4-color-꽃잎의 색*/
	private void drawPetal(Graphics g, int x, int y, int r, int angle, Color color) {
		g.setColor(color);
		int p=36;
		//위치, 위치, 너비, 너비, 시작위치, 각도
		g.fillArc(x, y, r, r, p, angle);
		g.fillArc(x, y, r, r, 3*p, angle);
		g.fillArc(x, y, r, r, 5*p, angle);
		g.fillArc(x, y, r, r, 7*p, angle);
		g.fillArc(x, y, r, r, 9*p, angle);
		g.setColor(Color.black);
		g.drawArc(x, y, r, r, p, angle);
		g.drawArc(x, y, r, r, 3*p, angle);
		g.drawArc(x, y, r, r, 5*p, angle);
		g.drawArc(x, y, r, r, 7*p, angle);
		g.drawArc(x, y, r, r, 9*p, angle);
	}
		

}

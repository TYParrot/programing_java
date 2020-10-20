import java.awt.*;
import javax.swing.*;
public class Bull extends JPanel{
	private int Panel_width;
	private int ring_number;
	private int ring_size;//반지름
	private int position=20;

	public Bull(int number_of_rings, int total_size) {
		Panel_width=total_size+37;//total_size가 지름이니까.
		ring_number=number_of_rings;
		ring_size=total_size;
		
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("Bull's Eye");
		f.setSize(Panel_width+16,Panel_width+36);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(0, 0, Panel_width,Panel_width);
		drawCircle(ring_number, ring_size, position, position, g);
		//가로, 세로 20씩 띄고 시작.
	}
	
	private void drawCircle(int ring_number, int ring_size/*지름*/, int x_position, int y_position, Graphics g) {
		int count=0;
		int diameter=ring_size;
		int panel_width=ring_size/ring_number;
		Color c=Color.red;
		while(count != ring_number) {
			g.setColor(c);
			int new_x_position=x_position+panel_width*count/2;
			int new_y_position=y_position+panel_width*count/2;
			g.fillOval(new_x_position, new_y_position, diameter, diameter);
			if(c==Color.red) 
				c=Color.white;
			else 
				c=Color.red;
			count=count+1;
			diameter=diameter-panel_width;
		}
	}
	
	public static void main(String[] args) {
		new Bull(10,300);
	}

}

import java.awt.*;
import javax.swing.*;

public class ChessBoardWriter extends JPanel{
	private int square_size;//정사각형 사이즈
	private int number;//행열 개수
	private int panel_size;
	private int offset=20;
	public ChessBoardWriter(int number_of_rows, int size_of_square) {
		square_size=size_of_square;
		number=number_of_rows;
		panel_size=square_size*number+offset*2;
		
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("Chess Board");
		f.setSize(panel_size+16,panel_size+36);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(0, 0, panel_size, panel_size);
		chessWriter(offset, offset, square_size, number, g);
	}
	
	private void chessWriter(int start_x, int start_y, int size_of_square, int number_of_rows, Graphics g) {
		int y_position=start_y;	
		for(int x=0; x<number; x=x+1) {	
			int x_position=start_x;
			for(int y=0; y<number; y=y+1) {
				if((x+y)%2==0)
					g.setColor(Color.white);
				else
					g.setColor(Color.cyan);
				g.fillRect(x_position, y_position, square_size, square_size);
				x_position=x_position+size_of_square;
			}
			y_position=y_position+size_of_square;
		}
	}
	public static void main(String[] args) {
		new ChessBoardWriter(8,40);
	}

}

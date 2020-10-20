import javax.swing.*;
import java.awt.*;

/*문장을 디스플레이할 그래픽스 윈도를 만듬*/
public class MyWriter extends JPanel {
	private int width;
	private int height;
	private String sentence;
	private int x_position, y_position;
	
	/*MyWriter- 가로 w픽셀, 세로 h픽셀 크기의 창을 생성
	 * @param w-창의 너비
	 * @param h-창의 높이 */
	public MyWriter(int w, int h) {
		width=w;
		height=h;
		x_position=width/5;
		y_position=height/2;
		sentence="hello";
		
		JFrame writer = new JFrame();
		writer.getContentPane().add(this);
		writer.setTitle("My WRITER");
		writer.setSize(width+13, height+37);
		writer.setVisible(true);
		writer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	/* paintComponent-화가 메소드
	 * @param g- 그래픽스 펜 */
	public void paintComponent(Graphics g) {
		makeBorder(g);
		g.setColor(Color.pink);
		g.drawString(sentence, x_position, y_position);	
		
	}
	
	/*makeBorder-창에 테두리 두르기
	 * @param pen-그래픽스 펜 */
	private void makeBorder(Graphics pen) {
		pen.setColor(Color.blue);
		pen.fillRect(0, 0, width, height);
		pen.setColor(Color.white);
		int size = 15;
		pen.fillRect(size, size, width-2*size, height-2*size);
	}
	
	/*writeSentence-s를 출력
	 * @param s- 출력할 문자열 */
	public void writeSentence(String s) {
		sentence=s;
		this.repaint();
	}

	/*positionSentence-위치를 (x,y)로 설정하고 그 위치에 출력
	 * @param x-x좌표
	 * @param y-y좌표 */
	public void positionSentence(int x, int y) {
		x_position=x;
		y_position=y;
		this.repaint();
	}

}

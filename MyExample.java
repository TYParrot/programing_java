import javax.swing.JOptionPane;

public class MyExample {
	public static void main(String[] args) {
		MyWriter w = new MyWriter(300,200);
		String s=JOptionPane.showInputDialog("보고 싶은 단어를 넣어 주세요.");
		w.writeSentence(s);
		w.positionSentence(120, 90);
		
		

	}

}

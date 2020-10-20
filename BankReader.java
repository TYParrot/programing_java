import javax.swing.*;

public class BankReader {
	private String input_line="";
	public char readCommand(String message) {
		input_line=JOptionPane.showInputDialog(message);
		return input_line.charAt(0);//0번째 string 반환
	}
	
	public int readAmount() {
		String s = input_line.substring(1);//맨 앞의 문자부터 쭉 
		s.trim();//공백 삭제
		int amount=0;
		if(s.length()>0)
			amount=Integer.parseInt(s);
		else
			JOptionPane.showMessageDialog(null, "금액 입력 오류");
		return amount;
	}
	

}

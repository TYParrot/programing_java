import javax.swing.*;
public class DiceController {
	
	public static void main(String[] args) {
		String name1=JOptionPane.showInputDialog("플레이어1의 이름을 입력해주세요.");
		String name2=JOptionPane.showInputDialog("플레이어2의 이름을 입력해주세요.");	
		DiceWriter dw= new DiceWriter();
		Dice d = new Dice();
		int num1=d.throwDice();
		int num2=d.throwDice();
		int num3=d.throwDice();
		int num4=d.throwDice();
		dw.playerName(name1, name2);
		dw.showNum1(num1, num2);
		dw.showNum2(num3, num4);
		String message=d.compare(num1,num2,num3,num4);
		dw.showWinner(message, name1, name2);
	}

}

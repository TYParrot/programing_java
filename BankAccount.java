import javax.swing.*;
public class BankAccount{
	private int balance;//Invariant: balance >=0
	
	/*BankAccount-계좌 계설
	 *@param initial_amount-초기 입금액(0이상 정수)*/
	public BankAccount(int initial_amount){
		if(initial_amount>=0)
			balance=initial_amount;
		else
			balance=0;
	}
	
	/* deposit-계좌에서 돈 입금
	 * @param amount-입금 금액(0이상 정수) 
	 * @return 입금 성공하면-true, 실패하면-false*/
	public boolean deposit(int amount) {
		if(amount>=0){
			balance=balance+amount;
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "입금액에 문제가 있어서 입금이 취소되었습니다.");
			return false;
		}
	}
	
	/*withdraw-계좌에서 돈 출금
	 * @param amount-출금 금액(0이상 정수, balance보다 작거나 같음) 
	 * @return 출금 성공하면-true, 실패하면-false*/
	public boolean withdraw(int amount) {
		if(amount<0) {
			JOptionPane.showMessageDialog(null, "출금액에 문제가 있어서 출금이 취소되었습니다.");
			return false;
		}
		else if(amount>balance) {
			JOptionPane.showMessageDialog(null, "출금액에 문제가 있어서 출금이 취소되었습니다.");
			return false;
		}
		else {
			balance=balance-amount;
			return true;
		}
		
	}
	
	/*getBalance-계좌에 돈이 얼마나 있는지 참조*/
	public int getBalance() {
		return balance;
	}
	
}

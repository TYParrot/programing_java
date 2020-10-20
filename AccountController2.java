
public class AccountController2 {
	private BankReader reader;
	private BankWriter primary_writer;
	private BankWriter secondary_writer;
	private BankAccount primary_account;
	private BankAccount secondary_account;
	private BankWriter writer;
	private BankAccount account;
	public int hwal=1;//활성화 계좌가 primary_account일 때
	
	public AccountController2(BankReader r, BankWriter w1, BankAccount a1, BankWriter w2, BankAccount a2) {
		reader=r;
		primary_writer= w1;
		secondary_writer =w2;
		primary_account =a1;
		secondary_account=a2;
		account= primary_account;
		writer = primary_writer;	
		
	}
	
	private void resetAccount(BankAccount new_account, BankWriter new_writer) {
		writer.showTransaction("비활성");
		account= new_account;
		writer = new_writer;
		writer.showTransaction("활성");
	}
	
	public void receive (int amount) {
		if(hwal==1) {
			resetAccount(secondary_account, secondary_writer);//secondary_account활성화
			if(account.withdraw(amount)) {
				writer.showTransaction(amount, "출금 성공");
				resetAccount(primary_account, primary_writer);
				if(account.deposit(amount))
					writer.showTransaction(amount, "입금 성공");
				else
					writer.showTransaction("입금 실패");
			}	
			else {
				writer.showTransaction("출금 실패");
				resetAccount(primary_account, primary_writer);
			}
		}
		else if(hwal==2) {
			resetAccount(primary_account, primary_writer);//primary_account 활성화
			if(account.withdraw(amount)) {
				writer.showTransaction(amount, "출금 성공");
				resetAccount(secondary_account, secondary_writer);
				if(account.deposit(amount))
					writer.showTransaction(amount, "입금 성공");
				else
					writer.showTransaction("입금 실패");
			}	
			else {
				writer.showTransaction("출금 실패");
				resetAccount(secondary_account, secondary_writer);
			}
		}
	}
	
	public void send(int amount) {
		if(hwal==1) {
			if(account.withdraw(amount)) {
				writer.showTransaction(amount, "출금 성공");
				resetAccount(secondary_account, secondary_writer);
				if(account.deposit(amount)) {
					writer.showTransaction(amount, "입금 성공");
					resetAccount(primary_account, primary_writer);
				}
				else {
					writer.showTransaction("입금 실패");
					resetAccount(primary_account, primary_writer);
				}
			}
			else
				writer.showTransaction("출금 실패");
		}	
		else if(hwal==2) {
			if(account.withdraw(amount)) {
				writer.showTransaction(amount, "출금 성공");
				resetAccount(primary_account, primary_writer);
				if(account.deposit(amount)) {
					writer.showTransaction(amount, "입금 성공");
					resetAccount(secondary_account, secondary_writer);
				}
				else {
					writer.showTransaction("입금 실패");
					resetAccount(secondary_account, secondary_writer);
				}
			}
			else
				writer.showTransaction("출금 실패");		
		}
	}
	
	public void processTransactions() {
		char command = reader.readCommand("계좌#1 P, 계좌#2 S, send >금액, receive <금액, 입금 D금액, 출금 W금액, 종료 Q");
		if (command == 'Q') {
			writer.showTransaction("서비스를 마칩니다.");
			return;
		}
		else if(command=='D') {
			int amount= reader.readAmount();
			if(account.deposit(amount))
				writer.showTransaction(amount, "입금 성공");
			else
				writer.showTransaction("입금 실패");
		}
		else if(command=='W') {
			int amount = reader.readAmount();
			if(account.withdraw(amount))
				writer.showTransaction(amount, "출금 성공");
			else
				writer.showTransaction("출금 실패");
		}
		else if(command =='P') {
			resetAccount(primary_account, primary_writer);
			hwal=1;
		}
		else if(command=='S') {
			resetAccount(secondary_account, secondary_writer);
			hwal=2;//활성화 계좌가 secondary_account일 때
		}
		else if(command=='<') {//금액 받는 것
			int amount= reader.readAmount();
			receive(amount);
		}	
		else if(command=='>') {//활성계좌에서 출금
			int amount=reader.readAmount();
			send(amount);
		}	
		else
			writer.showTransaction("요청 오류");
		this.processTransactions();
	}
}

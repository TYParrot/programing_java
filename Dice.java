
public class Dice {

	public int throwDice() {
		int num=(int)(Math.random()*6+1);
		return num;
	}
	
	public String compare(int num1, int num2, int num3, int num4) {
		String message;
		if(num1==num2&&num3==num4) {
			if(num1+num2>num3+num4) {
				message="A";
				return message;
			}	
			else if(num1+num2<num3+num4) {
				message="B";
				return message;
			}	
			else {
				int a=Math.abs(num1-num2);
				int b=Math.abs(num3-num4);
				if(a>b) {
					message="B";
					return message;
				}	
				else if(a<b) {
					message="A";
					return message;
				}
				else {
					message="S";//두 주사위의 값이 같을 때, 합이 더 큰 수가 이기고, 합이 같으면 차가 더 작은 쪽이 이기며, 그 외에는 무승부
					return message;
				}
			}
		}
		else if(num1==num2) {
			message="A";
			return message;
		}	
		else if(num3==num4) {
			message="B";
			return message;
		}	
		else if(num1+num2>num3+num4){
			message="A";
			return message;
		}
		else {
			message="B";
			return message;
		}
	}
}

import javax.swing.*;

public class ClassManagement {

	public double computerAverage() {//시험을 몇개를 봤나?
		double total_score=0.0;
		int count=0;
		boolean processing=true;
		while(processing) {
			String message="다음 시험 점수? (입력 완료시 Cancel 버튼 누름)";
			String input = JOptionPane.showInputDialog(message);
			if(input==null)
				processing=false;
			else {
				int score=Integer.parseInt(input);
				total_score=total_score+score;			
				count=count+1;
				System.out.println("개수 = "+count+", 누적 점수=:"+total_score);
			}
		}
		if(count==0) {
			throw new RuntimeException("computerAberage error: 계산할 점수가 없습니다.");
		}
		return total_score/count;
	}
	public static void main(String[] args) {
		ClassManagement cm =new ClassManagement();
		System.out.println("평균점수 = "+ cm.computerAverage());

	}

}

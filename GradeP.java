package 수업자바;
import java.util.Scanner;

class People{
	private String name;  //성명
	private int KorG;     //국어
	private int EngG;     //영어
	private int MathG;    //수학
	private int SumG;     //합계
	private double AvgG;  //평균
	private int RankG;    //석차
	
	void setName(String name) {
		this.name = name; //화면에서 입력받을 이름값(매개변수)을 클래스내부에서 선언한 name 변수에 저장
	}
	void setKorG(int kor) {
		this.KorG = kor;
	}		
	void setEngG(int eng) {
		this.EngG = eng;
	}
	void setMathG(int math) {
		this.MathG = math;
	}
	void setRankG(int rank) {
		this.RankG = rank;
	}
	
	String getName() {
		return this.name; // 적절한 데이터 형식으로 변수(name)에 저장되어 있는 값을 변환한는 메소드
	}
	int getKor() {
		return this.KorG;
	}
	int getEng() {
		return this.EngG;
	}
	int getMath() {
		return this.MathG;
	}
	int getSum() {
		return this.getKor() + this.getEng() + this.getMath(); // 총점계산 메소드
	}
	double getAvg() {
		return this.getSum()/3; // 평균 게산 메소드
	}
	int getRank() {
		return this.RankG; // 적절한 데이터 형식으로 변수(RankG)에 저장되어 있는 값을 반환하는 메소드
	}
	void printScore() {	 // 변수 저장값들을 화면에 출력해주는 메소드
		System.out.printf(" %3s %3d %3d %3d %3d %3.2f %3d \n",
		this.getName(),this.getKor(),this.getEng(), this.getMath(), this.getSum(), this.getAvg(), this.getRank() ) ;		
	}	
}

public class GradeP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
				
		System.out.print("몇명의 성적처리를 하나요(숫자입력)? ");
		int num = input.nextInt();	  
		
		//객체배열 선언
		People stu[] = new People[num];
		
		//객체배열 초기화
        for(int i=0; i< stu.length ; i++) {
        	stu[i] = new People();
		}
        // 키보드 데이터입력
        for(int i=0; i<stu.length ; i++) {        	
        		System.out.print("성명을 입력하세요: ");
        		stu[i].setName(input.next());
        		System.out.print("국어 점수를 입력하세요: ");
        		stu[i].setKorG(input.nextInt());
        		System.out.print("영어 점수를 입력하세요: ");
        		stu[i].setEngG(input.nextInt());
        		System.out.print("수학 점수를 입력하세요: ");
        		stu[i].setMathG(input.nextInt());
        }

        // 석차 처리        
        for(int i=0; i< stu.length ; i++) {    
        	int rank=1;
        	for(int j=0 ; j < stu.length; j++) {
        		if (stu[i].getSum() < stu[j].getSum()) rank ++; 
        	}
        	stu[i].setRankG(rank);
        }
        
        System.out.println("=================출력=======================");
        System.out.printf("%3s %3s %2s %2s %3s %3s %4s \n", "성명","국어","영어","수학","합계","평균","석차");
        for(int i=0; i< stu.length ; i++) {
        	stu[i].printScore();
		}	        
        
	}
}



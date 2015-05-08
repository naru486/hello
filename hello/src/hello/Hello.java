package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hello {
	public static void main(String[] args) throws IOException {

		// BufferedReader 클래스 인스턴스 생생
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 배열 선언 및 초기화
		// 각 달이 담고있는 마지막 날짜
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// 테스트(확인)
		// System.out.println(day.length); //--==>> 12
		// 주요 변수 선언
		int nalsu, y, m, w; // -- 날수, 년, 월, 요일 변수

		do {
			System.out.print("『년도』를 입력하세요 : ");
			y = Integer.parseInt(br.readLine());
		} while (y < 1);
		do {
			System.out.print("『월』을 입력하세요 : ");
			m = Integer.parseInt(br.readLine());
		} while (m < 1 || m > 12);
		// 입력받은 년도에 해당하는 2월의 마지막 날 계산
		if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) { // 윤년이라면....
			days[1] = 29;
		} else { // 평년이라면....
			days[1] = 28;
		}
		// -- else 구문은
		// 현재 days[1] 가 28로 입력되어 있는 상태이므로
		// 생략 가능한 구문이다.

		// 날 수 연산
		// 1년 1월 1일 ~ 입력받은 년도 이전 년도의 12월 31일가지의
		// 날 수 계산
		nalsu = (y - 1) * 365 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;
		// 해당 년도 1월 1일 ~ 입력한 월의 이전 월 까지의
		// 날 수 누적 연산
		for (int i = 0; i < (m - 1); i++) {
			nalsu += days[i];
		}
		// 입력받은 월의 1일
		nalsu += 1; // ++nalsu;
		// 확인
		// System.out.println(nalsu);
		// --==>>735507
		// ------------------모든 날 수에 대한 종합 완료~~!!!!
		// 요일 산출
		// : 입력받은 월의 1일이 무슨 요일인지
		// 확인 하기 위한 연산
		w = nalsu % 7; // -- 0:일요일 1:월요일 2:화요일 ... 6:토요일

		// System.out.println(w);
		// 2014년 10월 → 3
		// 출력
		System.out.println();
		System.out.println("\t [ " + y + " 년 " + m + "월 ]");
		System.out.println();
		System.out.println("  일  월  화  수  목  금  토");
		System.out.println("============================");

		// 특정 요일부터 1일이 출발할 수 있도록 공백 발생(지정)
		for (int i = 1; i <= w; i++) {
			System.out.print("	"); // -- 공백 4칸
		}
		// 확인
		// System.out.printf("%4d",1);
		// ← 확인 완료
		// 해당 월의 날짜만 출력될 수 있도록 반복문 구성
		for (int i = 1; i <= days[m - 1]; i++) {
			System.out.printf("%4d", i);
			w++; // 날짜가 증가하는 만큼 요일도 함께 증가
			if (w % 7 == 0) {
				System.out.println();
			}
		}
		// 달의 마지막 날짜가 출력형식을 모두 채웠을 경우
		// 이미 일요일 개행이 이루어졌기 때문에
		// 이 경우에는 개행을 하지 않는다.
		if (w % 7 != 0) {
			System.out.println();
		}
		System.out.println("============================");
	}
}

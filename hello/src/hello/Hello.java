package hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hello {
	public static void main(String[] args) throws IOException {

		// BufferedReader Ŭ���� �ν��Ͻ� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// �迭 ���� �� �ʱ�ȭ
		// �� ���� ����ִ� ������ ��¥
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// �׽�Ʈ(Ȯ��)
		// System.out.println(day.length); //--==>> 12
		// �ֿ� ���� ����
		int nalsu, y, m, w; // -- ����, ��, ��, ���� ����

		do {
			System.out.print("���⵵���� �Է��ϼ��� : ");
			y = Integer.parseInt(br.readLine());
		} while (y < 1);
		do {
			System.out.print("�������� �Է��ϼ��� : ");
			m = Integer.parseInt(br.readLine());
		} while (m < 1 || m > 12);
		// �Է¹��� �⵵�� �ش��ϴ� 2���� ������ �� ���
		if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) { // �����̶��....
			days[1] = 29;
		} else { // ����̶��....
			days[1] = 28;
		}
		// -- else ������
		// ���� days[1] �� 28�� �ԷµǾ� �ִ� �����̹Ƿ�
		// ���� ������ �����̴�.

		// �� �� ����
		// 1�� 1�� 1�� ~ �Է¹��� �⵵ ���� �⵵�� 12�� 31�ϰ�����
		// �� �� ���
		nalsu = (y - 1) * 365 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;
		// �ش� �⵵ 1�� 1�� ~ �Է��� ���� ���� �� ������
		// �� �� ���� ����
		for (int i = 0; i < (m - 1); i++) {
			nalsu += days[i];
		}
		// �Է¹��� ���� 1��
		nalsu += 1; // ++nalsu;
		// Ȯ��
		// System.out.println(nalsu);
		// --==>>735507
		// ------------------��� �� ���� ���� ���� �Ϸ�~~!!!!
		// ���� ����
		// : �Է¹��� ���� 1���� ���� ��������
		// Ȯ�� �ϱ� ���� ����
		w = nalsu % 7; // -- 0:�Ͽ��� 1:������ 2:ȭ���� ... 6:�����

		// System.out.println(w);
		// 2014�� 10�� �� 3
		// ���
		System.out.println();
		System.out.println("\t [ " + y + " �� " + m + "�� ]");
		System.out.println();
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("============================");

		// Ư�� ���Ϻ��� 1���� ����� �� �ֵ��� ���� �߻�(����)
		for (int i = 1; i <= w; i++) {
			System.out.print("	"); // -- ���� 4ĭ
		}
		// Ȯ��
		// System.out.printf("%4d",1);
		// �� Ȯ�� �Ϸ�
		// �ش� ���� ��¥�� ��µ� �� �ֵ��� �ݺ��� ����
		for (int i = 1; i <= days[m - 1]; i++) {
			System.out.printf("%4d", i);
			w++; // ��¥�� �����ϴ� ��ŭ ���ϵ� �Բ� ����
			if (w % 7 == 0) {
				System.out.println();
			}
		}
		// ���� ������ ��¥�� ��������� ��� ä���� ���
		// �̹� �Ͽ��� ������ �̷������ ������
		// �� ��쿡�� ������ ���� �ʴ´�.
		if (w % 7 != 0) {
			System.out.println();
		}
		System.out.println("============================");
	}
}

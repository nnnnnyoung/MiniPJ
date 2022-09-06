import java.util.Scanner;

import javax.swing.Spring;

public class Game {
	Scanner in=new Scanner(System.in);
	String [] word=new String[10];
	int Score=0;
	Game(){
		menu();
	}
	
	public void save() {
		System.out.println("�ܾ �Է��ϼ���");
		String newWord=in.nextLine();
			if(chkLeng(newWord)==0) {
				System.out.println("�ԷºҰ�");		
			}else {
				for(int i=0; i<word.length; i++) {
					if(newWord.equals(word[i])) {
						System.out.println("�ߺ��� �ܾ �̹� �ֽ��ϴ�");
					}else if(newWord.contains("����")||newWord.contains("������")||newWord.contains("����")) {
						System.out.println("�弳�� ����� �� �����ϴ�.");
						break;
					}else if(word[i]==null) {
						word[i]=newWord;
						break;
					}
				}
			}

	}
	
	public int chkLeng(String w) {
		if(w.length()>8) {
			return 0;
		}else {
			return 1;
		}
	}
	

	
	public void prt() {
		for(int i=0; i<word.length; i++) {
			System.out.println(word[i]);
		}
	}
	
	public void modi() {
		int chkFlag=0;
		System.out.println("� �ܾ �����Ͻðڽ��ϱ�?");
		String oldWord=in.nextLine();
		for(int i=0; i<word.length; i++) {
			if(oldWord.equals(word[i])) {
				System.out.println("� �ܾ�� �����Ͻðڽ��ϱ�?");
				String newWord=in.nextLine();
				if(chkLeng(newWord)==0) {
					System.out.println("�ܾ��� ���̰� �ʰ��Ǿ����ϴ�.");
				}else {
					word[i]=newWord;
					chkFlag=1;
					break;
				}
			}
		}
		if (chkFlag==0) {
			System.out.println("�����Ͱ� �����ϴ�.");
		}
	}
	
	public void delete() {
		int chkFlag=0;
		System.out.println("������ �ܾ �Է��ϼ���");
		String newWord=in.nextLine();
		for (int i=0; i<word.length; i++) {
			if(newWord.equals(word[i])){
				word[i]=null;
				chkFlag=1;
				System.out.println(newWord+"�� ���� �Ǿ����ϴ�.");
				break;
			}
			
		}
		if(chkFlag==0) {
			System.out.println("�����Ͱ� �����ϴ�.");
		}
	}
	
	public void search() {
		int chkFlag=0;
		System.out.println("�˻��� �ܾ �Է��ϼ���");
		String newWord=in.nextLine();
		for(int i=0; i<word.length;i++) {
			if(word[i]!=null &&newWord.contains(word[i])) {
				System.out.println(word[i]);
				chkFlag=1;
				break;
			}
		}
		if(chkFlag==0) {
			System.out.println("�����Ͱ� �����ϴ�.");
		}
	}
	
	public void game() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<word.length; j++) {
				int a=(int)(Math.random()*word.length);
				if (word[a]!=null) {
					System.out.println(word[a]);
					String newWord=in.nextLine();
					if(newWord.equals(word[a])) {
						System.out.println("����");
						Score=Score+20;
						break;
					}else {
						System.out.println("��");
						break;
					}
				}else {
					j--;
				}
			}
		}
		System.out.println("���� :"+Score);
		Score=0;

	}
	
	public void menu() {
		for(;;) {
			System.out.println("�޴� ����");
			System.out.println("1. �ܾ�����");
			System.out.println("2. �ܾ� ��ü����");
			System.out.println("3. �ܾ���� ");
			System.out.println("4. �ܾ����");
			System.out.println("5. �ܾ�˻�");
			System.out.println("6. ���� ����");
			int number=in.nextInt();
			in.nextLine();
			if(number==1) {
				save();
			}else if(number==2) {
				prt();
			}else if(number==3) {
				modi();
			}else if(number==4) {
				delete();
			}else if(number==5) {
				search();
			}else if(number==6) {
				game();
			}
		}

	}
	

}

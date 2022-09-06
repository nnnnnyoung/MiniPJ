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
		System.out.println("단어를 입력하세요");
		String newWord=in.nextLine();
			if(chkLeng(newWord)==0) {
				System.out.println("입력불가");		
			}else {
				for(int i=0; i<word.length; i++) {
					if(newWord.equals(word[i])) {
						System.out.println("중복된 단어가 이미 있습니다");
					}else if(newWord.contains("씨발")||newWord.contains("개새끼")||newWord.contains("지랄")) {
						System.out.println("욕설은 사용할 수 없습니다.");
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
		System.out.println("어떤 단어를 수정하시겠습니까?");
		String oldWord=in.nextLine();
		for(int i=0; i<word.length; i++) {
			if(oldWord.equals(word[i])) {
				System.out.println("어떤 단어로 수정하시겠습니까?");
				String newWord=in.nextLine();
				if(chkLeng(newWord)==0) {
					System.out.println("단어의 길이가 초과되었습니다.");
				}else {
					word[i]=newWord;
					chkFlag=1;
					break;
				}
			}
		}
		if (chkFlag==0) {
			System.out.println("데이터가 없습니다.");
		}
	}
	
	public void delete() {
		int chkFlag=0;
		System.out.println("삭제할 단어를 입력하세요");
		String newWord=in.nextLine();
		for (int i=0; i<word.length; i++) {
			if(newWord.equals(word[i])){
				word[i]=null;
				chkFlag=1;
				System.out.println(newWord+"가 삭제 되었습니다.");
				break;
			}
			
		}
		if(chkFlag==0) {
			System.out.println("데이터가 없습니다.");
		}
	}
	
	public void search() {
		int chkFlag=0;
		System.out.println("검색할 단어를 입력하세요");
		String newWord=in.nextLine();
		for(int i=0; i<word.length;i++) {
			if(word[i]!=null &&newWord.contains(word[i])) {
				System.out.println(word[i]);
				chkFlag=1;
				break;
			}
		}
		if(chkFlag==0) {
			System.out.println("데이터가 없습니다.");
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
						System.out.println("정답");
						Score=Score+20;
						break;
					}else {
						System.out.println("땡");
						break;
					}
				}else {
					j--;
				}
			}
		}
		System.out.println("점수 :"+Score);
		Score=0;

	}
	
	public void menu() {
		for(;;) {
			System.out.println("메뉴 선택");
			System.out.println("1. 단어저장");
			System.out.println("2. 단어 전체보기");
			System.out.println("3. 단어수정 ");
			System.out.println("4. 단어삭제");
			System.out.println("5. 단어검색");
			System.out.println("6. 게임 시작");
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

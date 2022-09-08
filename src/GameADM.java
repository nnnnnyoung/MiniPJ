
import java.util.Scanner;
public class GameADM {
   Scanner in = new Scanner(System.in);
   String[] a = new String[10];
   // 단어를 저장하는 변수 a지정 
   String[] b = {"바보","멍청이","해삼","말미잘"};
   // 욕설을 저장하는 변수 b지정
   
   
   public int chk(String ck) {
      if(ck.length()<9) {
         return 0;
      }else return 1;
   }
   
   // 9글자 이상의 글자는 입력되지 않게 하기 위한 메서드 생성
   
   public int bb(String bbb) {
      int chk=0;
      for(int i = 0;i<b.length;i++) {
         if(bbb.contains(b[i])) {
            chk++;
         }
      }
      if(chk!=0) {
         return 0;
      }else return 1;

   }
   // 욕설을 포함한 글자는 입력되지 않게 하기 위한 메서드 생성
   
    
   public void input() { //단어 저장 메서드
      System.out.print("저장할 단어(8글자 이하) : ");
      // 단어를 입력하라는 안내문
      String insert = in.nextLine(); // 키보드로 입력
      if(chk(insert)==0) { //글자수 조건을 확인하기 위한 메서드 실행
         if(bb(insert)==0) { // 욕설 포함 조건을 확인하기 위한 메서드 실행
            System.out.println("욕설은 포함할 수 없습니다."); 
            //욕설이 포함된다면 "욕설은 포함할 수 없습니다." 안내문이 출력되고 입력되지 않음
            return;
         }
         for(int i = 0;i<a.length;i++) { 
            if(insert.equalsIgnoreCase(a[i])) { 
               //입력된 단어가 이미 저장된 단어인지 확인하기 위해 equalsIgnoreCase 메서드 사용
               System.out.println("이미 저장된 단어 입니다."); 
               //만약 입력단어와 저장된 단어가 같다면 "이미 저장된 단어입니다" 안내문이 출력됨
                  break;
               }else if(i==a.length-1) {
                  for(int j = 0;j<a.length;j++) {
                     if(a[j]==null) { //a배열의 j번 인덱스가 null값이라면 
                        a[j]=insert; //j번 인덱스에 입력된 단어를 저장
                        break;
                     }else if(j==a.length-1) {
                        System.out.println("저장 공간이 가득 찼습니다.");
                        // 만약 a인덱스에 null값이 없다면 저장할 곳이 없기 떄문에 
                        //저장 공간이 가득 찼습니다 안내문이 출력됨 
                     }
                  }
               }
            }
         }else {
            System.out.println("8글자 이하로 입력하세요.");
            //처음에 사용한 글자수 확인 메서드의 조건을 위배한다면 8글자 이하로 입력하세요 안내문 출력
         }
      }
   
   public void prt() { //저장된 단어 출력 메서드
       System.out.println("단어 전체 보기");
       for(int i = 0;i<a.length;i++) {
          System.out.println(a[i]);
       } //a배열의 모든 값이 출력됨
    }



   public void modify() {
         int chkFlag=0;
         System.out.println("수정할 단어 : ");
         String oldWord=in.nextLine(); //수정할 단어 입력
         for(int i=0; i<a.length; i++) {
            if(oldWord.equals(a[i])) {// 입력된 단어가 목록에 있는 단어라면
               System.out.println("새로운 단어 : "); // 어떤 단어로 바꿀지 입력한다
               String newWord=in.nextLine();
               chkFlag=1;
               if(chk(newWord)==1) { //입력된 단어 글자수 확인
                  System.out.println("8글자 이하로 입력하세요.");                
                  break;
               }else if(bb(newWord)==0) { //입력된 단어 욕설 확인
                  System.out.println("욕설은 포함할 수 없습니다.");
                  break;
               }
               for(int j = 0;j<a.length;j++) { //입력된 단어 중복 확인
                  if(newWord.equals(a[j])) {
                     System.out.println("이미 저장된 단어 입니다."); 
                     //같은 단어가 있다면 안내문이 출력되고 저장되지 않는다
                     break;
                  } else if(j==a.length-1){ 
                     a[i]=newWord; //위의 조건을 모두 만족한다면 새로운 단어로 수정된다.
                     break;
                  }
               }

            }
         }
         if (chkFlag==0) { //입력한 단어가 목록에 없는 단어라면 '일치하는 단어가 없습니다' 안내문 출력
            System.out.println("일치하는 단어가 없습니다.");
         }
      }
      
      public void search() { // 단어검색 메서드
         System.out.print("검색할 단어 : ");
         String searchin = in.nextLine(); //
         int chkPoint=0;
         if(chk(searchin)==0) { //글자수 확인 메서드
            for(int i = 0;i<a.length;i++) { 
               if(a[i]!=null &&a[i].contains(searchin)) { //입력된 단어를 포함하는 단어가 있다면 출력한다
                  System.out.println(a[i]);
                  chkPoint=1;
               }else if(chkPoint==0) { ////입력된 단어를 포함하는 단어가 없다면 일치하는 단어가 없다고 안내문이 출력된다
                  System.out.println("일치하는 단어가 없습니다.");
                  break;
               }
            }
         }else {
            System.out.println("8글자 이하로 입력하세요.");
         }
      }
      
      public void delete() {
         System.out.print("삭제할 단어 : "); 
         String deletein = in.nextLine(); //삭제할 단어 입력
         if(chk(deletein)==0) { //글자수 확인
            for(int i = 0;i<a.length;i++) {
               if(deletein.equalsIgnoreCase(a[i])) { //입력된 단어와 저장된 단어가 같다면
                  a[i]=null; //저장된 단어를 null로 비워버린다.
                  System.out.println("단어를 삭제하였습니다.");
                  break;
               }else if(i==a.length-1) {
                  System.out.println("일치하는 단어가 없습니다."); //입력된 단어가 목록에 없다면 안내문 출력
               }
            }
         }else {
            System.out.println("8글자 이하로 입력하세요.");
         }
      }
      
      public void games() {
          int[] num = new int[10]; 
          int sum = 0; //부분점수시 맞은 글자수 
          int s = 0; //게임 횟수 
          double asum = 0; //총점
          for(int i = 0;i<a.length;i++) {
             int rd = (int)(Math.random()*10); //num 배열에 랜덤한 숫자를 저장
             num[i]=rd;
             for(int j = 0;j<i;j++) {
                if(num[i]==num[j]) {
                   i--;
                }
             }
          }
          System.out.println("게임시작 : enter"); //엔터키를 누르면 게임이 시작 됩니다
          in.nextLine();
          for(int i = 0;i<a.length;i++) {
             if(a[num[i]]!=null) {
                System.out.println("게임종료 : stop"); 
                System.out.println("문제 : "+a[num[i]]);
                String q = in.nextLine();
                if(q.equalsIgnoreCase("stop")) { //큐 참조변수가 참조하는 객체에서 사용할 수 있는 메서드 equalsIgnoreCase
                    // 메서드 정의 :q문자열과 매개변수로 지정한 값을 비교하는데 대소문자 무시해라 
                    // 매개변수 : stop
                   // 리턴값 : 불린타입   큐와 매개변수가 같으면 참, 아니면 거짓
                   break;
                }else if(q.equalsIgnoreCase(a[num[i]])) { //정답 입력시 20점 
                   System.out.println("정답 +20점");
                   asum+=20;
                   s++;
                   if(s==5) {
                      System.out.println("총점 : "+asum); //게임 횟수가 5회가 되면 종료
                      return;
                   }
                }else if(q.equalsIgnoreCase(a[num[i]])==false||(q.equalsIgnoreCase(""))){
                   System.out.println("오답입니다."); //글자가 같지 않거나 공백일 시 오답
                   s++;
                   for(int j = 0;j<q.length()&&j<a[num[i]].length();j++) {
                      if(q.charAt(j)==a[num[i]].charAt(j)) { 
                         sum++;
                      }
                   }
                      asum+=20/a[num[i]].length()*sum; 
                      //정답은 아니지만 맞은 글자가 있을때 20을 글자수로 나눈 뒤 맞은 글자수만큼 곱해줍니다
                      System.out.println(sum+"글자 정답 +"+20/a[num[i]].length()*sum+"점");
                      sum=0;
                   }
                   if(s==5) {
                      System.out.println("총점 : "+asum); //게임 횟수가 5회가 되면 종료
                      return;
                   }
                }else if(i==a.length-1) {
                   System.out.println("저장된 단어가 존재하지 않습니다.");
                   System.out.println("총점 : "+asum);
             }
             
          }
       }
      
      
      public void menu() {
         for(;;) {
            System.out.println("단어 입력 : 1");
            System.out.println("단어 출력 : 2");
            System.out.println("단어 검색 : 3");
            System.out.println("단어 수정 : 4");
            System.out.println("단어 삭제 : 5");
            System.out.println("단어 게임 : 6");
            System.out.println("게임 종료 : 7");
            System.out.print("선택 : ");
            int a = in.nextInt();
            in.nextLine();
            if(a==1) {
               input();
            }else if(a==2) {
               prt();
            }else if(a==3) {
               search();
            }else if(a==4) {
               modify();
            }else if(a==5) {
               delete();
            }else if(a==6){
               games();
            }else if(a==7){
               break;
            }
         }
      }


      
      GameADM() {
          menu();
       }
   }
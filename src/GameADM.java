
import java.util.Scanner;
public class GameADM {
   Scanner in = new Scanner(System.in);
   String[] a = new String[10];
   // �ܾ �����ϴ� ���� a���� 
   String[] b = {"�ٺ�","��û��","�ػ�","������"};
   // �弳�� �����ϴ� ���� b����
   
   
   public int chk(String ck) {
      if(ck.length()<9) {
         return 0;
      }else return 1;
   }
   
   // 9���� �̻��� ���ڴ� �Էµ��� �ʰ� �ϱ� ���� �޼��� ����
   
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
   // �弳�� ������ ���ڴ� �Էµ��� �ʰ� �ϱ� ���� �޼��� ����
   
    
   public void input() { //�ܾ� ���� �޼���
      System.out.print("������ �ܾ�(8���� ����) : ");
      // �ܾ �Է��϶�� �ȳ���
      String insert = in.nextLine(); // Ű����� �Է�
      if(chk(insert)==0) { //���ڼ� ������ Ȯ���ϱ� ���� �޼��� ����
         if(bb(insert)==0) { // �弳 ���� ������ Ȯ���ϱ� ���� �޼��� ����
            System.out.println("�弳�� ������ �� �����ϴ�."); 
            //�弳�� ���Եȴٸ� "�弳�� ������ �� �����ϴ�." �ȳ����� ��µǰ� �Էµ��� ����
            return;
         }
         for(int i = 0;i<a.length;i++) { 
            if(insert.equalsIgnoreCase(a[i])) { 
               //�Էµ� �ܾ �̹� ����� �ܾ����� Ȯ���ϱ� ���� equalsIgnoreCase �޼��� ���
               System.out.println("�̹� ����� �ܾ� �Դϴ�."); 
               //���� �Է´ܾ�� ����� �ܾ ���ٸ� "�̹� ����� �ܾ��Դϴ�" �ȳ����� ��µ�
                  break;
               }else if(i==a.length-1) {
                  for(int j = 0;j<a.length;j++) {
                     if(a[j]==null) { //a�迭�� j�� �ε����� null���̶�� 
                        a[j]=insert; //j�� �ε����� �Էµ� �ܾ ����
                        break;
                     }else if(j==a.length-1) {
                        System.out.println("���� ������ ���� á���ϴ�.");
                        // ���� a�ε����� null���� ���ٸ� ������ ���� ���� ������ 
                        //���� ������ ���� á���ϴ� �ȳ����� ��µ� 
                     }
                  }
               }
            }
         }else {
            System.out.println("8���� ���Ϸ� �Է��ϼ���.");
            //ó���� ����� ���ڼ� Ȯ�� �޼����� ������ �����Ѵٸ� 8���� ���Ϸ� �Է��ϼ��� �ȳ��� ���
         }
      }
   
   public void prt() { //����� �ܾ� ��� �޼���
       System.out.println("�ܾ� ��ü ����");
       for(int i = 0;i<a.length;i++) {
          System.out.println(a[i]);
       } //a�迭�� ��� ���� ��µ�
    }



   public void modify() {
         int chkFlag=0;
         System.out.println("������ �ܾ� : ");
         String oldWord=in.nextLine(); //������ �ܾ� �Է�
         for(int i=0; i<a.length; i++) {
            if(oldWord.equals(a[i])) {// �Էµ� �ܾ ��Ͽ� �ִ� �ܾ���
               System.out.println("���ο� �ܾ� : "); // � �ܾ�� �ٲ��� �Է��Ѵ�
               String newWord=in.nextLine();
               chkFlag=1;
               if(chk(newWord)==1) { //�Էµ� �ܾ� ���ڼ� Ȯ��
                  System.out.println("8���� ���Ϸ� �Է��ϼ���.");                
                  break;
               }else if(bb(newWord)==0) { //�Էµ� �ܾ� �弳 Ȯ��
                  System.out.println("�弳�� ������ �� �����ϴ�.");
                  break;
               }
               for(int j = 0;j<a.length;j++) { //�Էµ� �ܾ� �ߺ� Ȯ��
                  if(newWord.equals(a[j])) {
                     System.out.println("�̹� ����� �ܾ� �Դϴ�."); 
                     //���� �ܾ �ִٸ� �ȳ����� ��µǰ� ������� �ʴ´�
                     break;
                  } else if(j==a.length-1){ 
                     a[i]=newWord; //���� ������ ��� �����Ѵٸ� ���ο� �ܾ�� �����ȴ�.
                     break;
                  }
               }

            }
         }
         if (chkFlag==0) { //�Է��� �ܾ ��Ͽ� ���� �ܾ��� '��ġ�ϴ� �ܾ �����ϴ�' �ȳ��� ���
            System.out.println("��ġ�ϴ� �ܾ �����ϴ�.");
         }
      }
      
      public void search() { // �ܾ�˻� �޼���
         System.out.print("�˻��� �ܾ� : ");
         String searchin = in.nextLine(); //
         int chkPoint=0;
         if(chk(searchin)==0) { //���ڼ� Ȯ�� �޼���
            for(int i = 0;i<a.length;i++) { 
               if(a[i]!=null &&a[i].contains(searchin)) { //�Էµ� �ܾ �����ϴ� �ܾ �ִٸ� ����Ѵ�
                  System.out.println(a[i]);
                  chkPoint=1;
               }else if(chkPoint==0) { ////�Էµ� �ܾ �����ϴ� �ܾ ���ٸ� ��ġ�ϴ� �ܾ ���ٰ� �ȳ����� ��µȴ�
                  System.out.println("��ġ�ϴ� �ܾ �����ϴ�.");
                  break;
               }
            }
         }else {
            System.out.println("8���� ���Ϸ� �Է��ϼ���.");
         }
      }
      
      public void delete() {
         System.out.print("������ �ܾ� : "); 
         String deletein = in.nextLine(); //������ �ܾ� �Է�
         if(chk(deletein)==0) { //���ڼ� Ȯ��
            for(int i = 0;i<a.length;i++) {
               if(deletein.equalsIgnoreCase(a[i])) { //�Էµ� �ܾ�� ����� �ܾ ���ٸ�
                  a[i]=null; //����� �ܾ null�� ���������.
                  System.out.println("�ܾ �����Ͽ����ϴ�.");
                  break;
               }else if(i==a.length-1) {
                  System.out.println("��ġ�ϴ� �ܾ �����ϴ�."); //�Էµ� �ܾ ��Ͽ� ���ٸ� �ȳ��� ���
               }
            }
         }else {
            System.out.println("8���� ���Ϸ� �Է��ϼ���.");
         }
      }
      
      public void games() {
          int[] num = new int[10]; 
          int sum = 0; //�κ������� ���� ���ڼ� 
          int s = 0; //���� Ƚ�� 
          double asum = 0; //����
          for(int i = 0;i<a.length;i++) {
             int rd = (int)(Math.random()*10); //num �迭�� ������ ���ڸ� ����
             num[i]=rd;
             for(int j = 0;j<i;j++) {
                if(num[i]==num[j]) {
                   i--;
                }
             }
          }
          System.out.println("���ӽ��� : enter"); //����Ű�� ������ ������ ���� �˴ϴ�
          in.nextLine();
          for(int i = 0;i<a.length;i++) {
             if(a[num[i]]!=null) {
                System.out.println("�������� : stop"); 
                System.out.println("���� : "+a[num[i]]);
                String q = in.nextLine();
                if(q.equalsIgnoreCase("stop")) { //ť ���������� �����ϴ� ��ü���� ����� �� �ִ� �޼��� equalsIgnoreCase
                    // �޼��� ���� :q���ڿ��� �Ű������� ������ ���� ���ϴµ� ��ҹ��� �����ض� 
                    // �Ű����� : stop
                   // ���ϰ� : �Ҹ�Ÿ��   ť�� �Ű������� ������ ��, �ƴϸ� ����
                   break;
                }else if(q.equalsIgnoreCase(a[num[i]])) { //���� �Է½� 20�� 
                   System.out.println("���� +20��");
                   asum+=20;
                   s++;
                   if(s==5) {
                      System.out.println("���� : "+asum); //���� Ƚ���� 5ȸ�� �Ǹ� ����
                      return;
                   }
                }else if(q.equalsIgnoreCase(a[num[i]])==false||(q.equalsIgnoreCase(""))){
                   System.out.println("�����Դϴ�."); //���ڰ� ���� �ʰų� ������ �� ����
                   s++;
                   for(int j = 0;j<q.length()&&j<a[num[i]].length();j++) {
                      if(q.charAt(j)==a[num[i]].charAt(j)) { 
                         sum++;
                      }
                   }
                      asum+=20/a[num[i]].length()*sum; 
                      //������ �ƴ����� ���� ���ڰ� ������ 20�� ���ڼ��� ���� �� ���� ���ڼ���ŭ �����ݴϴ�
                      System.out.println(sum+"���� ���� +"+20/a[num[i]].length()*sum+"��");
                      sum=0;
                   }
                   if(s==5) {
                      System.out.println("���� : "+asum); //���� Ƚ���� 5ȸ�� �Ǹ� ����
                      return;
                   }
                }else if(i==a.length-1) {
                   System.out.println("����� �ܾ �������� �ʽ��ϴ�.");
                   System.out.println("���� : "+asum);
             }
             
          }
       }
      
      
      public void menu() {
         for(;;) {
            System.out.println("�ܾ� �Է� : 1");
            System.out.println("�ܾ� ��� : 2");
            System.out.println("�ܾ� �˻� : 3");
            System.out.println("�ܾ� ���� : 4");
            System.out.println("�ܾ� ���� : 5");
            System.out.println("�ܾ� ���� : 6");
            System.out.println("���� ���� : 7");
            System.out.print("���� : ");
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
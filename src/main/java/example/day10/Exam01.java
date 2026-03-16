package example.day10;

class Vip{
    int add3(int a , int b){
        return a+b;
    }
}

class Member extends Vip {int add(int a, int b){return a+b;}
    static int add2(int a, int b){return  a+b;}
    int add3(int a , int b){return a-b;}

}





public class Exam01 {
    public static void main(String[] args) {
        // 1. 함수 = 메소드

        // 2. 종류
            // 2-1 인스턴스/멤버 메소드 == new 이용하여 인스턴스 생성하여 함수 호출
        Member member = new Member();
        int result = member.add(3,4);
            // 2-2 static/정적 메소드 == 인스턴스 생성 없이 함수 호출
        int result2 = Member.add2(3,4);
            // 2-3 오버라이딩 == 상속 또는 구현 받은 타입의 메소드 재정의
        Member member1 = new Member();
        int result3 = member1.add3(4 ,3);

        // 3. 함수 기본 구조
            // 매개변수 == 인자값 저장하는 변수 == 함수안으로 들어오는 값
            // 반환값  == 함수 밖으로 되돌려 주는 값
        // 4. 함수 호출하는 방법
            new Member().add(3, 4); // 4-1 인스턴스/멤버 메소드 일때
            Member.add2(3,4); // 4-2 static 메소드 일때
            // Member.getInstance().add2(3, 4) 4-3 싱글톤 메소드 일때
            // @Autowired Member member; member.add5();
            // ==========같은 클래스 일때 static 메소드에서는 불가능===============
            // add();
            // static 메소드 일때는 static 메소드 호출 또는 인스턴스 메소드 호출

    } //main e
} //class e


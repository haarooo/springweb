package example.day10;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Calculator{
    int plus(int x , int y); // 추상메소드(구현이 없는 메소드)
}

public class Exam02 {
    public static int plus(int x , int y){return x+y;}
    public static void main(String[] args) {
        // 1. 메소드 호출
        int  result = plus(3 ,2);
        // 2. 익명구현체 , 구현체란? 추상메소드를 구현한 객체 , 익명구현체란? 클래스없이 구현한 인스턴스
        // 인터페이스명 변수명  = new 인터페이스명(){오버라이딩}
        Calculator calculator = new Calculator() {
            @Override
            public int plus(int x, int y) { //재정의
                return x-y;
            }
        };
        int result2= calculator.plus(5 ,2 ); // 5-2 = 3
        // 3 람다 표현식 , 매개변수 -> {구현부}
        Calculator calc2 = (x , y)-> x - y;
        int result3 = calc2.plus(5,2);
        System.out.println("result3 = " + result3);
        
        // 4 람다 표현식을 사용하는 *함수형* 인터페이스 
        // <> : 제네릭이란? 인스턴스(객체) 를 생성할 때 인스턴스(객체)내 멤버들의 타입 정의한다.
        // List<Integer> : List객체 생성시 내부에 Integer 타입으로 항목 구성하곘다 
        //Map<String , Object> : Map 객체 1개 생성시 내부에 String 타입으로 key , Object 타입으로 value 구성
        //즉 객체내 멤버들의 타입을 매개로 정할 수 있는 타입
        // 4-1 Function<T , R> T:입력받은값 , R: 결과 반환앖 , .apply(T)메소드
        Function<Integer , Integer> function = x->x*2;
        System.out.println("function.apply(3) = " + function.apply(3));

        // 4-2 Supplier<T> T: 반환값의 타입 .get();
        Supplier<Double> supplier = ()-> 3.14;
        System.out.println("supplier.get(supplier) = " + supplier.get());

        // 4-3 Consumer<T> T: 입력받은값의 타입 .accept():
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("유재석");

        // 4-4 Predicate<T> T : 입력받아서true/false로 반환
        Predicate<Integer> predicate = (x)-> {return x%2 ==0;};
        System.out.println("predicate.test(3) = " + predicate.test(3));




    } // main e
}// class e

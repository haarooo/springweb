package example.day12.스레드;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Transactional
@RequiredArgsConstructor
public class ThreadService {

    // 1. 1초 간격으로 1부터 10까지 누적합계 값을 반환한다
    public int test1(){
        int result = 0;
        for(int i = 1 ; i<= 10 ; i++){
            System.out.println("ThreadService.test1");
            // ** 스레드 일시정지 **
            try{Thread.sleep(1000); //밀리초(1000/1초 )
            }catch (Exception e){System.out.println(e);}
            result += i;
        }
        return result;
    }
    
    // 2.
    @Async // 비동기 : 먼저 응답/반환 하고 내부적으로 처리
    public void test2(){
        int result = 0;
        for(int i = 1  ; i<=10 ; i++){
            System.out.println("ThreadService.test2");
            try{Thread.sleep(1000);
            }catch (Exception e){System.out.println(e);}
            result += i;
        }
        System.out.println("result = " + result);
    }





}//class e

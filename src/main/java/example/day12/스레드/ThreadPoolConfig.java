package example.day12.스레드;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration // IOC 빈 어노테이션 종류 , 빈 등록
// 주로 만들어진 설정값을 오버라이딩/등록
// 서버의 안정화
public class ThreadPoolConfig {

    @Bean // 해당 함수를 등록
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // 기본(최소) 실행 스레드 개수 설정
        executor.setMaxPoolSize(3); // 최대 실행 스레드 개수 설정
        // 5개 이상의 요청 및 스레드 사용시 이후 요청은 대기상태
        executor.setQueueCapacity(5);
        //queue : 요청의 대기열(웨이팅줄)
        executor.initialize();;
        return executor;
    }
}

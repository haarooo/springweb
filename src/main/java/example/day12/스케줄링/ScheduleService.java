package example.day12.스케줄링;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    // 컨트롤러 유무와 상관없이 특정 시간이 되면 서비스 자동 실행
    // 비동기 기반의 구조 , 목적 : 보안 , 자동화

    //1. 3초 마다 실행되는 스케줄 설정
    @Scheduled(fixedRate = 3000) //밀리초
    public void task1(){System.out.println("ScheduleService.task1");}

    //2. 변수값 마다 실행되는 스케줄 설정
    final int time = 5000;
    @Scheduled(fixedRate = time)
    public void task2(){System.out.println("ScheduleService.task2");}

    //3. 시스템의 날짜/시간 기준으로 스케줄링
    @Scheduled(cron = " */5 * * * * *") // 매시각 5초이면 실행
    public void task3(){System.out.println("ScheduleService.task3");}

    @Scheduled(cron = "0 */1 * * * *") // 매시각 1분마면 실행
    public void task4(){System.out.println("ScheduleService.task4");}


}//class e

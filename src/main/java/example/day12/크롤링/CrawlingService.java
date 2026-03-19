package example.day12.크롤링;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.AbstractNestablePropertyAccessor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

@Service
public class CrawlingService {

    //웹크롤링 : 웹페이지의 HTML 정보/자료 수집 과정
    //웹페이지 마다 : URL/robots.txt , 크롤링 허용 여부
    //정적페이지 : HTML , 동적페이지 : JS(AXIOS,REACT)
        // - 정적페이지 : Jsoup 라이브러리
        // - 동적페이지 : Selenium 라이브러리 (파이썬과 동일)


    // 1. Jsoup 이용한 특정 url HTML 정보 수집
    public List<String> test1(){
        List<String> list = new ArrayList<>(); // 여러개 문자열 저장

        // 1) 크롤링할 URL 웹페이지 주소
        String url = "https://www.karnews.or.kr/news/articleList.html?sc_section_code=S1N1&view_type=sm";

        // 2) 크롤링할 url 요청하여 html 전체를 가져온다 .Jsoup.connect().get();
        // Document import org.jsoup.nodes.Documnet
        try {
            Document document = Jsoup.connect(url).get();

            // 3) 특정한 마크업/요소 식별자 , document.select("식별자")
            Elements elements = document.select(".view-cont");
            System.out.println("elements = " + elements);
            
            // 4) 여러개 가져 왔다면
            for(Element element : elements){
                String title = element.text(); // .text();innerHTML과 비슷하게 마크업 사이 텍스트 반환
                if(title.isBlank()){continue;
                }else{list.add(title);}
            }

        }catch (Exception e){System.out.println(e);}
        return list;
    }


    // 2. Jsoup 이용한 HTML 정보 수집 , 페이지 이동
    public List<Map<String , Object>> test2(){
        List<Map<String , Object>> list = new ArrayList<>();

        try{//반복문 이용하여 페이지번호 여러개 요청
            for(int page = 1 ; page<=3 ; page++){
            String url = "https://www.yes24.com/product/category/daybestseller";
            url += "?categoryNumber=001";
            url += "&pageNumber="+page; // page를 변수로 활용
            url += "&pageSize=24";
            Document document = Jsoup.connect(url).get();

            //식별자 , 단일 선택자일 때는 중복 발생
            Elements name = document.select(".info_name .gd_name");
            Elements price = document.select(".info_price .txt_num .yes_b");
            Elements img = document.select(".img_bdr .lazy");

            for(int index = 0 ; index < name.size() ; index++){
                String bname = name.get(index).text();
                String bprice = price.get(index).text();
                String bimg = img.get(index).attr("data-original"); // attr(속성명) : 해당 속성명의 속성값
                // DTO/Map으로 구성
                Map<String ,Object> map = new HashMap<>();
                map.put("name" , bname); map.put("price" , bprice); map.put("img" , bimg);
                list.add(map);
            }
        }
        }catch (Exception e){System.out.println(e);}

        return list;
    }


    // 동적 페이지 크롤링 예제 1
    public Map<String , Object> test3(){

        // 1. 크롬 드라이버 설치
        WebDriverManager.chromedriver().setup();
        // 2. 크롤링 할 웹 주소
        String url = "https://weather.daum.net/?location-regionId=AB33110208&weather-cp=kweather";
        // 3. 크롬 드라이버 객체 생성
            // 드라이버 옵션
        ChromeOptions options = new ChromeOptions();
            // 크론 백그라운드 실행
        options.addArguments("--headless=new" , "--disable-gpu");

        WebDriver webDriver = new ChromeDriver(options);
        // 4. 크롬 드라이버에 크롤링할 주소 넣기
        webDriver.get(url);
        // 5. 해당 페이지는 동적 new WebDriverWait(현재크롭객체, Duration.ofxxx(대기단위));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(1));
        // 6. 크롤링할 선택자
        WebElement temp = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".info_weather .num_deg")) );
        WebElement temp2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tooltip_icon .ico_airstat1")));
        System.out.println(temp.getText());
        //7. 정보 map으로 구성
        Map<String , Object> map = new HashMap<>();
        map.put("온도" , temp.getText());
        map.put("초미세먼지" , temp2.getText());
        //8. 안전하게 드라이버 종료
        webDriver.quit();

        return map;
    }

    // 동적 크롤링 예제2
    public List<String> test4(){

        // 1 크롬 드라이버 설치
        WebDriverManager.chromedriver().setup();
        String url = "https://cgv.co.kr/cnm/cgvChart/movieChart/30000994";

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new" , "--disable-gpu");

        WebDriver webDriver = new ChromeDriver(options); // 크롬객체

        webDriver.get(url);
        // 자바에서 js 제어하여 스크롤 내리는 방법
        JavascriptExecutor js = (JavascriptExecutor)webDriver; //해당하는 크롬객체에서 js객체 꺼내기
        js.executeScript("window.scrollTo(100 , document.body.scrollHeight)"); //js 문법 사용 가능
            //document.body.scrollHeight : 현재 화면에서 스크롤 전체 길이 = 높이 = 300px , 상단이 = 0 , 하단 = 300
            // .scrollTo(이동할위치 , 전체길이)

        try{Thread.sleep(1000);
        }catch (Exception e){System.out.println(e);}
        List<String> list = new ArrayList<>();
        for(int page = 1; page <= 10 ; page++){
            int startCount = list.size(); // 현재리뷰 개수
            List<WebElement> elements = webDriver.findElements(By.cssSelector(".reveiwCard_txt__RrTgu"));
            System.out.println(elements);

            for(WebElement element : elements){
                String review = element.getText();
                if(list.contains(review)){continue;}
                else{list.add(review);}
            }
            int endCount = list.size(); // 특정 반복문이 1회 종료 되었을때
            if(startCount == endCount){break;} //리뷰 개수가 시작과 끝 개수가 같다면 크롤링 중지

            //스크롤 다시 내리기
            js.executeScript("window.scrollTo(100,document.body.scrollHeight);");
            try{Thread.sleep(1000);
            }catch (Exception e){System.out.println(e);}
        }

        return list;
    }







}

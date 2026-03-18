package example.day12.크롤링;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.AbstractNestablePropertyAccessor;
import org.springframework.stereotype.Service;

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
}

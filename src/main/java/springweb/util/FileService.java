package springweb.util;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
@Transactional
public class FileService {


    // 로컬환경
    private String baseDri = System.getProperty("user.dir");
    private String uploadDir = baseDri+"/build/resources/main/static/upload/"; // 상세 경로
    // 클라우드 환경


    // 업로드
    public String upload(MultipartFile multipartFile){

        // 만약에 파일이 존재하지 않으면
        if(multipartFile == null || multipartFile.isEmpty()==true){return null;}
        // 업로드할 파일의 경로 / 서버경로 , 개발자(src) --> 배포/실행 --> 서버(build파일) <-- 사용자
        File upload = new File(uploadDir);
        // 만약에 해당 경로의 폴더가 존재하지 않으며 폴더 생성
        if(!upload.exists()){
            upload.mkdir(); //file객체.mkdir(); 경로/폴더 생성
        }
        String uuid = UUID.randomUUID().toString();
            // uuid_파일명 : UUID와 파일명 사이에 _언더바 구분하자
            // UUID에는 _언더바 절대없다 하지만 파일명에는 _언더바 존재할 수 있다. (파일명 치환)
        String filename = uuid+"_"+multipartFile.getOriginalFilename().replaceAll("_" , "-");
        // 3 업로드
        File uploadRealPath = new File(uploadDir + filename); // 파일명과 경로 연결해서 최종적인 경로 파일객체 생성
        try {
        multipartFile.transferTo(uploadRealPath); // 업로드 파일을 특정한 경로에 이송/복사 한다. 예외처리 발생
        }catch (Exception e){System.out.println(e);}

        return null;
    }

}

//        System.out.println(multipartFile.isEmpty()); // 첨부파일 존재여부 반환
//        System.out.println(multipartFile.getOriginalFilename()); // 첨부파일의 파일명
//        System.out.println(multipartFile.getContentType()); // 첨부파일의 확장자
//        System.out.println(multipartFile.getSize()); // 파일의 용량(바이트)


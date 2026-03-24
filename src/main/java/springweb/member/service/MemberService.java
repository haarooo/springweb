package springweb.member.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springweb.member.dto.MemberDto;
import springweb.member.entity.MemberEntity;
import springweb.member.repositroy.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 1. 회원가입
    public boolean signUp(MemberDto memberDto){
        MemberEntity saveEntity = memberDto.toEntity();
        String pwd = passwordEncoder.encode(saveEntity.getMpwd());
        saveEntity.setMpwd(pwd);
        MemberEntity saved = memberRepository.save(saveEntity);
        if(saved.getMno() >= 0){return true;}
        return false;
    }

    // 2. 로그인
    public boolean login(MemberDto loginDto){
        // 1. JPA으로 아디디로 엔티티 찾기 , SQL로 아이디/비밀번호 일치 여부로 로그인 판단 불가능
        Optional<MemberEntity> optionalMember = memberRepository.findByMid(loginDto.getMid());
        if(optionalMember.isPresent()){
            MemberEntity memberEntity = optionalMember.get();
            // 비크립트 암호화로 평문과 암호화문 비교
            boolean result = passwordEncoder.matches(loginDto.getMpwd() , memberEntity.getMpwd());
            if(result == true){return true;}
            else{return false;} // 패스워드 다를때

        }
        return false; // 아이디 없을때
    }

    // 3. 마이페이지 , 세션조회
    public MemberDto myInfo(String loginMid){
        // 1) 로그인된 mid를 받아서 리포지토리에서 찾는다
        Optional<MemberEntity> optional = memberRepository.findByMid(loginMid);
        // 2) 만약에 엔티티가 존재하면
        if(optional.isPresent()){
            return optional.get().toDto();
        }
        return null;
    }


}

/*
    암호화
        1. 정의 : 자료를 보호하기 위해 사람이 이해하기 어려운 데이터로 변환
        2. 목적 : 자료보호 , 신뢰성 , 무경성 유지
        3. 사용처 : 비밀번호 , 금융 , HTTPS
        4. 용어 :
            - 평문 : 원래의 자료
            - 암호문 : 암호화된 자료
            - 암호화 : 평문자료를 암호문으로 변환하는 과정
            - 복호화 : 암호문을 평문자료로 변환하는 과정
            - 단방향 암호화 : 평문을 암호문으로 변환하고 다시 평문으로 변환 불가능 , 복호화 불가능
            - 양방향 암호화 : 퍙문을 암호문으로 변환하고 다시 평문으로 변환 가능 , 복호화 가능
            - 해시 함수 : 자료를 고정된 길이로 변환하는 함수
                - 자바 : .hashCode() , Object클래스의 메소드로 객체 주소값을 해시코드(일정한 길이의 값)로 반환
                - "사과" ---> A1B2C3 , 같은 자료는 같은 해시값이 나올 수 있다
                - "바나나" ---> X1G2R3 , 단 서로 다른 자료도 길이는 일정
            - 솔트 : 암호화할때 사용되는 랜덤값 (동일한 계산식(알고리즘/헤시)의 서로 다른 결과값)
                - "사과" --> 솔트추가 --> A3B4C5
        5. 종류
            1) 비밀번호 : Bcrypt(비크립트) , 해시함수 , 단방향
            2) 전자서명/파일 : SHA-256 , 해시함수 , 단방향
            3) 웹통신 : HTTPS(TLS)

        6. 비크립트
            1. 정의 : 해시 함수를 이용하여 주로 비밀번호 암호화 할 때 사용된다
            2. 특징 :
                - 솔트 : 같은 비밀번호 라도 랜덤값으로 서로 다른 암호화된 결과를 만든다
                - 반복연산적용 : 계산식을 여러번하여 검증 속도 늦춤
                - 원본 복구 불가능 : 단뱡항 암호화문으로 복호화 불가능
            3. 형태
                - $2a : 비크립트 버전
                - $10 : 반복연산수 , 제곱근
                - $~22 : salt(22글자)값
                - $22~ : 해시값

            3. 사용법
                BCryptPasswordEncoder 암호객체 = new BcryptPasswordEncoder();
                -String 암호화된값 = 암호객체.encode(암호화할자료)
                -boolean 비교결과 = 암호객체.matches(평문 , 암호문)

*/



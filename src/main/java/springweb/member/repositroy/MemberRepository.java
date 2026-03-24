package springweb.member.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import springweb.member.entity.MemberEntity;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity , Long> {

    // 1. 아이디로 엔티티 찾기
    Optional<MemberEntity> findByMid(String mid);

}

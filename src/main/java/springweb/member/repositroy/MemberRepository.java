package springweb.member.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import springweb.member.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity , Long> {
}

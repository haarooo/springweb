package springweb.member.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass //엔티티의 상속용도 클래스
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
    @CreatedDate //엔티티 생성날짜/시간주입
    private LocalDateTime createDate;
    @LastModifiedDate//엔티티 수정날짜/시간주입
    private LocalDateTime updateDate;
}

package pythonML.practice7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import pythonML.practice7.entity.FashionEntity;

@Repository
public interface FashionRepository extends JpaRepository<FashionEntity ,Integer> {
}

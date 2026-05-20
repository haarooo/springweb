package pythonML.practice6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pythonML.practice6.dto.CarDto;
import pythonML.practice6.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
}

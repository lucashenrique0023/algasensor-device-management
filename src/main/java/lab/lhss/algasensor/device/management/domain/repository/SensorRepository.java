package lab.lhss.algasensor.device.management.domain.repository;

import lab.lhss.algasensor.device.management.domain.model.Sensor;
import lab.lhss.algasensor.device.management.domain.model.SensorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, SensorId> {
}

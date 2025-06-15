package lab.lhss.algasensor.device.management.api.controller;

import lab.lhss.algasensor.device.management.api.model.SensorInput;
import lab.lhss.algasensor.device.management.common.IdGenerator;
import lab.lhss.algasensor.device.management.domain.model.Sensor;
import lab.lhss.algasensor.device.management.domain.model.SensorId;
import lab.lhss.algasensor.device.management.domain.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorRepository sensorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sensor create(@RequestBody SensorInput input) {
        var sensor = Sensor.builder()
                .id(new SensorId(IdGenerator.generateTSID()))
                .name(input.getName())
                .ip(input.getIp())
                .location(input.getLocation())
                .protocol(input.getProtocol())
                .model(input.getModel())
                .enabled(false)
                .build();

        return sensorRepository.saveAndFlush(sensor);
    }

}

package io.susimsek.hazelcastcache.bootstrap;

import io.susimsek.hazelcastcache.domain.Car;
import io.susimsek.hazelcastcache.repository.CarRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CarDataLoader {

    final CarRepository carRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void generateDefaultData() {
        Long count = carRepository.count();
        if (count == 0L) {
            List<String> colors = List.of("Black", "White", "Red", "Blue");
            List<Car> carList = new ArrayList<>();
            Date newDate = new Date();
            for (int i = 0; i < 5; i++) {
                carList.add(
                        Car.builder()
                                .brand("HKCar")
                                .colour(colors.get(i % 3))
                                .doorCount(4)
                                .fuel("Diesel")
                                .model("SuperCar")
                                .serial("SR" + i)
                                .type("TypeC")
                                .year(2020)
                                .build()
                );
            }
            carRepository.saveAll(carList);
        }
    }


}

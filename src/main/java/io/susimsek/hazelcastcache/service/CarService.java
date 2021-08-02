package io.susimsek.hazelcastcache.service;

import io.susimsek.hazelcastcache.service.dto.CarDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CarService {
    CarDto save(CarDto carDto);

    CarDto update(Long id, CarDto carDto);

    Optional<CarDto> partialUpdate(CarDto carDto);

    Page<CarDto> findAll(Pageable pageable);

    Optional<CarDto> findOne(Long id);

    void delete(Long id);
}

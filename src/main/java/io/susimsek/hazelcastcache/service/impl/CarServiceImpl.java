package io.susimsek.hazelcastcache.service.impl;


import io.susimsek.hazelcastcache.domain.Car;
import io.susimsek.hazelcastcache.errors.ResourceNotFoundException;
import io.susimsek.hazelcastcache.repository.CarRepository;
import io.susimsek.hazelcastcache.service.dto.CarDto;
import io.susimsek.hazelcastcache.service.mapper.CarMapper;
import io.susimsek.hazelcastcache.service.CarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
@Transactional
public class CarServiceImpl implements CarService {


    final CarRepository carRepository;

    final CarMapper carMapper;


    @Override
    public CarDto save(CarDto carDto) {
        log.debug("Request to save Car : {}", carDto);
        Car car = carMapper.toEntity(carDto);

        car = carRepository.save(car);
        CarDto result = carMapper.toDto(car);
        return result;
    }

    @Override
    public CarDto update(Long id, CarDto carDto) {
        if (!carRepository.existsById(id)) {
            throw new ResourceNotFoundException("Car", "id", id);
        }
        carDto.setId(id);

        Car car = carMapper.toEntity(carDto);
        car = carRepository.save(car);
        CarDto result = carMapper.toDto(car);
        return result;
    }

    @Override
    public Optional<CarDto> partialUpdate(CarDto carDto) {
        log.debug("Request to partially update Car : {}", carDto);

        Optional<Car> result =  carRepository.findById(carDto.getId());

        if (result.isEmpty()){
            throw new ResourceNotFoundException("Car", "id", carDto.getId());
        }

        return result
            .map(
                existingCar -> {
                    carMapper.partialUpdate(existingCar, carDto);

                    return existingCar;
                }
            )
            .map(carRepository::save)
            .map(carMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CarDto> findAll(Pageable pageable) {
        log.debug("Request to get all Cars");
        return carRepository.findAll(pageable).map(carMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CarDto> findOne(Long id) {
        log.debug("Request to get Car : {}", id);
        Optional<Car> result =  carRepository.findById(id);

        if (result.isEmpty()){
            throw new ResourceNotFoundException("Car", "id", id);
        }

        return result.map(carMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Car : {}", id);

        if (!carRepository.existsById(id)) {
            throw new ResourceNotFoundException("Car", "id", id);
        }


        carRepository.deleteById(id);
    }
}

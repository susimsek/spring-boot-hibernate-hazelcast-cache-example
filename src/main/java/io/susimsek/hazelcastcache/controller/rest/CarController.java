package io.susimsek.hazelcastcache.controller.rest;

import io.susimsek.hazelcastcache.service.CarService;
import io.susimsek.hazelcastcache.service.dto.CarDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Tag(name = "car", description = "Car API")
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CarController {

    final CarService carService;

    @Operation(summary = "Add a new car", description = "", tags = { "car" })
    @PostMapping("/cars")
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto carDto) throws URISyntaxException {
        log.debug("REST request to save Car : {}", carDto);

        CarDto result = carService.save(carDto);
        return ResponseEntity
                .created(new URI("/api/cars/" + result.getId()))
                .body(result);
    }


    @Operation(summary = "Update an existing car", description = "", tags = { "car" })
    @PutMapping("/cars/{id}")
    public ResponseEntity<CarDto> updateCar(
            @PathVariable(value = "id", required = false) final Long id,
            @Valid @RequestBody CarDto carDto
    ) throws URISyntaxException {
        log.debug("REST request to update Car : {}, {}", id, carDto);

        CarDto result = carService.update(id, carDto);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @Operation(summary = "Partial update an existing car partially", description = "", tags = { "car" })
    @PatchMapping(value = "/cars/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<CarDto> partialUpdateCar(
            @PathVariable(value = "id", required = false) final Long id,
            @NotNull @RequestBody CarDto carDto
    ) throws URISyntaxException {
        log.debug("REST request to partial update Car partially : {}, {}", id, carDto);

        Optional<CarDto> result = carService.partialUpdate(carDto);

        return ResponseEntity.ok().body(result.get());
    }

    @Operation(summary = "Find all cars", description = "Returns car list", tags = { "contact" })
    @GetMapping("/cars")
    public ResponseEntity<Page<CarDto>> getAllCars(@ParameterObject Pageable pageable) {
        log.debug("REST request to get Cars");
        Page<CarDto> page = carService.findAll(pageable);
        return ResponseEntity.ok().body(page);
    }

    @Operation(summary = "Find car by ID", description = "Returns a single car", tags = { "car" })
    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable Long id) {
        log.debug("REST request to get Car : {}", id);
        Optional<CarDto> carDto = carService.findOne(id);
        return ResponseEntity.ok().body(carDto.get());
    }


    @Operation(summary = "Deletes a car", description = "", tags = { "car" })
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        log.debug("REST request to delete Car : {}", id);
        carService.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
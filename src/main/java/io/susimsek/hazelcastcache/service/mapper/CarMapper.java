package io.susimsek.hazelcastcache.service.mapper;


import io.susimsek.hazelcastcache.domain.Car;
import io.susimsek.hazelcastcache.service.dto.CarDto;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Car} and its DTO {@link CarDto}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CarMapper extends EntityMapper<CarDto, Car> {}

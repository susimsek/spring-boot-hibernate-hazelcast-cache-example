package io.susimsek.hazelcastcache.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto implements Serializable {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    Long id;

    @NotBlank
    String serial;

    @NotBlank
    String model;

    @NotBlank
    String brand;

    Integer year;

    @NotBlank
    String type;

    int doorCount;

    @NotBlank
    String colour;

    @NotBlank
    String fuel;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarDto)) {
            return false;
        }

        CarDto productDto = (CarDto) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, productDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}

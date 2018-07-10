package ro.arnia.ridesharing.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Location {
    private BigDecimal latitude;
    private BigDecimal longitude;

}

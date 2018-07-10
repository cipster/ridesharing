package ro.arnia.ridesharing.domain.model;

import lombok.Data;

@Data
public class Rating{
    private int stars;
    private String comment;
}

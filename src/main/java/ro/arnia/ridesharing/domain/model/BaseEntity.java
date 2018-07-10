package ro.arnia.ridesharing.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseEntity {

    @Id
    private Long id;

}

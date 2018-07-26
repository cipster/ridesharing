package ro.arnia.ridesharing.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class BaseEntity {

    //@Indexed(direction = IndexDirection.ASCENDING)
    @Id private String id;

}

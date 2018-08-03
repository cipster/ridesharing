package ro.arnia.ridesharing.domain.model;


import org.springframework.data.annotation.Id;

public class BaseEntity {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

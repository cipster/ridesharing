package ro.arnia.ridesharing.domain.model;

import java.math.BigDecimal;

public class Location {

    private BigDecimal latitude;
    private BigDecimal longitude;

    public Location(BigDecimal la, BigDecimal lo) {
        this.latitude = la;
        this.longitude = lo;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }


}

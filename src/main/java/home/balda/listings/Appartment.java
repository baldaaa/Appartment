package home.balda.listings;

import javax.persistence.*;

@Entity
@Table(name = "Appartment")
/**
 * id,street,status,price,bedrooms,bathrooms,sq_ft,lat,lng
 */
public class Appartment {

    @Id
    @GeneratedValue
    Long id;
    @Column
    String nativeId;
    @Column
    String street;
    @Column
    String status;
    @Column
    Integer price;
    @Column
    Integer bedrooms;
    @Column
    Integer bathrooms;
    @Column
    Integer sq_ft;
    @Column
    Float lat;
    @Column
    Float lng;

    public Appartment(){}
    public Appartment(String nativeId, String street,String status,Integer price,
                      Integer bedrooms,Integer bathrooms,Integer sq_ft,
                      Float lat,Float lng){
        this.nativeId = nativeId;
        this.street = street;
        this.status = status;
        this.price = price;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.sq_ft = sq_ft;
        this.lat = lat;
        this.lng = lng;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getSq_ft() {
        return sq_ft;
    }

    public void setSq_ft(Integer sq_ft) {
        this.sq_ft = sq_ft;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public String getNativeId() {
        return nativeId;
    }

    public void setNativeId(String nativeId) {
        this.nativeId = nativeId;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }
}

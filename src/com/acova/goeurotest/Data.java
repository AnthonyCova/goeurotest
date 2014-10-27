package com.acova.goeurotest;

/**
 *
 * @author Anthony
 */
public class Data {

    Integer _id;
    String key;
    String name;
    String fullName;
    String iata_airport_code;
    String type;
    String country;
    GeoPosition geo_position;
    Integer locationId;
    boolean inEurope;
    String countryCode;
    boolean coreCountry;
    String distance;

    public void setId(Integer _id) {
        this._id = _id;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIata_airport_code(String iata_airport_code) {
        this.iata_airport_code = iata_airport_code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGeo_position(GeoPosition geo_position) {
        this.geo_position = geo_position;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIata_airport_code() {
        return iata_airport_code;
    }

    public String getType() {
        return type;
    }

    public Integer getId() {
        return _id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public String getCountry() {
        return country;
    }

    public GeoPosition getGeo_position() {
        return geo_position;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public boolean isCoreCountry() {
        return coreCountry;
    }

    public String getDistance() {
        return distance;
    }

}

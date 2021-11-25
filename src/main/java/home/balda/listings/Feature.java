package home.balda.listings;

import java.util.Map;

/**
 * {
 * "type": "FeatureCollection", "features": [
 * {
 * "type": "Feature",
 * "geometry": { "type": "Point", "coordinates": [-112.1, 33.4] }, "properties": {
 * "id": "123ABC", #CSVid
 * "price": 200000, #PriceinDollars "street": "123 Walnut St", "bedrooms": 3,
 * "bathrooms": 2,
 * "sq_ft": 1500 #SquareFootage
 * } },
 */
public class Feature {
    ListingEnum type = ListingEnum.Feature;
    Geometry geometry;
    Map<Object,Object> properties;

    public ListingEnum getType() {
        return type;
    }

    public void setType(ListingEnum type) {
        this.type = type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Map<Object,Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<Object,Object> properties) {
        this.properties = properties;
    }
}

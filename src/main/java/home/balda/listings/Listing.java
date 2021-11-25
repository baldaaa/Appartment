package home.balda.listings;

import java.util.List;

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
public class Listing {
    ListingEnum type = ListingEnum.FeatureCollection;
    List< Feature> features;



}

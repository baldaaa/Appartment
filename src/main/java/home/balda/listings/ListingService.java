package home.balda.listings;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class ListingService {
    @Autowired
    AppartmentRepository repository;
    @Autowired
    RestTemplate restTemplate;

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
    public List<Listing> get(int min_price, int max_price, int min_bed, int max_bed, int mmin_bath, int max_bath) {

        List<Appartment> appartments = repository.getApartnents(min_price,max_price,min_bed,max_bed,mmin_bath,max_bath);
        List<Listing> listings = new ArrayList<>();
        appartments.forEach(app ->{
            Listing listing = new Listing();
            Feature feature = new Feature();
            Geometry geometry = new Geometry();
            geometry.setCoordinates(new Float[]{app.lat,app.lng});
            feature.setGeometry(geometry);
            Map<Object,Object> properties = new HashMap<>();
            properties.put("id",app.getNativeId());
            properties.put("price", app.getPrice());
            properties.put("street",app.getStreet());
            properties.put("bedrooms",app.getBedrooms());
            properties.put("bathrooms",app.getBathrooms());
            properties.put("sq_ft",app.getSq_ft());
            feature.setProperties(properties);
            listing.setFeatures(feature);
            listings.add(listing);

        });
        return listings;
    }

    public void save() {

        try {
            List<Appartment> tutorials = CSVHelper.csvToTutorials(new FileReader(getCSV()));
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    private File getCSV() {

        File file = restTemplate.execute("https://server-assignment.s3.amazonaws.com/listing-details.csv", HttpMethod.GET, null, clientHttpResponse -> {
            File ret = File.createTempFile("download", "tmp");
            StreamUtils.copy(clientHttpResponse.getBody(), new FileOutputStream(ret));
            return ret;
        });
        return file;
    }

}

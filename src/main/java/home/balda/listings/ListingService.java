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
import java.util.List;

@Service
public class ListingService {
    @Autowired
    AppartmentRepository repository;
    @Autowired
    RestTemplate restTemplate;


    public List<Listing> get(int min_price, int max_price, int min_bed, int max_bed, int minPrice, int maxPrice) {
        return null;
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

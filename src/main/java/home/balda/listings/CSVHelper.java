package home.balda.listings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVHelper {
        public static String TYPE = "text/csv";
        static String[] HEADERs = { "id","street","status","price","bedrooms","bathrooms","sq_ft","lat","lng" };


        public static List<Appartment> csvToTutorials(FileReader is) {
            try (
                    BufferedReader fileReader = new BufferedReader(is);
                 CSVParser csvParser = new CSVParser(fileReader,
                         CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

                List<Appartment> appartments = new ArrayList<Appartment>();

                Iterable<CSVRecord> csvRecords = csvParser.getRecords();

                for (CSVRecord csvRecord : csvRecords) {
                    Appartment appartment = new Appartment(
                            csvRecord.get("street"),
                            csvRecord.get("status"),
                            Integer.parseInt(csvRecord.get("price")),
                            Integer.parseInt(csvRecord.get("bedrooms")),
                            Integer.parseInt(csvRecord.get("bathrooms")),
                            Integer.parseInt(csvRecord.get("sq_ft")),
                            Float.parseFloat(csvRecord.get("lat")),
                            Float.parseFloat(csvRecord.get("lat"))
                    );
                    appartments.add(appartment);
                }
                return appartments;
            } catch ( IOException e) {
                throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
            }
        }

    }


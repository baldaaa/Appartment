package home.balda.listings;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value="listings")
@RestController
@RequestMapping(path = "/listings")
/**
 * GET /listings?min_price=100000&max_price=200000&min_bed=2&max_bed=2&min_b ath=2&max_bath=2
 */
public class ListingController {


    @Autowired
    ListingService listingService;

    @ApiOperation(value = "Get Apartments")
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<Listing>> get(@RequestParam int min_price, @RequestParam int max_price,
                                             @RequestParam int min_bed, @RequestParam int max_bed,
                                             @RequestParam int min_bath, @RequestParam int max_bath) {
        return new ResponseEntity<List<Listing>>(this.listingService.get(min_price,max_price,min_bed,max_bed,min_price,max_price), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all apartments and save to DB")
    @RequestMapping(method = RequestMethod.GET, path = "/save")
    public void saveToDB() {
        this.listingService.save();
    }
}
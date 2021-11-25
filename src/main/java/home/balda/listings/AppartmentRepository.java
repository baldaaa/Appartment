package home.balda.listings;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppartmentRepository extends CrudRepository<Appartment, Long> {
    @Query(value = "SELECT * FROM Appartment WHERE price between ?1 and ?2 AND bedrooms between ?3 and ?4 AND bathrooms between ?5 and ?6", nativeQuery = true)
    List<Appartment> getApartnents(int min_price, int max_price, int min_bed, int max_bed, int min_bath, int max_bath);
}

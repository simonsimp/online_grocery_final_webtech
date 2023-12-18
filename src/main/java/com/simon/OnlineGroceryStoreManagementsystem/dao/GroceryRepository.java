package com.simon.OnlineGroceryStoreManagementsystem.dao;




import com.simon.OnlineGroceryStoreManagementsystem.model.Grocery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroceryRepository extends PagingAndSortingRepository<Grocery, Long> {
    //searching using a keyword
    @Query("SELECT g FROM Grocery g WHERE "
            + "CONCAT(g.name, g.description, g.price, g.quantityInStock, g.category, g.manufactureDate," +
            " g.expiryDate)" + "LIKE %?1%")
    public Page<Grocery> findAll(String keyword, Pageable pageable);
}

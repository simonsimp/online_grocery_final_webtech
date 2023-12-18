package com.simon.OnlineGroceryStoreManagementsystem.service;




import com.simon.OnlineGroceryStoreManagementsystem.model.Grocery;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GroceryService {
    Page<Grocery> findAll(int pageNumber, String keyword);



    Grocery findById(Long theId);

    void save(Grocery theGrocery, Long userId);

    void deleteById(Long theId);

    List<Grocery> findAll();
}

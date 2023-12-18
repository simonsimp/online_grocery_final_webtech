package com.simon.OnlineGroceryStoreManagementsystem.service;




import com.simon.OnlineGroceryStoreManagementsystem.dao.GroceryRepository;
import com.simon.OnlineGroceryStoreManagementsystem.model.Grocery;
import com.simon.OnlineGroceryStoreManagementsystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryServiceImpl implements GroceryService {

    private GroceryRepository groceryRepository;
    private UserService userService;

    private EntityManager entityManager;

    @Autowired
    public GroceryServiceImpl(GroceryRepository theGroceryRepository, UserService theuserService, EntityManager theentityManager) {
        groceryRepository = theGroceryRepository;
        this.userService = theuserService;
        this.entityManager = theentityManager;
    }

    @Override
    public List<Grocery> findAll() {
        // create query
        TypedQuery<Grocery> theQuery = entityManager.createQuery("SELECT g FROM Grocery g ORDER BY g.name ASC", Grocery.class);

        // return query results
        return theQuery.getResultList();
    }


    // Pageable findAll

    @Override
    public Page<Grocery> findAll(int pageNumber, String keyword) {
        Sort sort = Sort.by("name").ascending();

        Pageable pageable = PageRequest.of(pageNumber - 1, 2, sort);
        if(keyword !=null){
            return groceryRepository.findAll(keyword, pageable);
        }
        return groceryRepository.findAll(pageable);
    }


    @Override
    public Grocery findById(Long theId) {
        Optional<Grocery> result = groceryRepository.findById(theId);

        Grocery grocery = null;

        if (result.isPresent()) {
            grocery = result.get();
        }
        else {
            // we didn't find the project
            throw new RuntimeException("Did not find Grocery id - " + theId);
        }

        return grocery;
    }


    @Override
    @Transactional
    public void save(Grocery grocery, Long UserId) {
        User existingUser = userService.findById(UserId);
        existingUser.add(grocery);
        groceryRepository.save(grocery);
    }

    @Override
    public void deleteById(Long theId) {
        groceryRepository.deleteById(theId);
    }
}

package com.improve1.pgmtCarShopPr.repository;

import com.improve1.pgmtCarShopPr.model.Sproduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

//@Bean
@Repository
//@Component
public interface StudentsRepository extends JpaRepository<Sproduct, Integer> {

}
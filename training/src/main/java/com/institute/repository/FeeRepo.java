
package com.institute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.institute.model.Fee;

public interface FeeRepo extends JpaRepository<Fee, Integer> {
}
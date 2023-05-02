package com.project.coches.project_coches.persistence.crud;

import com.project.coches.project_coches.persistence.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCarCrudRepository  extends JpaRepository<BrandCarEntity, Integer> {
}

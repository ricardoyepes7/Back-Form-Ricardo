package com.example.form.infraestructure.output.jpa.repository;

import com.example.form.infraestructure.output.jpa.entity.DegreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDegreeRepository extends JpaRepository<DegreeEntity,Long> {
    List<DegreeEntity> findByUserId(long userId);
    void deleteByUserId(Long userId);
}

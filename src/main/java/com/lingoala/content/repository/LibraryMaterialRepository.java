package com.lingoala.content.repository;

import com.lingoala.content.domain.LibraryMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LibraryMaterialRepository extends JpaRepository<LibraryMaterial, Long>, JpaSpecificationExecutor<LibraryMaterial> {
}

package com.lingoala.content.repository;

import com.lingoala.content.domain.LibraryContentPart;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface LibraryContentPartRepository extends JpaRepository<LibraryContentPart, Long>,
        JpaSpecificationExecutor<LibraryContentPart>
{
    @Override
    @EntityGraph(attributePaths = {"parent", "child", "child.material"})
    Optional<LibraryContentPart> findById(Long aLong);

    @Override
    @EntityGraph(attributePaths = {"parent", "child"})
    List<LibraryContentPart> findAll();
}

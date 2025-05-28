package com.codehelp.CodeHelp.Repositories;

import com.codehelp.CodeHelp.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Optional<Tag> findByName(String name);
}
package com.docs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docs.entities.Docs;

public interface DocsRepository extends JpaRepository<Docs, Long> {

}

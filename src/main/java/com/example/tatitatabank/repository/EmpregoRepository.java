package com.example.tatitatabank.repository;

import com.example.tatitatabank.model.Emprego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpregoRepository extends JpaRepository<Emprego, Long> {

    Optional<Emprego> findByIdEmpregoAndAtivoIs(Long emprego, char s);
}

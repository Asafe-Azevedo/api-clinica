package br.com.clinica.repository;

import br.com.clinica.funcionarios.Contabil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContabilRepository extends JpaRepository<Contabil, Long> {

    Page<Contabil> findAllByAtivoTrue(Pageable pageable);
}

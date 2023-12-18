package br.com.clinica.repository;

import br.com.clinica.funcionarios.Administrador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Page<Administrador> findAllByAtivoTrue(Pageable pageable);
}

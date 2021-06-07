package com.george.orangetalent.repositories;

import com.george.orangetalent.entities.Veiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByUsuario(Long usuario);
}

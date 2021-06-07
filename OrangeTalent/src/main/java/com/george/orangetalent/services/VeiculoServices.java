package com.george.orangetalent.services;

import com.george.orangetalent.dtos.VeiculoDto;
import com.george.orangetalent.entities.Veiculo;
import com.george.orangetalent.repositories.VeiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoServices {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public Veiculo salvar(Long usuario, VeiculoDto veiculoDto) {

        Veiculo veiculo = new Veiculo();

        veiculo.setUsuario(usuario);
        veiculo.setMarca(veiculoDto.getMarca());
        veiculo.setModelo(veiculoDto.getModelo());
        veiculo.setAno(veiculoDto.getAno());
        int digitoAno = (veiculoDto.getAno() % 10);

        switch (digitoAno) {
            case 0:
            case 1:
                veiculo.setDiaRodizio("Segunda-feira");
                break;
            case 2:
            case 3:
                veiculo.setDiaRodizio("Terça-feira");
                break;
            case 4:
            case 5:
                veiculo.setDiaRodizio("Quarta-feira");
                break;
            case 6:
            case 7:
                veiculo.setDiaRodizio("Quinta-feira");
                break;
            case 8:
            case 9:
                veiculo.setDiaRodizio("Sexta-feira");
                break;
        }

        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> buscar(Long id) {

        return veiculoRepository.findByUsuario(id);
    }
}

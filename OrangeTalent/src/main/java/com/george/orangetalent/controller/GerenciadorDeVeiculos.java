package com.george.orangetalent.controller;

import com.george.orangetalent.dtos.VeiculoDto;
import com.george.orangetalent.entities.Veiculo;
import com.george.orangetalent.responses.Response;
import com.george.orangetalent.services.VeiculoServices;
import java.net.URI;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/orangetalent/")
public class GerenciadorDeVeiculos {

    @Autowired
    private VeiculoServices veiculoServices;

    @PostMapping(path = "/usuarios/{id}/newcar")
    public ResponseEntity<Response<Veiculo>> cadastrar(
            @Valid @RequestBody VeiculoDto veiculoDto, 
            BindingResult result, @PathVariable("id") Long id) {
        Response<Veiculo> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors()
                    .add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Veiculo veiculoSalvo = this.veiculoServices.salvar(id, veiculoDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(veiculoDto.getId())
                .toUri();
        response.setData(veiculoSalvo);
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/veiculos")
    public ResponseEntity<List<Veiculo>> listar() {
        List<Veiculo> veiculos = veiculoServices.listar();
        return ResponseEntity.status(HttpStatus.OK).body(veiculos);
    }

    @GetMapping(path = "/usuarios/{id}/veiculos")
    public ResponseEntity<List<Veiculo>> buscar(@PathVariable("id") Long id) {

        List<Veiculo> veiculos = veiculoServices.buscar(id);
        
        Calendar c = new GregorianCalendar();        
        for(int i=0; i<veiculos.size(); i++){
            Veiculo v = veiculos.get(i);
            if(v.getDiaRodizio().equalsIgnoreCase(weekDay(c))){                
                v.setRodizioAtivo(true);
            } else {
                v.setRodizioAtivo(false);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculos);
    }
    
    public String weekDay(Calendar cal) { 
            return new DateFormatSymbols()
                    .getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)]; 
    }
}
package com.agencia.envios.Agencia.envios.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.agencia.envios.Agencia.envios.services.*;
import com.agencia.envios.Agencia.envios.entities.*;

import javax.validation.Valid;

import com.agencia.envios.Agencia.envios.entities.UpdatePaqueteChecks;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
class PaqueteController {

    private final PaqueteRepository repository;

    PaqueteController(PaqueteRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/paquetes")
    List<Paquete> all(@RequestParam(required = false) Integer idRemitente,
                      @RequestParam(required = false) Integer idDestinatario,
                      @RequestParam(required = false) String ciudadOrigen,
                      @RequestParam(required = false) String ciudadDestino,
                      @RequestParam(required = false) Paquete.Estado estado,
                      @RequestParam(required = false) Paquete.Tamano tamano
                      ) {

        if(idRemitente != null) return repository.findByIdRemitente(idRemitente);
        if(idDestinatario != null) return repository.findByIdDestinatario(idDestinatario);
        if(ciudadDestino != null) return repository.findByCiudadDestino(ciudadDestino);
        if(ciudadOrigen != null) return repository.findByCiudadOrigen(ciudadOrigen);
        if(estado != null) return repository.findByEstado(estado);
        if(tamano != null) return repository.findByTamano(tamano);

        return repository.findAll();
    }
    @PostMapping("/paquetes")
    Paquete newPaquete(@Valid @RequestBody Paquete newPaquete) {
        return repository.save(newPaquete);
    }

    @GetMapping("/paquetes/{id}")
    Paquete one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PaqueteNotFoundException(id));
    }

    @PutMapping("/paquetes/{id}")
    Paquete replacePaquete(@Validated(UpdatePaqueteChecks.class) @RequestBody Paquete newPaquete, @PathVariable Long id) {
       Paquete paquete = this.one(id);
       paquete.setEstado(newPaquete.getEstado());
       return repository.save(paquete);
    }

    @DeleteMapping("/paquetes/{id}")
    void deletePaquete(@PathVariable Long id) {
        Paquete paquete = this.one(id);
        repository.delete(paquete);
    }
}

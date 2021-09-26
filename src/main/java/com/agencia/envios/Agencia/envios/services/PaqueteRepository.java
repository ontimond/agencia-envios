package com.agencia.envios.Agencia.envios.services;

import com.agencia.envios.Agencia.envios.entities.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaqueteRepository extends JpaRepository<Paquete, Long> {

    List<Paquete> findByIdRemitente(int idRemitente);
    List<Paquete> findByIdDestinatario(int idDestinatario);
    List<Paquete> findByCiudadDestino(String ciudadDestino);
    List<Paquete> findByCiudadOrigen(String ciudadOrigen);
    List<Paquete> findByEstado(Paquete.Estado estado);
    List<Paquete> findByTamano(Paquete.Tamano tamano);
}

package umg.edu.analisis_ii.sistema_votaciones.services;


import umg.edu.analisis_ii.sistema_votaciones.models.UsuarioVoto;

import java.util.Optional;

public interface UsuarioVotoService {

    Optional<UsuarioVoto> findbyCui(String cui);

    UsuarioVoto save(UsuarioVoto usuario);



 }

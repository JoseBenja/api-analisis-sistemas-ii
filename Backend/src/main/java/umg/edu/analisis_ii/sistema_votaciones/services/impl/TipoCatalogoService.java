package umg.edu.analisis_ii.sistema_votaciones.services.impl;

import umg.edu.analisis_ii.sistema_votaciones.models.TipoCatalogo;

import java.util.List;

public interface TipoCatalogoService {
    List<TipoCatalogo> getAllCatalogos();
    TipoCatalogo getTipoCatalogoByNombre(String nombre);
    TipoCatalogo saveTipoCatalogo(TipoCatalogo catalogo);
    void deleteTipoCatalogo(String nombre);
}

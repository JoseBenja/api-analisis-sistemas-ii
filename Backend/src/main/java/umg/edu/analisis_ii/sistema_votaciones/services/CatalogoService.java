package umg.edu.analisis_ii.sistema_votaciones.services;

import umg.edu.analisis_ii.sistema_votaciones.models.Catalogo;

import java.util.List;

public interface CatalogoService {
    List<Catalogo> getAllCatalogos();
    Catalogo getCatalogoByNombre(String nombre);
    Catalogo saveCatalogo(Catalogo catalogo);
    void deleteCatalogo(String nombre);
}

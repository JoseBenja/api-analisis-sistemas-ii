package umg.edu.analisis_ii.sistema_votaciones.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.analisis_ii.sistema_votaciones.models.Catalogo;
import umg.edu.analisis_ii.sistema_votaciones.repositories.CatalogoRepository;
import umg.edu.analisis_ii.sistema_votaciones.services.CatalogoService;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoServiceImpl implements CatalogoService {
    @Autowired
    private CatalogoRepository catalogoRepository;

    @Override
    public List<Catalogo> getAllCatalogos() {
        return catalogoRepository.findAll();
    }

    @Override
    public Catalogo getCatalogoByNombre(String nombre) {
        Optional<Catalogo> optionalCatalogo = catalogoRepository.findById(nombre);
        return optionalCatalogo.orElse(null);
    }

    @Override
    public Catalogo saveCatalogo(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    @Override
    public void deleteCatalogo(String nombre) {
        catalogoRepository.deleteById(nombre);
    }
}

package umg.edu.analisis_ii.sistema_votaciones.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umg.edu.analisis_ii.sistema_votaciones.models.TipoCatalogo;
import umg.edu.analisis_ii.sistema_votaciones.repositories.TipoCatalogoRepository;

import java.util.List;
@Service
public class TipoCatalogoServiceImpl implements TipoCatalogoService{
    @Autowired
    private TipoCatalogoRepository tipoCatalogoRepository;

    @Override
    public List<TipoCatalogo> getAllCatalogos() {
        return tipoCatalogoRepository.findAll();
    }

    @Override
    public TipoCatalogo getTipoCatalogoByNombre(String nombre) {
        return tipoCatalogoRepository.findById(nombre).orElse(null);
    }

    @Override
    public TipoCatalogo saveTipoCatalogo(TipoCatalogo catalogo) {
        return tipoCatalogoRepository.save(catalogo);
    }

    @Override
    public void deleteTipoCatalogo(String nombre) {
        tipoCatalogoRepository.deleteById(nombre);
    }
}

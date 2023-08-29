package umg.analisis.sistemas.apirenap.commons;

import java.util.Optional;

public interface CommonSvc<E> {
    public Iterable<E> findAll();

    public Optional<E> findById(Object id);

    public E save(E entity);

    public void deleteById(Object id);
}

package cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.domain.Sucursal;

@Repository
public interface SucursalRepository extends CrudRepository<Sucursal, Integer>{

}

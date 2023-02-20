package com.dustin.dojoninjas.repositories;

import com.dustin.dojoninjas.models.Ninja;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
  List<Ninja> findAll();
}

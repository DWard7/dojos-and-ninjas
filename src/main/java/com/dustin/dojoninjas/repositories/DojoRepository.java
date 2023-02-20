package com.dustin.dojoninjas.repositories;

import com.dustin.dojoninjas.models.Dojo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
  List<Dojo> findAll();
}

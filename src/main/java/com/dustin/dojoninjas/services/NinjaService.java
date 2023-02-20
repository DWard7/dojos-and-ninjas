package com.dustin.dojoninjas.services;

import com.dustin.dojoninjas.models.Ninja;
import com.dustin.dojoninjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

  @Autowired
  NinjaRepository ninjaRepository;

  public void addNinja(Ninja ninja) {
    ninjaRepository.save(ninja);
  }
}

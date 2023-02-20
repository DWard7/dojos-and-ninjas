package com.dustin.dojoninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dustin.dojoninjas.models.Dojo;
import com.dustin.dojoninjas.models.Ninja;
import com.dustin.dojoninjas.services.DojoService;
import com.dustin.dojoninjas.services.NinjaService;

@Controller
public class MainController {

  @Autowired
  DojoService dojoService;

  @Autowired
  NinjaService ninjaService;

  //! CREATE Dojo
  @RequestMapping(value = { "/dojos/new", "/" })
  public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
    return "dojos/new.jsp";
  }
  //! Handle Dojo from form
  @PostMapping("/dojos")
  public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
    dojoService.createDojo(dojo);
    return "redirect:/";
  }
  //! CREATE Ninja
  @GetMapping("/ninjas/new")
  public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
    List<Dojo> dojos = dojoService.getAll();
    model.addAttribute("dojos", dojos);
    return "ninjas/new.jsp";
  }
  //! Handle Ninja from form
  @PostMapping("/ninjas")
  public String createNinja(@ModelAttribute("ninja")Ninja ninja) {
    ninjaService.addNinja(ninja);
    return "redirect:/";
  }

  //! Display dojo and ninjas
  @GetMapping("/dojos/{id}")
  public String showDojo(@PathVariable("id")Long id, Model model){
    Dojo dojo = dojoService.getOne(id);
    System.out.println(dojo.getNinjas().get(0).getFirst());
    model.addAttribute("dojo", dojo);
    return "dojos/show.jsp";
  }



}

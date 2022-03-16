package com.karitoreyes.project.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.karitoreyes.project.models.Idioma;
import com.karitoreyes.project.services.IdiomaService;

@Controller
@RequestMapping("/languages")
public class IdiomaController {
	private final IdiomaService idiomaService;
    public IdiomaController(IdiomaService idiomaService){
        this.idiomaService = idiomaService;
    }
    
	@RequestMapping("")
	public String index(Model model) {
		List<Idioma> idiomas = idiomaService.allIdiomas();
		model.addAttribute("idiomas", idiomas);
		return "index.jsp";
	}
	
	@RequestMapping("/{id}")
	public String showidioma(
			Model model,
			@PathVariable("id") Long id
	) {
		Idioma idioma = idiomaService.finIdioma(id);
		model.addAttribute("idioma", idioma);
		return "show.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(
			Model model,
			@PathVariable("id") Long id
	) {
		Idioma idioma = idiomaService.finIdioma(id);
		model.addAttribute("idioma", idioma);
		return "edit.jsp";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(
			@PathVariable("id") Long id
	) {
		idiomaService.deleteIdioma(id);
		return "redirect:/languages";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String create(
		@RequestParam(value="id", required=false) Long id,
	    @RequestParam("name") String name,
	    @RequestParam("creator") String creator,
	    @RequestParam("version") String version,
	    RedirectAttributes redirectAttributes
	){
		boolean InsertLanguaguefail = false;
		if(name.equals("") || creator.equals("") || version.equals("")) {
			redirectAttributes.addFlashAttribute("error_todos", "Todos los datos son obligatorios.");
			InsertLanguaguefail = true;
		}
		if(name.length() < 2 || name.length() > 20) {
			redirectAttributes.addFlashAttribute("error_nombre", "El nombre debe ser mayor a 2 y menor a 20 carácteres.");
			InsertLanguaguefail = true;
		}
		if(creator.length() < 2 || creator.length() > 20) {
			redirectAttributes.addFlashAttribute("error_creador", "El creador debe ser mayor a 2 y menor a 20 carácteres.");
			InsertLanguaguefail = true;
		}
		if(InsertLanguaguefail == true) {
			if(id == null) {
				return "redirect:/languages";
			}else {
				return "redirect:/languages/edit/"+id;
			}
		}
		if(id == null) {
			Idioma idioma = new Idioma(name, creator, version);
		    idiomaService.createIdioma(idioma);
		}else {
			Idioma idioma = idiomaService.finIdioma(id);
			idioma.setName(name);
			idioma.setCreator(creator);
			idioma.setVersion(version);
		    idiomaService.createIdioma(idioma);
		}
	    
	    return "redirect:/languages";
	}
}
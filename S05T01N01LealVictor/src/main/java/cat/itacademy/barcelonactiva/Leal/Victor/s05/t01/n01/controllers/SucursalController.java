package cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.services.SucursalService;

//Notación para indicar que es un controlador de tipo Rest
@Controller

public class SucursalController {
	
	
    //Inyección de dependencias
	@Autowired
	private SucursalService sucursalService;
	
    //Se le indica el tipo de petición asi como el nombre del servicio
	@GetMapping ("/sucursal/getAll")
	@ResponseBody
	public List<SucursalDTO> getAllSucursal(){
		
		List<SucursalDTO> sucursalesDTO=sucursalService.getAllSucursals();
		
		return sucursalesDTO;
	}

	@GetMapping ("/sucursal/getOne/{id}")
	@ResponseBody
	public SucursalDTO getSucursal(@PathVariable ("id") int id){
		
		return sucursalService.getSucursalById(id);
	}
	
	@DeleteMapping ("/sucursal/delete/{id}")
	@ResponseBody
	public void deleteSucursal(@PathVariable ("id") int id) {
		
		sucursalService.delete(id);	
	}
	
	@PostMapping ("/sucursal/add")
	@ResponseBody
	public int addSucursal(@RequestBody Sucursal sucursal) {
		
		sucursalService.saveOrUpdate(sucursal);
		return sucursal.getPk_SucursalID();			
	}
	
	@PutMapping ("/sucursal/update")
	@ResponseBody
	public int updateSucursal(@RequestBody Sucursal sucursal) {
		
		sucursalService.saveOrUpdate(sucursal);
		return sucursal.getPk_SucursalID();	
	}
	
	@GetMapping({"/sucursal", "/sucursal/home"})
	public String viewHomePage(Model model) {
	    List<SucursalDTO> sucursalesDTO = sucursalService.getAllSucursals();
	    
	    model.addAttribute("sucursalesDTO", sucursalesDTO);

	    return "index";
	}
	
	@GetMapping({"/sucursal/new"})
	public String crear(Model model) {
		
	    //model.addAttribute("nuevasSucursales", new SucursalDTO());
	    model.addAttribute("sucursal", new Sucursal());

	    return "save";
	}
	
	@GetMapping({"/sucursal/edit/{id}"})
	public String editar(@PathVariable  int id, Model model) {
		

	    model.addAttribute("sucursal", sucursalService.getSucursalById(id));

	    return "edit";
	}
	 
	 @PostMapping("/sucursal/save")
	 public String save(Sucursal sucursal, Model model) {
	  sucursalService.saveOrUpdate(sucursal);
	  return "redirect:/sucursal/";
	 }
	 
	 /*@PutMapping("/sucursal/update/{id}")
	 public String update(Sucursal sucursal, Model model) {
	  sucursalService.saveOrUpdate(sucursal);
	  return "redirect:/sucursal/";
	 }*/
	 
	 @GetMapping("/sucursal/delete2/{id}")
	 public String ddelete(@PathVariable  int id, Model model) {
		 
		 //model.addAttribute("sucursalesDTO", sucursalesDTO);
		 sucursalService.delete(id);
	 
		  return "redirect:/sucursal/";
	 }
}

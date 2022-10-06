package cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalService {
	
	@Autowired
	SucursalRepository sr;
	@Autowired
	ModelMapper modelMapper;
	
	public List <SucursalDTO> getAllSucursals(){
		
		List <Sucursal> sucursals=new ArrayList<Sucursal>();
		sr.findAll().forEach(s->sucursals.add(s));
		List<SucursalDTO> sucursalsDTO=new ArrayList<SucursalDTO>();
		
		if (!sucursals.isEmpty()) {

			sucursals.forEach(s->sucursalsDTO.add(modelMapper.map(s, SucursalDTO.class)));
		}
		return sucursalsDTO;
	}
	
	public SucursalDTO getSucursalById(int id) {
		
		Sucursal sucursal=sr.findById(id).get();
		SucursalDTO sucursalDTO=modelMapper.map(sucursal,SucursalDTO.class);
		
		return sucursalDTO;
	}
	
	public void saveOrUpdate(Sucursal sucursal) {
		
		//Sucursal sucursal=modelMapper.map(sucursalDTO,Sucursal.class);
		sr.save(sucursal);
	}
	
	public void delete(int id) {
		
		sr.deleteById(id);
	}
}

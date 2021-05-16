package co.edu.usbbog.bdd.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.bdd.model.Transaccion;
import co.edu.usbbog.bdd.repository.ITransaccion;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {

	@Autowired
	ITransaccion it;
	
	@PostMapping("/create") //localhost:3001/ciudad/create
	public void insertTransaccion(@RequestBody Transaccion c) {
		it.save(c);
	}
	
	@GetMapping("/all")
	public List<Transaccion>findAllTransacciones() {
		return it.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Optional<Transaccion> findTransaccion(@PathVariable("id") long id) {
		return it.findById(id);
	}
	
	@GetMapping("/count")
	public long coundTransaccion() {
		return it.count();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteTransaccion(@PathVariable("id") long id) {
		it.deleteById(id);
	}
	
	@PutMapping("/update")
	public void updateTransaccion(@RequestBody Transaccion c) {
		it.save(c);
	}
	
}

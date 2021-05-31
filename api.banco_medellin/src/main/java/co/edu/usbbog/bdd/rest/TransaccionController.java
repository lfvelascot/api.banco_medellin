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

	@PostMapping("/create")
	public void insertTransaccion(@RequestBody Transaccion c) {
		it.save(c);
	}

	@GetMapping("/all")
	public List<Transaccion> findAllTransacciones() {
		List<Transaccion> l = it.findAll();
		if (l.isEmpty() || l.equals(null)) {
			throw new RuntimeException("No hay transacciones registradas");
		} else {
			return l;
		}
	}

	@GetMapping("/find/{id}")
	public Optional<Transaccion> findTransaccion(@PathVariable("id") long id) {
		Optional<Transaccion> t = it.findById(id);
		if (!t.equals(null)) {
			return t;
		} else {
			throw new RuntimeException("Tramsaccion identificada con el ID: " + id + " no encontrado");
		}
	}

	@GetMapping("/count")
	public long coundTransaccion() {
		long c = it.count();
		if (c != 0) {
			return c;
		} else {
			throw new RuntimeException("No hay transacciones registradas");
		}
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTransaccion(@PathVariable("id") long id) {
		Optional<Transaccion> t = it.findById(id);
		if (!t.equals(null)) {
			it.deleteById(id);
		} else {
			throw new RuntimeException("Tramsaccion identificada con el ID: " + id + " no encontrado");
		}
	}

	@PutMapping("/update")
	public void updateTransaccion(@RequestBody Transaccion c) {
		Optional<Transaccion> t = it.findById(c.getId());
		if (!t.equals(null)) {
			it.save(c);
		} else {
			throw new RuntimeException("Tramsaccion identificada con el ID: " + c.getId() + " no encontrado");
		}
	}
}

package com.jhemerson.apicda.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jhemerson.apicda.domain.Cliente;
import com.jhemerson.apicda.domain.dtos.ClienteDTO;
import com.jhemerson.apicda.services.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@GetMapping(path = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(new ClienteDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO objDTO) {
		Cliente newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDTO) {
		Cliente obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ClienteDTO(obj));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

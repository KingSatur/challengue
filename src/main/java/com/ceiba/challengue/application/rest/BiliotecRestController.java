package com.ceiba.challengue.application.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.challengue.domain.dto.BibliotecDTO;
import com.ceiba.challengue.domain.dto.BookDTO;
import com.ceiba.challengue.domain.model.Bibliotec;
import com.ceiba.challengue.domain.service.BibliotecService;

@RestController
@RequestMapping("/bibliotec")
public class BiliotecRestController {

	@Autowired
	private BibliotecService service;

	@GetMapping
	public ResponseEntity<?> getBibliotecs() {
		try {
			List<Bibliotec> bibliotecs = this.service.getAllBibliotec();
			return ResponseEntity.status(HttpStatus.OK).body(bibliotecs);

		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}
	}

	@PostMapping
	public ResponseEntity<?> createBibliotec(@RequestBody BibliotecDTO dto) {
		try {
			Bibliotec b = this.service.createBibliotec(dto);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarBibliotec(@PathVariable("id") String bibliotecId, @RequestBody BibliotecDTO dto){
		
		
	}

}

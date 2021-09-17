package br.com.isidrocorp.isibank.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.isibank.dao.ContaDAO;
import br.com.isidrocorp.isibank.model.Conta;

@RestController
public class ContaController {

	@Autowired
	private ContaDAO dao;
	
	@GetMapping("/conta")
public ArrayList<Conta> recuperarTodas() {
		return (ArrayList<Conta>)dao.findAll();
	}

@GetMapping("/conta/{numero}")
public ResponseEntity<Conta> recuperarPeloNumero(@PathVariable int numero) {
//return dao.findById(numero).get();
Conta resultado = dao.findById(numero).orElse(null);
if (resultado != null) {
	return ResponseEntity.ok(resultado);
	}
return ResponseEntity.notFound().build();
}


}

package br.com.jprojetar.provider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jprojetar.provider.domain.Usuario;
import br.com.jprojetar.provider.exception.UsuarioJaExistenteException;
import br.com.jprojetar.provider.exception.UsuarioNaoExistenteException;
import br.com.jprojetar.provider.service.UsuarioService;

@RestController
@RequestMapping(value = "/linknet/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listAllUser() {
		List<Usuario> usuarios = service.listAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> finById(@PathVariable String id) {
		Usuario usuario = service.finById(id);

		return usuario == null ? new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<Usuario>(usuario, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Usuario usuario) {

		try {
			service.save(usuario);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (UsuarioJaExistenteException e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable String id) {
			try {
				service.delete(id);
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch (UsuarioNaoExistenteException e) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestBody Usuario usuario) {
			try {
				service.update(usuario);
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch (UsuarioJaExistenteException e) {
				e.printStackTrace();
				return new ResponseEntity<String>(HttpStatus.CONFLICT);
			}
			
	}
	

}

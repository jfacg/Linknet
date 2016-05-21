package br.com.jprojetar.provider.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.jprojetar.provider.domain.Usuario;
import br.com.jprojetar.provider.exception.UsuarioJaExistenteException;
import br.com.jprojetar.provider.exception.UsuarioNaoExistenteException;
import br.com.jprojetar.provider.repository.UsuarioRepository;
import ch.qos.logback.core.net.SyslogOutputStream;

@Service
@Validated
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository repository;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional
	public Usuario save(@NotNull @Valid final Usuario usuario) throws UsuarioJaExistenteException {
		Usuario existing = repository.findByLogin(usuario.getLogin());

		if (existing != null) {
			throw new UsuarioJaExistenteException();
		}

		return repository.save(usuario);
	}

	@Transactional
	public void delete(String id) throws UsuarioNaoExistenteException {
		Usuario existing = repository.findById(id);
		if (existing == null) {
			throw new UsuarioNaoExistenteException();
		}
		repository.delete(id);
	}

	@Transactional
	public void update(Usuario usuario) throws UsuarioJaExistenteException {
		Usuario existente = repository.findById(usuario.getId());
		if (usuario.getLogin().equals(existente.getLogin())) {
			repository.save(usuario);
		} else {
			save(usuario);
		}
	}

	@Override
	public List<Usuario> listAll() {
		return repository.findAll();
	}

	@Override
	public Usuario finById(String id) {
		return repository.findById(id);
	}

	@Override
	public Usuario finByLogin(String login) throws UsuarioNaoExistenteException {
		Usuario existente = repository.findByLogin(login);

		if (existente == null) {
			throw new UsuarioNaoExistenteException();
		}

		return existente;
	}

}

package br.com.jprojetar.provider.service;

import java.util.List;

import br.com.jprojetar.provider.domain.Usuario;
import br.com.jprojetar.provider.exception.UsuarioJaExistenteException;
import br.com.jprojetar.provider.exception.UsuarioNaoExistenteException;

public interface UsuarioService {

	public Usuario save(Usuario usuario) throws UsuarioJaExistenteException;

	public void delete(String id) throws UsuarioNaoExistenteException;

	public List<Usuario> listAll();

	public Usuario finById(String id);

	public void update(Usuario usuario) throws UsuarioJaExistenteException;

	public Usuario finByLogin(String login) throws UsuarioNaoExistenteException;

}

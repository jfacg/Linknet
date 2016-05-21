package br.com.jprojetar.provider;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.jprojetar.provider.domain.Usuario;
import br.com.jprojetar.provider.exception.UsuarioJaExistenteException;
import br.com.jprojetar.provider.exception.UsuarioNaoExistenteException;
import br.com.jprojetar.provider.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProviderApplication.class)
@WebAppConfiguration
public class UsuarioServiceImplTest {

	@Autowired
	private UsuarioService service;
	private Usuario usuario;

//	@Before
//	public void fazerAntes() {
//		this.usuario = new Usuario();
//		usuario.setNome("Jailson");
//		usuario.setUsuario("jfacg");
//	}

//	@Test
//	public void localizaUsuarioPorUsuarioTeste() {
//		try {
//			Usuario existente = service.finByLogin(usuario.getUsuario());
//			Assert.assertNotNull(existente);
//		} catch (UsuarioNaoExistenteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Test (expected = UsuarioJaExistenteException.class)
	public void saveUsuarioTeste() throws UsuarioJaExistenteException {
		Usuario usuario = new Usuario();
		usuario.setNome("Jailson");
//		usuario.setUsuario("jfacg");


			Usuario usuarioSaldo = service.save(usuario);
			assertEquals(usuario, usuarioSaldo);

	}

	// @Test
	// public void test() throws UsuarioJaExistenteException {
	// Usuario usuario = new Usuario();
	// usuario.setUsuario("jailson");
	// usuario.setCpf("01235132439");
	// Usuario usuarioSalvo = service.save(usuario);
	// assertEquals(usuario.getUsuario(), usuarioSalvo.getUsuario());
	// }

}

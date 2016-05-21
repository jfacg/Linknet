package br.com.jprojetar.provider.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jprojetar.provider.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
//	@Query("{id: ?0}")
	public Usuario findById (String id);
	
//	@Query("{usuario: ?0}")
	public Usuario findByLogin (String login);

}

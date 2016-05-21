package br.com.jprojetar.provider.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "funcionario")
public class Funcionario extends Pessoa {

}

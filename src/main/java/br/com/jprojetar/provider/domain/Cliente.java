package br.com.jprojetar.provider.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cliente")
public class Cliente extends Pessoa{

}

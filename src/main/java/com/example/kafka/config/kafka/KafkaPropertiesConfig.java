package com.example.kafka.config.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.kafka.config.properties.KafkaProperties;

@Configuration
public class KafkaPropertiesConfig {

	// O unico motivo de criar o Bean abaixo é para usar na configuracao do
	// Listener.
	// Sem este Bean NOMEADO teria que usar o @Value ou usar EL mapeando diretamente
	// o properties.
	// O que faria com que o proposito da validacao com @Validated perdesse total
	// sentido, e subisse algum valor quebrado ou invalido

	@Bean(name = "kafkaProperties")
	public KafkaProperties kafkaProperties(KafkaProperties props) {
		return props;
	}
}
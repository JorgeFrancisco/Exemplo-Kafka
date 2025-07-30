package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka.config.properties.KafkaProperties;
import com.example.kafka.model.dto.UsuarioDTO;

@Service
public class UsuarioSenderService {

	private final KafkaTemplate<String, UsuarioDTO> kafkaTemplate;

	private final KafkaProperties kafkaProperties;

	@Autowired
	public UsuarioSenderService(KafkaTemplate<String, UsuarioDTO> kafkaTemplate, KafkaProperties kafkaProperties) {
		this.kafkaTemplate = kafkaTemplate;
		this.kafkaProperties = kafkaProperties;
	}

	public void send(String key, UsuarioDTO usuario) {
		kafkaTemplate.send(kafkaProperties.topic(), key, usuario);
	}
}
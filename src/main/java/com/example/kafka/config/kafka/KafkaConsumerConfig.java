package com.example.kafka.config.kafka;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.kafka.config.properties.KafkaProperties;
import com.example.kafka.model.dto.UsuarioDTO;

@Configuration
public class KafkaConsumerConfig {

	private final KafkaProperties kafkaProperties;

	@Autowired
	public KafkaConsumerConfig(KafkaProperties kafkaProperties) {
		this.kafkaProperties = kafkaProperties;
	}

	@Bean
	public ConsumerFactory<String, UsuarioDTO> consumerFactory() {
		var configs = new HashMap<String, Object>();

		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.server());
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.groupId());
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

		configs.put(JsonDeserializer.TRUSTED_PACKAGES, UsuarioDTO.class.getPackageName());
		configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE, UsuarioDTO.class.getName());

		return new DefaultKafkaConsumerFactory<>(configs);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UsuarioDTO> kafkaListenerContainerFactory() {
		var factory = new ConcurrentKafkaListenerContainerFactory<String, UsuarioDTO>();

		factory.setConsumerFactory(consumerFactory());

		// Define concorrência de 5 threads para consumir mensagens em paralelo
		factory.setConcurrency(5);

		return factory;
	}
}
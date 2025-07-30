package com.example.kafka.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UsuarioDTO {

	@Schema(description = "Nome do usuario")
	@JsonProperty("nome")
	private String nome;

	@Schema(description = "Idade do usuario")
	@JsonProperty("idade")
	private Integer idade;
}
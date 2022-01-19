package co.edu.usbcali.projectmanager.fcd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr353.JSR353Module;

import co.edu.usbcali.projectmanager.business.jsonpatch.JsonMergePatchMapper;
import co.edu.usbcali.projectmanager.business.jsonpatch.JsonPatchMapper;
import co.edu.usbcali.projectmanager.model.entities.Userapp;

@Configuration
public class SpringConfig {

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JSR353Module());
		return mapper;
	}

	@Bean
	public JsonPatchMapper<Userapp> personJsonPatchMapper(ObjectMapper mapper) {
		return new JsonPatchMapper<>(mapper);
	}

	@Bean
	public JsonMergePatchMapper<Userapp> personJsonMergePatchMapper(ObjectMapper mapper) {
		return new JsonMergePatchMapper<>(mapper);
	}

}

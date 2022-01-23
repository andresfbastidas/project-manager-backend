package co.edu.usbcali.projectmanager.fcd.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr353.JSR353Module;

@Configuration
public class SpringConfig {

	@Bean
	@JsonIgnoreProperties(ignoreUnknown = true)
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JSR353Module());
		ObjectMapper objectMapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		mapper.setDateFormat(df);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		return mapper;
	}

}

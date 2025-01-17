package fr.cyril.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// Second Way
@RestController
@RefreshScope
public class ConfigTestController {

	@Value("${global.params.p1}")
	private String p1;
	@Value("${global.params.p2}")
	private String p2;
	
	private CustomerConfigParams customerConfigParams;
	
	
	public ConfigTestController(CustomerConfigParams customerConfigParams) {
		super();
		this.customerConfigParams = customerConfigParams;
	}

	@GetMapping("/testConfig1")
	public Map<String, String> configTest1() {
		return Map.of("p1", p1, "p2", p2);
	}
	
	@GetMapping("/testConfig2")
	public CustomerConfigParams configTest2() {
		return customerConfigParams;
	}
}

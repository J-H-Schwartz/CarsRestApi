package com.carsRestApi.CarsRestApi;

import okhttp3.Request;
import okhttp3.RequestBody;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

//import org.springframework.transaction.annotation.Transactional;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarsRestApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getAllCars() {
		String body = this.testRestTemplate.getForObject("/cars", String.class);
		assertEquals("{\"2\":{\"id\":2,\"model\":\"308\",\"brand\":\"Peugeot\",\"color\":\"Anthracite\"}," +
				"\"1\":{\"id\":1,\"model\":\"Megane\",\"brand\":\"Renault\",\"color\":\"Jaune\"},"+
				"\"0\":{\"id\":0,\"model\":\"Clio\",\"brand\":\"Renault\",\"color\":\"Rouge\"}}", body);
	}
	@Test
	public void getCarById() {
		String body = this.testRestTemplate.getForObject("/cars/2", String.class);
		assertEquals("{\"id\":2,\"model\":\"308\",\"brand\":\"Peugeot\",\"color\":\"Anthracite\"}", body);
	}

	@Test
	public void addCar() {
		final RequestBody sendBody = RequestBody.create("{\"model\":\"911\",\"brand\":\"Porsche\",\"color\":\"Black\"}", okhttp3.MediaType.parse("Application/JSON"));
		Request request = new Request.Builder().url("http://localhost:8000/cars").post(sendBody).build();
		String body = this.testRestTemplate.postForObject("/cars", "{\"model\":\"911\",\"brand\":\"Porsche\",\"color\":\"Black\"}", String.class);
		assertEquals("{\"3\":{\"id\":3,\"model\":\"911\",\"brand\":\"Porsche\",\"color\":\"Black\"}," +
				"\"2\":{\"id\":2,\"model\":\"308\",\"brand\":\"Peugeot\",\"color\":\"Anthracite\"}," +
				"\"1\":{\"id\":1,\"model\":\"Megane\",\"brand\":\"Renault\",\"color\":\"Jaune\"},"+
				"\"0\":{\"id\":0,\"model\":\"Clio\",\"brand\":\"Renault\",\"color\":\"Rouge\"}}", body);
		testRestTemplate.delete("/cars/{1}", 3);
	}
	@Test
	public void updateCar() {
		this.testRestTemplate.put("/cars", "{\"id\":1,\"model\":\"Laguna\",\"brand\":\"Renault\",\"color\":\"Rouge\"}", String.class);
		String body = this.testRestTemplate.getForObject("/cars/1", String.class);
		assertEquals("{\"id\":1,\"model\":\"Laguna\",\"brand\":\"Renault\",\"color\":\"Rouge\"}", body);
		this.testRestTemplate.put("/cars", "{\"id\":1,\"model\":\"Megane\",\"brand\":\"Renault\",\"color\":\"Jaune\"}", String.class);
	}
	@Test
	public void deleteCarById() {
		testRestTemplate.delete("/cars/{1}", 1);
		String body = this.testRestTemplate.getForObject("/cars", String.class);
		assertEquals("{\"2\":{\"id\":2,\"model\":\"308\",\"brand\":\"Peugeot\",\"color\":\"Anthracite\"}," +
				"\"0\":{\"id\":0,\"model\":\"Clio\",\"brand\":\"Renault\",\"color\":\"Rouge\"}}", body);
	}

}

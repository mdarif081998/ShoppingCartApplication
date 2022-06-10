package com.md.arif;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.json.JSONException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;

import com.md.arif.model.Brand;
import com.md.arif.model.Product;
import com.md.arif.service.ProductService;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingCartApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private ProductService productservice;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Before
	public void before() {
		//headers.add("Authorization", createHttpAuthenticationHeaderValue(
		//		"md", "secret"));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		
	}
	
	@Test
	public void testGetproductById() throws JSONException{
	
		String url = "http://localhost:" + port + "/products/v1/get/info/1";
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				url, HttpMethod.GET, entity, String.class);
		//String expected="{\"productId\":1,\"price\":15999}";
		String expected ="{\"productId\":1,\"price\":15999,\"brand\":{\"brandName\":\"Samsung\",\"quantity\":20,\"brandAvailStatus\":true,\"brandId\":1},\"productName\":\"Mobile\"}";
		JSONAssert.assertEquals(expected, response.getBody(), true);
	
	}
	
	@Test
	public void testGetAllProducts() throws JSONException {
		String url = "http://localhost:" + port + "/products/v1/get/info";
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				url, HttpMethod.GET, entity, String.class);
		System.out.println(response.getBody());
		String expected="[{\"productId\":1},{\"productId\":2},{\"productId\":3},{\"productId\":4}]";
	    //String expected = "[{\"productId\":1,\"productName\":\"Mobile\",\"price\":15999.00,\"brand\":{\"brandId\":1,\"brandName\":\"Samsung\",\"brandAvailStatus\":true,\"quantity\":20}},{\"productId\":2,\"productName\":\"Laptop\",\"price\":65999.00,\"brand\":{\"brandId\":2,\"brandName\":\"Dell\",\"brandAvailStatus\":true,\"quantity\":15}},{\"productId\":3,\"productName\":\"Mobile\",\"price\":12999.00,\"brand\":{\"brandId\":2,\"brandName\":\"Dell\",\"brandAvailStatus\":true,\"quantity\":15}},{\"productId\":4,\"productName\":\"Grinder\",\"price\":5999.00,\"brand\":{\"brandId\":3,\"brandName\":\"Godrej\",\"brandAvailStatus\":false,\"quantity\":0}}]";
		JSONAssert.assertEquals(expected, response.getBody(), false);
		
	}
	
	@Test
	public void testAddProductdetails() throws JSONException {
		Product product = new Product(4,"Grinder",BigDecimal.valueOf(5999.0),
				new Brand(3, "Godrej", false,0));
		System.out.println(product);
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
		String url = "http://localhost:" + port + "/products/v1/post/add";
		ResponseEntity<String> response = restTemplate.exchange(
				url, HttpMethod.POST, entity, String.class);
		//String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
		String expected = "{\"productId\":4,\"productName\":\"Grinder\",\"price\":5999.00,\"brand\":{\"brandId\":3,\"brandName\":\"Godrej\",\"brandAvailStatus\":false,\"quantity\":0}}";
		JSONAssert.assertEquals(expected, response.getBody(), true);	
	}
	
	@Test 
	public void testUpdateProductMethod() {
		Product product=productservice.getProductById(2).get();
		product.setProductName("Elitebook");
		Product updatedproduct=productservice.updateProduct(product);
		assertThat(updatedproduct.getProductName()).isEqualTo("Elitebook");
	}
	
	@Test
	public void testDeleteProductMethod() {
		Product product = new Product(5,"Bike",BigDecimal.valueOf(85999.0),
				new Brand(4, "Hero", true,7));
		productservice.addProduct(product);
		String result = productservice.deleteProduct(5);
		assertEquals("Product Removerd Succesfully", result);
				
	}
	
	
	
	
	/*
	
	private String createHttpAuthenticationHeaderValue(String userId,
			String password) {

		String auth = userId + ":" + password;

		
		byte[] encodedAuth = Base64.encode(auth.getBytes(Charset
				.forName("US-ASCII")));

		String headerValue = "Basic " + new String(encodedAuth);

		return headerValue;
	}*/
	
}

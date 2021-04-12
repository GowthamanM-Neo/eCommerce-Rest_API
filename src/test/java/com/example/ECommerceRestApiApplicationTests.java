package com.example;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ECommerceRestApiApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;

	//Add A New Series
	@Test
	public void TestCase1() throws Exception {
			
		String dataOne = "{\"productId\":\"12881\",\"productName\":\"Nokia\",\"description\":\"one oldest model\",\"quantity\":\"8\",\"price\":\"4000\",\"type\":\"testphone\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/saveProduct")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
		 	
	}
	
	//Add A New Product
	@Test
	public void TestCase2() throws Exception {
			
	 	mockMvc.perform(MockMvcRequestBuilders.get("/getAllProduct")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
	        	.andReturn();
			 	
	}
	
	//Get Single Product
	@Test
	public void TestCase3() throws Exception {
			
		String dataOne = "{\"productId\":\"12881\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/getProduct")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andExpect(jsonPath("$.productName").value("Nokia"))
			    .andExpect(jsonPath("$.description").value("one oldest model"))
			    .andExpect(jsonPath("$.quantity").value("8"))
			    .andExpect(jsonPath("$.price").value("4000"))
	        	.andReturn();
		 	
	}
	
	//Get Single Product by Type
	@Test
	public void TestCase4() throws Exception {
			
		String dataOne = "{\"type\":\"testphone\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/getByType")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andExpect(jsonPath("$[0].productName").value("Nokia"))
			    .andExpect(jsonPath("$[0].description").value("one oldest model"))
			    .andExpect(jsonPath("$[0].quantity").value("8"))
			    .andExpect(jsonPath("$[0].price").value("4000"))
	        	.andReturn();
			 	
	}
	
	//Delete a Product
	@Test
	public void TestCase5() throws Exception {
				
		String dataOne = "{\"productId\":\"12881\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/deleteProduct")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(dataOne)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
	        	.andReturn();
				 	
	}

}

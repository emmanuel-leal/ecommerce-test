package com.emmanuel.test.testing.products;

import com.emmanuel.test.products.application.controller.ProductsController;
import com.emmanuel.test.products.application.service.impl.ProductsServiceImpl;
import com.emmanuel.test.products.domain.dto.ProductsDto;
import com.emmanuel.test.products.domain.dto.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductsController.class)
public class ProductControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductsServiceImpl productService;

    @Test
    public void testGetAllProducts() throws Exception {
        var jsonObject = new ObjectMapper().writeValueAsString(new ResponseDTO("product list not founded", HttpStatus.NO_CONTENT.toString(), null));
        Mockito.when(productService.getAllProducts()).thenReturn(new ResponseDTO("product list not founded", HttpStatus.NO_CONTENT.toString(), null));
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonObject))
        ;
    }

    @Test
    public void testSaveProduct() throws Exception {
        String jsonString = "{\n" +
                "    \"description\": \"product 1 0909\",\n" +
                "    \"price\": 2.34,\n" +
                "    \"userId\": \"33a480ab-7ec4-4ff0-8b83-434742qas21d\",\n" +
                "    \"brand\":\"hakuna matata\",\n" +
                "    \"productId\": \"19e0f9e0-a779-4496-a111-bfc96f6326c6\"\n" +
                "}";
        var product = new ObjectMapper().readValue(jsonString,  ProductsDto.class);
        Mockito.when(productService.saveProduct(product)).thenReturn(new ResponseDTO("Success product saved", HttpStatus.CREATED.toString(), product));
        mockMvc.perform(MockMvcRequestBuilders.post("/products/product")
                        .content(new ObjectMapper().writeValueAsString(product))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(new ResponseDTO("Success product saved", HttpStatus.CREATED.toString(), product))));
    }


    @Test
    public void testUpdateProduct() throws Exception {
        String jsonString = "{\n" +
                "    \"description\": \"product 1 0909\",\n" +
                "    \"price\": 2.34,\n" +
                "    \"userId\": \"33a480ab-7ec4-4ff0-8b83-434742qas21d\",\n" +
                "    \"brand\":\"hakuna matata\",\n" +
                "    \"productId\": \"19e0f9e0-a779-4496-a111-bfc96f6326c6\"\n" +
                "}";
        var product = new ObjectMapper().readValue(jsonString,  ProductsDto.class);
        Mockito.when(productService.updateProduct(Mockito.any())).thenReturn(new ResponseDTO("Success product saved", HttpStatus.CREATED.toString(), product));
        mockMvc.perform(MockMvcRequestBuilders.put("/products/product/33a480ab-7ec4-4ff0-8b83-434742qas21d")
                        .content(new ObjectMapper().writeValueAsString(product))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(new ResponseDTO("Success product saved", HttpStatus.CREATED.toString(), product))));
    }
    @Test
    public void testGetProductById() throws Exception {
        String jsonString = "{\n" +
                "    \"description\": \"product 1 0909\",\n" +
                "    \"price\": 2.34,\n" +
                "    \"brand\":\"hakuna matata\",\n" +
                "    \"productId\": \"19e0f9e0-a779-4496-a111-bfc96f6326c6\"\n" +
                "}";
        var productById = "33a480ab-7ec4-4ff0-8b83-434742qas21d";
        var product = new ObjectMapper().readValue(jsonString,  ProductsDto.class);
        var jsonObject = new ObjectMapper().writeValueAsString(new ResponseDTO("success to get product", HttpStatus.OK.toString(), product));
        Mockito.when(productService.getProductById(productById)).thenReturn(new ResponseDTO("success to get product", HttpStatus.OK.toString(), product));
        mockMvc.perform(MockMvcRequestBuilders.get("/products/product/"+productById))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonObject))
        ;
    }

    @Test
    public void testDeleteProduct() throws Exception {
        var productById = "33a480ab-7ec4-4ff0-8b83-434742qas21d";
        mockMvc.perform(MockMvcRequestBuilders.delete("/products/product/"+productById))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        ;
    }
}
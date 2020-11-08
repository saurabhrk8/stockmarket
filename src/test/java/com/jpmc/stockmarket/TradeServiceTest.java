package com.jpmc.stockmarket;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.jpmc.stockmarket.entity.StockEntity;
import com.jpmc.stockmarket.service.TradeService;

@SpringBootTest
@AutoConfigureMockMvc
public class TradeServiceTest {
	
	 @Autowired
	    private MockMvc mvc;
	 
	    
	    @MockBean
	    private TradeService tradeService;
	    
	    @MockBean
	    StockEntity stock;
	    
	    
	    @Test 
	    public void getGBCETest() throws Exception {
	   	 
	   	given(this.tradeService.getGBCE()) .willReturn(2d);
	   	
	   	this.mvc.perform(get("/stock/gbce/index").accept(MediaType.APPLICATION_JSON))
	 	  .andExpect(status().isOk()); 
	    }
	    


}

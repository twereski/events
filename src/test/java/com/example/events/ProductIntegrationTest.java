package com.example.events;

import com.example.events.app.product.ProductController;
import com.example.events.app.product.command.Buy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.UUID;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EventsApplication.class)
@RestClientTest(ProductController.class)
public class ProductIntegrationTest {

    @Autowired
    ProductController productController;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockRestServiceServer server;

    @Before
    public void setUp() throws Exception {
        String detailsString = objectMapper.writeValueAsString(new Buy());
        this.server.expect(requestTo("/xs/xd")).andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON));
    }
}

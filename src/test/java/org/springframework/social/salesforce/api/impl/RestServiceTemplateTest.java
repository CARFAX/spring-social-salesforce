package org.springframework.social.salesforce.api.impl;

import org.codehaus.jackson.JsonNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * Created by daviddavis on 2/21/14.
 */
public class RestServiceTemplateTest extends AbstractSalesforceTest {

    @Test
    public void testRestServiceGet() {
        mockServer.expect(requestTo("https://na7.salesforce.com/services/apexrest/TestService/account"))
                  .andExpect(method(GET))
                  .andRespond(withResponse(loadResource("rest-service.json"), responseHeaders));

        JsonNode result = (JsonNode) salesforce.restServiceOperations().get("TestService", "account", null, JsonNode.class);
        assertEquals("000000000000000ABC", result.get("id").getTextValue());
    }

    @Test
    public void testRestServicePost() {
        mockServer.expect(requestTo("https://na7.salesforce.com/services/apexrest/TestService/account"))
                  .andExpect(method(POST))
                  .andRespond(withResponse(loadResource("rest-service.json"), responseHeaders));

        JsonNode result = (JsonNode) salesforce.restServiceOperations().post("TestService", "account", null, JsonNode.class);
        assertEquals("000000000000000ABC", result.get("id").getTextValue());
    }
}

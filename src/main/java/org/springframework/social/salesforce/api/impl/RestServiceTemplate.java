package org.springframework.social.salesforce.api.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.salesforce.api.RestServiceOperations;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * Created by daviddavis on 2/21/14.
 */
public class RestServiceTemplate extends AbstractSalesForceOperations<Salesforce> implements RestServiceOperations {

    private RestTemplate restTemplate;

    public RestServiceTemplate(Salesforce api, RestTemplate restTemplate) {
        super(api);
        this.restTemplate = restTemplate;
    }

    public Object get(String serviceName, String path, Map<String, String> parameters, Class responseType) {
        requireAuthorization();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(getBaseUrl() + "/{serviceName}/{path}");
        if (parameters != null) {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                uriComponentsBuilder.queryParam(entry.getKey(), entry.getValue());
            }
        }

        return restTemplate.getForObject(uriComponentsBuilder.build().toString(), responseType, serviceName, path);
    }

    public Object post(String serviceName, String path, Object object, Class responseType) {
        requireAuthorization();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return restTemplate.postForObject(getBaseUrl() + "/{serviceName}/{path}", object, responseType, serviceName, path);
    }

    public String getBaseUrl() {
        return api.getInstanceUrl() + "/services/apexrest";
    }
}

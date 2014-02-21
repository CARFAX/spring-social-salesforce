package org.springframework.social.salesforce.api;

import java.util.Map;

/**
 * Created by daviddavis on 2/21/14.
 */
public interface RestServiceOperations {

    Object get(String serviceName, String path, Map<String, String> parameters, Class responseType);

    Object post(String serviceName, String path, Object object, Class responseType);
}

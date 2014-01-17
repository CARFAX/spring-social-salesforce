package org.springframework.social.salesforce.api;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Defines operations for interacting with the sObjects API.
 *
 * @author Umut Utkan
 */
public interface SObjectOperations {

    public List<Map> getSObjects();

    public SObjectSummary getSObjectSummary(String name);

    public SObjectDetail describeSObject(String name);

    public Map getRow(String name, String id, String... fields);

    public InputStream getBlob(String name, String id, String field);

    Map<String, ?> create(String name, Map<String, Object> fields);
    
    Map<String,?> update(String sObjectName, String sObjectId, Map<String, Object> fields);

    GetDeletedResult getDeleted(String name, Date start, Date end);

}

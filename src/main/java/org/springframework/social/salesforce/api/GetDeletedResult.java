package org.springframework.social.salesforce.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * Created by beccagaspard on 1/14/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDeletedResult {

    private Date earliestDateAvailable;
    private Date latestDateCovered;
    private List<DeletedRecord> deletedRecords;

    public List<DeletedRecord> getDeletedRecords() {
        return deletedRecords;
    }

    public void setDeletedRecords(List<DeletedRecord> deletedRecords) {
        this.deletedRecords = deletedRecords;
    }

    public Date getEarliestDateAvailable() {
        return earliestDateAvailable;
    }

    public void setEarliestDateAvailable(Date earliestDateAvailable) {
        this.earliestDateAvailable = earliestDateAvailable;
    }

    public Date getLatestDateCovered() {
        return latestDateCovered;
    }

    public void setLatestDateCovered(Date latestDateCovered) {
        this.latestDateCovered = latestDateCovered;
    }

}

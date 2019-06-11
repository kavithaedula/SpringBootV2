package com.springboot.v2.intercetors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
@ManagedResource(objectName = "PD:category=MBeans,name=togglingFeaturesMbean", description = "Get/Set log level for the category specified", log = true, logFile = "jmx-platform.log")
public class TogglingFeaturesMbean {

    private Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private boolean getClaimRecord = true;
    private boolean postClaimRecord = true;
    private boolean updateClaimRecord = true;
    private boolean deleteClaimRecord = true;

    @ManagedAttribute
    public boolean isGetClaimRecord() {
        return getClaimRecord;
    }

    @ManagedAttribute
    public void setGetClaimRecord(boolean getClaimRecord) {
        this.getClaimRecord = getClaimRecord;
    }

    @ManagedAttribute
    public boolean isPostClaimRecord() {
        return postClaimRecord;
    }

    @ManagedAttribute
    public void setPostClaimRecord(boolean postClaimRecord) {
        this.postClaimRecord = postClaimRecord;
    }

    @ManagedAttribute
    public boolean isUpdateClaimRecord() {
        return updateClaimRecord;
    }

    @ManagedAttribute
    public void setUpdateClaimRecord(boolean updateClaimRecord) {
        this.updateClaimRecord = updateClaimRecord;
    }

    @ManagedAttribute
    public boolean isDeleteClaimRecord() {
        return deleteClaimRecord;
    }

    @ManagedAttribute
    public void setDeleteClaimRecord(boolean deleteClaimRecord) {
        this.deleteClaimRecord = deleteClaimRecord;
    }
}
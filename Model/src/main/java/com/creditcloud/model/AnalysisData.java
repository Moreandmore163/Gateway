package com.creditcloud.common.rest;

import com.creditcloud.model.BaseObject;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the wrapper class for the return JSON result for Analysis Data
 */
@XmlRootElement
public class AnalysisData extends BaseObject{
    
    private static final long serialVersionUID = 20131012L; 

    private Date day;
    
    @Min(0)
    private long count;

    public AnalysisData() {
    }
    
    public AnalysisData(Date day, long count) {
        this.day = day;
        this.count = count;
    }

    
    /**
     * @return the day
     */
    public Date getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(Date day) {
        this.day = day;
    }

    /**
     * @return the count
     */
    public long getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(long count) {
        this.count = count;
    }
    

}

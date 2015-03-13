package com.creditcloud.chinapay.model.request;

public class SinglePayQueryParameters extends SinglePayParameters {

    private static final long serialVersionUID = 20150311L;

    @Override
    public String getTextToSign() {
        return new StringBuffer(merId).append(merDate).append(merSeqId).append(version).toString();
    }
}

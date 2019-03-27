package org.ffsc.samplebank.credit;

import org.springframework.stereotype.Component;

/**
 * Created by Felipe Carvalho on 2019-03-09.
 */

@Component
public class CreditServiceFallback implements CreditServiceProxy {

    @Override
    public String getCredit() {
        return "Sorry, Credit Not Available!";
    }
}
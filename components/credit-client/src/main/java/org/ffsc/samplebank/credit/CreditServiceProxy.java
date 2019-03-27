package org.ffsc.samplebank.credit;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "credit-service", fallback = CreditServiceFallback.class)
public interface CreditServiceProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/credit")
    String getCredit();
}
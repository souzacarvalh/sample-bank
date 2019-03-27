package org.ffsc.samplebank.commons.database;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.security.SecureRandom;

@Component
@Slf4j
public class ResourceGuidGenerator {

    private SecureRandom random = new SecureRandom();

    public String generate(String resourceType) {
        Assert.notNull(resourceType, "resourceType required.  Should be provided by a generator parameter in entity.");
        Assert.isTrue(resourceType.length() == 3, "Invalid resourceType. Should be 3 characters long.");

        String dataCenter = "0";
        byte[] bytes = new byte[32];
        random.nextBytes(bytes);
        String generatedValue = String.valueOf(Hex.encodeHex(bytes));
        String epochTime = String.valueOf(System.currentTimeMillis() / 1000);
        StringBuilder guid = new StringBuilder().append(dataCenter).append(resourceType).append(generatedValue).append(epochTime);
        log.debug("new GUID is {} ", guid);

        return guid.toString();
    }

}
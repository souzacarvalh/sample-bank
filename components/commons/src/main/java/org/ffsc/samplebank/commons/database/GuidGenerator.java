package org.ffsc.samplebank.commons.database;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Properties;

@Component
public class GuidGenerator implements IdentifierGenerator, Configurable {

    private String resourceType;
    private ResourceGuidGenerator guidGenerator = new ResourceGuidGenerator();

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        return guidGenerator.generate(resourceType);
    }

    @Override
    public void configure(org.hibernate.type.Type type, Properties params, ServiceRegistry serviceRegistry) {
        Assert.notNull(params.getProperty("resourceType"), "Invalid resourceType.  Should be provided by a " +
                "generator parameter in entity or should be 3 character long.");

        this.resourceType = params.getProperty("resourceType");
    }
}
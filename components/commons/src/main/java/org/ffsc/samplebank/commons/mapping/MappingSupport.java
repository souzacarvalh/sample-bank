package org.ffsc.samplebank.commons.mapping;

import org.modelmapper.ModelMapper;

/**
 * Created by Felipe Carvalho on 2019-03-10.
 */

public interface MappingSupport {

    default <T> T transform(Class<T> target) {
        return new ModelMapper().map(this, target);
    }
}
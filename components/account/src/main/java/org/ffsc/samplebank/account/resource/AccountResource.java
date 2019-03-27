package org.ffsc.samplebank.account.resource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ffsc.samplebank.commons.mapping.MappingSupport;
import org.ffsc.samplebank.validator.ValidAccount;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Felipe Carvalho on 2019-03-10.
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class AccountResource extends ResourceSupport implements MappingSupport {

    @NotNull(message = "field.required")
    private String guid;

    @NotNull(message = "field.required")
    @Size.List({@Size(min = 1, message = "not.empty"), @Size(max = 5, message = "exceed.max.length")})
    private String branch;

    @ValidAccount
    private String number;

    @NotNull(message = "field.required")
    @Size.List({@Size(min = 1, message = "not.empty"), @Size(max = 15, message = "exceed.max.length")})
    private String documentId;

    @NotNull(message = "field.required")
    @Size.List({@Size(min = 1, message = "not.empty"), @Size(max = 30, message = "exceed.max.length")})
    private String firstName;

    @NotNull(message = "field.required")
    @Size.List({@Size(min = 1, message = "not.empty"), @Size(max = 30, message = "exceed.max.length")})
    private String lastName;

}
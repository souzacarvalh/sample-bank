package org.ffsc.samplebank.account.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.ffsc.samplebank.commons.mapping.MappingSupport;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Felipe Carvalho on 2019-03-10.
 */

@Entity
@Table(name = "ACCOUNT", schema = "SAMPLE_BANK")
@Data
@EqualsAndHashCode(callSuper = false)
public class Account implements MappingSupport {

    @Id
    @GenericGenerator(name = "acct_guid_gen", strategy = "org.ffsc.samplebank.commons.database.GuidGenerator",
            parameters = {@org.hibernate.annotations.Parameter(name = "resourceType", value = "ACCT")})
    @GeneratedValue(generator = "acct_guid_gen")
    @Column(name = "ACCT_GUID", nullable = false)
    private String guid;

    @Column(name = "BRANCH", nullable = false)
    private String branch;

    @Column(name = "ACCT_NUMBER", nullable = false, unique = true)
    private String number;

    @Column(name = "DOCUMENT_ID", nullable = false)
    private String documentId;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

}
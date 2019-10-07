package com.app.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GENERIC_ATTRIBUTE")
public class GenericAttributePo extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENEIRC_ATTRIBUTE_SEQ_GEN")
    @SequenceGenerator(name = "GENEIRC_ATTRIBUTE_SEQ_GEN", sequenceName = "GENEIRC_ATTRIBUTE_SEQ", initialValue = 1)
    private long id;

    @Column(name = "DTYPE")
    private String dtype;

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PARENT_ATTRIBUTE")
    private String parentAttribute;

    @Column(name = "DESCRIPTION")
    private String description;

    public long getId() {
        return this.id;
    }

    public String getDtype() {
        return this.dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentAttribute() {
        return this.parentAttribute;
    }

    public void setParentAttribute(String parentAttribute) {
        this.parentAttribute = parentAttribute;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

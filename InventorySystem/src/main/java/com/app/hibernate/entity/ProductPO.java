package com.app.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductPo extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ_GEN")
	@SequenceGenerator(name = "PRODUCT_SEQ_GEN", sequenceName = "PRODUCT_SEQ", initialValue = 1)
	private long id;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;


/**
 * @return the code
 */
public String getCode() {
    return code;
}



/**
 * @return the description
 */
public String getDescription() {
    return description;
}

/**
 * @return the id
 */
public long getId() {
    return id;
}


/**
 * @return the name
 */
public String getName() {
    return name;
}


/**
 * @param code the code to set
 */
public void setCode(String code) {
    this.code = code;
}


/**
 * @param description the description to set
 */
public void setDescription(String description) {
    this.description = description;
}


/**
 * @param name the name to set
 */
public void setName(String name) {
    this.name = name;
}










}
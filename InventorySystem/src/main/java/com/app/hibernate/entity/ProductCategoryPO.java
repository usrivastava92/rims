package com.app.hibernate.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategoryPO extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_CATEGORY_SEQ_GEN")
	@SequenceGenerator(name = "PRODUCT_CATEGORY_SEQ_GEN", sequenceName = "PRODUCT_CATEGORY_SEQ", initialValue = 1)
    private long id;
    
    @Column(name = "NAME")
    private String name;
    
    @Column(name = "CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private String category;
    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }


  
    @Override
    public Date getCreationTimeStamp() {
        // TODO Auto-generated method stub
        return super.getCreationTimeStamp();
    }

@Override
public Date getLastUpdatedTimeStamp() {
    // TODO Auto-generated method stub
    return super.getLastUpdatedTimeStamp();
}


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
 * @param category the category to set
 */
public void setCategory(String category) {
    this.category = category;
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
 * @param id the id to set
 */
public void setId(long id) {
    this.id = id;
}/**
 * @param name the name to set
 */
public void setName(String name) {
    this.name = name;
}

}
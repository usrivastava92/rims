package com.app.hibernate.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.hibernate.core.entities.BaseEntity;
import com.app.hibernate.entity.masters.ProductPo;

@Entity
@Table(name = "PRODUCT_CLASSIFICATION")
public class ProductClassificationPo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productClassification")
    private Collection<ProductPo> products;

    @Column(name = "PARENT_CATEGORY1")
    private String parentCategory1;

    @Column(name = "PARENT_CATEGORY2")
    private String parentCategory2;

    @Column(name = "SUB_CATEGORY1")
    private String subCategory1;

    @Column(name = "SUB_CATEGORY2")
    private String subCategory2;

    public String getParentCategory1() {
        return parentCategory1;
    }

    public void setParentCategory1(String parentCategory1) {
        this.parentCategory1 = parentCategory1;
    }

    public String getParentCategory2() {
        return parentCategory2;
    }

    public void setParentCategory2(String parentCategory2) {
        this.parentCategory2 = parentCategory2;
    }

    public String getSubCategory1() {
        return subCategory1;
    }

    public void setSubCategory1(String subCategory1) {
        this.subCategory1 = subCategory1;
    }

    public String getSubCategory2() {
        return subCategory2;
    }

    public void setSubCategory2(String subCategory2) {
        this.subCategory2 = subCategory2;
    }

    public Collection<ProductPo> getProducts() {
        return products;
    }

    public void setProducts(Collection<ProductPo> products) {
        this.products = products;
    }

}
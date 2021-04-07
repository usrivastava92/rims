package com.app.hibernate.entity.masters;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.app.hibernate.entity.core.BaseMasterEntity;

@Entity
@Table(name = "REPORTS")
public class ReportPo extends BaseMasterEntity {

	private static final long serialVersionUID = 1L;

}

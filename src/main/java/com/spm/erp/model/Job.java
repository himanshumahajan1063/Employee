package com.spm.erp.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "description")
    private String description;
    
    @Column(name = "min_salary")
    private Double min_salary;
    
    @Column(name = "max_salary")
    private Double max_salary;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(Double min_salary) {
		this.min_salary = min_salary;
	}

	public Double getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(Double max_salary) {
		this.max_salary = max_salary;
	}
    
   
    
}
package com.cz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @NotEmpty 字符串，集合类型不能为空
 * @NotNull 用在基本数据类型不能为空
 *
 */
@Data
@Repository@NoArgsConstructor
@JsonIgnoreProperties(value = { "handler" })
public class Employee{
	private int empId;
	@NotEmpty
	private String empName;
	@NotEmpty
	private String gender;
	@Email
	@Size(min = 6,max = 60)
	private String email;
	//float：2^23 = 8388608，共七位，意味着最多能有7位有效数字，但绝对能保证的为6位，也即float的精度为6~7位有效数字；
	//double：2^52 = 4503599627370496，一共16位，同理，double的精度为15~16位。
	@NumberFormat(pattern = "#,###,###.#")
	@NotNull
	private Float salary;
	@NotEmpty
	private String jobTitle;

	private Department dept;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	private int deptId;

}

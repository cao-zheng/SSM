package com.cz.dao;

import com.cz.model.Employee;
import lombok.Data;

import java.util.List;
@Data
public class EmpDto {

    private Employee employee;

    private List<Integer> ids;
}

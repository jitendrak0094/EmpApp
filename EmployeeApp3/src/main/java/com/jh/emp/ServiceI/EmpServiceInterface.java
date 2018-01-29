package com.jh.emp.ServiceI;

import java.util.List;

import com.jh.emp.Bo.EmployeeBo;

public interface EmpServiceInterface {

	public abstract List<EmployeeBo> insertRecord(EmployeeBo employeeBo);
	public abstract List<EmployeeBo> getAll();

}

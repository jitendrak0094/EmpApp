package com.jh.emp.DaoI;

import java.util.List;

import com.jh.emp.Bo.EmployeeBo;

public interface EmpDaoInterface {

	public abstract List<EmployeeBo> insertRecord(EmployeeBo employeeBo);
	public abstract List<EmployeeBo> getAll();

}

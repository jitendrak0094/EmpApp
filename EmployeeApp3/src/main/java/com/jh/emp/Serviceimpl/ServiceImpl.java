package com.jh.emp.Serviceimpl;

import java.util.List;

import com.jh.emp.Bo.EmployeeBo;
import com.jh.emp.DaoI.EmpDaoInterface;
import com.jh.emp.DaoImpl.DaoImpl;
import com.jh.emp.ServiceI.EmpServiceInterface;

public class ServiceImpl implements EmpServiceInterface{

	EmpDaoInterface edi;
	@Override
	public List<EmployeeBo> insertRecord(EmployeeBo employeeBo) {
		edi = new DaoImpl();
		List<EmployeeBo>list =edi.insertRecord(employeeBo);
		return list;
	}
	
	@Override
	public List<EmployeeBo> getAll() {
	
		edi = new DaoImpl();
		List<EmployeeBo>list =edi.getAll();
		return list;
	}

}

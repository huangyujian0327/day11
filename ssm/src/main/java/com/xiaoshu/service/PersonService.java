package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.CompanyMapper;
import com.xiaoshu.dao.PersonMapper;
import com.xiaoshu.entity.Company;
import com.xiaoshu.entity.Person;
import com.xiaoshu.entity.PersonVo;

@Service
public class PersonService {

	@Autowired
	PersonMapper  personMapper;
	@Autowired
	CompanyMapper  companyMapper;

	/*public PageInfo<PersonVo> findPersonPage(Integer pageNum,Integer pageSize,PersonVo personVo){
		PageHelper.startPage(pageNum, pageSize);
		List<PersonVo> list=personMapper.findList(personVo);
		return new PageInfo<>(list);
		
	}*/
	public Person findByName(String name){
		Person parm=new Person();
		parm.setpName(name);
		 return personMapper.selectOne(parm);
	}
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyMapper.selectAll();
	}
	public  void updatePerson(Person person){
		personMapper.updateByPrimaryKeySelective(person);
	}
	public void addPerson(Person person){
		personMapper.insert(person);
	}
	public void delPerson(Integer id) {
		personMapper.deleteByPrimaryKey(id);
		
	}
	public PageInfo<PersonVo> findPersonPage(PersonVo personVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<PersonVo> list=personMapper.findList(personVo);
		return new PageInfo<>(list);
	}


}

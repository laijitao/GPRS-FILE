package com.hp.cmcc.bboss.bdc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hp.cmcc.bboss.bdc.pojo.BbdcTypeCdr;

public interface BbdcTypeCdrDao extends JpaRepository<BbdcTypeCdr,Long>{

	List<BbdcTypeCdr> findByValNameAndValType(String valName, String valType);
}

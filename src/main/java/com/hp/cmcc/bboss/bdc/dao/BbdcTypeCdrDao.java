package com.hp.cmcc.bboss.bdc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hp.cmcc.bboss.bdc.pojo.BbdcTypeCdr;

public interface BbdcTypeCdrDao extends JpaRepository<BbdcTypeCdr,Long>{

	@Query(value = "select *from bdcpro.bbdc_type_cdr where val_name=?1 and val_type=?2", nativeQuery = true)  
	List<BbdcTypeCdr> findByValNameAndValType(String valName, String valType);
}

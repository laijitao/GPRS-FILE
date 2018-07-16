package com.hp.cmcc.bboss.bdc.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * The persistent class for the BBDC_TYPE_CDR database table.
 * 
 */
@Component
public class BbdcTypeCdr implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String dataAlign;
	private String dataFiller;
	private Long dataLen;
	private String dataPattern;
	private String dataReplace;
	private String dataSeparator;
	private String dataType;
	private Date effDate;
	private Date expDate;
	private Long fieldIdx;
	private Long fieldLen;
	private String fieldName;
	private String fieldType;
	private String fieldValue;
	private Long formerIdx;
	private Long hinderIdx;
	private String valName;
	private String valType;
	private String validateRegex;

	public BbdcTypeCdr(String valName,String fieldName,String dataSeparator, Long formerIdx, Long hinderIdx) {
		super();
		this.valName = valName;
		this.fieldName = fieldName;
		this.dataSeparator = dataSeparator;
		this.formerIdx = formerIdx;
		this.hinderIdx = hinderIdx;
	}
	
	public BbdcTypeCdr(String valName,String fieldName,String dataSeparator, Long formerIdx, Long hinderIdx,String dataFiller) {
		super();
		this.valName = valName;
		this.fieldName = fieldName;
		this.dataSeparator = dataSeparator;
		this.formerIdx = formerIdx;
		this.hinderIdx = hinderIdx;
		this.dataFiller = dataFiller;
	}
	
	public BbdcTypeCdr(String valName,String fieldName,String dataSeparator, Long formerIdx, Long hinderIdx,String dataFiller,String dataPattern) {
		super();
		this.valName = valName;
		this.fieldName = fieldName;
		this.dataSeparator = dataSeparator;
		this.formerIdx = formerIdx;
		this.hinderIdx = hinderIdx;
		this.dataFiller = dataFiller;
		this.dataPattern = dataPattern;
	}
	
	public BbdcTypeCdr() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDataAlign() {
		return this.dataAlign;
	}

	public void setDataAlign(String dataAlign) {
		this.dataAlign = dataAlign;
	}

	public String getDataFiller() {
		return this.dataFiller;
	}

	public void setDataFiller(String dataFiller) {
		this.dataFiller = dataFiller;
	}

	public Long getDataLen() {
		return this.dataLen;
	}

	public void setDataLen(Long dataLen) {
		this.dataLen = dataLen;
	}

	public String getDataPattern() {
		return this.dataPattern;
	}

	public void setDataPattern(String dataPattern) {
		this.dataPattern = dataPattern;
	}

	public String getDataReplace() {
		return this.dataReplace;
	}

	public void setDataReplace(String dataReplace) {
		this.dataReplace = dataReplace;
	}

	public String getDataSeparator() {
		return this.dataSeparator;
	}

	public void setDataSeparator(String dataSeparator) {
		this.dataSeparator = dataSeparator;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Date getEffDate() {
		return this.effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Long getFieldIdx() {
		return this.fieldIdx;
	}

	public void setFieldIdx(Long fieldIdx) {
		this.fieldIdx = fieldIdx;
	}

	public Long getFieldLen() {
		return this.fieldLen;
	}

	public void setFieldLen(Long fieldLen) {
		this.fieldLen = fieldLen;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldValue() {
		return this.fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public Long getFormerIdx() {
		return this.formerIdx;
	}

	public void setFormerIdx(Long formerIdx) {
		this.formerIdx = formerIdx;
	}

	public Long getHinderIdx() {
		return this.hinderIdx;
	}

	public void setHinderIdx(Long hinderIdx) {
		this.hinderIdx = hinderIdx;
	}

	public String getValName() {
		return this.valName;
	}

	public void setValName(String valName) {
		this.valName = valName;
	}

	public String getValType() {
		return this.valType;
	}

	public void setValType(String valType) {
		this.valType = valType;
	}

	public String getValidateRegex() {
		return this.validateRegex;
	}

	public void setValidateRegex(String validateRegex) {
		this.validateRegex = validateRegex;
	}

}
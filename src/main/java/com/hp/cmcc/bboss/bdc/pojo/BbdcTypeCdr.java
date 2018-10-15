package com.hp.cmcc.bboss.bdc.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the BBDC_TYPE_CDR database table.
 * 
 */
@Table(name="BBDC_TYPE_CDR")
@Entity
public class BbdcTypeCdr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LJT")
	@SequenceGenerator(name = "SEQ_LJT", sequenceName = "SEQ_LJT_TEST", initialValue = 1, allocationSize = 1)
	private Long id;
	@Column(name="DATA_ALIGN")
	private String dataAlign;    //对其方式
	@Column(name="DATA_FILLER")
	private String dataFiller;   //数据填充
	@Column(name="DATA_LEN")
	private Long dataLen;        //数据长度
	@Column(name="DATA_PATTERN")
	private String dataPattern;  //
	@Column(name="DATA_REPLACE")
	private String dataReplace;  //缺省填充
	@Column(name="DATA_SEPARATOR")
	private String dataSeparator;//分隔符
	@Column(name="DATA_TYPE")
	private String dataType;     //数据类型
	@Column(name="EFF_DATE")
	private Date effDate;        //生效时间:2018/6/1
	@Column(name="EXP_DATE")
	private Date expDate;        //失效时间
	@Column(name="FIELD_IDX")
	private Long fieldIdx;       //字段索引
	@Column(name="FIELD_LEN")
	private Long fieldLen;       //字段长度
	@Column(name="FIELD_NAME")
	private String fieldName;    //字段名
	@Column(name="FIELD_TYPE")
	private String fieldType;    //字段类型（CDR，CVS，enum）
	@Column(name="FIELD_VALUE")
	private String fieldValue;   //字段取值的来源（来自数据库查询还是系统配置）
	@Column(name="FORMER_IDX")
	private Long formerIdx;      //记录处理前字段所处位置
	@Column(name="HINDER_IDX")
	private Long hinderIdx;      //记录处理后字段所处位置
	@Column(name="VAL_NAME")
	private String valName;      //业务名称
	@Column(name="VAL_TYPE")
	private String valType;      //字段所属部分（文件名，文件头，文件体，文件尾）
	@Column(name="VALIDATE_REGEX")
	private String validateRegex;//校验正则表达式

	public BbdcTypeCdr(Long id, String valName, String valType, String fieldName, String fieldType, String fieldValue,
			Long fieldIdx, Long fieldLen, String dataType, Long dataLen, String dataPattern, String dataSeparator,
			String dataAlign, String dataFiller, String dataReplace, String validateRegex,
			Long formerIdx, Long hinderIdx) {
		super();
		this.id = id;
		this.dataAlign = dataAlign;
		this.dataFiller = dataFiller;
		this.dataLen = dataLen;
		this.dataPattern = dataPattern;
		this.dataReplace = dataReplace;
		this.dataSeparator = dataSeparator;
		this.dataType = dataType;
		this.fieldIdx = fieldIdx;
		this.fieldLen = fieldLen;
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.fieldValue = fieldValue;
		this.formerIdx = formerIdx;
		this.hinderIdx = hinderIdx;
		this.valName = valName;
		this.valType = valType;
		this.validateRegex = validateRegex;
	}

	public BbdcTypeCdr() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	@Override
	public String toString() {
		return "BbdcTypeCdr [id=" + id + ", dataAlign=" + dataAlign + ", dataFiller=" + dataFiller + ", dataLen="
				+ dataLen + ", dataPattern=" + dataPattern + ", dataReplace=" + dataReplace + ", dataSeparator="
				+ dataSeparator + ", dataType=" + dataType + ", effDate=" + effDate + ", expDate=" + expDate
				+ ", fieldIdx=" + fieldIdx + ", fieldLen=" + fieldLen + ", fieldName=" + fieldName + ", fieldType="
				+ fieldType + ", fieldValue=" + fieldValue + ", formerIdx=" + formerIdx + ", hinderIdx=" + hinderIdx
				+ ", valName=" + valName + ", valType=" + valType + ", validateRegex=" + validateRegex + "]";
	}

}
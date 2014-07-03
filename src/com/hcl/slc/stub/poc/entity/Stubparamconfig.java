package com.hcl.slc.stub.poc.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the STUBPARAMCONFIG database table.
 * 
 */
@Entity
@Table(name="Stubparamconfig",schema="WASADMIN")
@NamedQuery(name="Stubparamconfig.findAll", query="SELECT s FROM Stubparamconfig s")
public class Stubparamconfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String argument1;

	private String argument2;

	private String argument3;

	private int datalength;

	private String destfieldname;

	private String destinationdatatype;

	private String schemaname;

	private String sourcedatatype;

	private String sourcefieldname;

	private String tablename;

	private String testdata;

	private String usetestdata;

    public Stubparamconfig() {
    }

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArgument1() {
		return this.argument1;
	}

	public void setArgument1(String argument1) {
		this.argument1 = argument1;
	}

	public String getArgument2() {
		return this.argument2;
	}

	public void setArgument2(String argument2) {
		this.argument2 = argument2;
	}

	public String getArgument3() {
		return this.argument3;
	}

	public void setArgument3(String argument3) {
		this.argument3 = argument3;
	}

	public int getDatalength() {
		return this.datalength;
	}

	public void setDatalength(int datalength) {
		this.datalength = datalength;
	}

	public String getDestfieldname() {
		return this.destfieldname;
	}

	public void setDestfieldname(String destfieldname) {
		this.destfieldname = destfieldname;
	}

	public String getDestinationdatatype() {
		return this.destinationdatatype;
	}

	public void setDestinationdatatype(String destinationdatatype) {
		this.destinationdatatype = destinationdatatype;
	}

	public String getSchemaname() {
		return this.schemaname;
	}

	public void setSchemaname(String schemaname) {
		this.schemaname = schemaname;
	}

	public String getSourcedatatype() {
		return this.sourcedatatype;
	}

	public void setSourcedatatype(String sourcedatatype) {
		this.sourcedatatype = sourcedatatype;
	}

	public String getSourcefieldname() {
		return this.sourcefieldname;
	}

	public void setSourcefieldname(String sourcefieldname) {
		this.sourcefieldname = sourcefieldname;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getTestdata() {
		return this.testdata;
	}

	public void setTestdata(String testdata) {
		this.testdata = testdata;
	}

	public String getUsetestdata() {
		return this.usetestdata;
	}

	public void setUsetestdata(String usetestdata) {
		this.usetestdata = usetestdata;
	}

}
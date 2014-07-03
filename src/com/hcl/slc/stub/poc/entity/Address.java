package com.hcl.slc.stub.poc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="Address",schema="WASADMIN")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="ID_GENERATOR", sequenceName="HIBERNATE_SEQUENCE", allocationSize=1,schema="WASADMIN")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_GENERATOR")
	@Id
	private long addressid;

	private String addressline1;

	private String addressline2;

	private String addressline3;

	private String addressline4;

	private String addressline5;

	private String addressline6;

	private String addressline7;

	private String docid;

	private String postzipcode;

	private String ubisarchive;

	private String ubisdelete;

    @Temporal( TemporalType.DATE)
	private Date uboccupancydt;

	private String ubpremisesstatus;

	private int versionnum;

    public Address() {
    }

    
	public long getAddressid() {
		return addressid;
	}


	public void setAddressid(long addressid) {
		this.addressid = addressid;
	}


	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getAddressline3() {
		return this.addressline3;
	}

	public void setAddressline3(String addressline3) {
		this.addressline3 = addressline3;
	}

	public String getAddressline4() {
		return this.addressline4;
	}

	public void setAddressline4(String addressline4) {
		this.addressline4 = addressline4;
	}

	public String getAddressline5() {
		return this.addressline5;
	}

	public void setAddressline5(String addressline5) {
		this.addressline5 = addressline5;
	}

	public String getAddressline6() {
		return this.addressline6;
	}

	public void setAddressline6(String addressline6) {
		this.addressline6 = addressline6;
	}

	public String getAddressline7() {
		return this.addressline7;
	}

	public void setAddressline7(String addressline7) {
		this.addressline7 = addressline7;
	}

	public String getDocid() {
		return this.docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getPostzipcode() {
		return this.postzipcode;
	}

	public void setPostzipcode(String postzipcode) {
		this.postzipcode = postzipcode;
	}

	public String getUbisarchive() {
		return this.ubisarchive;
	}

	public void setUbisarchive(String ubisarchive) {
		this.ubisarchive = ubisarchive;
	}

	public String getUbisdelete() {
		return this.ubisdelete;
	}

	public void setUbisdelete(String ubisdelete) {
		this.ubisdelete = ubisdelete;
	}

	public Date getUboccupancydt() {
		return this.uboccupancydt;
	}

	public void setUboccupancydt(Date uboccupancydt) {
		this.uboccupancydt = uboccupancydt;
	}

	public String getUbpremisesstatus() {
		return this.ubpremisesstatus;
	}

	public void setUbpremisesstatus(String ubpremisesstatus) {
		this.ubpremisesstatus = ubpremisesstatus;
	}

	public int getVersionnum() {
		return this.versionnum;
	}

	public void setVersionnum(int versionnum) {
		this.versionnum = versionnum;
	}

}
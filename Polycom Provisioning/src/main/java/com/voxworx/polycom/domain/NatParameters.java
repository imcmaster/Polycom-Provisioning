package com.voxworx.polycom.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contains the parameters needed to build a nat tag
 * For details of the nat parameters, refer to the polycom spip documentation
 * @author Ian
 *
 */
@Entity
@Table(name="nat_parameters")
public class NatParameters {

	private int id;
	private String ip;
	private int keepAliveInterval;
	private int rtpMediaPortStart;
	private int sipPort;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="ip")
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Column(name="keep_alive_interval")
	public int getKeepAliveInterval() {
		return keepAliveInterval;
	}
	public void setKeepAliveInterval(int keepAliveInterval) {
		this.keepAliveInterval = keepAliveInterval;
	}

	@Column(name="rpt_media_port_start")
	public int getRtpMediaPortStart() {
		return rtpMediaPortStart;
	}
	public void setRtpMediaPortStart(int rtpMediaPortStart) {
		this.rtpMediaPortStart = rtpMediaPortStart;
	}

	@Column(name="sip_port")
	public int getSipPort() {
		return sipPort;
	}
	public void setSipPort(int sipPort) {
		this.sipPort = sipPort;
	}
	
}

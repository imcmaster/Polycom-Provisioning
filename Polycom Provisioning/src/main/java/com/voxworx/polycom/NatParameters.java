package com.voxworx.polycom;

/**
 * Contains the parameters needed to build a nat tag
 * For details of the nat parameters, refer to the polycom spip documentation
 * @author Ian
 *
 */
public class NatParameters {

	private String ip;
	private int keepAliveInterval;
	private int rtpMediaPortStart;
	private int sipPort;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getKeepAliveInterval() {
		return keepAliveInterval;
	}
	public void setKeepAliveInterval(int keepAliveInterval) {
		this.keepAliveInterval = keepAliveInterval;
	}
	public int getRtpMediaPortStart() {
		return rtpMediaPortStart;
	}
	public void setRtpMediaPortStart(int rtpMediaPortStart) {
		this.rtpMediaPortStart = rtpMediaPortStart;
	}
	public int getSipPort() {
		return sipPort;
	}
	public void setSipPort(int sipPort) {
		this.sipPort = sipPort;
	}
	
}

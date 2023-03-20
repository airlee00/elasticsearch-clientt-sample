
/*
 * Copyright (C) Hanwha S&C Ltd., 2018. All rights reserved.
 *
 * This software is covered by the license agreement between
 * the end user and Hanwha S&C Ltd., and may be
 * used and copied only in accordance with the terms of the
 * said agreement.
 *
 * Hanwha S&C Ltd., assumes no responsibility or
 * liability for any errors or inaccuracies in this software,
 * or any consequential, incidental or indirect damage arising
 * out of the use of the software.
 */
package hone.admin.online.server.monitor.dto.elasticsearch;

/**
 * <pre>
 * </pre>
 * @author kclee
 * @since
 * @createdate 2023.02.25.
 */
public class EsErrorDetail {
	private String marker;
	private String ts; //timestamp
	private String serviceId; // tx_code
	private String requestId;
	private String msg;
	public String getMarker() {
		return marker;
	}
	public void setMarker(String marker) {
		this.marker = marker;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EsErrorDetail [marker=").append(marker).append(", ts=").append(ts).append(", serviceId=")
				.append(serviceId).append(", requestId=").append(requestId).append(", msg=").append(msg).append("]");
		return builder.toString();
	}


}

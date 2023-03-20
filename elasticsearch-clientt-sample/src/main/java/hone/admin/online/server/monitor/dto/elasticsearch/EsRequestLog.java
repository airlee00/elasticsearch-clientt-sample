
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

import java.util.HashMap;

/**
 * <pre>
 * </pre>
 *
 * @author kclee
 * @since
 * @createdate 2023.02.25.
 */
public class EsRequestLog {
	private String guid;
	private HashMap host;
	private String marker;
	private String ts; //timestamp
	private String serviceId; // tx_code
	private String requestId;
	private long requestTime;
	private String screenId;
	private String userId;
	private String remoteIp;
	private long elapsedTime;
	private String channelCode;
	private String resultCode;
	private String level;
	private String logMessage;

	private long startTime;
	private long endTime;
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
	public long getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRemoteIp() {
		return remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	public long getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}

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

	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getLogMessage() {
		return logMessage;
	}
	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}
	public HashMap getHost() {
		return host;
	}
	public void setHost(HashMap host) {
		this.host = host;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EsRequestLog [guid=");
		builder.append(guid);
		builder.append(", host=");
		builder.append(host);
		builder.append(", marker=");
		builder.append(marker);
		builder.append(", ts=");
		builder.append(ts);
		builder.append(", serviceId=");
		builder.append(serviceId);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", requestTime=");
		builder.append(requestTime);
		builder.append(", screenId=");
		builder.append(screenId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", remoteIp=");
		builder.append(remoteIp);
		builder.append(", elapsedTime=");
		builder.append(elapsedTime);
		builder.append(", channelCode=");
		builder.append(channelCode);
		builder.append(", resultCode=");
		builder.append(resultCode);
		builder.append(", level=");
		builder.append(level);
		builder.append(", logMessage=");
		builder.append(logMessage);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append("]");
		return builder.toString();
	}



}

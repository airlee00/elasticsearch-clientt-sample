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
package kworkslab.admin.online.server.monitor.dto;

import java.sql.Timestamp;




/**
 * <pre>
 * </pre>
 *
 * @author 유광종
 * @since
 * @createdate 2015. 5. 12.
 */
public class ServiceLog {

	private String txCode;
	private String requestId;
	private String serviceId;
	private String userId;
	private String remoteIp;
	private String instanceId;

	private String loggerName;
	private String threadName;
	private String logLevel;
	private String sourcePosition;

	private long logTime;

	private long endTime;
	private long startTime;
	private long elapsedTime;

	private String logMessage;

	private String marker;

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	public String getTxCode() {
		return txCode;
	}

	public void setTxCode(String txCode) {
		this.txCode = txCode;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getLoggerName() {
		return loggerName;
	}

	public void setLoggerName(String loggerName) {
		this.loggerName = loggerName;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getSourcePosition() {
		return sourcePosition;
	}

	public void setSourcePosition(String sourcePosition) {
		this.sourcePosition = sourcePosition;
	}

	public long getLogTime() {
		return logTime;
	}

	public void setLogTime(long logTime) {
		this.logTime = logTime;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceLog [txCode=");
		builder.append(txCode);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", serviceId=");
		builder.append(serviceId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", remoteIp=");
		builder.append(remoteIp);
		builder.append(", instanceId=");
		builder.append(instanceId);
		builder.append(", loggerName=");
		builder.append(loggerName);
		builder.append(", threadName=");
		builder.append(threadName);
		builder.append(", logLevel=");
		builder.append(logLevel);
		builder.append(", sourcePosition=");
		builder.append(sourcePosition);
		builder.append(", logTime=");
		builder.append(logTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", elapsedTime=");
		builder.append(elapsedTime);
		builder.append(", logMessage=");
		builder.append(logMessage);
		builder.append(", marker=");
		builder.append(marker);
		builder.append("]");
		return builder.toString();
	}

}

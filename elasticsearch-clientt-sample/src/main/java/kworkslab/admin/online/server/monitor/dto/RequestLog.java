
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
 * @createdate 2015. 6. 16.
 */
public class RequestLog {
	private String serviceId; // tx_code
	private String serviceName = "";
	private String reqId;
	private long reqTime;
	private String contextType;
	private String channelType;

	private String fnCode;
	private String screenId;
	private String svrInst;
	private String userId;
	private String userNm;
	private String clientIp;

	private long elapsedTime;
	private String result;
	private String channelCode;
	private String resultCode;

	private long startTime;
	private long endTime;
	private long fromElapsedTime;
	private long toElapsedTime;

	private long nanoTime;

	//2021.06.10 kclee
	private transient String execDate;
	private transient String serverType;
	private transient Integer totalCount;
	private transient Integer successCount;
	private transient Integer failCount;

	public String getExecDate() {
		return execDate;
	}

	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}

	private String searchType;
	//BACKWARD or FORWARD

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public final String getServiceName() {
		return serviceName;
	}

	public final void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getReqId() {
		return reqId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	}

	public long getReqTime() {
		return reqTime;
	}

	public void setReqTime(long reqTime) {
		this.reqTime = reqTime;
	}

	public String getContextType() {
		return contextType;
	}

	public void setContextType(String contextType) {
		this.contextType = contextType;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getFnCode() {
		return fnCode;
	}

	public void setFnCode(String fnCode) {
		this.fnCode = fnCode;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getSvrInst() {
		return svrInst;
	}

	public void setSvrInst(String svrInst) {
		this.svrInst = svrInst;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public long getFromElapsedTime() {
		return fromElapsedTime;
	}

	public void setFromElapsedTime(long fromElapsedTime) {
		this.fromElapsedTime = fromElapsedTime;
	}

	public long getToElapsedTime() {
		return toElapsedTime;
	}

	public void setToElapsedTime(long toElapsedTime) {
		this.toElapsedTime = toElapsedTime;
	}

	public long getNanoTime() {
		return nanoTime;
	}

	public void setNanoTime(long nanoTime) {
		this.nanoTime = nanoTime;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}



	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}



	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestLog [serviceId=");
		builder.append(serviceId);
		builder.append(", serviceName=");
		builder.append(serviceName);
		builder.append(", reqId=");
		builder.append(reqId);
		builder.append(", reqTime=");
		builder.append(reqTime);
		builder.append(", contextType=");
		builder.append(contextType);
		builder.append(", channelType=");
		builder.append(channelType);
		builder.append(", fnCode=");
		builder.append(fnCode);
		builder.append(", screenId=");
		builder.append(screenId);
		builder.append(", svrInst=");
		builder.append(svrInst);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userNm=");
		builder.append(userNm);
		builder.append(", clientIp=");
		builder.append(clientIp);
		builder.append(", elapsedTime=");
		builder.append(elapsedTime);
		builder.append(", result=");
		builder.append(result);
		builder.append(", channelCode=");
		builder.append(channelCode);
		builder.append(", resultCode=");
		builder.append(resultCode);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append(", fromElapsedTime=");
		builder.append(fromElapsedTime);
		builder.append(", toElapsedTime=");
		builder.append(toElapsedTime);
		builder.append(", nanoTime=");
		builder.append(nanoTime);
		builder.append(", searchType=");
		builder.append(searchType);
		builder.append("]");
		return builder.toString();
	}




}

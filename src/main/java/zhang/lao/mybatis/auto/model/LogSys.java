package zhang.lao.mybatis.auto.model;

import java.util.Date;

public class LogSys {
    private Long id;

    private Date actionenddate;

    private Long actionendtime;

    private Integer actionhaoshi;

    private Date actionstartdate;

    private Long actionstarttime;

    private String cause;

    private String cookie;

    private Date enddate;

    private Long endtime;

    private Integer haoshi;

    private String ips;

    private String method;

    private String referer;

    private Date startdate;

    private Long starttime;

    private String status;

    private String useragent;

    private Integer viewhaoshi;

    private String operatorids;

    private String accept;

    private String acceptencoding;

    private String acceptlanguage;

    private String connection;

    private String host;

    private String xrequestedwith;

    private String pvids;

    private String userids;

    private String description;

    private String requestpath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getActionenddate() {
        return actionenddate;
    }

    public void setActionenddate(Date actionenddate) {
        this.actionenddate = actionenddate;
    }

    public Long getActionendtime() {
        return actionendtime;
    }

    public void setActionendtime(Long actionendtime) {
        this.actionendtime = actionendtime;
    }

    public Integer getActionhaoshi() {
        return actionhaoshi;
    }

    public void setActionhaoshi(Integer actionhaoshi) {
        this.actionhaoshi = actionhaoshi;
    }

    public Date getActionstartdate() {
        return actionstartdate;
    }

    public void setActionstartdate(Date actionstartdate) {
        this.actionstartdate = actionstartdate;
    }

    public Long getActionstarttime() {
        return actionstarttime;
    }

    public void setActionstarttime(Long actionstarttime) {
        this.actionstarttime = actionstarttime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause == null ? null : cause.trim();
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Long getEndtime() {
        return endtime;
    }

    public void setEndtime(Long endtime) {
        this.endtime = endtime;
    }

    public Integer getHaoshi() {
        return haoshi;
    }

    public void setHaoshi(Integer haoshi) {
        this.haoshi = haoshi;
    }

    public String getIps() {
        return ips;
    }

    public void setIps(String ips) {
        this.ips = ips == null ? null : ips.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer == null ? null : referer.trim();
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Long getStarttime() {
        return starttime;
    }

    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent == null ? null : useragent.trim();
    }

    public Integer getViewhaoshi() {
        return viewhaoshi;
    }

    public void setViewhaoshi(Integer viewhaoshi) {
        this.viewhaoshi = viewhaoshi;
    }

    public String getOperatorids() {
        return operatorids;
    }

    public void setOperatorids(String operatorids) {
        this.operatorids = operatorids == null ? null : operatorids.trim();
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept == null ? null : accept.trim();
    }

    public String getAcceptencoding() {
        return acceptencoding;
    }

    public void setAcceptencoding(String acceptencoding) {
        this.acceptencoding = acceptencoding == null ? null : acceptencoding.trim();
    }

    public String getAcceptlanguage() {
        return acceptlanguage;
    }

    public void setAcceptlanguage(String acceptlanguage) {
        this.acceptlanguage = acceptlanguage == null ? null : acceptlanguage.trim();
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection == null ? null : connection.trim();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getXrequestedwith() {
        return xrequestedwith;
    }

    public void setXrequestedwith(String xrequestedwith) {
        this.xrequestedwith = xrequestedwith == null ? null : xrequestedwith.trim();
    }

    public String getPvids() {
        return pvids;
    }

    public void setPvids(String pvids) {
        this.pvids = pvids == null ? null : pvids.trim();
    }

    public String getUserids() {
        return userids;
    }

    public void setUserids(String userids) {
        this.userids = userids == null ? null : userids.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRequestpath() {
        return requestpath;
    }

    public void setRequestpath(String requestpath) {
        this.requestpath = requestpath == null ? null : requestpath.trim();
    }
}
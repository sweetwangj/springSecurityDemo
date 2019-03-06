package com.operation.qkwall.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Task implements Serializable {


    private static final long serialVersionUID = 6277758944399229568L;

    private int id;// 任务ID
    private String appName;// APP名称
    private String keyWord;// 刷关键词的搜索词
    private String icon;// 任务图标地址
    private String title;// 任务名称
    private String desc;// 任务描述
    private int totalNum ;// 任务总数，后台新增任务时同时更新任务剩余数量
    private int remainNum ;// 任务剩余数量
    private int ingNum ;// 进行中的任务数量
    private int endNum ;// 完成的任务数量
    private BigDecimal price ;// 任务奖励
    private String showPrice;   //用于展示的奖励(展示为 1K / 12.3M  等等)
    private int appType;// app的类型：0-免费app 1- 付费app
    private int taskOperation;  //任务行为： 0-刷关键词（需要用户自己搜索）  1-刷下载量
    private int weight;// 权重：越小越靠前，默认排最后 （后录入的在最后）
    private int visible ;// 可见性：0-不可见 1-可见
    private int status;// 0-待审核 1-审核未通过 2-删除 3-上线 4-下线
    private Timestamp hopeTime;// 期望上线时间
    private Timestamp addTime;// 插入时间 任务申请时间
    private Timestamp upTime;// 最后一次更新的时间
    private String taskUrl; // 任务开始的第三方URL
    private String appId;  //app的id(自家的为gameId)
    private String os;//操作系统  android  ios
    private String packetName;//包名
    private Long expirationTime;    //任务过期时间
    private String priceType;  //奖励类型  cash  token
    private int needPlay;   //是否需要试玩   0不需要   1需要
    private int parentTaskId;   //父级任务id
    private int hasChild;    //有子任务  0没有  1有
    private String gameId;
    private String searchDescription;   //搜索下载的描述
    private int needOpenWhile;  //是否需要打开app一段时间  0 不需要  1需要
    private Long openTime;  //需要打开该应用的时间  单位 秒
    private String downloadDescription;   //下载任务的时候显示部分
    private String tryitupDescription;   //试玩描述的上部分
    private String tryitdownDescription;   //搜索下载的描述
    private String receiveDescription;   //领取奖励的描述
    private String downloadDetailDescription; //下载描述的详细描述部分
    private String searchKeywordDescription; //搜索任务  关键字以及商店描述

    private int userTaskStatus; // 用户对应的该任务状态 0-未领取(普通) 1-领取(正在进行) 2-完成任务(可以领取奖励了) 3-任务关闭(这个任务做完并领取奖励了) 4-任务没有剩余(任务库存为0 被领取完了) TASKNOLEFT


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(int remainNum) {
        this.remainNum = remainNum;
    }

    public int getIngNum() {
        return ingNum;
    }

    public void setIngNum(int ingNum) {
        this.ingNum = ingNum;
    }

    public int getEndNum() {
        return endNum;
    }

    public void setEndNum(int endNum) {
        this.endNum = endNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public int getTaskOperation() {
        return taskOperation;
    }

    public void setTaskOperation(int taskOperation) {
        this.taskOperation = taskOperation;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getHopeTime() {
        return hopeTime;
    }

    public void setHopeTime(Timestamp hopeTime) {
        this.hopeTime = hopeTime;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Timestamp getUpTime() {
        return upTime;
    }

    public void setUpTime(Timestamp upTime) {
        this.upTime = upTime;
    }

    public String getTaskUrl() {
        return taskUrl;
    }

    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPacketName() {
        return packetName;
    }

    public void setPacketName(String packetName) {
        this.packetName = packetName;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public int getNeedPlay() {
        return needPlay;
    }

    public void setNeedPlay(int needPlay) {
        this.needPlay = needPlay;
    }

    public int getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(int parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public int getHasChild() {
        return hasChild;
    }

    public void setHasChild(int hasChild) {
        this.hasChild = hasChild;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getUserTaskStatus() {
        return userTaskStatus;
    }

    public void setUserTaskStatus(int userTaskStatus) {
        this.userTaskStatus = userTaskStatus;
    }

    public String getSearchDescription() {
        return searchDescription;
    }

    public void setSearchDescription(String searchDescription) {
        this.searchDescription = searchDescription;
    }

    public int getNeedOpenWhile() {
        return needOpenWhile;
    }

    public void setNeedOpenWhile(int needOpenWhile) {
        this.needOpenWhile = needOpenWhile;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public String getDownloadDescription() {
        return downloadDescription;
    }

    public void setDownloadDescription(String downloadDescription) {
        this.downloadDescription = downloadDescription;
    }

    public String getTryitupDescription() {
        return tryitupDescription;
    }

    public void setTryitupDescription(String tryitupDescription) {
        this.tryitupDescription = tryitupDescription;
    }

    public String getTryitdownDescription() {
        return tryitdownDescription;
    }

    public void setTryitdownDescription(String tryitdownDescription) {
        this.tryitdownDescription = tryitdownDescription;
    }

    public String getReceiveDescription() {
        return receiveDescription;
    }

    public void setReceiveDescription(String receiveDescription) {
        this.receiveDescription = receiveDescription;
    }

    public String getDownloadDetailDescription() {
        return downloadDetailDescription;
    }

    public void setDownloadDetailDescription(String downloadDetailDescription) {
        this.downloadDetailDescription = downloadDetailDescription;
    }

    public String getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(String showPrice) {
        this.showPrice = showPrice;
    }

    public String getSearchKeywordDescription() {
        return searchKeywordDescription;
    }

    public void setSearchKeywordDescription(String searchKeywordDescription) {
        this.searchKeywordDescription = searchKeywordDescription;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", totalNum=" + totalNum +
                ", remainNum=" + remainNum +
                ", ingNum=" + ingNum +
                ", endNum=" + endNum +
                ", price=" + price +
                ", showPrice='" + showPrice + '\'' +
                ", appType=" + appType +
                ", taskOperation=" + taskOperation +
                ", weight=" + weight +
                ", visible=" + visible +
                ", status=" + status +
                ", hopeTime=" + hopeTime +
                ", addTime=" + addTime +
                ", upTime=" + upTime +
                ", taskUrl='" + taskUrl + '\'' +
                ", appId='" + appId + '\'' +
                ", os='" + os + '\'' +
                ", packetName='" + packetName + '\'' +
                ", expirationTime=" + expirationTime +
                ", priceType='" + priceType + '\'' +
                ", needPlay=" + needPlay +
                ", parentTaskId=" + parentTaskId +
                ", hasChild=" + hasChild +
                ", gameId='" + gameId + '\'' +
                ", searchDescription='" + searchDescription + '\'' +
                ", needOpenWhile=" + needOpenWhile +
                ", openTime=" + openTime +
                ", downloadDescription='" + downloadDescription + '\'' +
                ", tryitupDescription='" + tryitupDescription + '\'' +
                ", tryitdownDescription='" + tryitdownDescription + '\'' +
                ", receiveDescription='" + receiveDescription + '\'' +
                ", downloadDetailDescription='" + downloadDetailDescription + '\'' +
                ", searchKeywordDescription='" + searchKeywordDescription + '\'' +
                ", userTaskStatus=" + userTaskStatus +
                '}';
    }
}

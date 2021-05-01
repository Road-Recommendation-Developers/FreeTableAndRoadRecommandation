package com.company.dataBean;

public class POIPoint {
    /*
    * poiIndex：索引，目前作为主键
    * latitude：地理位置上的纬度
    * longitude：地理位置上的经度
    * poiName：名称，主要用于最终推荐路线的展示
    * poiType：兴趣点的类型，用于后期优化
    * DistInterval:兴趣点之间的距离
    * */
    private int poiIndex;
    private double latitude;
    private double longitude;
    private String poiName;
    private String poiType;
    private double DistInterval;

    //构造方法，进行数据的赋值
    public POIPoint(String lineStr) {
        String str[] = lineStr.split(",");
        //对已有数据，通过逗号进行拆分
        this.longitude = Double.valueOf(str[1]).doubleValue();
        this.latitude = Double.valueOf(str[2]).doubleValue();
        this.poiIndex=Integer.valueOf(str[0]).intValue();
        this.poiName = str[3];
    }

    //基本的数据获取与设置
    public int getPoiIndex() {
        return poiIndex;
    }

    public void setPoiIndex(int poiIndex) {
        this.poiIndex = poiIndex;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    public String getPoiType() {
        return poiType;
    }

    public void setPoiType(String poiType) {
        this.poiType = poiType;
    }

    public double getDistInterval() {
        return DistInterval;
    }

    public void setDistInterval(double distInterval) {
        DistInterval = distInterval;
    }
}

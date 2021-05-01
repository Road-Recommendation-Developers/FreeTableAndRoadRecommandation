package com.company.dataBean;

public class GPSPoint {
    /*
     * gpsIndex：索引，目前作为主键
     * latitude：地理位置上的纬度
     * longitude：地理位置上的经度
     * DistInterval:兴趣点之间的距离
     * */
    private int gpsIndex;
    private double latitude;
    private double longitude;
    private double DistInterval;
    public GPSPoint(String lineStr) {
        String str[] = lineStr.split(",");
        this.gpsIndex=Integer.valueOf(str[0]).intValue();
        this.latitude = Double.valueOf(str[1]).doubleValue();
        this.longitude = Double.valueOf(str[2]).doubleValue();

    }
    public GPSPoint() {
        // TODO Auto-generated constructor stub
    }

    //基本的数据获取与设置
    public int getGpsIndex() {
        return gpsIndex;
    }

    
    public void setGpsIndex(int gpsIndex) {
        this.gpsIndex = gpsIndex;
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

    public double getDistInterval() {
        return DistInterval;
    }

    public void setDistInterval(double distInterval) {
        DistInterval = distInterval;
    }


}

package com.company.dataBean;

public class POIPoint {
    /*
    * poiIndex��������Ŀǰ��Ϊ����
    * latitude������λ���ϵ�γ��
    * longitude������λ���ϵľ���
    * poiName�����ƣ���Ҫ���������Ƽ�·�ߵ�չʾ
    * poiType����Ȥ������ͣ����ں����Ż�
    * DistInterval:��Ȥ��֮��ľ���
    * */
    private int poiIndex;
    private double latitude;
    private double longitude;
    private String poiName;
    private String poiType;
    private double DistInterval;

    //���췽�����������ݵĸ�ֵ
    public POIPoint(String lineStr) {
        String str[] = lineStr.split(",");
        //���������ݣ�ͨ�����Ž��в��
        this.longitude = Double.valueOf(str[1]).doubleValue();
        this.latitude = Double.valueOf(str[2]).doubleValue();
        this.poiIndex=Integer.valueOf(str[0]).intValue();
        this.poiName = str[3];
    }

    //���������ݻ�ȡ������
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

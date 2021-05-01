package com.company.process;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.company.dataBean.POIPoint;
import com.company.dataBean.GPSPoint;
import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

import static java.lang.Character.getName;
import static java.lang.Character.valueOf;

public class SimpleRoadRecommandation {
    private static final int INF = Integer.MAX_VALUE;   // ���ֵ


    public SimpleRoadRecommandation() {
    }

    public double CalculateTheTotalDistance(List<POIPoint> poiDatas) {
        double totalDistance=0;
        //����ͼ�Ĺ����������������
        //1�����ø���ľ���
        //2�����������Э��
        int[][] distance=SetDistance(poiDatas);
        char[] name={'A', 'B', 'C', 'D', 'E', 'F','G','H','I','J','K','L'};
        MatrixUDG matrix =new MatrixUDG();
        matrix.demo(name,distance);
        //����Լ�������ϵķ���
        //1,����Լ����������ʵ���������
        //2,����Լ���������Դ����������

        return  totalDistance;

    }


    private char[] SetNamelist(List<POIPoint> poiDatas){
        char[] NameList=new char[poiDatas.size()];
        String name;
        for(int i = 0; i < poiDatas.size(); ++i){
            name= poiDatas.get(i).getPoiName();
        }
        return NameList;
    }

    private int[][] SetDistance(List<POIPoint> poiDatas){
        int dist = 0;
        int[][] distance=new int[poiDatas.size()][poiDatas.size()];
        ((POIPoint)poiDatas.get(0)).setDistInterval(dist);
        //��ʼ��������㣬��ʼ������
        for(int i = 0; i < poiDatas.size(); ++i) {
            for(int j = 1;j < poiDatas.size(); ++j){
                dist = Integer.valueOf((int) this.GetDistance((POIPoint)poiDatas.get(i), (POIPoint)poiDatas.get(j)));
                if(dist>500)
                    dist=INF;
                distance[i][j]=distance[j][i]=dist;
            }
        }
        return distance;
    }

    private double GetDistance(POIPoint dp1, POIPoint dp2) {
        double PI = 3.1415926D;
        double Earth_Radius = 6378.137D;
        double radLat1 = dp1.getLatitude() * PI / 180.0D;
        double radLat2 = dp2.getLatitude() * PI / 180.0D;
        double a = radLat1 - radLat2;
        double b = dp1.getLongitude() * PI / 180.0D - dp2.getLongitude() * PI / 180.0D;
        double s = 2.0D * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2.0D), 2.0D) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2.0D), 2.0D)));
        s *= Earth_Radius;
        s *= 1000.0D;
        return s;
    }
    private void AnalyzeTheLimitCondition(){
        //���룺��������
        //Ԥ�ȵ����ְ�ܷ����������֣������ķ�������ģ�����䡢���ȼ�����
        //����ĸ�����������㡢�����Լ��ľ�������
        //�����Լ������
        char[] task={'a','b','c'};
    }

    private void RoadRecommandationWithLimit(){
        //���룺��������
        //Ԥ�ȵ����ְ�ܷ����������֣������ķ�������ģ�����䡢���ȼ�����
        //����ĸ�����������㡢�����Լ��ľ�������
        //�����Լ������
        char[] task={'a','b','c'};
    }
}



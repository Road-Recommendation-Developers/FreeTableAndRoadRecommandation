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
    private static final int INF = Integer.MAX_VALUE;   // 最大值


    public SimpleRoadRecommandation() {
    }

    public double CalculateTheTotalDistance(List<POIPoint> poiDatas) {
        double totalDistance=0;
        //进行图的构建，而后深度优先
        //1，设置各点的距离
        //2，和深度优先协作
        int[][] distance=SetDistance(poiDatas);
        char[] name={'A', 'B', 'C', 'D', 'E', 'F','G','H','I','J','K','L'};
        MatrixUDG matrix =new MatrixUDG();
        matrix.demo(name,distance);
        //进行约束条件上的分析
        //1,产生约束条件，从实际情况出发
        //2,利用约束条件，对代码进行修正

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
        //起始点距离置零，初始化操作
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
        //输入：具体事务
        //预先奠基：职能分析、步骤拆分（初步的分析）、模型适配、优先级评估
        //问题的根本在于切入点、在于自己的精力分配
        //输出：约束条件
        char[] task={'a','b','c'};
    }

    private void RoadRecommandationWithLimit(){
        //输入：具体事务
        //预先奠基：职能分析、步骤拆分（初步的分析）、模型适配、优先级评估
        //问题的根本在于切入点、在于自己的精力分配
        //输出：约束条件
        char[] task={'a','b','c'};
    }
}



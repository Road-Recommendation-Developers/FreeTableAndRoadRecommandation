package com.company.doMain;

import com.company.dataBean.Course;
import com.company.dataBean.POIPoint;
import com.company.process.InputCourseData;
import com.company.process.InputPOIData;
import com.company.process.SimpleFreeTable;
import com.company.process.SimpleRoadRecommandation;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();    //获取开始时间

        String poifilepath = "src\\Data\\POIPoint01.csv";
        InputPOIData ipd = new InputPOIData();
        List<POIPoint> poiDatas = ipd.InputPOIPointData(poifilepath);
        //实现兴趣点数据的输入
        SimpleRoadRecommandation sim=new SimpleRoadRecommandation();
        double temp=sim.CalculateTheTotalDistance(poiDatas);
        //简单地根据兴趣点索引顺序进行路线推荐
        //进行课程表方面的分析，实现函数设计
        sim.CallPythonCode();
        String coursefilepath="src\\Data\\infos.txt";
        InputCourseData icd=new InputCourseData();
        List <Course> courseDatas=icd.ReadFile(coursefilepath);
        //System.out.println(coursedata);
        SimpleFreeTable sift=new SimpleFreeTable();
        sift.FormatTheCourseData(courseDatas);

        long endTime = System.currentTimeMillis();    //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }
}

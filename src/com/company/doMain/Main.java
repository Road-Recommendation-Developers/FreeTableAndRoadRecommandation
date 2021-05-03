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
        long startTime = System.currentTimeMillis();    //��ȡ��ʼʱ��

        String poifilepath = "src\\Data\\POIPoint01.csv";
        InputPOIData ipd = new InputPOIData();
        List<POIPoint> poiDatas = ipd.InputPOIPointData(poifilepath);
        //ʵ����Ȥ�����ݵ�����
        SimpleRoadRecommandation sim=new SimpleRoadRecommandation();
        double temp=sim.CalculateTheTotalDistance(poiDatas);
        //�򵥵ظ�����Ȥ������˳�����·���Ƽ�
        //���пγ̱���ķ�����ʵ�ֺ������
        sim.CallPythonCode();
        String coursefilepath="src\\Data\\infos.txt";
        InputCourseData icd=new InputCourseData();
        List <Course> courseDatas=icd.ReadFile(coursefilepath);
        //System.out.println(coursedata);
        SimpleFreeTable sift=new SimpleFreeTable();
        sift.FormatTheCourseData(courseDatas);

        long endTime = System.currentTimeMillis();    //��ȡ����ʱ��

        System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");    //�����������ʱ��
    }
}

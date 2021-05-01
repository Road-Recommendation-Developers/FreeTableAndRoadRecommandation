//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.company.dataBean.POIPoint;

public class InputPOIData {
    public List<POIPoint> InputPOIPointData(String filepath){
        List<POIPoint> poiDatas = new ArrayList<POIPoint>();

        try{
            File infile = new File(filepath);
            if(infile.isFile() && infile.exists()){      // judge the file exist or not
                InputStreamReader read = new InputStreamReader(new FileInputStream(infile), "GBK");
                //InputStreamReader���Խ�һ���ֽ�����������װ���ַ�������
                BufferedReader bufferedReader = new BufferedReader(read);
                //(read);//BufferedReader�ڶ�ȡ�ı��ļ�ʱ�����Ⱦ������ļ��ж����ַ����ݲ����뻺��������֮����ʹ��read()���������ȴӻ������н��ж�ȡ��
                String lineStr = null;

                while((lineStr = bufferedReader.readLine()) != null){
                    POIPoint poi = new POIPoint(lineStr);
                    poiDatas.add(poi);

                }
                read.close();
            }else{
                System.out.println("Not Find file " + filepath);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return poiDatas;
    }
}

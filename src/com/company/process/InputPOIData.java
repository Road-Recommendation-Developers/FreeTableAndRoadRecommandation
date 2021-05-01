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
                //InputStreamReader可以将一个字节输入流包包装成字符输入流
                BufferedReader bufferedReader = new BufferedReader(read);
                //(read);//BufferedReader在读取文本文件时，会先尽量从文件中读入字符数据并置入缓冲区，而之后若使用read()方法，会先从缓冲区中进行读取。
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

package com.company.process;

import com.company.dataBean.Course;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputCourseData {
    public InputCourseData() {
    }
    public List<Course> ReadFile(String coursefilepath) {
        String coursedata=new String();
        List<Course> courseDatas = new ArrayList<Course>();
        try {
            File infile = new File(coursefilepath);
            if (infile.isFile() && infile.exists()) {      // judge the file exist or not
                InputStreamReader read = new InputStreamReader(new FileInputStream(infile), "UTF-8");
                //InputStreamReader可以将一个字节输入流包包装成字符输入流
                BufferedReader bufferedReader = new BufferedReader(read);
                //(read);//BufferedReader在读取文本文件时，会先尽量从文件中读入字符数据并置入缓冲区，而之后若使用read()方法，会先从缓冲区中进行读取。
                String lineStr = null;
                while ((lineStr = bufferedReader.readLine()) != null) {
                    Course course=new Course(lineStr);
                    courseDatas.add(course);
                    //System.out.println(lineStr);

                }
                read.close();
            } else {
                System.out.println("Not Find file " + coursefilepath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return courseDatas;
    }

}

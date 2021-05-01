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
                //InputStreamReader���Խ�һ���ֽ�����������װ���ַ�������
                BufferedReader bufferedReader = new BufferedReader(read);
                //(read);//BufferedReader�ڶ�ȡ�ı��ļ�ʱ�����Ⱦ������ļ��ж����ַ����ݲ����뻺��������֮����ʹ��read()���������ȴӻ������н��ж�ȡ��
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

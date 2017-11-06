package com.example.xmltools.util;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Path;
import android.util.Log;
import android.widget.Toast;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.File;
import java.io.FileWriter;


/**
 * Created by Fangzheng on 2017/11/5.
 */

public class XmlUtils {
    Context context;


    public XmlUtils(Context context) {
        this.context = context;
    }

    /**
     * 将String类型写入xml文件
     */
    public void getXmlToString(String path,String xmlStr){
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();  //转换成字符串
            format.setEncoding("UTF-8");
            FileWriter out = new FileWriter(path);
            XMLWriter writer = new XMLWriter(out,format);
            Document document = DocumentHelper.parseText(xmlStr);//xml文本解析成doc
            writer.write(document);
            writer.close();
            Toast.makeText(context,"保存成功",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context,"输入有误请重新输入",Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public Document parse(File file) throws DocumentException {

        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        return document;
    }


}

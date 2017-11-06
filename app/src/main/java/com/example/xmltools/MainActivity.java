package com.example.xmltools;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.xmltools.util.XmlUtils;
import java.io.File;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    public static String name = "lalal.xml";
    public static String path =  "data/data/com.example.xmltools/"+name;
    public static String defaultxmlStr ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<employee>\n" +
            "  <empname>default</empname>\n" +
            "  <age>default</age>\n" +
            "  <title>default</title>\n" +
            "</employee>";
    public static String xmlStr ;
    private XmlUtils xmlUtils;
    private EditText edit_content;
    private boolean isfirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        edit_content = (EditText) findViewById(R.id.edit_content);

    }

    /**
     * 把一串xml文本转换成xml文件
     * @param view
     */
    public void save(View view){
        xmlStr = edit_content.getText().toString();
        xmlUtils = new XmlUtils(getApplicationContext());
        xmlUtils.getXmlToString(path,xmlStr);
    }

    /**
     *把xml文件读出来转换成字符串
     * @param view
     */
    public void read(View view) {
        xmlUtils = new XmlUtils(this);
        if (isfirst){
            edit_content.setText(defaultxmlStr);
            isfirst = false;
        }else{
            try{
                String s = xmlUtils.parse(new File(path)).asXML();  //字符串与XML的转换
                isfirst = false;
                edit_content.setText(s);
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this,"输入有误请重新输入",Toast.LENGTH_SHORT).show();
            }

        }
    }
}

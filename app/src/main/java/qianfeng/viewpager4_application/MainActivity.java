package qianfeng.viewpager4_application;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private List<String> list;
    private List<String> urlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = ((ListView) findViewById(R.id.lv));

        initInfo();

    }

    private void initInfo() {
        list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add("李四" + i);
        }

        View view = LayoutInflater.from(this).inflate(R.layout.header_item, null);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
//        viewPager.setAdapter();
        urlList = new ArrayList<>();

        urlList.add("http://n.sinaimg.cn/tech/transform/20160912/KJG5-fxvukhz1637041.png");
        urlList.add("http://img.firefoxchina.cn/2016/09/8/201609131034470.jpg");
        urlList.add("http://cms-bucket.nosdn.127.net/catchpic/f/fa/faa3de33cfa207cf4be09198562a11e3.jpg");
        urlList.add("http://article.fd.zol-img.com.cn/t_s640x2000/g5/M00/04/07/ChMkJ1fWFCSIZclYAAIM4EBQLGMAAVO0wEyO1IAAgz4003.jpg");
        urlList.add("http://a4.peoplecdn.cn/542fa0bb1ecce403130db74135dc958d.jpg");

        viewPager.setAdapter(new MyPagerAdapter(this,urlList));

        // 还可以设置ViewPager中item的切换动画    Transformer:变换
//        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
//            @Override
//            public void transformPage(View page, float position) {
//
//            }
//        });




        lv.addHeaderView(view); // 添加头部只能在setAdapter之前

        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));


        
        
    }


}

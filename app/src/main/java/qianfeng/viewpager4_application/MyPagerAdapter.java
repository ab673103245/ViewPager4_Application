package qianfeng.viewpager4_application;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class MyPagerAdapter extends PagerAdapter{
    private Context context;
    private List<String> list;

    public MyPagerAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {


//        ImageView imageView = new ImageView(context);
//
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        Picasso.with(context).load(list.get(position)).into(imageView);
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"position"+position,Toast.LENGTH_SHORT).show();
//            }
//        });
//        container.addView(imageView);
//
//        return imageView;

        ImageView iv = new ImageView(context);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(context).load(list.get(position)).into(iv);
        container.addView(iv);
        // 在这里，每一个imageView都是新建的，然后不显示的都会被销毁掉，然后重新创建imageView，而不像上午那样一直复用那3个ImageView
//        // 所以可以在这里给每个新建的ImageView添加点击事件
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return iv;
    }
}

package basti.coryphaei.com.learncoding;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends BaseActivity implements NetworkCallback{

    private TextView tv;
    private Toolbar toolbar;
    private Toolbar.OnMenuItemClickListener menuItemClickListener;
    private String url = "https://coding.net/api/project/39583/topic";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initCustomVariable();
        //使用get方法
        //getNetwork(url);

        //使用post方法
        //params.add("key","value");
        //...
        showProgressMessage(true,"正在加载");
        postNetwork(url,params);
    }

    private void initCustomVariable() {
        menuItemClickListener = new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.search:
                        showBottomToast("搜索");
                        break;
                    case R.id.more:
                        showBottomToast("更多");
                }
                return true;
            }
        };
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(menuItemClickListener);
    }

    private void initView() {
        tv = (TextView) findViewById(R.id.textview);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void parseJson(JSONObject response) {
        tv.setText(response.toString());
        //进度条
        showProgressMessage(false);
        //Toast
        showBottomToast("加载成功！");
    }
}


package basti.coryphaei.com.learncoding;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends BaseActivity implements NetworkCallback{

    private TextView tv;
    private Toolbar toolbar;
    private android.support.v7.app.ActionBar mActionBar;
    private View actionbarCustom;
    private Toolbar.OnMenuItemClickListener menuItemClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textview);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        menuItemClickListener = new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.search:
                        Toast.makeText(getApplicationContext(),R.string.search,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.more:
                        Toast.makeText(getApplicationContext(),R.string.more,Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        };
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(menuItemClickListener);

        String url = "https://coding.net/api/project/39583/topic";

        //get请求方式
        //getNetwork(url);

        //post请求方式
        //params.add("key","value");
        //...
        postNetwork(url,params);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void parseJson(JSONObject response) {
        tv.setText(response.toString());
    }
}


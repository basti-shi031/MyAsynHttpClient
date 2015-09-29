package basti.coryphaei.com.learncoding;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

/**
 * Created by Bowen on 2015/9/29.
 */
public class BaseActivity extends ActionBarActivity implements NetworkCallback{

    protected NetworkUtils networkUtils;
    protected RequestParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVariable();
    }

    private void initVariable() {
        networkUtils = new NetworkUtils(this);
        params = new RequestParams();
    }

    //get方法
    protected void getNetwork(String url){
        networkUtils.loadData(url,null,NetworkUtils.RequestMethod.GET);
    }

    //post方法
    protected void postNetwork(String url,RequestParams params){
        networkUtils.loadData(url,params,NetworkUtils.RequestMethod.POST);
    }

    @Override
    public void parseJson(JSONObject respanse) {

    }
}

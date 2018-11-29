package Activity;

import android.app.Activity;
import android.os.Bundle;

import util.ActivityCollector;

/**
 * Created by Administrator on 2018/11/8 0008.
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.addActivity(this);
    }
}

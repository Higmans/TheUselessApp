package biz.lungo.theuselessapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        RelativeLayout rlMain = new RelativeLayout(this);
        RelativeLayout.LayoutParams rlMainParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        addContentView(rlMain, rlMainParams);
        rlMain.setOnClickListener(this);
        uninstall();
    }

    private void uninstall() {
        Intent intent = new Intent(Intent.ACTION_DELETE);
        intent.setData(Uri.parse("package:" + this.getPackageName()));
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        uninstall();
    }

    @Override
    public void onBackPressed() {
        uninstall();
    }
}

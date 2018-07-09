package com.prim.partake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lib.share.PrimPartake;
import com.lib.share.ShareMedia;
import com.lib.share.param.ShareParamSpec;
import com.umeng.socialize.UMShareAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view) {
        ShareParamSpec paramSpec = ShareParamSpec.paramBuilder()
                .addImageParam()
                .addShareTitle("test")
                .addShareImageUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=302701032,2300144492&fm=27&gp=0.jpg")
                .addShareImageUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=302701032,2300144492&fm=27&gp=0.jpg")
                .addShareImageUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=302701032,2300144492&fm=27&gp=0.jpg")
                .addShareImageUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=302701032,2300144492&fm=27&gp=0.jpg")
                .build();
        PrimPartake.defaultPartake().share(this, ShareMedia.SINA, paramSpec, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();
    }
}

package com.mky1428.owncook1;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //카카오 SDK 초기화
        KakaoSdk.init(this, "4a7a8a91dec17ba6c45db90245306300");  //Application이 Context를 상속받아 만들어졌으므로 this, appKey는 내애플리케이션 -> 앱설정 -> 앱키
    }

}

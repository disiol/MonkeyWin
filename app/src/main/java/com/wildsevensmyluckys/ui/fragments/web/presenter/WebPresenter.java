package com.wildsevensmyluckys.ui.fragments.web.presenter;




import com.wildsevensmyluckys.ui.base.BasePresenter;
import com.wildsevensmyluckys.ui.fragments.web.view.WebView;

import javax.inject.Inject;

public class WebPresenter extends BasePresenter<WebView> {

    @Inject
    WebPresenter(){
    }

    public void showSite() {
        getView().showSite();
    }
}

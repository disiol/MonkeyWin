package com.monkeywintolucky.ui.fragments.web.presenter;




import com.monkeywintolucky.ui.base.BasePresenter;
import com.monkeywintolucky.ui.fragments.web.view.WebView;

import javax.inject.Inject;

public class WebPresenter extends BasePresenter<WebView> {

    @Inject
    WebPresenter(){
    }

    public void showSite() {
        getView().showSite();
    }
}

package com.bwei.versionupdata.presenter;

import com.bwei.versionupdata.bean.UpdataBean;
import com.bwei.versionupdata.model.UpdataModel;
import com.bwei.versionupdata.utils.OnNetListener;
import com.bwei.versionupdata.view.UpdataView;

/**
 * Created by pc on 2017/11/29.
 */

public class UpdataPres {
    UpdataView updataView;
    private final UpdataModel updataModel;

    public UpdataPres(UpdataView updataView) {
        this.updataView = updataView;
        updataModel = new UpdataModel();
    }
    public void updataMandV(int type){
        updataModel.getUpdata(type, new OnNetListener() {
            @Override
            public void onSuccess(UpdataBean updataBean) {
                updataView.updataShow(updataBean);
            }
        });
    }
}

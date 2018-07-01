package com.example.administrator.test.campaign.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.test.AppConfig;
import com.example.administrator.test.campaign.adapter.CampaignFragmentAdapter;
import com.example.administrator.test.campaign.entity.CampaignEntity;
import com.example.administrator.test.campaign.entity.CampaignResult;
import com.example.administrator.test.R;
import com.example.administrator.test.common.base.BaseFragment;
import com.example.administrator.test.common.dto.BaseDTO;
import com.example.administrator.test.common.http.CallBack;
import com.example.administrator.test.common.http.CommonApiClient;
import com.example.administrator.test.common.utils.LogUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/12/23.
 */
public class CampaignFragment extends BaseFragment {
    private RecyclerView recyclerview_campaign;
    private CampaignFragmentAdapter adapter;

    List<CampaignEntity> campData;

    @Override
    protected void retry() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_campaign;
    }

    @Override
    public void initView(View view) {
        recyclerview_campaign = (RecyclerView) rootView.findViewById(R.id.recyclerview_campaign);

    }

    @Override
    public void initData() {
        //获取服务器数据
        getDataFromService();

    }

    /**
     * 从服务器获取数据
     */
    private void getDataFromService() {

        CommonApiClient.campaign(getActivity(), new BaseDTO(), new CallBack<CampaignResult>() {
            @Override
            public void onSuccess(CampaignResult result) {
                if (AppConfig.SUCCESS.equals(result.getCode())) {
                    LogUtils.e("获取活动页面成功");
                    if (result.getData() == null) {
                        mErrorLayout.setErrorMessage("暂无活动记录", mErrorLayout.FLAG_NODATA);
                        mErrorLayout.setErrorImag(R.drawable.siaieless1, mErrorLayout.FLAG_NODATA);
                    } else {
                        campData = result.getData();
                        setAdapter();
                    }

                }
            }
        });


    }

    private void setAdapter() {
        recyclerview_campaign.setLayoutManager(new LinearLayoutManager(getContext()));
        //设置adapter
        adapter = new CampaignFragmentAdapter(getActivity(), campData);
        recyclerview_campaign.setAdapter(adapter);
    }

}

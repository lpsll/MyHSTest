package com.example.administrator.test.campaign.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.test.campaign.entity.CampaignEntity;
import com.example.administrator.test.campaign.fragment.CampaignUiGoto;
import com.example.administrator.test.MainActivity;
import com.example.administrator.test.R;
import com.example.administrator.test.common.AppContext;

import java.util.List;

/**
 * Created by lenovo on 2016/12/25.
 */
public class CampaignFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int RECYCLERVIEW_HEAD = 0;
    private static final int RECYCLERVIEW_BODY = 1;
    private Context context;
    private List<CampaignEntity> list;

    public CampaignFragmentAdapter(Context context, List<CampaignEntity> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == RECYCLERVIEW_HEAD) {
            HeadViewHolder Headholder = new HeadViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.camp_fragment_img_item, parent,
                    false));
            return Headholder;
        }
        if (viewType == RECYCLERVIEW_BODY) {

            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    context).inflate(R.layout.camp_fragment_item, parent,
                    false));
            return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {

            CampaignEntity entity = list.get(position - 1);
            final String chongzhi = entity.getRechargeAmount();
            String youhui = entity.getCouponAmount();

            final MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.tv_campaign_fragment_item_zengsong.setText("赠送价值" + youhui + "元的优惠券");
            myViewHolder.tv_campaign_fragment_item_chongzhi.setText("充值" + chongzhi + "元");

            int[] images = {R.drawable.tupian1_03, R.drawable.green_03, R.drawable.huangse_03, R.drawable.juhuang_03, R.drawable.hongse_03};
            //            int ramdom =  new Random().nextInt(5);
            myViewHolder.img_campaign_fragment_item_rmb.setBackgroundResource(images[(position - 1) % 5]);


            myViewHolder.img_lijichongzhi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return RECYCLERVIEW_HEAD;
        }
        return RECYCLERVIEW_BODY;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_campaign_fragment_item_chongzhi; //充值
        TextView tv_campaign_fragment_item_zengsong; //赠送
        ImageView img_campaign_fragment_item_rmb; //左侧人民币
        TextView img_lijichongzhi; //立即充值

        public MyViewHolder(View view) {
            super(view);
            tv_campaign_fragment_item_chongzhi = (TextView) view.findViewById(R.id.tv_campaign_fragment_item_chongzhi);
            tv_campaign_fragment_item_zengsong = (TextView) view.findViewById(R.id.tv_campaign_fragment_item_zengsong);
            img_campaign_fragment_item_rmb = (ImageView) view.findViewById(R.id.img_campaign_fragment_item_rmb);
            img_lijichongzhi = (TextView) view.findViewById(R.id.img_lijichongzhi);

        }


    }

    class HeadViewHolder extends RecyclerView.ViewHolder {

        public HeadViewHolder(View itemView) {
            super(itemView);
        }
    }

}

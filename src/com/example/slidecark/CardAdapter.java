package com.example.slidecark;
/*
 * ��cardmode�Ļ����϶���һ��card��������������viewholder��card���ϴ洢����
 * ����glide�ķ�ʽչʾ����
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.slidecark.R;
import com.bumptech.glide.Glide;
import java.util.List;


public class CardAdapter extends BaseAdapter {
    //����һ������
    private Context mContext;
    //cardmode���͵�����
    private List<CardMode> mCardList;

    public CardAdapter(Context mContext, List<CardMode> mCardList) {
        this.mContext = mContext;
        this.mCardList = mCardList;
    }
    //�ඨ���һЩ�����ӿ�
    @Override
    public int getCount() {
        return mCardList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            //ʵ����LayoutInflater
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
            //��holder��ֵ
            holder = new ViewHolder();
            holder.mCardImageView = (RotateTextImageView) convertView.findViewById(R.id.helloText);
            holder.mCardName = (TextView) convertView.findViewById(R.id.card_name);
            holder.mCardCollege = (TextView) convertView.findViewById(R.id.card_college);
            holder.mCardGender = (TextView) convertView.findViewById(R.id.card_gender);
            holder.mCardYear = (TextView) convertView.findViewById(R.id.card_year);
            holder.mCardAddress = (TextView) convertView.findViewById(R.id.card_address);
            holder.mCardWantLanuage = (TextView) convertView.findViewById(R.id.card_want_lanuage);
            holder.mCardMotherLanuage = (TextView) convertView.findViewById(R.id.card_mother_lanuage);
            //���ñ�ǩ
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //��һ��Glide�ķ���
        Glide.with(mContext)
                .load(mCardList.get(position).getImages())
                .into(holder.mCardImageView);
        holder.mCardName.setText(mCardList.get(position).getName());
        holder.mCardCollege.setText(mCardList.get(position).getcollege());
        holder.mCardYear.setText(String.valueOf(mCardList.get(position).getYear()));
        holder.mCardGender.setText(mCardList.get(position).getgender());
        holder.mCardWantLanuage.setText(mCardList.get(position).getwantLanuage());
        holder.mCardMotherLanuage.setText(mCardList.get(position).getmotherLanuage());
        holder.mCardAddress.setText(mCardList.get(position).getaddress());
        return convertView;
    }
//����viewHolder
    class ViewHolder {
        TextView mCardName;
        TextView mCardYear;
        TextView mCardCollege;
        TextView mCardGender;
        TextView mCardWantLanuage;
        TextView mCardMotherLanuage;
        TextView mCardAddress;
        RotateTextImageView mCardImageView;
    }
}

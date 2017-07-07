package com.zwl9517.zutillibrary.sample.adpater;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zwl9517.zutillibrary.sample.R;

import java.util.List;

/**
 * <pre>
 *      author : zouweilin
 *      e-mail : zwl9517@hotmail.com
 *      time   : 2017/07/06
 *      version:
 *      desc   :
 * </pre>
 */
public class ItemAdapter extends BaseAdapter {

    private Context context;
    private List<ItemData> datas;
    private LayoutInflater inflater;
    private int layoutId;

    public ItemAdapter(Context context, List<ItemData> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
        layoutId = R.layout.item_main;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ItemData itemData = datas.get(position);

        TextView title = holder.title;
        title.setText(itemData.getTitle());
        setTextDrawable(title, itemData.getIcon());
        return convertView;
    }

    private void setTextDrawable(TextView title, int icon) {
        if (icon == 0) return;
        Drawable drawable = ContextCompat.getDrawable(context, icon);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        title.setCompoundDrawables(drawable, null, null, null);
    }

    private class ViewHolder {
        private TextView title;
    }
}

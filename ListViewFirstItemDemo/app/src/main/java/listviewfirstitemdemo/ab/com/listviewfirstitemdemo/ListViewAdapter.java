package listviewfirstitemdemo.ab.com.listviewfirstitemdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 项目名称：ListViewFirstItemDemo
 * 类描述：
 * 创建人：Administrator
 * 创建时间： 2017/11/16 14:24
 * 修改人：Administrator
 * 修改时间：2017/11/16 14:24
 * 修改备注：
 */

public class ListViewAdapter extends BaseAdapter {

    private LayoutInflater inflater = null;
    private ArrayList<HashMap<String,Object>> items;
    public ListViewAdapter(Context context, ArrayList<HashMap<String, Object>> items) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        HashMap<String,Object> map  = items.get(i);
        return map.get(Constants.DATA);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        GroupViewHolder groupViewHolder;
        ItemViewHolder itemViewHolder ;
        View groupView = view;
        View itemView = view;

        int type = getItemViewType(i);
        switch (type){
            case Constants.GROUP:
                if (null == groupView){
                    groupView = inflater.inflate(R.layout.listitemgroup,null);
                    groupViewHolder = new GroupViewHolder();
                    groupViewHolder.groupTV = groupView.findViewById(R.id.group_tv);

                    groupView.setTag(groupViewHolder);
                }else{
                    groupViewHolder = (GroupViewHolder) groupView.getTag();
                }
                view = groupView;

                groupViewHolder.groupTV.setText(getItem(i).toString());
                break;
            case Constants.ITEM:
                if (null == itemView){
                    itemView = inflater.inflate(R.layout.listitem,null);
                    itemViewHolder = new ItemViewHolder();
                    itemViewHolder.itemTV = itemView.findViewById(R.id.item_tv);

                    itemView.setTag(itemViewHolder);
                }else{
                    itemViewHolder = (ItemViewHolder) itemView.getTag();
                }
                view = itemView;

                itemViewHolder.itemTV.setText(getItem(i).toString());
                break;
        }

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        HashMap<String,Object> map = items.get(position);
        return (int) map.get(Constants.TYPE);
    }

    @Override
    public int getViewTypeCount() {
        return Constants.VIEW_TYPE_COUNT;
    }

    class GroupViewHolder{
        private TextView groupTV;
    }

    class ItemViewHolder{
        private TextView itemTV;
    }
}

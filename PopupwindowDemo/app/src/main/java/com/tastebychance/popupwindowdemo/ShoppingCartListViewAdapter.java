package com.tastebychance.popupwindowdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**购物车列表展示
 * @author shenbh
 *
 * 2017年8月11日
 */
public class ShoppingCartListViewAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private List<Map<String,Object>> list;
	private Context context;
	
	public ShoppingCartListViewAdapter(Context context, List<Map<String,Object>> list) {
		this.context =  context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list == null ? null : list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.ordercart_popupwindow_tem, null);
			viewHolder = new ViewHolder();
			
			viewHolder.order_shoppingcart_dishname = (TextView) convertView.findViewById(R.id.order_shoppingcart_dishname);
			viewHolder.order_shoppingcart_dishesprice = (TextView) convertView.findViewById(R.id.order_shoppingcart_dishesprice);
			viewHolder.order_shoppingcart_dishesless = (ImageButton) convertView.findViewById(R.id.order_shoppingcart_dishesless);
			viewHolder. order_shoppingcart_dishesnum = (TextView) convertView.findViewById(R.id.order_shoppingcart_dishesnum);
			viewHolder.order_shoppingcart_dishesmore = (ImageButton) convertView.findViewById(R.id.order_shoppingcart_dishesmore);
	 
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		Map<String,Object> map = list.get(position);

		viewHolder.order_shoppingcart_dishname .setText(map.get("dishname").toString());
		viewHolder.order_shoppingcart_dishesprice .setText(map.get("price").toString());
		viewHolder. order_shoppingcart_dishesnum .setText(map.get("num").toString());
 
		viewHolder.order_shoppingcart_dishesless .setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {

			}
		});
		viewHolder.order_shoppingcart_dishesmore .setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				
			}
		});
		
		return convertView;
	}

	class ViewHolder{
	    private TextView order_shoppingcart_dishname;
	    private TextView order_shoppingcart_dishesprice;
	    private ImageButton order_shoppingcart_dishesless;
	    private TextView order_shoppingcart_dishesnum;
	    private ImageButton order_shoppingcart_dishesmore;
	}
}

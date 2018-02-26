package com.example.testsurfaceview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * 2015-1-24
 * С�ְ�
 * */
public class NodeProgressBar extends View implements Runnable {
    /**��ȡ�ս�����ͼƬ*/
	private BitmapDrawable db_empty;
	/**View���*/
	private int viewWidth;
	/**View�߶�*/
	private int viewHeight;
	/**
	 * ��ɫ����ԲͼƬ����
	 * */
	private List<BitmapDrawable> list_whitecircle = new ArrayList<BitmapDrawable>();
	/**
	 * ��ɫʵ��ԲͼƬ����
	 * */
	private List<BitmapDrawable> list_bluecircle = new ArrayList<BitmapDrawable>();
	/**��ɫ������*/
	private BitmapDrawable db_blue;

	/**���ȱ�ֵ       ������ɫ������*/
	private double ratio = 0;
	/**�ڵ�����*/
    private String[] textArr=new String[]{"�ȴ�����","������","�ȴ�����","�ɹ�"};
    /**�ڵ���*/
	private int count=textArr.length;;
    /**��ǰ�ڵ����*/
	private int index = 0;
	/**X��Գ� ƫ��ֵ*/
	private int offX=50;
	/**Y�� ƫ��ֵ*/
	private int offY=100;
	/**������ڵ� ƫ��ֵ*/
	private int offTextY=85;
	/**��ɫ����Բƫ��ֵ*/
	private int offWhiteCirle_y=-3;
	/**��ɫ���Ľ�����ƫ��ֵ*/
	private int offWhiteRect_y=-2;
	/**��ɫ���Ľ�����ƫ��ֵ*/
	private BitmapDrawable db_blue_half_circle;
	/**����һֻ�»���*/
	private Paint paint = new Paint();
    /**��ɫ����Բ�뾶*/
	private int r_white = 76;
    /**��ɫ����Բ�뾶*/
	private int r_blue = 56;
	/**��ɫ�������߶�*/
	private int whiteProgressHeight = 30;
	/**��ɫ�������߶�*/
	private int blueProgressHeight = 16;
	
	/**�ı���ɫj*/
	private String textColor="#46A3FF";
	/**�ı�δ������ɫ*/
	private String textColorNotEnabled="#7E7E81";
	/**View ������ɫ*/
	private String bgColor="#FAFAFB";
	/**�ı����С*/
	private int textSize=32; 
	
	/**��ɫ���Ľ��������*/
	private int maxProgressWidth;
	/**��Բ��ɫ���������*/
	private int half_blueWidth = 12;

	@SuppressWarnings("deprecation")
	public NodeProgressBar(Context context) {
		super(context);
		init();
	}

	public NodeProgressBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
    /**������ɫ������*/
	public void setProgressOnly(int i) {
		ratio = i / 100d;
        invalidate();
	}
	
	/**�Խڵ�������ֵ������ ���ٴ���1*/
	public void setProgressByNode(final double d)
	{
		int progress;
		if(d==1)
		{
			progress=1;
		}else
		{
			progress= (int) ( (100d/((count-1)*1.0d))*(d-1));
		}
		setProgressAndIndex(progress);
		
	}
	/**������ɫ���������ҶԽڵ�Ⱦɫ*/
	public void setProgressAndIndex(int i){
		if(i==0){
		index=0;
		ratio=0;
		invalidate();
		return ;
		}
		//�����Խ���������
		int adbProgress = maxProgressWidth-(count-1)*r_white;
		//�õ�ÿһ���ڵ��������ֵ
		int k=100/(count-1);
		//���㵱ǰ������ҪȾɫ�Ľڵ����
		index=1+i/k;
		if(index!=count)
		{
	      //��ýڵ��������
		  double wh=1.0d*(r_white/2)/(double)maxProgressWidth;
		  //������ɫ��������Ⱦɫ�ڵ���
		  ratio=i%100==0?ratio=1:wh+wh*2*(index-1)+1.0d*((double)adbProgress/(double)maxProgressWidth)*(i/100d);
		}else
		{
			//���ý�����Ϊ��
		    ratio=1;
		}
		invalidate();
	}
	
	/**
	 * ��ʼ��ͼƬ��Դ���ͻ�����ֵ
	 * */
	@SuppressWarnings("deprecation")
	private void init() {
		//���ݽڵ���� ��ʼ������Բ��ʵ��Բ
		for (int i = 0; i < count; i++) {
			BitmapDrawable drawable1 = new BitmapDrawable(
					BitmapFactory.decodeResource(getResources(),
							R.drawable.progress_white_circle));
			list_whitecircle.add(drawable1);
			BitmapDrawable drawable2 = new BitmapDrawable(
					BitmapFactory.decodeResource(getResources(),
							R.drawable.progress_blue_circle));
			list_bluecircle.add(drawable2);
		}
        //��ʼ����ɫС��Բ
		db_blue_half_circle = new BitmapDrawable(BitmapFactory.decodeResource(
				getResources(), R.drawable.progress_blue_half_circle));
		//��ʼ�����Ľ�����
		db_empty = new BitmapDrawable(BitmapFactory.decodeResource(
				getResources(), R.drawable.progress_whtie_groove));
		//��ʼ��
		db_blue = new BitmapDrawable(BitmapFactory.decodeResource(
				getResources(), R.drawable.progress_blue_groove));
		//UI�̳߳�ʼ����ֵ
		this.post(this);
	}
	@Override
	public void run() {
		//��ȡView���
		viewWidth = NodeProgressBar.this.getWidth();
	    //��ȡView�߶�
		viewHeight = NodeProgressBar.this.getHeight();
		// ��������ȼ���
		maxProgressWidth = viewWidth - r_white-offX*2;
		//����
		invalidate();	
	}


	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.draw(canvas);
		//���X��ƫתֵ
		int offAbs_x=(int)((viewWidth-maxProgressWidth)/2.0d);
		//���X��ƫתֵ
		canvas.drawColor(Color.parseColor(bgColor));
		//���ƿ��Ľ�����
		drawRect(canvas, db_empty, viewWidth / 2, r_white / 2+offY+offWhiteRect_y, maxProgressWidth,whiteProgressHeight);
	    
		paint.setTextSize(textSize);
		paint.setFakeBoldText(true);
		
		//���ư�ɫ����԰
		for (int i = 0, j = list_whitecircle.size(); i < j; i++) {
			BitmapDrawable db_whitecircle = list_whitecircle.get(i);
			int x=maxProgressWidth / (count - 1)* i+offAbs_x;
			int y=r_white/2 + offWhiteCirle_y+offY;
			drawCircle(canvas, db_whitecircle,x, y, r_white);
			
			String str=textArr[i];
			if(i<index)
			{
				paint.setColor(Color.parseColor(textColor));
			}else
			{
				paint.setColor(Color.parseColor(textColorNotEnabled));
			}
			float textWidht = paint.measureText(str);
			canvas.drawText(str, x-textWidht/2, y+offTextY, paint);
		}

		//������ɫ������
		drawRect(canvas, db_blue, (int) 
				((maxProgressWidth * ratio) / 2)+offAbs_x , 
				r_white / 2+offY, 
				(int) (maxProgressWidth * ratio),blueProgressHeight);

		//������ɫС��Բ
		if (ratio > 0) {

			drawRect(canvas, db_blue_half_circle,(int) ((maxProgressWidth * ratio) / 2)
							+ (int) (maxProgressWidth * ratio) / 2 + half_blueWidth
							/ 2+offAbs_x, r_white / 2+offY, half_blueWidth,
					blueProgressHeight);
		}
		//������ɫԲ
		for (int i = 0, j = index; i < j; i++) {
			BitmapDrawable db_bluecircle = list_bluecircle.get(i);
			drawCircle(canvas, db_bluecircle,
					maxProgressWidth / (count - 1) * i+offAbs_x, r_white/2+offY, r_blue);
		}

	}

	/**��ͳ�������귽��*/
	public void drawRect(Canvas canvas, Drawable d, int x, int y, int width,
			int height) {
		d.setBounds(x - width / 2, y - height / 2, x + width / 2, y + height
				/ 2);
		d.draw(canvas);
	}
	/**��ͳԲ��������㷽��*/
	public void drawCircle(Canvas canvas, Drawable d, int x, int y, int r) {
		d.setBounds(x - r / 2, y - r / 2, x + r / 2, y + r / 2);
		d.draw(canvas);
	}
	/**�������� ��ͳ������㷽��*/
	public void drawText(Canvas canvas,Paint paint, String str, int x, int y, int w,int h) {
	     canvas.drawText(str, x-w/2, y-h/2, x+w, y+h, paint);
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}



}

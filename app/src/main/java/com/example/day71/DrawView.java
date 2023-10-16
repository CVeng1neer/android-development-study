package com.example.day71;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {
    public float currentX = 40;
    public float currentY = 50;
    public float radius = 15;
    //定义、创建画笔
    Paint p = new Paint();
    public DrawView(Context context, AttributeSet set){
        super(context,set);
    }
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //设置画笔的颜色
        p.setColor(Color.RED);
        //绘制一个小圆
        canvas.drawCircle(currentX,currentY,radius,p);
    }
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_BUTTON_PRESS:
                radius = 30;//手指按下时，半径增大为30
                break;
                case MotionEvent.ACTION_BUTTON_RELEASE:
                    radius = 15;//手指抬起时，半径恢复为初始值
                    break;
        }
        this.currentX = event.getX();
        this.currentY = event.getY();
        //通知改组件重绘
        this.invalidate();
        //返回true表明处理方法完全处理该事件
        return true;
    }
}
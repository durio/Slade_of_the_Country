package com.example.slade_of_the_contury;

import cn.edu.tsinghua.academic.c00740273.magictower.engine.Engine;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

public class LoadInterfaceDrawer {
	private Paint paint = new Paint();
	PictureCollector pictures;
	private Engine[] engines;
	private Context context;
    
	public enum Position {
		ONE,TWO,AUTO
	}

	public boolean getAvailable(Position p) {
		return getEngine(p) != null;
	}

	
	
	public Engine getEngine(Position p) {
		switch(p) {
		case ONE:
			return engines[0];
		case TWO:
			return engines[1];
		case AUTO:
			return engines[2];
		default:
			return null;
		}
	}
		

	public LoadInterfaceDrawer(PictureCollector pictures, Context context){
		this.pictures = pictures;
		this.context = context;
		engines = new Engine[3];
	}
	
	public void LoadSaving() {
		DataManager dm = new DataManager(context);
		for (int i = 0;i < 3;i++) {
			engines[i] = dm.LoadSavings("save" + i + ".txt");
		}
	}
	
	public void SaveSaving(Engine engine, Position p,Canvas canvas) {
		switch(p) {
		case ONE:
			if (engines[0] != null) {
				
			}
			else {
				
			}
			break;
		case TWO:
			break;
		case AUTO:
			break;
		}
	}
	
	public void draw(Canvas canvas, Matrix canvasMatrix) {
		canvas.setMatrix(canvasMatrix);
		paint.setColor(Color.WHITE);
		canvas.drawColor(Color.BLACK);
		canvas.drawRect(Constants.MARGIN, Constants.MARGIN,
				(Constants.MYSCREENWIDTH - Constants.MARGIN),
				(Constants.MARGIN + Constants.SAVEOPTIONHEIGHT), paint);
		canvas.drawRect(Constants.MARGIN,
				(Constants.MARGIN * 2 + Constants.SAVEOPTIONHEIGHT),
				(Constants.MYSCREENWIDTH - Constants.MARGIN),
				(Constants.MARGIN + Constants.SAVEOPTIONHEIGHT) * 2, paint);
		canvas.drawRect(Constants.MARGIN,
				(Constants.MARGIN * 3 + Constants.SAVEOPTIONHEIGHT * 2),
				(Constants.MYSCREENWIDTH - Constants.MARGIN),
				(Constants.MARGIN + Constants.SAVEOPTIONHEIGHT) * 3, paint);
		paint.setColor(Color.BLACK);
		canvas.drawBitmap(pictures.scaledrrreturn,
				Constants.INSTRUCTION_LOGO_X1, Constants.INSTRUCTION_LOGO_Y,
				paint);
		paint.setColor(Color.BLACK);
		paint.setTextSize(Constants.SMALLFONTSIZE);
		canvas.drawText(Texts.TEXT_SAVE0, Constants.MARGIN * 2,  Constants.MARGIN * 2 + Constants.SMALLFONTSIZE, paint);
		canvas.drawText(Texts.TEXT_SAVE1, Constants.MARGIN * 2, Constants.MARGIN * 3 + Constants.SAVEOPTIONHEIGHT + Constants.SMALLFONTSIZE, paint);
		canvas.drawText(Texts.TEXT_SAVEAUTO, Constants.MARGIN * 2, Constants.MARGIN * 4 + Constants.SAVEOPTIONHEIGHT * 2 + Constants.SMALLFONTSIZE, paint);
		
		for (int i = 0;i < 3;i++) {
			if(engines[i] != null) {
				
			}
			else if (engines[i] == null) {
				canvas.drawText(Texts.TEXT_FILENOTFOUND, Constants.MARGIN * 2, (Constants.MARGIN * i + Constants.SAVEOPTIONHEIGHT * (i - 1) + Constants.SAVEOPTIONHEIGHT / 2 + Constants.SMALLFONTSIZE), paint);
			}
		}
	}
}

package com.game.animal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Region;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class Demo {
    public static void ex(String paramString) throws Exception {

    }

    public float[] xxx(Canvas paramCanvas, Bitmap paramBitmap,B b){
        Paint paint = new Paint(1);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        Matrix matrix = new Matrix();
        RectF rectF = new RectF();
        Path path = new Path();
        float f1 = paramBitmap.getWidth() / 2.0F;
        float f2 = paramBitmap.getHeight() / 2.0F;
        b.pp.computeBounds(rectF, false);
        float f3 = Math.min(paramBitmap.getWidth() / rectF.width(), paramBitmap.getHeight() / rectF.height()) * 0.5F;
        matrix.setTranslate(-rectF.centerX() + f1, -rectF.centerY() + f2);
        matrix.postScale(f3, f3, f1, f2);
        b.pp.transform(matrix, path);
        paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        paramCanvas.drawPath(path, paint);
        float[] arrayOfFloat1 = zzzz(path, paramBitmap, -65536);
        if (arrayOfFloat1 == null)
            return null;
        float f4 = 1.0F / f3;
        matrix.setScale(f4, f4, f1, f2);
        matrix.postTranslate(rectF.centerX() - f1, rectF.centerY() - f2);
        float[] arrayOfFloat2 = new float[2];
        matrix.mapPoints(arrayOfFloat2, new float[] { arrayOfFloat1[0], arrayOfFloat1[1] });
        arrayOfFloat1[2] = arrayOfFloat1[2] / f3;
        return aaaa(b.pp, arrayOfFloat2[0], arrayOfFloat2[1]) ? null :
                ((arrayOfFloat1[2] < 2.0F) ? null : new float[] { arrayOfFloat2[0], arrayOfFloat2[1], arrayOfFloat1[2] });
    }

    public static boolean aaaa(Path paramPath, float paramFloat1, float paramFloat2) {
        RectF rectF = new RectF();
        paramPath.computeBounds(rectF, true);
        Region region = new Region();
        region.setPath(paramPath, new Region((int)rectF.left, (int)rectF.top, (int)rectF.right, (int)rectF.bottom));
        return region.contains((int)paramFloat1, (int)paramFloat2);
    }

        private static float[] zzzz(Path paramPath, Bitmap paramBitmap, int paramInt) {
            RectF rectF2 = new RectF();
            paramPath.computeBounds(rectF2, false);
            int j = (int)rectF2.left;
            int i = j;
            if (j < 0)
                i = 0;
            int k = (int)rectF2.top;
            j = k;
            if (k < 0)
                j = 0;
            k = (int)rectF2.right;
            int m = k;
            if (k > paramBitmap.getWidth())
                m = paramBitmap.getWidth();
            int n = (int)rectF2.bottom;
            k = n;
            if (n > paramBitmap.getHeight())
                k = paramBitmap.getHeight();
            RectF rectF1 = new RectF();
            rectF2 = new RectF();
            float f1 = 0.0F;
            float f2 = 0.0F;
            n = m;
            int i1 = i;
            m = k;
            while (i1 < n) {
                int i2 = j;
                i = n;
                k = j;
                j = m;
                while (i2 < j) {
                    int i3 = j;
                    m = k;
                    n = i;
                    float f3 = f1;
                    float f4 = f2;
                    if (vvvv(paramBitmap, i1, i2, paramInt)) {
                        float f = rectF1.width() + 1.0F;
                        while (true) {
                            float f5 = i1;
                            float f7 = f / 2.0F;
                            float f6 = f5 - f7;
                            i3 = j;
                            m = k;
                            n = i;
                            f3 = f1;
                            f4 = f2;
                            if (f6 >= 0.0F) {
                                float f8 = i2;
                                float f9 = f8 - f7;
                                m = k;
                                n = i;
                                f3 = f1;
                                f4 = f2;
                                i3 = j;
                                if (f9 >= 0.0F) {
                                    float f10 = f5 + f7;
                                    n = i;
                                    f3 = f1;
                                    f4 = f2;
                                    i3 = j;
                                    m = k;
                                    if (f10 <= paramBitmap.getWidth()) {
                                        f3 = f8 + f7;
                                        if (f3 >= paramBitmap.getHeight()) {
                                            f3 = f1;
                                            f4 = f2;
                                            n = i;
                                            i3 = j;
                                            m = k;
                                            break;
                                        }
                                        rectF2.set(f6, f9, f10, f3);
                                        m = (int)rectF2.left;
                                        boolean bool1 = true;
                                        while (m < (int)rectF2.right) {
                                            boolean bool = vvvv(paramBitmap, m, (int)rectF2.top, paramInt);
                                            bool1 = bool;
                                            if (bool)
                                                bool1 = vvvv(paramBitmap, m, (int)rectF2.bottom, paramInt);
                                            if (!bool1)
                                                break;
                                            m++;
                                        }
                                        boolean bool2 = bool1;
                                        if (bool1) {
                                            m = (int)rectF2.top;
                                            while (true) {
                                                bool2 = bool1;
                                                if (m < (int)rectF2.bottom) {
                                                    bool2 = vvvv(paramBitmap, (int)rectF2.left, m, paramInt);
                                                    bool1 = bool2;
                                                    if (bool2)
                                                        bool1 = vvvv(paramBitmap, (int)rectF2.right, m, paramInt);
                                                    if (!bool1) {
                                                        bool2 = bool1;
                                                        break;
                                                    }
                                                    m++;
                                                    continue;
                                                }
                                                break;
                                            }
                                        }
                                        f3 = f1;
                                        f4 = f2;
                                        n = i;
                                        i3 = j;
                                        m = k;
                                        if (bool2) {
                                            f3 = f1;
                                            f4 = f2;
                                            n = i;
                                            i3 = j;
                                            m = k;
                                            if (bbbb(paramBitmap, paramInt, rectF2)) {
                                                rectF1.set(rectF2);
                                                f++;
                                                f1 = f5;
                                                f2 = f8;
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                    i2++;
                    i = n;
                    j = i3;
                    k = m;
                    f1 = f3;
                    f2 = f4;
                }
                i1++;
                m = j;
                j = k;
                n = i;
            }
            return (f1 == 0.0F || f2 == 0.0F || rectF1.width() == 0.0F) ? null : new float[] { f1, f2, rectF1.width() };
        }

    private static boolean vvvv(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3) {
        return (paramBitmap.getPixel(paramInt1, paramInt2) == paramInt3);
    }

    private static boolean bbbb(Bitmap paramBitmap, int paramInt, RectF paramRectF) {
        for (float f = paramRectF.left; f < paramRectF.right; f++) {
            float f1;
            for (f1 = paramRectF.top; f1 < paramRectF.bottom; f1++) {
                if (!vvvv(paramBitmap, (int)f, (int)f1, paramInt))
                return false;
            }
        }
        return true;
    }


}

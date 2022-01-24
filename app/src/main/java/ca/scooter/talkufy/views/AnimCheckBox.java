package ca.scooter.talkufy.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Paint.Style;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Checkable;
import com.github.lguipeng.library.R.styleable;

public class AnimCheckBox extends View implements Checkable {
    private final double mSin27;
    private final double mSin63;
    private final int mDuration;
    private final int defaultSize;
    private final Paint mPaint;
    private int radius;
    private final RectF mRectF;
    private final RectF mInnerRectF;
    private final Path mPath;
    private float mSweepAngle;
    private float mHookStartY;
    private float mBaseLeftHookOffset;
    private float mBaseRightHookOffset;
    private float mEndLeftHookOffset;
    private float mEndRightHookOffset;
    private int size;
    private boolean mChecked;
    private float mHookOffset;
    private float mHookSize;
    private int mInnerCircleAlpha;
    private int mStrokeWidth;
    private int mStrokeColor;
    private int mCircleColor;
    private AnimCheckBox.OnCheckedChangeListener mOnCheckedChangeListener;

    public AnimCheckBox(Context context) {
        this(context, null);
    }

    public AnimCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSin27 = Math.sin(Math.toRadians(27.0D));
        this.mSin63 = Math.sin(Math.toRadians(63.0D));
        this.mDuration = 200;
        this.defaultSize = 40;
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mInnerRectF = new RectF();
        this.mPath = new Path();
        this.mInnerCircleAlpha = 255;
        this.mStrokeWidth = 2;
        this.mStrokeColor = -16776961;
        this.mCircleColor = -1;
        this.init(attrs);
    }

    private void init(AttributeSet attrs) {
        boolean checked = this.mChecked;
        if (attrs != null) {
            TypedArray array = this.getContext().obtainStyledAttributes(attrs, styleable.AnimCheckBox);
            this.mStrokeWidth = (int)array.getDimension(styleable.AnimCheckBox_stroke_width, (float)this.dip(this.mStrokeWidth));
            this.mStrokeColor = array.getColor(styleable.AnimCheckBox_stroke_color, this.mStrokeColor);
            this.mCircleColor = array.getColor(styleable.AnimCheckBox_circle_color, -1);
            checked = array.getBoolean(styleable.AnimCheckBox_checked, false);
            array.recycle();
        } else {
            this.mStrokeWidth = this.dip(this.mStrokeWidth);
        }

        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeWidth((float)this.mStrokeWidth);
        this.mPaint.setColor(this.mStrokeColor);
        super.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                AnimCheckBox.this.setChecked(!AnimCheckBox.this.mChecked);
            }
        });
        this.setCheckedViewInner(checked, false);
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @SuppressLint("WrongConstant")
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (MeasureSpec.getMode(widthMeasureSpec) == -2147483648 && MeasureSpec.getMode(heightMeasureSpec) == -2147483648) {
            MarginLayoutParams params = (MarginLayoutParams)this.getLayoutParams();
            width = height = Math.min(this.dip(40) - params.leftMargin - params.rightMargin, this.dip(40) - params.bottomMargin - params.topMargin);
        }

        int size = Math.min(width - this.getPaddingLeft() - this.getPaddingRight(), height - this.getPaddingBottom() - this.getPaddingTop());
        this.setMeasuredDimension(size, size);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.size = this.getWidth();
        this.radius = (this.getWidth() - 2 * this.mStrokeWidth) / 2;
        this.mRectF.set((float)this.mStrokeWidth, (float)this.mStrokeWidth, (float)(this.size - this.mStrokeWidth), (float)(this.size - this.mStrokeWidth));
        this.mInnerRectF.set(this.mRectF);
        this.mInnerRectF.inset((float)(this.mStrokeWidth / 2), (float)(this.mStrokeWidth / 2));
        this.mHookStartY = (float)((double)(this.size / 2) - ((double)this.radius * this.mSin27 + ((double)this.radius - (double)this.radius * this.mSin63)));
        this.mBaseLeftHookOffset = (float)((double)this.radius * (1.0D - this.mSin63)) + (float)(this.mStrokeWidth / 2);
        this.mBaseRightHookOffset = 0.0F;
        this.mEndLeftHookOffset = this.mBaseLeftHookOffset + ((float)(2 * this.size / 3) - this.mHookStartY) * 0.33F;
        this.mEndRightHookOffset = this.mBaseRightHookOffset + ((float)(this.size / 3) + this.mHookStartY) * 0.38F;
        this.mHookSize = (float)this.size - (this.mEndLeftHookOffset + this.mEndRightHookOffset);
        this.mHookOffset = this.mChecked ? this.mHookSize + this.mEndLeftHookOffset - this.mBaseLeftHookOffset : 0.0F;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.drawCircle(canvas);
        this.drawHook(canvas);
    }

    private void drawCircle(Canvas canvas) {
        this.initDrawStrokeCirclePaint();
        canvas.drawArc(this.mRectF, 202.0F, this.mSweepAngle, false, this.mPaint);
        this.initDrawAlphaStrokeCirclePaint();
        canvas.drawArc(this.mRectF, 202.0F, this.mSweepAngle - 360.0F, false, this.mPaint);
        this.initDrawInnerCirclePaint();
        canvas.drawArc(this.mInnerRectF, 0.0F, 360.0F, false, this.mPaint);
    }

    private void drawHook(Canvas canvas) {
        if (this.mHookOffset != 0.0F) {
            this.initDrawHookPaint();
            this.mPath.reset();
            if (this.mHookOffset <= (float)(2 * this.size / 3) - this.mHookStartY - this.mBaseLeftHookOffset) {
                this.mPath.moveTo(this.mBaseLeftHookOffset, this.mBaseLeftHookOffset + this.mHookStartY);
                this.mPath.lineTo(this.mBaseLeftHookOffset + this.mHookOffset, this.mBaseLeftHookOffset + this.mHookStartY + this.mHookOffset);
            } else if (this.mHookOffset <= this.mHookSize) {
                this.mPath.moveTo(this.mBaseLeftHookOffset, this.mBaseLeftHookOffset + this.mHookStartY);
                this.mPath.lineTo((float)(2 * this.size / 3) - this.mHookStartY, (float)(2 * this.size / 3));
                this.mPath.lineTo(this.mHookOffset + this.mBaseLeftHookOffset, (float)(2 * this.size / 3) - (this.mHookOffset - ((float)(2 * this.size / 3) - this.mHookStartY - this.mBaseLeftHookOffset)));
            } else {
                float offset = this.mHookOffset - this.mHookSize;
                this.mPath.moveTo(this.mBaseLeftHookOffset + offset, this.mBaseLeftHookOffset + this.mHookStartY + offset);
                this.mPath.lineTo((float)(2 * this.size / 3) - this.mHookStartY, (float)(2 * this.size / 3));
                this.mPath.lineTo(this.mHookSize + this.mBaseLeftHookOffset + offset, (float)(2 * this.size / 3) - (this.mHookSize - ((float)(2 * this.size / 3) - this.mHookStartY - this.mBaseLeftHookOffset) + offset));
            }

            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    private void initDrawHookPaint() {
        this.mPaint.setAlpha(255);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeWidth((float)this.mStrokeWidth);
        this.mPaint.setColor(this.mStrokeColor);
    }

    private void initDrawStrokeCirclePaint() {
        this.mPaint.setAlpha(255);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setStrokeWidth((float)this.mStrokeWidth);
        this.mPaint.setColor(this.mStrokeColor);
    }

    private void initDrawAlphaStrokeCirclePaint() {
        this.mPaint.setStrokeWidth((float)this.mStrokeWidth);
        this.mPaint.setStyle(Style.STROKE);
        this.mPaint.setColor(this.mStrokeColor);
        this.mPaint.setAlpha(64);
    }

    private void initDrawInnerCirclePaint() {
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(this.mCircleColor);
        this.mPaint.setAlpha(this.mInnerCircleAlpha);
    }

    private void startCheckedAnim() {
        ValueAnimator animator = new ValueAnimator();
        final float hookMaxValue = this.mHookSize + this.mEndLeftHookOffset - this.mBaseLeftHookOffset;
        final float circleMaxFraction = this.mHookSize / hookMaxValue;
        final float circleMaxValue = 360.0F / circleMaxFraction;
        animator.setFloatValues(0.0F, 1.0F);
        animator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                AnimCheckBox.this.mHookOffset = fraction * hookMaxValue;
                if (fraction <= circleMaxFraction) {
                    AnimCheckBox.this.mSweepAngle = (float)((int)((circleMaxFraction - fraction) * circleMaxValue));
                } else {
                    AnimCheckBox.this.mSweepAngle = 0.0F;
                }

                AnimCheckBox.this.mInnerCircleAlpha = (int)(fraction * 255.0F);
                AnimCheckBox.this.invalidate();
            }
        });
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(mDuration).start();
    }

    private void startUnCheckedAnim() {
        ValueAnimator animator = new ValueAnimator();
        final float hookMaxValue = this.mHookSize + this.mEndLeftHookOffset - this.mBaseLeftHookOffset;
        final float circleMinFraction = (this.mEndLeftHookOffset - this.mBaseLeftHookOffset) / hookMaxValue;
        final float circleMaxValue = 360.0F / (1.0F - circleMinFraction);
        animator.setFloatValues(0.0F, 1.0F);
        animator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                float circleFraction = animation.getAnimatedFraction();
                float fraction = 1.0F - circleFraction;
                AnimCheckBox.this.mHookOffset = fraction * hookMaxValue;
                if (circleFraction >= circleMinFraction) {
                    AnimCheckBox.this.mSweepAngle = (float)((int)((circleFraction - circleMinFraction) * circleMaxValue));
                } else {
                    AnimCheckBox.this.mSweepAngle = 0.0F;
                }

                AnimCheckBox.this.mInnerCircleAlpha = (int)(fraction * 255.0F);
                AnimCheckBox.this.invalidate();
            }
        });
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(mDuration).start();
    }

    private void startAnim() {
        this.clearAnimation();
        if (this.mChecked) {
            this.startCheckedAnim();
        } else {
            this.startUnCheckedAnim();
        }

    }

    private int getAlphaColor(int color, int alpha) {
        alpha = alpha < 0 ? 0 : alpha;
        alpha = alpha > 255 ? 255 : alpha;
        return color & 16777215 | alpha << 24;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean checked) {
        this.setChecked(checked, true);
    }

    public void toggle() {
        this.setChecked(!this.isChecked());
    }

    public void setChecked(boolean checked, boolean animation) {
        if (checked != this.mChecked) {
            this.setCheckedViewInner(checked, animation);
            if (this.mOnCheckedChangeListener != null) {
                this.mOnCheckedChangeListener.onChange(this, this.mChecked);
            }

        }
    }

    /** @deprecated */
    @Deprecated
    public void setOnClickListener(OnClickListener l) {
    }

    private void setCheckedViewInner(boolean checked, boolean animation) {
        this.mChecked = checked;
        if (animation) {
            this.startAnim();
        } else {
            if (this.mChecked) {
                this.mInnerCircleAlpha = 255;
                this.mSweepAngle = 0.0F;
                this.mHookOffset = this.mHookSize + this.mEndLeftHookOffset - this.mBaseLeftHookOffset;
            } else {
                this.mInnerCircleAlpha = 0;
                this.mSweepAngle = 360.0F;
                this.mHookOffset = 0.0F;
            }

            this.invalidate();
        }

    }

    private int dip(int dip) {
        return (int)this.getContext().getResources().getDisplayMetrics().density * dip;
    }

    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }

    public void setOnCheckedChangeListener(AnimCheckBox.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    public interface OnCheckedChangeListener {
        void onChange(AnimCheckBox var1, boolean var2);
    }
}


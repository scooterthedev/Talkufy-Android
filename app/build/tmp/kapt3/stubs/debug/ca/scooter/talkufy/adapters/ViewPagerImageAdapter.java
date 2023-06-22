package ca.scooter.talkufy.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lca/scooter/talkufy/adapters/ViewPagerImageAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "inflater", "Landroid/view/LayoutInflater;", "paths", "Ljava/util/ArrayList;", "", "type", "isForPreview", "", "(Landroid/view/LayoutInflater;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V", "captions", "", "getCaptions", "()Ljava/util/List;", "setCaptions", "(Ljava/util/List;)V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getImageCaptions", "instantiateItem", "isViewFromObject", "p0", "Landroid/view/View;", "p1", "app_debug"})
public final class ViewPagerImageAdapter extends androidx.viewpager.widget.PagerAdapter {
    private final android.view.LayoutInflater inflater = null;
    private final java.util.ArrayList<java.lang.String> paths = null;
    private final java.util.ArrayList<java.lang.String> type = null;
    private boolean isForPreview;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.String> captions;
    
    public ViewPagerImageAdapter(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> paths, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> type, boolean isForPreview) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getCaptions() {
        return null;
    }
    
    public final void setCaptions(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.Object instantiateItem(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup container, int position) {
        return null;
    }
    
    @java.lang.Override
    public boolean isViewFromObject(@org.jetbrains.annotations.NotNull
    android.view.View p0, @org.jetbrains.annotations.NotNull
    java.lang.Object p1) {
        return false;
    }
    
    @java.lang.Override
    public int getCount() {
        return 0;
    }
    
    @java.lang.Override
    public void destroyItem(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup container, int position, @org.jetbrains.annotations.NotNull
    java.lang.Object object) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getImageCaptions() {
        return null;
    }
}
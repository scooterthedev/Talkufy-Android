package ca.scooter.talkufy.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u001dH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lca/scooter/talkufy/utils/LocationHelper;", "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;", "Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;", "context", "Landroid/content/Context;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "(Landroid/content/Context;Lcom/google/android/gms/maps/GoogleMap;)V", "(Landroid/content/Context;)V", "apiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "getContext", "()Landroid/content/Context;", "dialog", "Landroidx/appcompat/app/AlertDialog;", "connect", "", "disconnect", "getAddress", "Landroid/location/Address;", "latitude", "", "longitude", "onConnected", "p0", "Landroid/os/Bundle;", "onConnectionFailed", "Lcom/google/android/gms/common/ConnectionResult;", "onConnectionSuspended", "", "app_debug"})
public final class LocationHelper implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private final com.google.android.gms.common.api.GoogleApiClient apiClient = null;
    private com.google.android.gms.maps.GoogleMap map;
    private androidx.appcompat.app.AlertDialog dialog;
    
    public LocationHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    public LocationHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.google.android.gms.maps.GoogleMap map) {
        super();
    }
    
    public final void connect() {
    }
    
    public final void disconnect() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.location.Address getAddress(double latitude, double longitude) {
        return null;
    }
    
    @java.lang.Override
    public void onConnectionFailed(@org.jetbrains.annotations.NotNull
    com.google.android.gms.common.ConnectionResult p0) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override
    public void onConnected(@org.jetbrains.annotations.Nullable
    android.os.Bundle p0) {
    }
    
    @java.lang.Override
    public void onConnectionSuspended(int p0) {
    }
}
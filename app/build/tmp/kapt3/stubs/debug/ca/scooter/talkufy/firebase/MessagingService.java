package ca.scooter.talkufy.firebase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u00013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001f\u001a\u00020\u0004J \u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0002J \u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)H\u0003J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0004H\u0016J \u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0002J\u0010\u00101\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u00102\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010\u00a8\u00064"}, d2 = {"Lca/scooter/talkufy/firebase/MessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "KEY_GROUP_NAME", "", "KEY_IS_MUTED", "KEY_MESSAGES", "KEY_MSG_IDs", "KEY_RECEIVER", "KEY_SENDER", "KEY_SENDER_PHONE", "KEY_SENDER_PIC_URL", "KEY_UNREAD", "MESSAGE_SEPERATOR", "channelIDMerged", "getChannelIDMerged", "()Ljava/lang/String;", "channelIDSingle", "getChannelIDSingle", "channelNameIndividual", "getChannelNameIndividual", "channelNameMerged", "getChannelNameMerged", "getAllUnreadMessages", "", "notificationCompatBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "getIDs", "", "msgIDsString", "getMessages", "messageString", "getNotificationManager", "Landroid/app/NotificationManager;", "channelName", "channelID", "notify", "title", "intent", "Landroid/content/Intent;", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onMessageReceived", "p0", "onNewToken", "setAllMessageFromUserAsDelivered", "uid", "targetUID", "msgIDs", "showNotification", "updateNotificationWithBigText", "NotificationDetail", "app_debug"})
public final class MessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    private final java.lang.String KEY_UNREAD = "unreadCount";
    private final java.lang.String KEY_SENDER = "senderUID";
    private final java.lang.String KEY_RECEIVER = "receiverUID";
    private final java.lang.String KEY_MSG_IDs = "messageIDs";
    private final java.lang.String KEY_SENDER_PHONE = "senderPhoneNumber";
    private final java.lang.String KEY_SENDER_PIC_URL = "senderPhotoURL";
    private final java.lang.String KEY_MESSAGES = "messages";
    private final java.lang.String KEY_IS_MUTED = "isMuted";
    private final java.lang.String KEY_GROUP_NAME = "groupNameIfAny";
    private final java.lang.String MESSAGE_SEPERATOR = "<--MESSAGE_SEPERATOR-->";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String channelIDSingle = "talkufy-single";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String channelIDMerged = "talkufy-merged";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String channelNameIndividual = "Individual";
    @org.jetbrains.annotations.NotNull
    private final java.lang.String channelNameMerged = "Merged";
    
    public MessagingService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChannelIDSingle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChannelIDMerged() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChannelNameIndividual() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getChannelNameMerged() {
        return null;
    }
    
    @java.lang.Override
    public void onMessageReceived(@org.jetbrains.annotations.NotNull
    com.google.firebase.messaging.RemoteMessage p0) {
    }
    
    private final void showNotification(com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }
    
    @android.annotation.SuppressLint(value = {"UnspecifiedImmutableFlag"})
    private final void notify(java.lang.String title, android.content.Intent intent, com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }
    
    private final void getAllUnreadMessages(androidx.core.app.NotificationCompat.Builder notificationCompatBuilder) {
    }
    
    private final void updateNotificationWithBigText(com.google.firebase.messaging.RemoteMessage remoteMessage, androidx.core.app.NotificationCompat.Builder notificationCompatBuilder) {
    }
    
    private final android.app.NotificationManager getNotificationManager(androidx.core.app.NotificationCompat.Builder notificationCompatBuilder, java.lang.String channelName, java.lang.String channelID) {
        return null;
    }
    
    private final void setAllMessageFromUserAsDelivered(java.lang.String uid, java.lang.String targetUID, java.lang.String msgIDs) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getIDs(@org.jetbrains.annotations.NotNull
    java.lang.String msgIDsString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getMessages(@org.jetbrains.annotations.NotNull
    java.lang.String messageString) {
        return null;
    }
    
    @java.lang.Override
    public void onNewToken(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lca/scooter/talkufy/firebase/MessagingService$NotificationDetail;", "", "()V", "MUlTIPLE_ID", "", "getMUlTIPLE_ID", "()I", "SINGLE_ID", "getSINGLE_ID", "app_debug"})
    public static final class NotificationDetail {
        @org.jetbrains.annotations.NotNull
        public static final ca.scooter.talkufy.firebase.MessagingService.NotificationDetail INSTANCE = null;
        private static final int SINGLE_ID = 123456;
        private static final int MUlTIPLE_ID = 654321;
        
        private NotificationDetail() {
            super();
        }
        
        public final int getSINGLE_ID() {
            return 0;
        }
        
        public final int getMUlTIPLE_ID() {
            return 0;
        }
    }
}
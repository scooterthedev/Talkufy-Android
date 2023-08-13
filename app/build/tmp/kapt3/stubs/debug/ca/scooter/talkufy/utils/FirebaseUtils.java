package ca.scooter.talkufy.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b[\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u00b9\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u0004J\u001e\u0010d\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u0004J(\u0010f\u001a\u00020`2\u0006\u0010g\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u0004H\u0002J\u0016\u0010k\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020oJ\u001e\u0010p\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u0004J\u001e\u0010q\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u0004J\u0006\u0010r\u001a\u00020`J\u0006\u0010s\u001a\u00020\u0004J\u0006\u0010t\u001a\u00020\u0004J\u0006\u0010u\u001a\u00020oJ\u0018\u0010v\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\u0004H\u0002J\u001e\u0010w\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010x\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zJ\u001e\u0010{\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010x\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zJ\u001e\u0010|\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010}\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zJ\u001e\u0010~\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010}\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zJ\u001e\u0010\u007f\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zJ\u001f\u0010\u0080\u0001\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zJ2\u0010\u0081\u0001\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\u00042\u0007\u0010\u0082\u0001\u001a\u00020\u00042\u0007\u0010\u0083\u0001\u001a\u00020\u00042\u0007\u0010\u0084\u0001\u001a\u00020oJ2\u0010\u0085\u0001\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u00042\u0007\u0010\u0082\u0001\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00020\u00042\u0007\u0010\u0084\u0001\u001a\u00020oJ \u0010\u0087\u0001\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u0004J \u0010\u0089\u0001\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\u00042\u0007\u0010\u0088\u0001\u001a\u00020\u0004J9\u0010\u008a\u0001\u001a\u00020`2\u0006\u0010g\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u00042\u0007\u0010\u008b\u0001\u001a\u00020\u00042\u0007\u0010\u008c\u0001\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u0004J\u0019\u0010\u008d\u0001\u001a\u00020`2\u0006\u0010b\u001a\u00020\u00042\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001J\"\u0010\u0090\u0001\u001a\u00020`2\u0007\u0010\u0091\u0001\u001a\u00020\u00042\u0007\u0010\u0092\u0001\u001a\u00020\u00042\u0007\u0010\u0093\u0001\u001a\u00020zJ\u0019\u0010\u0094\u0001\u001a\u00020`2\u0006\u0010e\u001a\u00020\u00042\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001J#\u0010\u0095\u0001\u001a\u00020`2\u0007\u0010\u0091\u0001\u001a\u00020\u00042\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0093\u0001\u001a\u00020zJ\u0007\u0010\u0096\u0001\u001a\u00020`J\u0007\u0010\u0097\u0001\u001a\u00020`J\u0010\u0010\u0098\u0001\u001a\u00020`2\u0007\u0010\u0091\u0001\u001a\u00020\u0004J<\u0010\u0099\u0001\u001a\u00020`2\u0007\u0010\u0092\u0001\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00042\u0007\u0010\u0091\u0001\u001a\u00020\u00042\u0007\u0010\u009a\u0001\u001a\u00020o2\u0007\u0010\u009b\u0001\u001a\u00020o2\u0007\u0010\u009c\u0001\u001a\u00020\u0004J\u0017\u0010\u009d\u0001\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zJ\u0019\u0010\u009e\u0001\u001a\u00020`2\u0007\u0010\u0092\u0001\u001a\u00020\u00042\u0007\u0010\u0091\u0001\u001a\u00020\u0004J*\u0010\u009f\u0001\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010a\u001a\u00020\u00042\u0007\u0010\u0082\u0001\u001a\u00020\u00042\b\u0010\u00a0\u0001\u001a\u00030\u00a1\u0001J8\u0010\u00a2\u0001\u001a\u00020`2\u0007\u0010\u0091\u0001\u001a\u00020\u00042\b\u0010\u00a3\u0001\u001a\u00030\u00a4\u00012\u0016\u0010\u00a5\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u008f\u00010\u00a6\u0001\"\u00030\u008f\u0001\u00a2\u0006\u0003\u0010\u00a7\u0001J*\u0010\u00a8\u0001\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0006\u0010a\u001a\u00020\u00042\u0007\u0010\u00a9\u0001\u001a\u00020oJ!\u0010\u00aa\u0001\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010a\u001a\u00020\u00042\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001J\u0017\u0010\u00aa\u0001\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010y\u001a\u00020zJ\u0007\u0010\u00ab\u0001\u001a\u00020`JT\u0010\u00ac\u0001\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\u00042\u0007\u0010\u0082\u0001\u001a\u00020\u00042\u0007\u0010\u00ad\u0001\u001a\u00020o2\u0007\u0010\u00ae\u0001\u001a\u00020o2\u000f\u0010\u00af\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b1\u00010\u00b0\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u0004JT\u0010\u00b2\u0001\u001a\u00020`2\u0006\u0010l\u001a\u00020m2\u0006\u0010a\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u00042\u0007\u0010\u0082\u0001\u001a\u00020\u00042\u0007\u0010\u00ad\u0001\u001a\u00020o2\u0007\u0010\u00ae\u0001\u001a\u00020o2\u000f\u0010\u00b3\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b4\u00010\u00b0\u00012\u0007\u0010\u0086\u0001\u001a\u00020\u0004J\u0011\u0010\u00b5\u0001\u001a\u00020`2\b\u0010\u00b6\u0001\u001a\u00030\u00b7\u0001J\u0007\u0010\u00b8\u0001\u001a\u00020`R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001d\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0014\u0010\u001f\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0014\u0010!\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0014\u0010#\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0014\u0010%\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0014\u0010\'\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0014\u0010)\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0014\u0010+\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0014\u0010-\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0014\u0010/\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0014\u00101\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0014\u00103\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0014\u00105\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u0014\u00107\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0014\u00109\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0014\u0010;\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0014\u0010=\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0014\u0010?\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R\u0014\u0010A\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0006R\u0014\u0010C\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0006R\u0014\u0010E\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0006R\u0014\u0010G\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0006R\u0014\u0010I\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0006R\u0014\u0010K\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0006R\u0014\u0010M\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0006R\u0014\u0010O\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0006R\u0014\u0010Q\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0006R\u0014\u0010S\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0006R\u0014\u0010U\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0006R\u0014\u0010W\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0006R\u0014\u0010Y\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u0006R\u0014\u0010[\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u0006R\u0014\u0010]\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010\u0006\u00a8\u0006\u00ba\u0001"}, d2 = {"Lca/scooter/talkufy/utils/FirebaseUtils;", "", "()V", "EVENT_TYPE_ADDED", "", "getEVENT_TYPE_ADDED", "()Ljava/lang/String;", "EVENT_TYPE_CALL_LOG_FROM", "getEVENT_TYPE_CALL_LOG_FROM", "EVENT_TYPE_CALL_LOG_JOINED", "getEVENT_TYPE_CALL_LOG_JOINED", "EVENT_TYPE_CALL_LOG_LEAVED", "getEVENT_TYPE_CALL_LOG_LEAVED", "EVENT_TYPE_CALL_LOG_TO", "getEVENT_TYPE_CALL_LOG_TO", "EVENT_TYPE_CREATED", "getEVENT_TYPE_CREATED", "EVENT_TYPE_LEFT", "getEVENT_TYPE_LEFT", "EVENT_TYPE_REMOVED", "getEVENT_TYPE_REMOVED", "KEY_BIO", "getKEY_BIO", "KEY_BLOCKED", "getKEY_BLOCKED", "KEY_CITY", "getKEY_CITY", "KEY_CONVERSATION_CHANNEL", "getKEY_CONVERSATION_CHANNEL", "KEY_CONVERSATION_GROUP", "getKEY_CONVERSATION_GROUP", "KEY_CONVERSATION_SINGLE", "getKEY_CONVERSATION_SINGLE", "KEY_ENABLED", "getKEY_ENABLED", "KEY_FILE_LOCAL_PATH", "getKEY_FILE_LOCAL_PATH", "KEY_FULL_NAME", "getKEY_FULL_NAME", "KEY_NAME", "getKEY_NAME", "KEY_NAME_OR_NUMBER", "getKEY_NAME_OR_NUMBER", "KEY_PHONE", "getKEY_PHONE", "KEY_PROFILE_PIC_URL", "getKEY_PROFILE_PIC_URL", "KEY_REVERSE_TIMESTAMP", "getKEY_REVERSE_TIMESTAMP", "KEY_STATUS", "getKEY_STATUS", "KEY_TIME_IN_MILLIS", "getKEY_TIME_IN_MILLIS", "KEY_UID", "getKEY_UID", "NODE_BLOCKED_LIST", "getNODE_BLOCKED_LIST", "NODE_CALLS", "getNODE_CALLS", "NODE_CHANNEL_INFO", "getNODE_CHANNEL_INFO", "NODE_CHANNEL_MEMBER", "getNODE_CHANNEL_MEMBER", "NODE_FEEDBACK", "getNODE_FEEDBACK", "NODE_FILE", "getNODE_FILE", "NODE_GROUP_INFO", "getNODE_GROUP_INFO", "NODE_GROUP_MEMBER", "getNODE_GROUP_MEMBER", "NODE_INDIVIDUAL_NOTIFICATION_SETTING", "getNODE_INDIVIDUAL_NOTIFICATION_SETTING", "NODE_LAST_MESSAGE", "getNODE_LAST_MESSAGE", "NODE_MESSAGES", "getNODE_MESSAGES", "NODE_MESSAGE_STATUS", "getNODE_MESSAGE_STATUS", "NODE_TOKEN", "getNODE_TOKEN", "NODE_USER", "getNODE_USER", "NODE_USER_ACTIVITY_STATUS", "getNODE_USER_ACTIVITY_STATUS", "VAL_OFFLINE", "getVAL_OFFLINE", "VAL_ONLINE", "getVAL_ONLINE", "VAL_TYPING", "getVAL_TYPING", "user_jio", "getUser_jio", "user_voda", "getUser_voda", "addedChannelMemberEvent", "", "uid", "channelID", "addingMemberPhoneNumber", "addedMemberEvent", "groupID", "callLogToMessages", "meOrTargetUID", "TargetOrMeUID", "eventType", "caption", "checkForUpdate", "context", "Landroid/content/Context;", "shouldShowToast", "", "createdChannelEvent", "createdGroupEvent", "deleteCurrentToken", "getPhoneNumber", "getUid", "isLoggedIn", "leftMemberEvent", "loadChannelPic", "channelId", "imageView", "Landroid/widget/ImageView;", "loadChannelPicThumbnail", "loadGroupPic", "groupId", "loadGroupPicThumbnail", "loadProfilePic", "loadProfileThumbnail", "removeMember", "phoneNumber", "groupName", "isRemovedByOther", "removeMemberFromChannel", "channelName", "removedChannelMemberEvent", "removedMemberPhoneNumber", "removedMemberEvent", "setCallLog", "conversationType", "meOrTargetNumber", "setChannelName", "textView", "Landroid/widget/TextView;", "setDeliveryStatusTick", "targetUID", "messageID", "messageStatusImageView", "setGroupName", "setLastMessage", "setMeAsOffline", "setMeAsOnline", "setMeAsTyping", "setMessageStatusToDB", "isDelivered", "isRead", "groupOrChannelNameIf", "setMuteImageIcon", "setReadStatusToMessage", "setTargetOptionMenu", "view", "Landroid/view/View;", "setUnreadCount", "notificationBadge", "Lcom/nex3z/notificationbadge/NotificationBadge;", "boldTextViews", "", "(Ljava/lang/String;Lcom/nex3z/notificationbadge/NotificationBadge;[Landroid/widget/TextView;)V", "setUserDetailFromUID", "shouldQueryFromContacts", "setUserOnlineStatus", "setonDisconnectListener", "showTargetOptionMenuFromProfile", "isAdmin", "isMeAdmin", "groupMembers", "", "Lca/scooter/talkufy/models/Models$GroupMember;", "showTargetOptionMenuFromProfileForChannel", "channelMembers", "Lca/scooter/talkufy/models/Models$ChannelMember;", "storeFileMetaData", "file", "Lca/scooter/talkufy/models/Models$File;", "updateFCMToken", "ref", "app_debug"})
public final class FirebaseUtils {
    @org.jetbrains.annotations.NotNull
    public static final ca.scooter.talkufy.utils.FirebaseUtils INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_MESSAGES = "Messages";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_USER = "users";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_BLOCKED_LIST = "Block_list";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_MESSAGE_STATUS = "Message_Status";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_USER_ACTIVITY_STATUS = "User_Status";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_TOKEN = "FCM_Tokens";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_INDIVIDUAL_NOTIFICATION_SETTING = "Mute_Notification";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_GROUP_INFO = "GroupInfo";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_GROUP_MEMBER = "GroupMember";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_CHANNEL_INFO = "ChannelInfo";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_CHANNEL_MEMBER = "ChannelMember";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_CALLS = "Calls";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EVENT_TYPE_ADDED = "added";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EVENT_TYPE_REMOVED = "removed";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EVENT_TYPE_LEFT = "left";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EVENT_TYPE_CREATED = "created";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EVENT_TYPE_CALL_LOG_TO = "call_log_to";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EVENT_TYPE_CALL_LOG_FROM = "call_log_from";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EVENT_TYPE_CALL_LOG_JOINED = "call_log_joined";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String EVENT_TYPE_CALL_LOG_LEAVED = "call_log_leaved";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String VAL_ONLINE = "Online";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String VAL_OFFLINE = "Offline";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String VAL_TYPING = "Typing...";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_FILE = "Files";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_FEEDBACK = "Feedbacks";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_STATUS = "status";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_ENABLED = "enabled";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_UID = "uid";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String NODE_LAST_MESSAGE = "LastMessage";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_REVERSE_TIMESTAMP = "reverseTimeStamp";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_TIME_IN_MILLIS = "timeInMillis";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_PHONE = "phone";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_PROFILE_PIC_URL = "profile_pic_url";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_NAME = "name";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_FULL_NAME = "full_name";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_BIO = "bio";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_CITY = "city";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_NAME_OR_NUMBER = "nameOrNumber";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_CONVERSATION_SINGLE = "single";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_CONVERSATION_GROUP = "group";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_CONVERSATION_CHANNEL = "channel";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_BLOCKED = "blocked";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_FILE_LOCAL_PATH = "file_local_path";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String user_voda = "vHv8TSqbS2YBHZJXS5X5Saz4acC2";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String user_jio = "LPVjVKbpTzeUDpank04sxkoparE2";
    
    private FirebaseUtils() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_MESSAGES() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_USER() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_BLOCKED_LIST() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_MESSAGE_STATUS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_USER_ACTIVITY_STATUS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_TOKEN() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_INDIVIDUAL_NOTIFICATION_SETTING() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_GROUP_INFO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_GROUP_MEMBER() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_CHANNEL_INFO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_CHANNEL_MEMBER() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_CALLS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEVENT_TYPE_ADDED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEVENT_TYPE_REMOVED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEVENT_TYPE_LEFT() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEVENT_TYPE_CREATED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEVENT_TYPE_CALL_LOG_TO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEVENT_TYPE_CALL_LOG_FROM() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEVENT_TYPE_CALL_LOG_JOINED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEVENT_TYPE_CALL_LOG_LEAVED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getVAL_ONLINE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getVAL_OFFLINE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getVAL_TYPING() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_FILE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_FEEDBACK() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_STATUS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_ENABLED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_UID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNODE_LAST_MESSAGE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_REVERSE_TIMESTAMP() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_TIME_IN_MILLIS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_PHONE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_PROFILE_PIC_URL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_NAME() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_FULL_NAME() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_BIO() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_CITY() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_NAME_OR_NUMBER() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_CONVERSATION_SINGLE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_CONVERSATION_GROUP() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_CONVERSATION_CHANNEL() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_BLOCKED() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKEY_FILE_LOCAL_PATH() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUser_voda() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUser_jio() {
        return null;
    }
    
    public final void loadProfilePic(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    public final void loadGroupPic(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String groupId, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    public final void loadChannelPic(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String channelId, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    public final void loadProfileThumbnail(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    public final void loadGroupPicThumbnail(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String groupId, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    public final void loadChannelPicThumbnail(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String channelId, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    public final void setUserDetailFromUID(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.widget.TextView textView, @org.jetbrains.annotations.NotNull
    java.lang.String uid, boolean shouldQueryFromContacts) {
    }
    
    public final void setLastMessage(@org.jetbrains.annotations.NotNull
    java.lang.String targetUID, @org.jetbrains.annotations.NotNull
    android.widget.TextView textView, @org.jetbrains.annotations.NotNull
    android.widget.ImageView messageStatusImageView) {
    }
    
    public final void setUnreadCount(@org.jetbrains.annotations.NotNull
    java.lang.String targetUID, @org.jetbrains.annotations.NotNull
    com.nex3z.notificationbadge.NotificationBadge notificationBadge, @org.jetbrains.annotations.NotNull
    android.widget.TextView... boldTextViews) {
    }
    
    public final void setMeAsOnline() {
    }
    
    public final void setMeAsOffline() {
    }
    
    public final void setMeAsTyping(@org.jetbrains.annotations.NotNull
    java.lang.String targetUID) {
    }
    
    public final void setDeliveryStatusTick(@org.jetbrains.annotations.NotNull
    java.lang.String targetUID, @org.jetbrains.annotations.NotNull
    java.lang.String messageID, @org.jetbrains.annotations.NotNull
    android.widget.ImageView messageStatusImageView) {
    }
    
    public final void setMessageStatusToDB(@org.jetbrains.annotations.NotNull
    java.lang.String messageID, @org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String targetUID, boolean isDelivered, boolean isRead, @org.jetbrains.annotations.NotNull
    java.lang.String groupOrChannelNameIf) {
    }
    
    public final void setReadStatusToMessage(@org.jetbrains.annotations.NotNull
    java.lang.String messageID, @org.jetbrains.annotations.NotNull
    java.lang.String targetUID) {
    }
    
    public final void setUserOnlineStatus(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    android.widget.TextView textView) {
    }
    
    public final void setUserOnlineStatus(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    public final void updateFCMToken() {
    }
    
    public final void deleteCurrentToken() {
    }
    
    public final void storeFileMetaData(@org.jetbrains.annotations.NotNull
    ca.scooter.talkufy.models.Models.File file) {
    }
    
    public final void setMuteImageIcon(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    android.widget.ImageView imageView) {
    }
    
    public final void checkForUpdate(@org.jetbrains.annotations.NotNull
    android.content.Context context, boolean shouldShowToast) {
    }
    
    public final void addedMemberEvent(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String groupID, @org.jetbrains.annotations.NotNull
    java.lang.String addingMemberPhoneNumber) {
    }
    
    public final void createdGroupEvent(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String groupID, @org.jetbrains.annotations.NotNull
    java.lang.String addingMemberPhoneNumber) {
    }
    
    public final void createdChannelEvent(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String channelID, @org.jetbrains.annotations.NotNull
    java.lang.String addingMemberPhoneNumber) {
    }
    
    public final void addedChannelMemberEvent(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String channelID, @org.jetbrains.annotations.NotNull
    java.lang.String addingMemberPhoneNumber) {
    }
    
    public final void removedMemberEvent(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String groupID, @org.jetbrains.annotations.NotNull
    java.lang.String removedMemberPhoneNumber) {
    }
    
    private final void leftMemberEvent(java.lang.String uid, java.lang.String groupID) {
    }
    
    public final void setGroupName(@org.jetbrains.annotations.NotNull
    java.lang.String groupID, @org.jetbrains.annotations.NotNull
    android.widget.TextView textView) {
    }
    
    public final void setChannelName(@org.jetbrains.annotations.NotNull
    java.lang.String channelID, @org.jetbrains.annotations.NotNull
    android.widget.TextView textView) {
    }
    
    public final void setTargetOptionMenu(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    public final void removeMember(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String groupID, @org.jetbrains.annotations.NotNull
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull
    java.lang.String groupName, boolean isRemovedByOther) {
    }
    
    public final void removeMemberFromChannel(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String channelID, @org.jetbrains.annotations.NotNull
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull
    java.lang.String channelName, boolean isRemovedByOther) {
    }
    
    public final void showTargetOptionMenuFromProfile(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String groupID, @org.jetbrains.annotations.NotNull
    java.lang.String phoneNumber, boolean isAdmin, boolean isMeAdmin, @org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.GroupMember> groupMembers, @org.jetbrains.annotations.NotNull
    java.lang.String groupName) {
    }
    
    public final void showTargetOptionMenuFromProfileForChannel(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String channelID, @org.jetbrains.annotations.NotNull
    java.lang.String phoneNumber, boolean isAdmin, boolean isMeAdmin, @org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.ChannelMember> channelMembers, @org.jetbrains.annotations.NotNull
    java.lang.String channelName) {
    }
    
    public final void removedChannelMemberEvent(@org.jetbrains.annotations.NotNull
    java.lang.String uid, @org.jetbrains.annotations.NotNull
    java.lang.String channelID, @org.jetbrains.annotations.NotNull
    java.lang.String removedMemberPhoneNumber) {
    }
    
    public final void setonDisconnectListener() {
    }
    
    public final void setCallLog(@org.jetbrains.annotations.NotNull
    java.lang.String meOrTargetUID, @org.jetbrains.annotations.NotNull
    java.lang.String TargetOrMeUID, @org.jetbrains.annotations.NotNull
    java.lang.String conversationType, @org.jetbrains.annotations.NotNull
    java.lang.String meOrTargetNumber, @org.jetbrains.annotations.NotNull
    java.lang.String caption, @org.jetbrains.annotations.NotNull
    java.lang.String eventType) {
    }
    
    private final void callLogToMessages(java.lang.String meOrTargetUID, java.lang.String TargetOrMeUID, java.lang.String eventType, java.lang.String caption) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\"\u001a\u00020\u0004H\u0002J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u0004\u00a8\u0006&"}, d2 = {"Lca/scooter/talkufy/utils/FirebaseUtils$ref;", "", "()V", "FCMToken", "Lcom/google/firebase/database/DatabaseReference;", "uid", "", "allMessageStatus", "targetUID", "allMessageStatusRootRef", "allUser", "blockedUser", "callRef", "channelInfo", "channelID", "channelMember", "channelMembers", "feedback", "fileRef", "getBlockedUserListQuery", "Lcom/google/firebase/database/Query;", "getChatQuery", "getChatRef", "getNotificationMuteRootRef", "groupInfo", "groupID", "groupMember", "groupMembers", "lastMessage", "messageStatus", "messageID", "notificationMute", "profilePicStorageRef", "Lcom/google/firebase/storage/StorageReference;", "root", "user", "userStatus", "userStatusRoot", "app_debug"})
    public static final class ref {
        @org.jetbrains.annotations.NotNull
        public static final ca.scooter.talkufy.utils.FirebaseUtils.ref INSTANCE = null;
        
        private ref() {
            super();
        }
        
        private final com.google.firebase.database.DatabaseReference root() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference fileRef() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.Query getChatQuery(@org.jetbrains.annotations.NotNull
        java.lang.String uid, @org.jetbrains.annotations.NotNull
        java.lang.String targetUID) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference getChatRef(@org.jetbrains.annotations.NotNull
        java.lang.String uid, @org.jetbrains.annotations.NotNull
        java.lang.String targetUID) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference lastMessage(@org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference user(@org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference allUser() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.storage.StorageReference profilePicStorageRef(@org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference FCMToken(@org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference blockedUser(@org.jetbrains.annotations.NotNull
        java.lang.String uid, @org.jetbrains.annotations.NotNull
        java.lang.String targetUID) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.Query getBlockedUserListQuery(@org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference allMessageStatus(@org.jetbrains.annotations.NotNull
        java.lang.String uid, @org.jetbrains.annotations.NotNull
        java.lang.String targetUID) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference allMessageStatusRootRef() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference messageStatus(@org.jetbrains.annotations.NotNull
        java.lang.String uid, @org.jetbrains.annotations.NotNull
        java.lang.String targetUID, @org.jetbrains.annotations.NotNull
        java.lang.String messageID) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference userStatusRoot() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference userStatus(@org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference notificationMute(@org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference getNotificationMuteRootRef() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference groupInfo(@org.jetbrains.annotations.NotNull
        java.lang.String groupID) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference channelInfo(@org.jetbrains.annotations.NotNull
        java.lang.String channelID) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference groupMembers(@org.jetbrains.annotations.NotNull
        java.lang.String groupID) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference channelMembers(@org.jetbrains.annotations.NotNull
        java.lang.String channelID) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference groupMember(@org.jetbrains.annotations.NotNull
        java.lang.String groupID, @org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference channelMember(@org.jetbrains.annotations.NotNull
        java.lang.String channelID, @org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference feedback() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.google.firebase.database.DatabaseReference callRef(@org.jetbrains.annotations.NotNull
        java.lang.String uid) {
            return null;
        }
    }
}
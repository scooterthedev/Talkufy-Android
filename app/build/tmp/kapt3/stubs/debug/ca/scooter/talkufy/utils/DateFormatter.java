package ca.scooter.talkufy.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0006"}, d2 = {"Lca/scooter/talkufy/utils/DateFormatter;", "", "()V", "Companion", "Formatter", "Template", "app_debug"})
public final class DateFormatter {
    @org.jetbrains.annotations.NotNull
    public static final ca.scooter.talkufy.utils.DateFormatter.Companion Companion = null;
    
    private DateFormatter() {
        super();
    }
    
    /**
     * Interface used to format dates before they were displayed (e.g. dialogs time, messages date headers etc.).
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lca/scooter/talkufy/utils/DateFormatter$Formatter;", "", "format", "", "date", "Ljava/util/Date;", "app_debug"})
    public static abstract interface Formatter {
        
        /**
         * Formats an string representation of the date object.
         *
         * @param date The date that should be formatted.
         * @return Formatted text.
         */
        @org.jetbrains.annotations.NotNull
        public abstract java.lang.String format(@org.jetbrains.annotations.NotNull
        java.util.Date date);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lca/scooter/talkufy/utils/DateFormatter$Template;", "", "template", "", "(Ljava/lang/String;ILjava/lang/String;)V", "get", "STRING_DAY_MONTH_YEAR", "STRING_DAY_MONTH", "TIME", "app_debug"})
    public static enum Template {
        /*public static final*/ STRING_DAY_MONTH_YEAR /* = new STRING_DAY_MONTH_YEAR(null) */,
        /*public static final*/ STRING_DAY_MONTH /* = new STRING_DAY_MONTH(null) */,
        /*public static final*/ TIME /* = new TIME(null) */;
        private final java.lang.String template = null;
        
        Template(java.lang.String template) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String get() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0012\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0015"}, d2 = {"Lca/scooter/talkufy/utils/DateFormatter$Companion;", "", "()V", "format", "", "date", "Ljava/util/Date;", "template", "Lca/scooter/talkufy/utils/DateFormatter$Template;", "isCurrentYear", "", "calendar", "Ljava/util/Calendar;", "isSameDay", "cal1", "cal2", "date1", "date2", "isSameYear", "isToday", "isYesterday", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String format(@org.jetbrains.annotations.NotNull
        java.util.Date date, @org.jetbrains.annotations.NotNull
        ca.scooter.talkufy.utils.DateFormatter.Template template) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String format(@org.jetbrains.annotations.Nullable
        java.util.Date date, @org.jetbrains.annotations.NotNull
        java.lang.String format) {
            return null;
        }
        
        public final boolean isSameDay(@org.jetbrains.annotations.Nullable
        java.util.Date date1, @org.jetbrains.annotations.Nullable
        java.util.Date date2) {
            return false;
        }
        
        public final boolean isSameDay(@org.jetbrains.annotations.Nullable
        java.util.Calendar cal1, @org.jetbrains.annotations.Nullable
        java.util.Calendar cal2) {
            return false;
        }
        
        public final boolean isSameYear(@org.jetbrains.annotations.Nullable
        java.util.Date date1, @org.jetbrains.annotations.Nullable
        java.util.Date date2) {
            return false;
        }
        
        public final boolean isSameYear(@org.jetbrains.annotations.Nullable
        java.util.Calendar cal1, @org.jetbrains.annotations.Nullable
        java.util.Calendar cal2) {
            return false;
        }
        
        public final boolean isToday(@org.jetbrains.annotations.NotNull
        java.util.Calendar calendar) {
            return false;
        }
        
        public final boolean isToday(@org.jetbrains.annotations.NotNull
        java.util.Date date) {
            return false;
        }
        
        public final boolean isYesterday(@org.jetbrains.annotations.NotNull
        java.util.Calendar calendar) {
            return false;
        }
        
        public final boolean isYesterday(@org.jetbrains.annotations.NotNull
        java.util.Date date) {
            return false;
        }
        
        public final boolean isCurrentYear(@org.jetbrains.annotations.NotNull
        java.util.Date date) {
            return false;
        }
        
        public final boolean isCurrentYear(@org.jetbrains.annotations.NotNull
        java.util.Calendar calendar) {
            return false;
        }
    }
}
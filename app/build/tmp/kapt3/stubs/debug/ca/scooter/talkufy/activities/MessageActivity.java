package ca.scooter.talkufy.activities;

import java.lang.System;

@kotlin.Suppress(names = {"DEPRECATION"})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u00ba\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u00bd\u0001\u001a\u00020>H\u0002J\u001c\u0010\u00be\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u00bd\u0001\u001a\u00020>H\u0003J\u001c\u0010\u00bf\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u00bd\u0001\u001a\u00020>H\u0003J\u001c\u0010\u00c0\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u00bd\u0001\u001a\u00020>H\u0002J\u001c\u0010\u00c1\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u00bd\u0001\u001a\u00020>H\u0002J\n\u0010\u00c2\u0001\u001a\u00030\u00bb\u0001H\u0003J\n\u0010\u00c3\u0001\u001a\u00030\u00bb\u0001H\u0003J$\u0010\u00c4\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00c5\u0001\u001a\u00020\u00052\u000f\u0010\u00c6\u0001\u001a\n\u0012\u0005\u0012\u00030\u00bb\u00010\u00c7\u0001H\u0002J\n\u0010\u00c8\u0001\u001a\u00030\u00bb\u0001H\u0002J\n\u0010\u00c9\u0001\u001a\u00030\u00bb\u0001H\u0002J\u0014\u0010\u00ca\u0001\u001a\u00030\u00bb\u00012\b\u00106\u001a\u0004\u0018\u000107H\u0003J\u001c\u0010\u00cb\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00cc\u0001\u001a\u00020>2\u0007\u0010\u00bc\u0001\u001a\u00020\u0005H\u0003J7\u0010\u00cd\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u00ce\u0001\u001a\u00020j2\u0007\u0010\u00cf\u0001\u001a\u00020\u00052\u0007\u0010\u00d0\u0001\u001a\u00020\u00052\u0007\u0010\u00d1\u0001\u001a\u00020\u0005H\u0003J\u001f\u0010\u00d2\u0001\u001a\u0005\u0018\u00010\u00d3\u00012\b\u0010\u00d4\u0001\u001a\u00030\u00d5\u00012\u0007\u0010\u00d6\u0001\u001a\u00020\bH\u0002J\u001f\u0010\u00d2\u0001\u001a\u0005\u0018\u00010\u00d3\u00012\b\u0010\u00d4\u0001\u001a\u00030\u00d7\u00012\u0007\u0010\u00d6\u0001\u001a\u00020\bH\u0002J\u001c\u0010\u00d8\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00d9\u0001\u001a\u00020\u00052\u0007\u0010\u00da\u0001\u001a\u00020FH\u0002J\n\u0010\u00db\u0001\u001a\u00030\u00bb\u0001H\u0002J\n\u0010\u00dc\u0001\u001a\u00030\u00bb\u0001H\u0003J\n\u0010\u00dd\u0001\u001a\u00030\u00bb\u0001H\u0003J\n\u0010\u00de\u0001\u001a\u00030\u00bb\u0001H\u0003J\u001e\u0010\u00df\u0001\u001a\u00030\u00bb\u00012\b\u0010\u00e0\u0001\u001a\u00030\u00e1\u00012\b\u0010\u00e2\u0001\u001a\u00030\u00e3\u0001H\u0003J\n\u0010\u00e4\u0001\u001a\u00030\u00bb\u0001H\u0002J\n\u0010\u00e5\u0001\u001a\u00030\u00bb\u0001H\u0002J(\u0010\u00e6\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00e7\u0001\u001a\u00020\b2\u0007\u0010\u00e8\u0001\u001a\u00020\b2\n\u0010\u00e9\u0001\u001a\u0005\u0018\u00010\u00ea\u0001H\u0015J\n\u0010\u00eb\u0001\u001a\u00030\u00bb\u0001H\u0017J\u0016\u0010\u00ec\u0001\u001a\u00030\u00bb\u00012\n\u0010\u00ed\u0001\u001a\u0005\u0018\u00010\u00ee\u0001H\u0015J\u0015\u0010\u00ef\u0001\u001a\u00020F2\n\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u00f1\u0001H\u0016J\n\u0010\u00f2\u0001\u001a\u00030\u00bb\u0001H\u0014J\u0012\u0010\u00f3\u0001\u001a\u00020F2\u0007\u0010\u00f4\u0001\u001a\u00020HH\u0016J\n\u0010\u00f5\u0001\u001a\u00030\u00bb\u0001H\u0014J5\u0010\u00f6\u0001\u001a\u00030\u00bb\u00012\u0007\u0010\u00e7\u0001\u001a\u00020\b2\u0010\u0010\u00f7\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00050\u00f8\u00012\b\u0010\u00f9\u0001\u001a\u00030\u00fa\u0001H\u0017\u00a2\u0006\u0003\u0010\u00fb\u0001J\n\u0010\u00fc\u0001\u001a\u00030\u00bb\u0001H\u0014J\n\u0010\u00fd\u0001\u001a\u00030\u00bb\u0001H\u0014J0\u0010\u00fe\u0001\u001a\u00030\u00bb\u00012\b\u0010\u00ff\u0001\u001a\u00030\u0080\u00022\u0007\u0010\u00cc\u0001\u001a\u00020>2\b\u0010\u0081\u0002\u001a\u00030\u0082\u00022\u0007\u0010\u0083\u0002\u001a\u00020\u0005H\u0003J%\u0010\u0084\u0002\u001a\u00030\u00bb\u00012\u0007\u0010\u0085\u0002\u001a\u00020\u00052\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u0086\u0002\u001a\u00020FH\u0002J/\u0010\u0087\u0002\u001a\u00030\u00bb\u00012\b\u0010\u00ff\u0001\u001a\u00030\u0080\u00022\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u00cc\u0001\u001a\u00020>2\u0007\u0010\u0088\u0002\u001a\u00020\bH\u0002J\n\u0010\u0089\u0002\u001a\u00030\u00bb\u0001H\u0002J&\u0010\u008a\u0002\u001a\u00030\u00bb\u00012\b\u0010\u008b\u0002\u001a\u00030\u008c\u00022\u0007\u0010\u00cc\u0001\u001a\u00020>2\u0007\u0010\u00bc\u0001\u001a\u00020\u0005H\u0002J&\u0010\u008d\u0002\u001a\u00030\u00bb\u00012\b\u0010\u008b\u0002\u001a\u00030\u008e\u00022\u0007\u0010\u00cc\u0001\u001a\u00020>2\u0007\u0010\u00bc\u0001\u001a\u00020\u0005H\u0002J\n\u0010\u008f\u0002\u001a\u00030\u00bb\u0001H\u0002J\n\u0010\u0090\u0002\u001a\u00030\u00bb\u0001H\u0002J\n\u0010\u0091\u0002\u001a\u00030\u00bb\u0001H\u0003J\u0014\u0010\u0092\u0002\u001a\u00030\u00bb\u00012\b\u0010\u0093\u0002\u001a\u00030\u0094\u0002H\u0002J\n\u0010\u0095\u0002\u001a\u00030\u00bb\u0001H\u0002JA\u0010\u0096\u0002\u001a\u00030\u00bb\u00012\b\u0010\u0097\u0002\u001a\u00030\u0080\u00022\u0007\u0010\u0098\u0002\u001a\u00020\u00062\u0007\u0010\u0099\u0002\u001a\u00020\u00052\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u00d0\u0001\u001a\u00020\u00052\u0007\u0010\u009a\u0002\u001a\u00020\u0005H\u0003J&\u0010\u009b\u0002\u001a\u00030\u00bb\u00012\b\u0010\u008b\u0002\u001a\u00030\u009c\u00022\u0007\u0010\u00cc\u0001\u001a\u00020>2\u0007\u0010\u00bc\u0001\u001a\u00020\u0005H\u0002J&\u0010\u009d\u0002\u001a\u00030\u00bb\u00012\b\u0010\u008b\u0002\u001a\u00030\u009e\u00022\u0007\u0010\u00cc\u0001\u001a\u00020>2\u0007\u0010\u00bc\u0001\u001a\u00020\u0005H\u0002J\n\u0010\u009f\u0002\u001a\u00030\u00bb\u0001H\u0002J%\u0010\u00a0\u0002\u001a\u00030\u00bb\u00012\u0007\u0010\u00d9\u0001\u001a\u00020\u00052\u0007\u0010\u00da\u0001\u001a\u00020F2\u0007\u0010\u00a1\u0002\u001a\u00020\u0005H\u0002J\u001d\u0010\u00a2\u0002\u001a\u00030\u00bb\u00012\b\u0010\u00ff\u0001\u001a\u00030\u0080\u00022\u0007\u0010\u00cc\u0001\u001a\u00020>H\u0003J7\u0010\u00a3\u0002\u001a\u00030\u00bb\u00012\u0007\u0010\u00bc\u0001\u001a\u00020\u00052\u0007\u0010\u00ce\u0001\u001a\u00020j2\u0007\u0010\u00d0\u0001\u001a\u00020\u00052\u0007\u0010\u00d1\u0001\u001a\u00020\u00052\u0007\u0010\u00a4\u0002\u001a\u00020FH\u0003R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0014\u0010\u001b\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\nR\u0014\u0010\u001d\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\n\"\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\nR\u001a\u0010+\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\"R\u001a\u0010.\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\"R\u001a\u00101\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\n\"\u0004\b3\u0010\"R\u0014\u00104\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010\nR\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R&\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010EX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010HX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR \u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0011\u0010b\u001a\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010dR \u0010e\u001a\b\u0012\u0004\u0012\u00020f0\\X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010_\"\u0004\bh\u0010aR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001a\u0010s\u001a\u00020FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010p\"\u0004\bt\u0010rR\u001a\u0010u\u001a\u00020FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010p\"\u0004\bv\u0010rR\u001a\u0010w\u001a\u00020FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010p\"\u0004\bx\u0010rR\u001a\u0010y\u001a\u00020FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010p\"\u0004\bz\u0010rR\u001a\u0010{\u001a\u00020FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u0010p\"\u0004\b|\u0010rR\u001a\u0010}\u001a\u00020FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b}\u0010p\"\u0004\b~\u0010rR\u001b\u0010\u007f\u001a\u00020FX\u0086\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010p\"\u0005\b\u0080\u0001\u0010rR\u001d\u0010\u0081\u0001\u001a\u00020FX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010p\"\u0005\b\u0082\u0001\u0010rR \u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020F0\u0004\u00a2\u0006\n\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R+\u0010\u0085\u0001\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020F0\u0004X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0084\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u0089\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u008a\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u008b\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010R\"\u0005\b\u008d\u0001\u0010TR\u001d\u0010\u008e\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010R\"\u0005\b\u0090\u0001\u0010TR#\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\\X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010_\"\u0005\b\u0093\u0001\u0010aR\u001d\u0010\u0094\u0001\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\n\"\u0005\b\u0096\u0001\u0010\"R\u000f\u0010\u0097\u0001\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\\\u00a2\u0006\t\n\u0000\u001a\u0005\b\u009f\u0001\u0010_R#\u0010\u00a0\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\\X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a1\u0001\u0010_\"\u0005\b\u00a2\u0001\u0010aR#\u0010\u00a3\u0001\u001a\b\u0012\u0004\u0012\u00020>0\\X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a4\u0001\u0010_\"\u0005\b\u00a5\u0001\u0010aR\u000f\u0010\u00a6\u0001\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u00a7\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a8\u0001\u0010R\"\u0005\b\u00a9\u0001\u0010TR\u001d\u0010\u00aa\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ab\u0001\u0010R\"\u0005\b\u00ac\u0001\u0010TR\u001d\u0010\u00ad\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ae\u0001\u0010R\"\u0005\b\u00af\u0001\u0010TR\u001d\u0010\u00b0\u0001\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b1\u0001\u0010\n\"\u0005\b\u00b2\u0001\u0010\"R\u001d\u0010\u00b3\u0001\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b4\u0001\u0010\n\"\u0005\b\u00b5\u0001\u0010\"R\"\u0010\u00b6\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00b7\u0001\u0010\u009b\u0001\"\u0006\b\u00b8\u0001\u0010\u009d\u0001R\u0011\u0010\u00b9\u0001\u001a\u0004\u0018\u00010HX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00a5\u0002"}, d2 = {"Lca/scooter/talkufy/activities/MessageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CircularProgressBarsAt", "Ljava/util/HashMap;", "", "Lcom/mikhaellopez/circularprogressbar/CircularProgressBar;", "RP_INITAL_STORAGE_PERMISSION", "", "getRP_INITAL_STORAGE_PERMISSION", "()I", "RP_LOCATION", "getRP_LOCATION", "RP_STORAGE_CAMERA", "getRP_STORAGE_CAMERA", "RP_STORAGE_GALLERY", "getRP_STORAGE_GALLERY", "RP_STORAGE_VIDEO", "getRP_STORAGE_VIDEO", "RQ_CAMERA", "getRQ_CAMERA", "RQ_GALLERY", "getRQ_GALLERY", "RQ_LOCATION", "getRQ_LOCATION", "RQ_PREVIEW_IMAGE", "getRQ_PREVIEW_IMAGE", "RQ_VIDEO", "getRQ_VIDEO", "TYPE_EVENT", "getTYPE_EVENT", "TYPE_MINE", "getTYPE_MINE", "setTYPE_MINE", "(I)V", "TYPE_MY_IMAGE", "getTYPE_MY_IMAGE", "setTYPE_MY_IMAGE", "TYPE_MY_MAP", "getTYPE_MY_MAP", "setTYPE_MY_MAP", "TYPE_MY_VIDEO", "getTYPE_MY_VIDEO", "TYPE_TARGET", "getTYPE_TARGET", "setTYPE_TARGET", "TYPE_TARGET_IMAGE", "getTYPE_TARGET_IMAGE", "setTYPE_TARGET_IMAGE", "TYPE_TARGET_MAP", "getTYPE_TARGET_MAP", "setTYPE_TARGET_MAP", "TYPE_TARGET_VIDEO", "getTYPE_TARGET_VIDEO", "actionMode", "Landroidx/appcompat/view/ActionMode;", "getActionMode", "()Landroidx/appcompat/view/ActionMode;", "setActionMode", "(Landroidx/appcompat/view/ActionMode;)V", "adapter", "Lcom/firebase/ui/database/FirebaseRecyclerAdapter;", "Lca/scooter/talkufy/models/Models$MessageModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getAdapter", "()Lcom/firebase/ui/database/FirebaseRecyclerAdapter;", "setAdapter", "(Lcom/firebase/ui/database/FirebaseRecyclerAdapter;)V", "asyncLoader", "Ljava/util/concurrent/Future;", "", "audioCallItem", "Landroid/view/MenuItem;", "blockItem", "blockedSnackbar", "Lcom/google/android/material/snackbar/Snackbar;", "getBlockedSnackbar", "()Lcom/google/android/material/snackbar/Snackbar;", "setBlockedSnackbar", "(Lcom/google/android/material/snackbar/Snackbar;)V", "cameraImagePath", "getCameraImagePath", "()Ljava/lang/String;", "setCameraImagePath", "(Ljava/lang/String;)V", "cameraImageUri", "Landroid/net/Uri;", "getCameraImageUri", "()Landroid/net/Uri;", "setCameraImageUri", "(Landroid/net/Uri;)V", "channelMembers", "", "Lca/scooter/talkufy/models/Models$ChannelMember;", "getChannelMembers", "()Ljava/util/List;", "setChannelMembers", "(Ljava/util/List;)V", "context", "getContext", "()Lca/scooter/talkufy/activities/MessageActivity;", "groupMembers", "Lca/scooter/talkufy/models/Models$GroupMember;", "getGroupMembers", "setGroupMembers", "imageFile", "Ljava/io/File;", "getImageFile", "()Ljava/io/File;", "setImageFile", "(Ljava/io/File;)V", "isBlockedByMe", "()Z", "setBlockedByMe", "(Z)V", "isBlockedByUser", "setBlockedByUser", "isChannel", "setChannel", "isContextMenuActive", "setContextMenuActive", "isGroup", "setGroup", "isMeAdmin", "setMeAdmin", "isMeRemoved", "setMeRemoved", "isMenuHidden", "setMenuHidden", "isTranslatorPressed", "setTranslatorPressed", "isUploading", "()Ljava/util/HashMap;", "loadedPosition", "getLoadedPosition", "setLoadedPosition", "(Ljava/util/HashMap;)V", "mediaControlImageViewAt", "Landroid/widget/ImageView;", "myUID", "getMyUID", "setMyUID", "nameOrNumber", "getNameOrNumber", "setNameOrNumber", "searchFilterItemPosition", "getSearchFilterItemPosition", "setSearchFilterItemPosition", "searchPosition", "getSearchPosition", "setSearchPosition", "searchQuery", "selectedDrawable", "Landroid/graphics/drawable/Drawable;", "getSelectedDrawable", "()Landroid/graphics/drawable/Drawable;", "setSelectedDrawable", "(Landroid/graphics/drawable/Drawable;)V", "selectedItemPosition", "getSelectedItemPosition", "selectedMessageIDs", "getSelectedMessageIDs", "setSelectedMessageIDs", "selectedMessageModel", "getSelectedMessageModel", "setSelectedMessageModel", "selectedPosition", "targetType", "getTargetType", "setTargetType", "targetUid", "getTargetUid", "setTargetUid", "unreadFirstMessageID", "getUnreadFirstMessageID", "setUnreadFirstMessageID", "unreadHeaderPosition", "getUnreadHeaderPosition", "setUnreadHeaderPosition", "unreadMessageCount", "getUnreadMessageCount", "setUnreadMessageCount", "unselectedDrawable", "getUnselectedDrawable", "setUnselectedDrawable", "videoCallItem", "addMessageToBoth", "", "messageID", "messageModel", "addMessageToChannelMembers", "addMessageToGroupMembers", "addMessageToMyNode", "addMessageToTargetNode", "animateAttachmentMenu", "bindSmartReply", "checkIfBlocked", "targetUID", "onChecked", "Lkotlin/Function0;", "checkIfMeAdmin", "checkIfMeRemoved", "deleteSelectedMessages", "downloadVideo", "model", "fileUpload", "file", "originalFinalPath", "caption", "messageType", "getFont", "Landroid/graphics/Typeface;", "callback", "Landroidx/appcompat/view/ActionMode$Callback;", "helveticaRegular", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "hasTargetInitiatedCallAlready", "callId", "audioOnly", "hideRevealView", "initComponents", "loadChannelMembers", "loadGroupMembers", "loadMap", "mapView", "Lcom/google/android/gms/maps/MapView;", "latLng", "Lcom/google/android/gms/maps/model/LatLng;", "monitorChannelNameChanges", "monitorGroupNameChanges", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", "onTranslatorDownloaded", "itemView", "Landroid/view/View;", "firebaseTranslator", "Lcom/google/firebase/ml/naturallanguage/translate/FirebaseTranslator;", "languageName", "saveBitmapFromPicasso", "url", "isSent", "setContextualToolbarOnViewHolder", "position", "setMenuListeners", "setMyImageHolder", "holder", "Lca/scooter/talkufy/views/Holders$MyImageMsgHolder;", "setMyVideoHolder", "Lca/scooter/talkufy/views/Holders$MyVideoMsgHolder;", "setObserver", "setRecyclerAdapter", "setScrollingListener", "setSearchView", "searchView", "Landroidx/appcompat/widget/SearchView;", "setSendMessageListener", "setTapToRetryBtn", "tapToRetry", "progressBar", "filePath", "fileType", "setTargetImageHolder", "Lca/scooter/talkufy/views/Holders$TargetImageMsgHolder;", "setTargetVideoHolder", "Lca/scooter/talkufy/views/Holders$TargetVideoMsgHolder;", "startCamera", "startNewCall", "targetPhone", "translateMessage", "uploadFile", "isNewIDRequired", "app_debug"})
public final class MessageActivity extends androidx.appcompat.app.AppCompatActivity {
    private int unreadHeaderPosition = 0;
    private int unreadMessageCount = 0;
    @org.jetbrains.annotations.NotNull
    private java.lang.String unreadFirstMessageID = "";
    private int TYPE_MINE = 0;
    private int TYPE_TARGET = 1;
    private int TYPE_MY_MAP = 2;
    private int TYPE_TARGET_MAP = 3;
    private int TYPE_MY_IMAGE = 4;
    private int TYPE_TARGET_IMAGE = 5;
    private final int TYPE_MY_VIDEO = 6;
    private final int TYPE_TARGET_VIDEO = 7;
    private final int TYPE_EVENT = 10;
    private final int RQ_CAMERA = 100;
    private final int RQ_GALLERY = 101;
    private final int RQ_PREVIEW_IMAGE = 102;
    private final int RQ_LOCATION = 103;
    private final int RQ_VIDEO = 104;
    private final int RP_STORAGE_GALLERY = 101;
    private final int RP_LOCATION = 102;
    private final int RP_STORAGE_CAMERA = 103;
    private final int RP_STORAGE_VIDEO = 104;
    private final int RP_INITAL_STORAGE_PERMISSION = 105;
    @org.jetbrains.annotations.NotNull
    private java.lang.String targetUid = "";
    @org.jetbrains.annotations.NotNull
    private java.lang.String targetType;
    @org.jetbrains.annotations.NotNull
    private java.lang.String myUID = "";
    private boolean isGroup = false;
    private boolean isChannel = false;
    private boolean isMeRemoved = false;
    private boolean isMeAdmin = false;
    @org.jetbrains.annotations.NotNull
    private java.lang.String nameOrNumber = "";
    @org.jetbrains.annotations.Nullable
    private java.io.File imageFile;
    @org.jetbrains.annotations.NotNull
    private java.lang.String cameraImagePath = "";
    @org.jetbrains.annotations.Nullable
    private android.net.Uri cameraImageUri;
    private boolean isBlockedByMe = false;
    private boolean isBlockedByUser = false;
    @org.jetbrains.annotations.NotNull
    private final ca.scooter.talkufy.activities.MessageActivity context = null;
    @org.jetbrains.annotations.NotNull
    private java.util.HashMap<java.lang.Integer, java.lang.Boolean> loadedPosition;
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.MessageModel> selectedMessageModel;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.String> selectedMessageIDs;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Integer> selectedItemPosition = null;
    @org.jetbrains.annotations.NotNull
    private java.util.List<java.lang.Integer> searchFilterItemPosition;
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.GroupMember> groupMembers;
    @org.jetbrains.annotations.NotNull
    private java.util.List<ca.scooter.talkufy.models.Models.ChannelMember> channelMembers;
    private java.util.concurrent.Future<java.lang.Boolean> asyncLoader;
    @org.jetbrains.annotations.NotNull
    private final java.util.HashMap<java.lang.String, java.lang.Boolean> isUploading = null;
    private final java.util.HashMap<java.lang.String, com.mikhaellopez.circularprogressbar.CircularProgressBar> CircularProgressBarsAt = null;
    private final java.util.HashMap<java.lang.String, android.widget.ImageView> mediaControlImageViewAt = null;
    public com.firebase.ui.database.FirebaseRecyclerAdapter<ca.scooter.talkufy.models.Models.MessageModel, androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.snackbar.Snackbar blockedSnackbar;
    @org.jetbrains.annotations.Nullable
    private android.graphics.drawable.Drawable selectedDrawable;
    @org.jetbrains.annotations.Nullable
    private android.graphics.drawable.Drawable unselectedDrawable;
    private boolean isTranslatorPressed = false;
    @org.jetbrains.annotations.Nullable
    private androidx.appcompat.view.ActionMode actionMode;
    private boolean isContextMenuActive = false;
    private android.view.MenuItem blockItem;
    private android.view.MenuItem videoCallItem;
    private android.view.MenuItem audioCallItem;
    private int selectedPosition = -1;
    private java.lang.String searchQuery = "";
    private int searchPosition = 0;
    private boolean isMenuHidden = true;
    private java.util.HashMap _$_findViewCache;
    
    public MessageActivity() {
        super();
    }
    
    public final int getUnreadHeaderPosition() {
        return 0;
    }
    
    public final void setUnreadHeaderPosition(int p0) {
    }
    
    public final int getUnreadMessageCount() {
        return 0;
    }
    
    public final void setUnreadMessageCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUnreadFirstMessageID() {
        return null;
    }
    
    public final void setUnreadFirstMessageID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final int getTYPE_MINE() {
        return 0;
    }
    
    public final void setTYPE_MINE(int p0) {
    }
    
    public final int getTYPE_TARGET() {
        return 0;
    }
    
    public final void setTYPE_TARGET(int p0) {
    }
    
    public final int getTYPE_MY_MAP() {
        return 0;
    }
    
    public final void setTYPE_MY_MAP(int p0) {
    }
    
    public final int getTYPE_TARGET_MAP() {
        return 0;
    }
    
    public final void setTYPE_TARGET_MAP(int p0) {
    }
    
    public final int getTYPE_MY_IMAGE() {
        return 0;
    }
    
    public final void setTYPE_MY_IMAGE(int p0) {
    }
    
    public final int getTYPE_TARGET_IMAGE() {
        return 0;
    }
    
    public final void setTYPE_TARGET_IMAGE(int p0) {
    }
    
    public final int getTYPE_MY_VIDEO() {
        return 0;
    }
    
    public final int getTYPE_TARGET_VIDEO() {
        return 0;
    }
    
    public final int getTYPE_EVENT() {
        return 0;
    }
    
    public final int getRQ_CAMERA() {
        return 0;
    }
    
    public final int getRQ_GALLERY() {
        return 0;
    }
    
    public final int getRQ_PREVIEW_IMAGE() {
        return 0;
    }
    
    public final int getRQ_LOCATION() {
        return 0;
    }
    
    public final int getRQ_VIDEO() {
        return 0;
    }
    
    public final int getRP_STORAGE_GALLERY() {
        return 0;
    }
    
    public final int getRP_LOCATION() {
        return 0;
    }
    
    public final int getRP_STORAGE_CAMERA() {
        return 0;
    }
    
    public final int getRP_STORAGE_VIDEO() {
        return 0;
    }
    
    public final int getRP_INITAL_STORAGE_PERMISSION() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTargetUid() {
        return null;
    }
    
    public final void setTargetUid(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTargetType() {
        return null;
    }
    
    public final void setTargetType(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMyUID() {
        return null;
    }
    
    public final void setMyUID(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean isGroup() {
        return false;
    }
    
    public final void setGroup(boolean p0) {
    }
    
    public final boolean isChannel() {
        return false;
    }
    
    public final void setChannel(boolean p0) {
    }
    
    public final boolean isMeRemoved() {
        return false;
    }
    
    public final void setMeRemoved(boolean p0) {
    }
    
    public final boolean isMeAdmin() {
        return false;
    }
    
    public final void setMeAdmin(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNameOrNumber() {
        return null;
    }
    
    public final void setNameOrNumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.io.File getImageFile() {
        return null;
    }
    
    public final void setImageFile(@org.jetbrains.annotations.Nullable
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCameraImagePath() {
        return null;
    }
    
    public final void setCameraImagePath(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.net.Uri getCameraImageUri() {
        return null;
    }
    
    public final void setCameraImageUri(@org.jetbrains.annotations.Nullable
    android.net.Uri p0) {
    }
    
    public final boolean isBlockedByMe() {
        return false;
    }
    
    public final void setBlockedByMe(boolean p0) {
    }
    
    public final boolean isBlockedByUser() {
        return false;
    }
    
    public final void setBlockedByUser(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final ca.scooter.talkufy.activities.MessageActivity getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.Integer, java.lang.Boolean> getLoadedPosition() {
        return null;
    }
    
    public final void setLoadedPosition(@org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.Integer, java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.MessageModel> getSelectedMessageModel() {
        return null;
    }
    
    public final void setSelectedMessageModel(@org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.MessageModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getSelectedMessageIDs() {
        return null;
    }
    
    public final void setSelectedMessageIDs(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> getSelectedItemPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> getSearchFilterItemPosition() {
        return null;
    }
    
    public final void setSearchFilterItemPosition(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.GroupMember> getGroupMembers() {
        return null;
    }
    
    public final void setGroupMembers(@org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.GroupMember> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<ca.scooter.talkufy.models.Models.ChannelMember> getChannelMembers() {
        return null;
    }
    
    public final void setChannelMembers(@org.jetbrains.annotations.NotNull
    java.util.List<ca.scooter.talkufy.models.Models.ChannelMember> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.HashMap<java.lang.String, java.lang.Boolean> isUploading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.firebase.ui.database.FirebaseRecyclerAdapter<ca.scooter.talkufy.models.Models.MessageModel, androidx.recyclerview.widget.RecyclerView.ViewHolder> getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull
    com.firebase.ui.database.FirebaseRecyclerAdapter<ca.scooter.talkufy.models.Models.MessageModel, androidx.recyclerview.widget.RecyclerView.ViewHolder> p0) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber", "ShowToast"})
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkIfMeAdmin() {
    }
    
    private final void checkIfMeRemoved() {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void initComponents() {
    }
    
    private final void monitorGroupNameChanges() {
    }
    
    private final void monitorChannelNameChanges() {
    }
    
    private final void setMenuListeners() {
    }
    
    private final void startCamera() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingSuperCall"})
    @java.lang.Override
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull
    int[] grantResults) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    @java.lang.Override
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable
    android.content.Intent data) {
    }
    
    private final void setRecyclerAdapter() {
    }
    
    private final void setObserver() {
    }
    
    private final void setSendMessageListener() {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void setTapToRetryBtn(android.view.View tapToRetry, com.mikhaellopez.circularprogressbar.CircularProgressBar progressBar, java.lang.String filePath, java.lang.String messageID, java.lang.String caption, java.lang.String fileType) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void loadMap(com.google.android.gms.maps.MapView mapView, com.google.android.gms.maps.model.LatLng latLng) {
    }
    
    private final void addMessageToBoth(java.lang.String messageID, ca.scooter.talkufy.models.Models.MessageModel messageModel) {
    }
    
    private final void addMessageToMyNode(java.lang.String messageID, ca.scooter.talkufy.models.Models.MessageModel messageModel) {
    }
    
    private final void addMessageToTargetNode(java.lang.String messageID, ca.scooter.talkufy.models.Models.MessageModel messageModel) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void addMessageToGroupMembers(java.lang.String messageID, ca.scooter.talkufy.models.Models.MessageModel messageModel) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void addMessageToChannelMembers(java.lang.String messageID, ca.scooter.talkufy.models.Models.MessageModel messageModel) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void uploadFile(java.lang.String messageID, java.io.File file, java.lang.String caption, java.lang.String messageType, boolean isNewIDRequired) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber", "NotifyDataSetChanged"})
    private final void fileUpload(java.lang.String messageID, java.io.File file, java.lang.String originalFinalPath, java.lang.String caption, java.lang.String messageType) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void downloadVideo(ca.scooter.talkufy.models.Models.MessageModel model, java.lang.String messageID) {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.snackbar.Snackbar getBlockedSnackbar() {
        return null;
    }
    
    public final void setBlockedSnackbar(@org.jetbrains.annotations.Nullable
    com.google.android.material.snackbar.Snackbar p0) {
    }
    
    private final void checkIfBlocked(java.lang.String targetUID, kotlin.jvm.functions.Function0<kotlin.Unit> onChecked) {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    private final void setMyImageHolder(ca.scooter.talkufy.views.Holders.MyImageMsgHolder holder, ca.scooter.talkufy.models.Models.MessageModel model, java.lang.String messageID) {
    }
    
    private final void setMyVideoHolder(ca.scooter.talkufy.views.Holders.MyVideoMsgHolder holder, ca.scooter.talkufy.models.Models.MessageModel model, java.lang.String messageID) {
    }
    
    private final void setTargetImageHolder(ca.scooter.talkufy.views.Holders.TargetImageMsgHolder holder, ca.scooter.talkufy.models.Models.MessageModel model, java.lang.String messageID) {
    }
    
    private final void setTargetVideoHolder(ca.scooter.talkufy.views.Holders.TargetVideoMsgHolder holder, ca.scooter.talkufy.models.Models.MessageModel model, java.lang.String messageID) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.graphics.drawable.Drawable getSelectedDrawable() {
        return null;
    }
    
    public final void setSelectedDrawable(@org.jetbrains.annotations.Nullable
    android.graphics.drawable.Drawable p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.graphics.drawable.Drawable getUnselectedDrawable() {
        return null;
    }
    
    public final void setUnselectedDrawable(@org.jetbrains.annotations.Nullable
    android.graphics.drawable.Drawable p0) {
    }
    
    public final boolean isTranslatorPressed() {
        return false;
    }
    
    public final void setTranslatorPressed(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.appcompat.view.ActionMode getActionMode() {
        return null;
    }
    
    public final void setActionMode(@org.jetbrains.annotations.Nullable
    androidx.appcompat.view.ActionMode p0) {
    }
    
    private final void setContextualToolbarOnViewHolder(android.view.View itemView, java.lang.String messageID, ca.scooter.talkufy.models.Models.MessageModel model, int position) {
    }
    
    private final android.graphics.Typeface getFont(androidx.appcompat.view.ActionMode.Callback callback, int helveticaRegular) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void translateMessage(android.view.View itemView, ca.scooter.talkufy.models.Models.MessageModel model) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void onTranslatorDownloaded(android.view.View itemView, ca.scooter.talkufy.models.Models.MessageModel model, com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator firebaseTranslator, java.lang.String languageName) {
    }
    
    public final boolean isContextMenuActive() {
        return false;
    }
    
    public final void setContextMenuActive(boolean p0) {
    }
    
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    @java.lang.Override
    public void onBackPressed() {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
        return false;
    }
    
    public final int getSearchPosition() {
        return 0;
    }
    
    public final void setSearchPosition(int p0) {
    }
    
    private final void setSearchView(androidx.appcompat.widget.SearchView searchView) {
    }
    
    private final android.graphics.Typeface getFont(androidx.appcompat.widget.SearchView.OnQueryTextListener callback, int helveticaRegular) {
        return null;
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void hasTargetInitiatedCallAlready(java.lang.String callId, boolean audioOnly) {
    }
    
    private final void startNewCall(java.lang.String callId, boolean audioOnly, java.lang.String targetPhone) {
    }
    
    private final void saveBitmapFromPicasso(java.lang.String url, java.lang.String messageID, boolean isSent) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setScrollingListener() {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void deleteSelectedMessages(androidx.appcompat.view.ActionMode actionMode) {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void loadGroupMembers() {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private final void loadChannelMembers() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void bindSmartReply() {
    }
    
    public final boolean isMenuHidden() {
        return false;
    }
    
    public final void setMenuHidden(boolean p0) {
    }
    
    private final void hideRevealView() {
    }
    
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    private final void animateAttachmentMenu() {
    }
}
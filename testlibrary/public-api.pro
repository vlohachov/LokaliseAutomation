-keep class com.example.testlibrary.HomeActivity {
    <init>();
    protected void onCreate(android.os.Bundle);
}
-keep class com.example.testlibrary.HomeActivityKt {
    public static void DefaultPreview();
    public static void Greeting(java.lang.String);
}
-keep class com.example.testlibrary.ui.theme.ColorKt {
    public static long getPink40();
    public static long getPink80();
    public static long getPurple40();
    public static long getPurple80();
    public static long getPurpleGrey40();
    public static long getPurpleGrey80();
}
-keep class com.example.testlibrary.ui.theme.ThemeKt {
    public static void LokaliseAutomationTheme(boolean, boolean, kotlin.jvm.functions.Function0);
}
-keep class com.example.testlibrary.ui.theme.TypeKt {
    public static androidx.compose.material3.Typography getTypography();
}

# Launcher3
Android 8.0 Launcher3 的源代码


### 修改记录
---
- gradle 和 protobuf 插件升级
``` gradle
   classpath 'com.android.tools.build:gradle:3.0.0'
   classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.2'
```
- 修改gradle文件中的 applicationId
``` gradle
   applicationId 'com.my.launcher3'
   testApplicationId 'com.my.launcher3.tests'
```
- 和系统原有的Launcher3的自定b义权限冲突，检测&ensp;```AndroidManifest.xml```&ensp;文件把&ensp;```permission```&ensp;节点中含有&ensp;```com.android.launcher3```&ensp;字符串的修改为&ensp;```com.my.launcher3```&ensp;

- 修改LauncherProvider的authorities 为：
``` xml
    android:authorities="com.my.launcher3.settings"
    android:writePermission="com.my.launcher3.permission.WRITE_SETTINGS"
    android:readPermission="com.my.launcher3.permission.READ_SETTINGS"
```
&emsp;并修改```com.android.launcher3.config.ProviderConfig```类中的
```
public static final String AUTHORITY = "com.my.launcher3.settings".intern();
```

- 异常```Error:Error: Expected resource of type animator [ResourceType]```<br> 把```res\anim\discovery_bounce.xml```移动```res\animator\```中去 并修改```R.anim``` 为```R.animator```

- 异常
```
    java.lang.IllegalArgumentException: width and height must be > 0:
    at com.android.launcher3.badge.BadgeRenderer$IconDrawer.<init>(BadgeRenderer.java:167)
    at com.android.launcher3.badge.BadgeRenderer.<init>(BadgeRenderer.java:77)
    at com.android.launcher3.DeviceProfile.<init>(DeviceProfile.java:216)
    at com.android.launcher3.InvariantDeviceProfile.<init>(InvariantDeviceProfile.java:174)
    at com.android.launcher3.LauncherAppState.<init>(LauncherAppState.java:93)
    at com.android.launcher3.LauncherAppState.getInstance(LauncherAppState.java:55)
    at com.android.launcher3.Launcher.onCreate(Launcher.java:364)
```
这个问题是命名空间&ensp;```xmlns:launcher="http://schemas.android.com/apk/res-auto/com.android.launcher3"```&ensp;导致读取```device_profiles.xml```资源失败, 把命名空间里的url换成```http://schemas.android.com/apk/res-auto```即可。相应其它使用xmlns的地方可能也存在这个问题

- 异常 "查询快捷方式失败"
```
    Failed to query for shortcuts
    java.lang.SecurityException: Caller can't access shortcut information
    at com.android.launcher3.shortcuts.DeepShortcutManager.query(DeepShortcutManager.java:216)
    at com.android.launcher3.shortcuts.DeepShortcutManager.queryForPinnedShortcuts(DeepShortcutManager.java:182)
    at com.android.launcher3.LauncherModel$LoaderTask.loadWorkspace(LauncherModel.java:883)
    at com.android.launcher3.LauncherModel$LoaderTask.run(LauncherModel.java:704)
```
这是Android定义了必须是默认桌面才有权限获取所有应用的Shortcuts信息。解决方法是在桌面按Home键，然后选择我们自己的Luancher3作为默认桌面(点击“始终”按钮)。接下来你看到的就是自己的Luancher3了，以为我是用虚拟机运行的，所以看到的桌面和原来的没有区别。这时我们临时修改SearchBar上面的文字（“搜索”变为“Google搜索”即可. strings.xml 的```abandoned_search```）




<br/>

### 定制修改
---
- 配置桌面搜索框（QSB）
```
FeatureFlags.java

    QSB_ON_FIRST_SCREEN = false // 搜索框开启按钮
    PULLDOWN_SEARCH = false // 第一屏是否支持下拉进入搜索动作
    
    
```

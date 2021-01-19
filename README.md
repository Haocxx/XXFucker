# XXFucker
使用代码插桩，复刻一个做IOC操作的库。

## 使用场景
如demoApp，现有工程模块依赖关系如下：
```
graph TB
    app-->testLib1
    app-->testLib2
    app-->testLib3
    testLib1-->base
    testLib2-->base
    testLib3-->base
```
现在三个testLib中都有一个Execute.doSomething静态方法，希望在base中有一个收口方法，调用该收口方法即可调用所有的testLib中的Execute.doSomething。

由于收口方法希望放在下层，因此base无法直接引用调用到这些方法。

思路：使用代码插桩，把所有testLib中的Execute.doSomething方法调用插入到base模块中的一个收口方法TestIOC.executeAll中。

原本**TestIOC.executeAll调用所有testLib的Execute.doSomething**，变为**所有testLib的Execute.doSomething的调用被注入TestIOC.executeAll中**，这就是控制反转(IOC)在这里的应用。

## 集成方法
### 集成gradle-plugin
1.将XXFucker项目根目录下的buildCache复制到自己的工程根目录下

2.在工程根目录的build.gradle中添加
```gradle
buildscript {
    repositories {
        ........
        maven {
            url new File(rootProject.projectDir, "buildCache/plugin").toURI()
        }
        
        ........
    }
    dependencies {
        .......
        //plugin
        classpath 'com.haocxx:xxfucker:1.0.0'
    }
}

allprojects {
    repositories {
        ........
        maven {
            url new File(rootProject.projectDir, "buildCache/plugin").toURI()
        }
        ........
        
    }
}
```
3.在工程主Module的build.gradle中添加
```gradle
........
apply plugin: 'com.haocxx.xxfucker'
........
```
4.在需要使用XXFucker的Module目录下的build.gradle中添加
```
dependencies {
    ........
    implementation 'com.haocxx:xxfucker-annotation:1.0.0'
    ........
}
```
## 使用方法
1.声明收口的，需要被插入指令到方法体中的静态方法。为收口静态方法所在的类添加@Bitch注解，填入name字符串作为该Bitch类的唯一标识。然后为被注入的静态方法添加@Vagina注解，讲该方法声明为Vagina方法。**每个Bitch类只能有一个Vagina方法，且Vagina方法必须为静态方法。**
```Java
@Bitch(name =TestIOC.NAME)
public class TestIOC {
  public final static String NAME = "com.haocxx.base.TestIOC";

  @Vagina
  public static void executeAll() {
    // something will be there while compile
  }
}
```
2.标记需要被收口方法调用的静态方法。为该静态方法所在的类添加@Fucker注解，为方法添加@Semen注解，bitchName即为目标收口Bitch类的name。
```Java
@Fucker
public class Execute1 {
  private final static String TAG = "Execute1";

  @Semen(bitchName = TestIOC.NAME)
  public static void doSomething() {
    Log.d(TAG, "it works.");
  }
}

......

@Fucker
public class Execute2 {
  private final static String TAG = "Execute2";

  @Semen(bitchName = TestIOC.NAME)
  public static void doSomething() {
    Log.d(TAG, "it works.");
  }
}

......

@Fucker
public class Execute3 {
  private final static String TAG = "Execute3";

  @Semen(bitchName = TestIOC.NAME)
  public static void doSomething() {
    Log.d(TAG, "it works.");
  }
}
```
3.此时调用收口Vagina方法，即可调用所有的Semen方法。
```Java
public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    TestIOC.executeAll();
  }
}
```
```
2021-01-19 14:08:26.756 25226-25226/com.haocxx.xxfucker D/Execute1: it works.
2021-01-19 14:08:26.756 25226-25226/com.haocxx.xxfucker D/Execute2: it works.
2021-01-19 14:08:26.756 25226-25226/com.haocxx.xxfucker D/Execute3: it works.
```
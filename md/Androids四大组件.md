===
###
# Android四大组件
## Activity
* 1.生命周期（// TODO 附带fragment）
    * onCreate 创建
    * onStart 界面可见
    * onResume 位于前端，焦点
    
    * onPause 失去焦点
    * onStop 不可见
    * onDestroy 销毁
- A 切换到 B  // 页面失去焦点，等一个页面可见
    * A.onPause
    * B.onCreate onStart onResume
    * A.onStop

* 2.四种启动模式
- standard 标准
- singleTop 栈顶复用
    Activity位于栈顶部时复用，调用onNewIntent方法，可用于从通知栏音乐进入App这类场景。
- singleTask 栈内复用
    栈内已经有就复用，复用时会销毁中间的Activity,用于详情页，浏览器标签页这类场景。
- singleInstance 独立栈
    独立的栈，按返回时可不返回本应用的其他页面，适用于快捷功能，地图软件的地铁图这类场景。
    
* 3.



***
## Service 后台服务
* 1.两种启动模式
- context.startService() 
    * onCreate 只执行一次
    * onStartCommend 重复 start不会重启onCreate，会多次执行onStartCommend。
- context.bindService() context.unbindService() 
    * onCreate
    * onBind
    * onUnBind
    * onDestroy
- 音乐类软件会两种方式混合使用，先start，再bind，对音乐进行控制，退出后还可以后台播放。
 
* 2.通信方式
    - IBinder对象 用ServiceConnection,bindService的方式拿到对象，可以调用Service里的方法。
    - AIDL： 跨进程时使用，传递基本参数和序列号参数，比如Android系统的音量等。
    
## ContentProvider 内容提供者，用数据库共享数据

## BroadcastReceiver 广播接收者，接收广播来达到通信的目的

- 静态注册广播接收者
    * 在清单文件中注册，例如开机广播android.intent.action.BOOT_COMPLETED（这个还需要申请权限android.permission.RECEIVE_BOOT_COMPLETED）
    * 在onRecive中接受
    * 获取传递的参数（基本类型，序列化的数据）
- 动态注册广播接收者
    * 在代码中注册，context.register(),设置action，例如在Activity中接受某些任务完成，屏幕锁定等
    * 在不需要的时候注销,onDesotry中，context.unregister
- adb测试广播
    * 通过adb 发送广播进行测试，曾经在项目中使用这种方式开启、关闭日志打印；
    ```
     adb shell am broadcast -a wind.action --es string "asdfasdf"
    ```
- //TODO 权限 exported属性 
 // 有序、无序广播
 
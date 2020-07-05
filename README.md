# 死机蓝  
用于恶搞的模仿Windows死机蓝色界面，UI基于Java Swing  

## 说明
程序首先判断操作系统版本，如果系统版本为 Windows 8、Windows 8.1、Windows 10则全屏展示新的死机界面，否则展示旧死机界面。  
通过线程控制，随机增加进度，当进度达到100后，重启Windows。  
为了恶搞的目的，添加了键盘事件，即任何触碰键盘将直接触发重启Windows。  
![旧界面](/imgs/old.png)  
![新界面](/imgs/new.png)  

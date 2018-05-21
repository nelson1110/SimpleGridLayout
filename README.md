# SimpleGridLayout
用途：根据指定的列数对子view们按顺序布局

##用法
###Step1. 继承SimpleGridLayoutAdapter
```java
        class SimpleGridLayoutAdapter extends SimpleGridLayout.SimpleGridLayoutAdapter
```
###Step2. 实现方法
```java
        //指定列数
        public abstract int getItemColumns();
        //准备要显示的view们
        public abstract List<View> getItemViews(Context context);
       
```
###Step3. setAdapter
```java
        grid.setAdapter(adapter)
```
###其他设置
* 指定某个item跨过的列数，可以是小数，但是要保证那一行的总列数不超过上面设定的列数，否则会有部分item显示不全,不写的话默认为1
```java
        @Override
        public int getItemWeight(int position) {
            return 1;
        }
```
* 如果adapter内数据发生变化可以手动通知Layout进行重新布局
```java
        //调用一下这个就可以了
        notifyDataSetChanged()
```



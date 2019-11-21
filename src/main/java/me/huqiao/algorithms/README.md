# 设计原则
越简单越好。


# 环形数组队列 
既然是环形数组队列，那么关键点还是这个环形。即，随着出队的操作，数组头部前方的位置空出了位置，当数组尾部满了之后，队列的尾部会跑到数组的前面去。

我们需要两个变量来存储队列的头部（front）和尾部（rear）。rear永远指向最后一个元素的下一个位置。这个下一个位置就比较特别了。有的实现中，会故意将数组中留一个空白位置，来表示队列尾部和头部之间的间隔。

这种方式中，rear永远不会等于front。（即使循环一圈转回来之后，rear永远不会超过front。）带来的好处是，我们可以通过front和rear是否相等，来判断队列是否是空的。

不留间隔时，队列满的时候，rear就等于front了。


也就是说，队列满和队列空的时候，front和rear都是相等的。

我们会发现，在算法设计中，这种微妙的差别无处不在。因此处理好一些临界关系，非常重要！

我觉得，在循环数组队列的实现中。完全没必要留这个空白。因为队列的空或者满根本不需要通过rear和front来判断。

增加一个变量size来记录队列的大小。当入队(enqueue)时size++、出队(dequeue)时size--。这样，队列的是否空、是否满、大小的计算就非常方便了：
```java
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size >= arraySize;  //arraySize表示实际数组的length
    }

    public int size(){
        return size;
    }
```
入队，取模预算可以将递增的变量front限制在一个范围以内：
```java
    public void enqueue(T t){
        if(isFull()){
            growUp();
        }
        elements[rear] = t;
        rear++;
        rear = rear % arraySize;
        size++;
    }
```
要知道，队列的内容已经可能不是数组原始的内容了：
```java
    /**
     * 以队列的顺序（而不是数组的原始顺序）输出
     * @return
     */
    public T[] toArray(){
        T[] res = (T[])new Object[size];
        int i = front;
        int index = 0;
        while(i!=rear){
            res[index++] = (T)elements[i];
            i++;
            i = i % arraySize;
        }
        return res;
    }
```
数组的动态增长：新建一个更大的数组很容易，但是在拷贝数据时，可得注意元素的顺序了，不能按数组的原始顺序拷贝！
```java
    /**
     * 生成新的数组，并将原数组中的数据以队列的顺序移动到新数组中
     */
    private void growUp(){
        int newArraySize = arraySize * 2 + 1;
        Object[] newElements = new Object[newArraySize];
        int index = 0;
        for(T t : toArray()) {
            newElements[index] = elements[index];
            index++;
        }
        System.out.println(String.format("grow up from %d to %d",elements.length,newElements.length));
        rear = index;
        front = 0;
        elements = newElements;
        arraySize = elements.length;
    }
```
要想写出一个产品级的基础组件，还要考虑哪些？

* 动态增长时，如何保证线程安全？
* jdk源码中的数组是怎么增长的？
* jdk源码中的`isFull`是怎么判断的? 是用`>=`判断，还是用`==`？ 答案：`==`
* 初始数组和数组的增长

从ArrayList的源码中能看到：

* 允许数组大小为0：这样也可以防止多余数组的创建
* 数组大小是0是，不会重新`new Object[0]`，而是引用已经准备好的`static final`类型的空数组。这样可以防止没必要的空数组的创建。
* 第一次增长，直接增长到10。之后是x2的方式增长。在特殊场景，比如需要一次性往ArrayList中增加大量数据是，可以通过`ensureCapacity`方法来指定一个容量，这样可以防止数组多次缓慢增长。
* 线程安全：ArrayList本身并不是线程安全的，它在复制原始数组时，并没有做任何同步防护。Vector是线程安全的，它的防护方式也非常粗暴，直接在`add`、`remove`的方法上增加`synchronized`。
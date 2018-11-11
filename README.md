# udf_example
#### 自定义函数步骤

- 继承类 UDF 并重载其 evaluate 方法

- 打包成 jar 包

- add jar  /xxx.jar  添加到hive的环境变量中

- 给自定义函数注册名字

  ```
  create temporary function itcastfunc as 'cn.itcast.hive.udf.ItcastUDF';
  ```

  自定义是临时函数  只在session内有效 断开连接之后 需要重新注册关联。

#### Transform 实现（了解）    

Hive 的 TRANSFORM 关键字提供了在 SQL 中调用自写脚本的功能 

适合实现 Hive 中没有的功能又不想写 UDF 的情况    

使用示例 1： 下面这句 sql 就是借用了 weekday_mapper.py 对数据进行了处理.    

```
add FILE weekday_mapper.py;

INSERT OVERWRITE TABLE u_data_new
SELECT
	TRANSFORM (movieid , rate, timestring,uid)
	USING 'python weekday_mapper.py'
	AS (movieid, rating, weekday,userid)
FROM t_rating;
```

其中 weekday_mapper.py 内容如下    

```
#!/bin/python
import sys
import datetime

for line in sys.stdin:
	line = line.strip()
	movieid, rating, unixtime,userid = line.split('\t')
	weekday = datetime.datetime.fromtimestamp(float(unixtime)).isoweekday()
	print '\t'.join([movieid, rating, str(weekday),userid])
```


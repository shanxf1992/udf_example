# udf_example
自定义函数步骤

- 继承类 UDF 并重载其 evaluate 方法

- 打包成 jar 包

- add jar  /xxx.jar  添加到hive的环境变量中

- 给自定义函数注册名字

  ```
  create temporary function itcastfunc as 'cn.itcast.hive.udf.ItcastUDF';
  ```

  自定义是临时函数  只在session内有效 断开连接之后 需要重新注册关联。


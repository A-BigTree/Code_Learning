// 创建对象
var obj01 = {};
// 给对象设置属性和属性值
obj01.stuName = "tom";
obj01.stuAge = 20;
obj01.stuSubject = "java";
obj01.study = function() {
  console.log(this.stuName + " is studying");
};
// 在控制台输出对象
console.log(obj01);
// 调用函数
obj01.study();

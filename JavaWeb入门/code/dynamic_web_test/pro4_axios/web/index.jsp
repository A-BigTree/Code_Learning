<%--
  Created by IntelliJ IDEA.
  User: Top.0
  Date: 2023/3/28
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Axios Test</title>
  </head>
  <body>
  <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

  <div id="app">
    <button @click="commonParam">普通请求参数</button>
  </div>

  <script>
    const { createApp } = Vue
    const app = createApp({
      data(){},
      methods:{
        commonParam:function (){
          axios({
            method:"post",
            url:"/pro4_axios/AjaxServlet?method=commonParam",
            data: {
              userName: "tom",
              userPwd: "123456"
            }
          }).then(function (response){
            console.log(response);
          }).catch(function (error){
            console.log(error);
          });
        }
      }
    });
    app.mount("#app");
  </script>
  </body>
</html>

<template>
  <div class="bg">
    <el-form :rules="rules" class="login-container" label-position="left" ref="loginForm"
             label-width="70px" v-loading="loading" :model="loginForm">
      <h3 class="login_title">系统登录</h3>
      <el-form-item prop="username" label="账 号">
        <el-row>
          <el-col :span="20" style="margin-right: 5px">
            <el-input type="text" v-model.trim="loginForm.username"
                      auto-complete="off" placeholder="账号"></el-input>
          </el-col>
          <el-col :span="2">
            <el-button type="text" @click="clearUserName">清除</el-button>
          </el-col>
        </el-row>
      </el-form-item>
      <el-form-item prop="password" label="密 码">
        <el-row>
          <el-col :span="20" style="margin-right: 5px">
            <el-input type="password" v-model.trim="loginForm.password"
                      auto-complete="off" placeholder="密码"></el-input>
          </el-col>
          <el-col :span="2">
            <el-button type="text" @click="clearPassword">清除</el-button>
          </el-col>
        </el-row>
      </el-form-item>
      <el-form-item  prop="verify" label="验证码">
        <el-row>
          <el-col :span="10" style="margin-right: 5px">
            <el-input  v-model.trim="loginForm.verify" placeholder="验证码" type="" auto-complete="off">
            </el-input>
          </el-col>
          <el-col :span="10">
            <div class="verify-box" @click="refreshCode" onselectstart ='return false'>
              <Sidentify :identify-code="identifyCode" ref="identify">
              </Sidentify>
            </div>
          </el-col>
          <el-col :span="2">
            <el-button type="text" @click="clearIdentifyCode">清除</el-button>
          </el-col>
        </el-row>
      </el-form-item>

      <el-form-item style="width: 100%">
        <el-button type="primary" style="width: 100%" @click="submitClick">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
  export default {
    components:{
      Sidentify
    },
    data() {

    },
    methods: {

    },
  }
</script>
<style>
  .bg {
    position: fixed;
    overflow: hidden;
    height: 100%;
    width: 100%;
    display: flex;
    background-size: cover;
    justify-content: center;
    align-items: center;
    background-repeat: no-repeat;
    background-image: url("../../static/img/bg.jpg");
    background-position: center 0;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    width: 400px;
    padding: 35px 45px 10px 25px;
    background: #fff;
    border: 1px solid #eaeaea;
    z-index: 5;
    box-shadow: 0 0 25px #cac6c6;
    background: rgba(150, 130, 120, 0.5);
    margin-left: 950px;
    margin-bottom: 100px;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
</style>

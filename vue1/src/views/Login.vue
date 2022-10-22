<!--&lt;!&ndash;<template>&ndash;&gt;-->
<!--&lt;!&ndash;  <div class="wrapper">&ndash;&gt;-->
<!--&lt;!&ndash;    <div style="margin:200px auto; backgroud-color:#fff; width:350px;height:300px;padding:20px;border-radius:10px">&ndash;&gt;-->
<!--&lt;!&ndash;      <div style="margin:20px 0;text-align:center; front-size:24px"><b>登录</b></div>&ndash;&gt;-->
<!--&lt;!&ndash;      <el-input size="medium" style="margin:10px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>&ndash;&gt;-->
<!--&lt;!&ndash;      <el-input size="medium" style="margin:10px 0" prefix-icon="el-icon-user" show-password v-model="user.password"></el-input>&ndash;&gt;-->
<!--&lt;!&ndash;      <div style="margin: 10px 0;text-align: right">&ndash;&gt;-->
<!--&lt;!&ndash;        <el-button type="primary" size="small" autocomplete="off"></el-button>&ndash;&gt;-->
<!--&lt;!&ndash;        <el-button type="warning" size="small" autocomplete="off"></el-button>&ndash;&gt;-->
<!--&lt;!&ndash;      </div>&ndash;&gt;-->
<!--&lt;!&ndash;    </div>&ndash;&gt;-->
<!--&lt;!&ndash;  </div>&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
<!--&lt;!&ndash;export default {&ndash;&gt;-->
<!--&lt;!&ndash;  name:"Login",&ndash;&gt;-->
<!--&lt;!&ndash;  data(){&ndash;&gt;-->
<!--&lt;!&ndash;    return{&ndash;&gt;-->
<!--&lt;!&ndash;      user:{}&ndash;&gt;-->
<!--&lt;!&ndash;    }&ndash;&gt;-->
<!--&lt;!&ndash;  }&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->

<!--&lt;!&ndash;<style>&ndash;&gt;-->
<!--&lt;!&ndash;.wrapper{&ndash;&gt;-->
<!--&lt;!&ndash;  height:100vh;&ndash;&gt;-->
<!--&lt;!&ndash;  background-image: linear-gradient(to bottom right,#FC566B,#3F5EFB);&ndash;&gt;-->
<!--&lt;!&ndash;  overflow: hidden;&ndash;&gt;-->
<!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->
<!--<template>-->
<!--  <div id="login">-->
<!--    &lt;!&ndash; 背景及不规则图形效果 &ndash;&gt;-->
<!--    <div id="particles-js">-->
<!--      <div class="sk-rotating-plane">-->
<!--      </div>-->
<!--    </div>-->
<!--    <div class="login-form-body">-->
<!--      <div class="login-form-title">-->
<!--        {{$t('userLoginL.loginPageName')}}-->
<!--      </div>-->
<!--      <div class="md-form-content">-->
<!--        <el-form-->
<!--            ref="loginForm"-->
<!--            class="login-form"-->
<!--            :model="loginData"-->
<!--            :rules="roleFormRules"-->
<!--        >-->
<!--          <el-row>-->
<!--            <el-col :span="24">-->
<!--              <el-form-item prop="username">-->
<!--                <el-input-->
<!--                    v-model="loginData.username"-->
<!--                    prefix-icon="el-icon-user"-->
<!--                    :placeholder="$t('userLoginL.userName')"-->
<!--                    clearable-->
<!--                ></el-input>-->
<!--              </el-form-item>-->
<!--            </el-col>-->
<!--          </el-row>-->
<!--          <el-row>-->
<!--            <el-col :span="24">-->
<!--              <el-form-item prop="password">-->
<!--                <el-input-->
<!--                    v-model="loginData.password"-->
<!--                    prefix-icon="el-icon-lock"-->
<!--                    :type="isShowPass"-->
<!--                    :placeholder="$t('userLoginL.passWord')"-->
<!--                    @input="changeText($event)"-->
<!--                >-->
<!--                  <i-->
<!--                      slot="suffix"-->
<!--                      :title="$t('login.showPass')"-->
<!--                      @click="changePass('show')"-->
<!--                      style="cursor:pointer;"-->
<!--                      class="el-input__icon iconfont icon-showPass"-->
<!--                      v-if="showBtn&&showPass&&(isShowPass=='password')"-->
<!--                  ></i>-->
<!--                  <i-->
<!--                      slot="suffix"-->
<!--                      :title="$t('login.hidePass')"-->
<!--                      @click="changePass('hide')"-->
<!--                      style="cursor:pointer;"-->
<!--                      class="el-input__icon iconfont icon-hidePass"-->
<!--                      v-if="showBtn&&hidePass&&(isShowPass=='text')"-->
<!--                  ></i>-->
<!--                </el-input>-->
<!--              </el-form-item>-->
<!--            </el-col>-->
<!--          </el-row>-->
<!--          <el-row>-->
<!--            <el-col :span="24" style="margin-bottom: 16px;">-->
<!--              <el-button-->
<!--                  class="login-btn"-->
<!--                  type="primary"-->
<!--                  @click="login(loginData)"-->
<!--                  :loading="isLogin"-->
<!--                  style="width:250px"-->
<!--              >{{$t('userLoginL.loginBtn')}}</el-button>-->
<!--            </el-col>-->
<!--          </el-row>-->
<!--        </el-form>-->
<!--      </div>-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->
<!--<script>-->
<!--import {initLoginPic} from '../../../public/static/loginPic/js/initParticles'-->
<!--export default {-->
<!--  name: "login",-->
<!--  data() {-->
<!--    return {-->
<!--      loginData:{},-->
<!--      isShowPass: "password",-->
<!--      showBtn: false,-->
<!--      showPass: false,-->
<!--      hidePass: false,-->
<!--      isLogin: false,-->
<!--      roleFormRules: {-->
<!--        username: [-->
<!--          {-->
<!--            required: true,-->
<!--            message: "用户名称不能为空",-->
<!--            trigger: "blur"-->
<!--          }-->
<!--        ],-->
<!--        password:[-->
<!--          {-->
<!--            required: true,-->
<!--            message: "用户密码不能为空",-->
<!--            trigger: "blur"-->
<!--          }-->
<!--        ]-->
<!--      },-->
<!--    };-->
<!--  },-->
<!--  mounted() {-->
<!--    /*-->
<!--    * 背景效果-->
<!--    * */-->
<!--    initLoginPic("particles-js");-->
<!--  },-->
<!--  methods: {-->
<!--    /**-->
<!--     * 监听密码输入框是否输入-->
<!--     */-->
<!--    changeText(event) {-->
<!--      let that = this;-->
<!--      that.showPass = true;-->
<!--      that.hidePass = true;-->
<!--      if (event === "") {-->
<!--        that.showBtn = false;-->
<!--      } else {-->
<!--        that.showBtn = true;-->
<!--      }-->
<!--    },-->
<!--    /**-->
<!--     * 显示或隐藏密码-->
<!--     */-->
<!--    changePass(isShow) {-->
<!--      let that = this;-->
<!--      if (isShow === "show") {-->
<!--        that.hidePass = true;-->
<!--        that.isShowPass = "text";-->
<!--      } else {-->
<!--        that.showPass = true;-->
<!--        that.isShowPass = "password";-->
<!--      }-->
<!--    },-->
<!--    /**-->
<!--     * 登录-->
<!--     * @method login-->
<!--     * @param {Object} data-->
<!--     */-->
<!--    login(data) {-->
<!--      this.$refs.loginForm.validate(valid => {-->
<!--        if(valid){-->
<!--          this.$router.push({-->
<!--            path:"/index"-->
<!--          });-->
<!--          console.log(data)-->
<!--        }else {-->
<!--          console.log("s")-->
<!--        }-->
<!--      })-->
<!--    }-->
<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped lang="scss">-->
<!--$shadow_color: #719e9c;-->
<!--$form_bg: #5c868f33;-->
<!--#login {-->
<!--  width: 100%;-->
<!--  height: 100%;-->
<!--  background: url("../../../public/static/assets/images/bg.jpg") fixed center center no-repeat;-->
<!--  background-size: cover;-->
<!--  background-position: center;-->
<!--  position: relative;-->
<!--  .login-form-body{-->
<!--    padding:20px 15px;-->
<!--    width: 20%;-->
<!--    height: 40%;-->
<!--    float: right;-->
<!--    position: absolute;-->
<!--    background: $form_bg;-->
<!--    border: 1px solid #374f50;-->
<!--    border-radius:5px;-->
<!--    opacity: .8;-->
<!--    box-shadow:inset -2px 0 3px $shadow_color, inset 0 -2px 3px $shadow_color, inset 2px 0px 3px $shadow_color, inset 0 2px 3px $shadow_color;-->
<!--    right: 10%;-->
<!--    top: 38%;-->
<!--    >.login-form-title{-->
<!--      padding:0 15px;-->
<!--      height: 50px;-->
<!--      /*background: aqua;*/-->
<!--      margin:15px 0;-->
<!--      text-align: center;-->
<!--      color: aliceblue;-->
<!--      font-size: 16px;-->
<!--    }-->
<!--    .md-form-content{-->
<!--      margin-top: 10px;-->
<!--      height: calc(100% - 100px);-->
<!--    }-->
<!--  }-->
<!--  // css3炫酷登录页效果样式-->
<!--  #particles-js {-->
<!--    width: 100%;-->
<!--    height: 100%;-->
<!--    position: absolute;-->
<!--    background-size: 100% 100%;-->
<!--  }-->

<!--  .sk-rotating-plane {-->
<!--    display: none;-->
<!--    width: 80px;-->
<!--    height: 80px;-->
<!--    margin: auto;-->
<!--    background-color: white;-->
<!--    -webkit-animation: sk-rotating-plane 1.2s infinite ease-in-out;-->
<!--    animation: sk-rotating-plane 1.2s infinite ease-in-out;-->
<!--    z-index: 1;-->
<!--    position: absolute;-->
<!--    top: 50%;-->
<!--    left: 50%;-->
<!--    margin-left: -40px;-->
<!--    margin-top: -80px;-->
<!--  }-->
<!--  .sk-rotating-plane.active {-->
<!--    display: block;-->
<!--  }-->

<!--  @keyframes sk-rotating-plane {-->
<!--    0% {-->
<!--      -webkit-transform: perspective(120px) rotateX(0deg) rotateY(0deg);-->
<!--      transform: perspective(120px) rotateX(0deg) rotateY(0deg);-->
<!--    }-->
<!--    50% {-->
<!--      -webkit-transform: perspective(120px) rotateX(-180.1deg) rotateY(0deg);-->
<!--      transform: perspective(120px) rotateX(-180.1deg) rotateY(0deg);-->
<!--    }-->
<!--    100% {-->
<!--      -webkit-transform: perspective(120px) rotateX(-180deg) rotateY(-179.9deg);-->
<!--      transform: perspective(120px) rotateX(-180deg) rotateY(-179.9deg);-->
<!--    }-->
<!--  }-->
<!--  .login-btn{-->
<!--    background: #609696;-->
<!--    border-color: $shadow_color;-->
<!--  }-->
<!--  .el-input{-->
<!--    border: none;-->
<!--  }-->
<!--}-->
<!--</style>-->




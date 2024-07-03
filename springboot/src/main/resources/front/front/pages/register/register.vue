<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"100rpx 80rpx 120rpx","background":"url(http://codegen.caihongy.cn/20221227/38bdf285653f4e2580978aa4e42be204.gif) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20221227/589d8c6e0832418f9d0f7a67ce7103ca.jpg) no-repeat center top / 100% 100%","height":"100%"}'>
		<view :style='{"padding":"60rpx 60rpx","boxShadow":"0px 16rpx 0px #9595cf","borderColor":"#bbbbe1","borderRadius":"48rpx","background":"#ffffff","borderWidth":"0 0 16rpx","display":"block","width":"100%","borderStyle":"solid","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 40rpx auto","borderRadius":"8rpx","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xinlilaoshi'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.laoshizhanghao"  type="text"  class="uni-input" name="" placeholder="老师账号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xinlilaoshi'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xinlilaoshi'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xinlilaoshi'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.laoshixingming"  type="text"  class="uni-input" name="" placeholder="老师姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xinlilaoshi'" @tap="xinlilaoshitouxiangTap" class="">
                <view>请上传头像</view>
                <image :style='{"border":"2rpx solid #eee","padding":"0","margin":"0 0 0 0px","borderRadius":"16rpx","objectFit":"cover","display":"block","width":"200rpx","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"border":"2rpx solid #eee","padding":"0","margin":"0 0 0 0px","borderRadius":"16rpx","objectFit":"cover","display":"block","width":"200rpx","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"boxShadow":"0px 0px 0px #2c77cb","margin":"24rpx 0 24rpx 0","borderColor":"#eee","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xinlilaoshi'"  @change="xinlilaoshixingbieChange" :value="xinlilaoshixingbieIndex" :range="xinlilaoshixingbieOptions">
				<view :style='{"width":"100%","padding":"0 40rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#555"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<picker :style='{"boxShadow":"0px 0px 0px #2c77cb","margin":"24rpx 0 24rpx 0","borderColor":"#eee","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xinlilaoshi'"  @change="xinlilaoshishanzhanglingyuChange" :value="xinlilaoshishanzhanglingyuIndex" :range="xinlilaoshishanzhanglingyuOptions">
				<view :style='{"width":"100%","padding":"0 40rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#555"}' class="uni-input">{{ruleForm.shanzhanglingyu?ruleForm.shanzhanglingyu:"请选择擅长领域"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xinlilaoshi'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.lianxidianhua"  type="text"  class="uni-input" name="" placeholder="联系电话" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.xuehao"  type="text"  class="uni-input" name="" placeholder="学号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.xueshengxingming"  type="text"  class="uni-input" name="" placeholder="学生姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" @tap="xueshengtouxiangTap" class="">
                <view>请上传头像</view>
                <image :style='{"border":"2rpx solid #eee","padding":"0","margin":"0 0 0 0px","borderRadius":"16rpx","objectFit":"cover","display":"block","width":"200rpx","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"border":"2rpx solid #eee","padding":"0","margin":"0 0 0 0px","borderRadius":"16rpx","objectFit":"cover","display":"block","width":"200rpx","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"boxShadow":"0px 0px 0px #2c77cb","margin":"24rpx 0 24rpx 0","borderColor":"#eee","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='xuesheng'"  @change="xueshengxingbieChange" :value="xueshengxingbieIndex" :range="xueshengxingbieOptions">
				<view :style='{"width":"100%","padding":"0 40rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#555"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.nianling"  type="text"  class="uni-input" name="" placeholder="年龄" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.shoujihaoma"  type="text"  class="uni-input" name="" placeholder="手机号码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 40rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"padding":"0px 40rpx","boxShadow":"0px 0px 0px #2c77cb","margin":"0px","borderColor":"#eee","color":"#555","borderRadius":"16rpx","background":"#ececee","borderWidth":"0 0 2rpx","width":"100%","fontSize":"28rpx","borderStyle":"solid","height":"80rpx"}'  v-model="ruleForm.youxiang"  type="text"  class="uni-input" name="" placeholder="邮箱" />
			</view>
			<button :style='{"padding":"0px","boxShadow":"0px 0px 0px #82d1e8","margin":"60rpx auto 24rpx","borderColor":"#ef6d0d","color":"#fff","display":"block","borderRadius":"16rpx","background":"#5959d9","borderWidth":"0 0 0px","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
		</view>
	</view>
</view>
</template>

<script>
	export default {
		data() {
			return {
                xinlilaoshixingbieOptions: [],
                xinlilaoshixingbieIndex: 0,
                xinlilaoshishanzhanglingyuOptions: [],
                xinlilaoshishanzhanglingyuIndex: 0,
                xueshengxingbieOptions: [],
                xueshengxingbieIndex: 0,
				ruleForm: {
                laoshizhanghao: '',
                mima: '',
                laoshixingming: '',
                touxiang: '',
                xingbie: '',
                shanzhanglingyu: '',
                lianxidianhua: '',
                gerenjianjie: '',
                xuehao: '',
                mima: '',
                xueshengxingming: '',
                touxiang: '',
                xingbie: '',
                nianling: '',
                shoujihaoma: '',
                youxiang: '',
				},
				tableName:""
			}
		},
        computed: {
            baseUrl() {
                return this.$base.url;
            }
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='xinlilaoshi'){
                this.xinlilaoshixingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.xinlilaoshixingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='xinlilaoshi'){
                this.xinlilaoshishanzhanglingyuOptions = "情感,学习,心理,其他".split(',');
				this.ruleForm.shanzhanglingyu=this.xinlilaoshishanzhanglingyuOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='xuesheng'){
                this.xueshengxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.xueshengxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            xinlilaoshitouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            xinlilaoshixingbieChange(e) {
                    this.xinlilaoshixingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.xinlilaoshixingbieOptions[this.xinlilaoshixingbieIndex]
            },
            // 下拉变化
            xinlilaoshishanzhanglingyuChange(e) {
                    this.xinlilaoshishanzhanglingyuIndex = e.target.value
                    this.ruleForm.shanzhanglingyu = this.xinlilaoshishanzhanglingyuOptions[this.xinlilaoshishanzhanglingyuIndex]
            },
            xueshengtouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            xueshengxingbieChange(e) {
                    this.xueshengxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.xueshengxingbieOptions[this.xueshengxingbieIndex]
            },
            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				if((!this.ruleForm.laoshizhanghao) && `xinlilaoshi` == this.tableName){
					this.$utils.msg(`老师账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `xinlilaoshi` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`xinlilaoshi` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.laoshixingming) && `xinlilaoshi` == this.tableName){
					this.$utils.msg(`老师姓名不能为空`);
					return
				}
				if(`xinlilaoshi` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if((!this.ruleForm.xuehao) && `xuesheng` == this.tableName){
					this.$utils.msg(`学号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `xuesheng` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`xuesheng` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.xueshengxingming) && `xuesheng` == this.tableName){
					this.$utils.msg(`学生姓名不能为空`);
					return
				}
				if(`xuesheng` == this.tableName && this.ruleForm.shoujihaoma&&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
					this.$utils.msg(`手机号码应输入手机格式`);
					return
				}
				if(`xuesheng` == this.tableName && this.ruleForm.youxiang&&(!this.$validate.isEmail(this.ruleForm.youxiang))){
					this.$utils.msg(`邮箱应输入邮件格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>

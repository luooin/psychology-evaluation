(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-xuesheng-add-or-update"],{"0a7e":function(e,r,i){var t=i("24fb");r=t(!1),r.push([e.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.content[data-v-1a1a206e]{min-height:calc(100vh - 44px);box-sizing:border-box}',""]),e.exports=r},1304:function(e,r,i){"use strict";var t=i("4ea4");Object.defineProperty(r,"__esModule",{value:!0}),r.default=void 0,i("a481"),i("c5f6"),i("f559"),i("ac6a"),i("28a5"),i("96cf");var n=t(i("3b8d")),a=t(i("e2b1")),o=t(i("064f")),s={data:function(){return{cross:"",ruleForm:{xuehao:"",mima:"",xueshengxingming:"",touxiang:"",xingbie:"",nianling:"",shoujihaoma:"",youxiang:""},xingbieOptions:[],xingbieIndex:0,user:{},ro:{xuehao:!1,mima:!1,xueshengxingming:!1,touxiang:!1,xingbie:!1,nianling:!1,shoujihaoma:!1,youxiang:!1}}},components:{wPicker:a.default,xiaEditor:o.default},computed:{baseUrl:function(){return this.$base.url}},onLoad:function(){var e=(0,n.default)(regeneratorRuntime.mark((function e(r){var i,t,n,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return i=uni.getStorageSync("nowTable"),e.next=3,this.$api.session(i);case 3:if(t=e.sent,this.user=t.data,this.xingbieOptions="男,女".split(","),this.ruleForm.userid=uni.getStorageSync("userid"),r.refid&&(this.ruleForm.refid=r.refid,this.ruleForm.nickname=uni.getStorageSync("nickname")),!r.id){e.next=14;break}return this.ruleForm.id=r.id,e.next=12,this.$api.info("xuesheng",this.ruleForm.id);case 12:t=e.sent,this.ruleForm=t.data;case 14:if(this.cross=r.cross,!r.cross){e.next=54;break}n=uni.getStorageSync("crossObj"),e.t0=regeneratorRuntime.keys(n);case 18:if((e.t1=e.t0()).done){e.next=54;break}if(a=e.t1.value,"xuehao"!=a){e.next=24;break}return this.ruleForm.xuehao=n[a],this.ro.xuehao=!0,e.abrupt("continue",18);case 24:if("mima"!=a){e.next=28;break}return this.ruleForm.mima=n[a],this.ro.mima=!0,e.abrupt("continue",18);case 28:if("xueshengxingming"!=a){e.next=32;break}return this.ruleForm.xueshengxingming=n[a],this.ro.xueshengxingming=!0,e.abrupt("continue",18);case 32:if("touxiang"!=a){e.next=36;break}return this.ruleForm.touxiang=n[a].split(",")[0],this.ro.touxiang=!0,e.abrupt("continue",18);case 36:if("xingbie"!=a){e.next=40;break}return this.ruleForm.xingbie=n[a],this.ro.xingbie=!0,e.abrupt("continue",18);case 40:if("nianling"!=a){e.next=44;break}return this.ruleForm.nianling=n[a],this.ro.nianling=!0,e.abrupt("continue",18);case 44:if("shoujihaoma"!=a){e.next=48;break}return this.ruleForm.shoujihaoma=n[a],this.ro.shoujihaoma=!0,e.abrupt("continue",18);case 48:if("youxiang"!=a){e.next=52;break}return this.ruleForm.youxiang=n[a],this.ro.youxiang=!0,e.abrupt("continue",18);case 52:e.next=18;break;case 54:this.styleChange();case 55:case"end":return e.stop()}}),e,this)})));function r(r){return e.apply(this,arguments)}return r}(),methods:{styleChange:function(){this.$nextTick((function(){}))},xingbieChange:function(e){this.xingbieIndex=e.target.value,this.ruleForm.xingbie=this.xingbieOptions[this.xingbieIndex]},touxiangTap:function(){var e=this;this.$api.upload((function(r){e.ruleForm.touxiang="upload/"+r.file,e.$forceUpdate(),e.$nextTick((function(){e.styleChange()}))}))},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var e=(0,n.default)(regeneratorRuntime.mark((function e(){var r,i,t,n,a,o,s,u,d,x;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(this.ruleForm.xuehao){e.next=3;break}return this.$utils.msg("学号不能为空"),e.abrupt("return");case 3:if(this.ruleForm.mima){e.next=6;break}return this.$utils.msg("密码不能为空"),e.abrupt("return");case 6:if(this.ruleForm.xueshengxingming){e.next=9;break}return this.$utils.msg("学生姓名不能为空"),e.abrupt("return");case 9:if(!this.ruleForm.shoujihaoma||this.$validate.isMobile(this.ruleForm.shoujihaoma)){e.next=12;break}return this.$utils.msg("手机号码应输入手机格式"),e.abrupt("return");case 12:if(!this.ruleForm.youxiang||this.$validate.isEmail(this.ruleForm.youxiang)){e.next=15;break}return this.$utils.msg("邮箱应输入邮件格式"),e.abrupt("return");case 15:if(!this.cross){e.next=31;break}if(a=uni.getStorageSync("statusColumnName"),o=uni.getStorageSync("statusColumnValue"),""==a){e.next=31;break}if(r||(r=uni.getStorageSync("crossObj")),a.startsWith("[")){e.next=27;break}for(s in r)s==a&&(r[s]=o);return u=uni.getStorageSync("crossTable"),e.next=25,this.$api.update("".concat(u),r);case 25:e.next=31;break;case 27:i=Number(uni.getStorageSync("userid")),t=r["id"],n=uni.getStorageSync("statusColumnName"),n=n.replace(/\[/,"").replace(/\]/,"");case 31:if(!t||!i){e.next=53;break}return this.ruleForm.crossuserid=i,this.ruleForm.crossrefid=t,d={page:1,limit:10,crossuserid:i,crossrefid:t},e.next=37,this.$api.list("xuesheng",d);case 37:if(x=e.sent,!(x.data.total>=n)){e.next=43;break}return this.$utils.msg(uni.getStorageSync("tips")),e.abrupt("return",!1);case 43:if(!this.ruleForm.id){e.next=48;break}return e.next=46,this.$api.update("xuesheng",this.ruleForm);case 46:e.next=50;break;case 48:return e.next=50,this.$api.add("xuesheng",this.ruleForm);case 50:this.$utils.msgBack("提交成功");case 51:e.next=61;break;case 53:if(!this.ruleForm.id){e.next=58;break}return e.next=56,this.$api.update("xuesheng",this.ruleForm);case 56:e.next=60;break;case 58:return e.next=60,this.$api.add("xuesheng",this.ruleForm);case 60:this.$utils.msgBack("提交成功");case 61:case"end":return e.stop()}}),e,this)})));function r(){return e.apply(this,arguments)}return r}(),optionsChange:function(e){this.index=e.target.value},bindDateChange:function(e){this.date=e.target.value},getDate:function(e){var r=new Date,i=r.getFullYear(),t=r.getMonth()+1,n=r.getDate();return"start"===e?i-=60:"end"===e&&(i+=2),t=t>9?t:"0"+t,n=n>9?n:"0"+n,"".concat(i,"-").concat(t,"-").concat(n)},toggleTab:function(e){this.$refs[e].show()}}};r.default=s},6602:function(e,r,i){"use strict";var t=i("cda9"),n=i.n(t);n.a},"992e":function(e,r,i){"use strict";var t,n=function(){var e=this,r=e.$createElement,i=e._self._c||r;return i("v-uni-view",{staticClass:"content"},[i("v-uni-view",{style:{minHeight:"100vh",padding:"0px",borderColor:"#21d5ae",background:"url(http://codegen.caihongy.cn/20221227/38bdf285653f4e2580978aa4e42be204.gif) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20221227/981928ff5e8b4de0bd3f18588ef6cb0f.png) fixed repeat center top,#959bd9",borderWidth:"0px 0 0",width:"100%",position:"relative",borderStyle:"dashed",height:"auto"}},[i("v-uni-form",{staticClass:"app-update-pv",style:{width:"100%",padding:"60rpx 40rpx",background:"none",height:"auto"}},[i("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("学号")]),i("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.xuehao,placeholder:"学号"},model:{value:e.ruleForm.xuehao,callback:function(r){e.$set(e.ruleForm,"xuehao",r)},expression:"ruleForm.xuehao"}})],1),i("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("密码")]),i("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.mima,placeholder:"密码"},model:{value:e.ruleForm.mima,callback:function(r){e.$set(e.ruleForm,"mima",r)},expression:"ruleForm.mima"}})],1),i("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("学生姓名")]),i("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.xueshengxingming,placeholder:"学生姓名"},model:{value:e.ruleForm.xueshengxingming,callback:function(r){e.$set(e.ruleForm,"xueshengxingming",r)},expression:"ruleForm.xueshengxingming"}})],1),i("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"},on:{click:function(r){arguments[0]=r=e.$handleEvent(r),e.touxiangTap.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("头像")]),e.ruleForm.touxiang?i("v-uni-image",{staticClass:"avator",style:{width:"72rpx",margin:"12rpx 0",borderRadius:"100%",objectFit:"cover",display:"block",height:"72rpx"},attrs:{src:e.baseUrl+e.ruleForm.touxiang.split(",")[0],mode:"aspectFill"}}):i("v-uni-image",{staticClass:"avator",style:{width:"72rpx",margin:"12rpx 0",borderRadius:"100%",objectFit:"cover",display:"block",height:"72rpx"},attrs:{src:"../../static/gen/upload.png",mode:"aspectFill"}})],1),i("v-uni-view",{staticClass:" select",style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("性别")]),i("v-uni-picker",{style:{width:"100%",flex:"1",height:"auto"},attrs:{value:e.xingbieIndex,range:e.xingbieOptions},on:{change:function(r){arguments[0]=r=e.$handleEvent(r),e.xingbieChange.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"uni-input",style:{color:"#333",width:"100%",fontSize:"28rpx"}},[e._v(e._s(e.ruleForm.xingbie?e.ruleForm.xingbie:"请选择性别"))])],1)],1),i("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("年龄")]),i("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.nianling,placeholder:"年龄"},model:{value:e.ruleForm.nianling,callback:function(r){e.$set(e.ruleForm,"nianling",r)},expression:"ruleForm.nianling"}})],1),i("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("手机号码")]),i("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.shoujihaoma,placeholder:"手机号码"},model:{value:e.ruleForm.shoujihaoma,callback:function(r){e.$set(e.ruleForm,"shoujihaoma",r)},expression:"ruleForm.shoujihaoma"}})],1),i("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[i("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("邮箱")]),i("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.youxiang,placeholder:"邮箱"},model:{value:e.ruleForm.youxiang,callback:function(r){e.$set(e.ruleForm,"youxiang",r)},expression:"ruleForm.youxiang"}})],1),i("v-uni-view",{staticClass:"btn",style:{width:"100%",margin:"40rpx 0 0 0",justifyContent:"center",display:"flex",height:"auto"}},[i("v-uni-button",{staticClass:"bg-red",style:{padding:"0 40rpx",boxShadow:"4rpx 8rpx 0px #cfcfe3",margin:"0 40rpx 0 0",borderColor:"#9F9FEC",color:"#333",display:"inline",minWidth:"212rpx",borderRadius:"40rpx",background:"#eaeafa",borderWidth:"2rpx 8rpx 2rpx",width:"auto",lineHeight:"72rpx",fontSize:"28rpx",borderStyle:"dashed",height:"80rpx"},on:{click:function(r){arguments[0]=r=e.$handleEvent(r),e.onSubmitTap.apply(void 0,arguments)}}},[e._v("提交")])],1)],1)],1)],1)},a=[];i.d(r,"b",(function(){return n})),i.d(r,"c",(function(){return a})),i.d(r,"a",(function(){return t}))},cda9:function(e,r,i){var t=i("0a7e");"string"===typeof t&&(t=[[e.i,t,""]]),t.locals&&(e.exports=t.locals);var n=i("4f06").default;n("070cd36d",t,!0,{sourceMap:!1,shadowMode:!1})},f19e:function(e,r,i){"use strict";i.r(r);var t=i("992e"),n=i("f2c1");for(var a in n)"default"!==a&&function(e){i.d(r,e,(function(){return n[e]}))}(a);i("6602");var o,s=i("f0c5"),u=Object(s["a"])(n["default"],t["b"],t["c"],!1,null,"1a1a206e",null,!1,t["a"],o);r["default"]=u.exports},f2c1:function(e,r,i){"use strict";i.r(r);var t=i("1304"),n=i.n(t);for(var a in t)"default"!==a&&function(e){i.d(r,e,(function(){return t[e]}))}(a);r["default"]=n.a}}]);
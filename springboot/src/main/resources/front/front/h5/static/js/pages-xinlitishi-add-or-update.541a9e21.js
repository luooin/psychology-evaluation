(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-xinlitishi-add-or-update"],{"03e8":function(e,i,r){var t=r("24fb");i=t(!1),i.push([e.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */.content[data-v-3b660f4d]{min-height:calc(100vh - 44px);box-sizing:border-box}',""]),e.exports=i},"37b1":function(e,i,r){"use strict";var t=r("4ea4");Object.defineProperty(i,"__esModule",{value:!0}),i.default=void 0,r("a481"),r("c5f6"),r("f559"),r("ac6a"),r("28a5"),r("96cf");var n=t(r("3b8d")),a=t(r("e2b1")),o=t(r("064f")),s={data:function(){return{cross:"",ruleForm:{xuehao:"",xueshengxingming:"",pinggujieguo:"",tishineirong:"",tishishijian:"",laoshizhanghao:"",laoshixingming:"",touxiang:"",userid:""},xuehaoOptions:[],xuehaoIndex:0,user:{},ro:{xuehao:!1,xueshengxingming:!1,pinggujieguo:!1,tishineirong:!1,tishishijian:!1,laoshizhanghao:!1,laoshixingming:!1,touxiang:!1,userid:!1}}},components:{wPicker:a.default,xiaEditor:o.default},computed:{baseUrl:function(){return this.$base.url}},onLoad:function(){var e=(0,n.default)(regeneratorRuntime.mark((function e(i){var r,t,n,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return this.ruleForm.tishishijian=this.$utils.getCurDateTime(),r=uni.getStorageSync("nowTable"),e.next=4,this.$api.session(r);case 4:return t=e.sent,this.user=t.data,this.ruleForm.laoshizhanghao=this.user.laoshizhanghao,this.ro.laoshizhanghao=!0,this.ruleForm.laoshixingming=this.user.laoshixingming,this.ro.laoshixingming=!0,this.ruleForm.touxiang=this.user.touxiang,this.ro.touxiang=!0,e.next=14,this.$api.option("xuesheng","xuehao",{});case 14:if(t=e.sent,this.xuehaoOptions=t.data,this.xuehaoOptions.unshift("请选择学号"),this.ruleForm.userid=uni.getStorageSync("userid"),i.refid&&(this.ruleForm.refid=i.refid,this.ruleForm.nickname=uni.getStorageSync("nickname")),!i.id){e.next=25;break}return this.ruleForm.id=i.id,e.next=23,this.$api.info("xinlitishi",this.ruleForm.id);case 23:t=e.sent,this.ruleForm=t.data;case 25:if(this.cross=i.cross,!i.cross){e.next=69;break}n=uni.getStorageSync("crossObj"),e.t0=regeneratorRuntime.keys(n);case 29:if((e.t1=e.t0()).done){e.next=69;break}if(a=e.t1.value,"xuehao"!=a){e.next=35;break}return this.ruleForm.xuehao=n[a],this.ro.xuehao=!0,e.abrupt("continue",29);case 35:if("xueshengxingming"!=a){e.next=39;break}return this.ruleForm.xueshengxingming=n[a],this.ro.xueshengxingming=!0,e.abrupt("continue",29);case 39:if("pinggujieguo"!=a){e.next=43;break}return this.ruleForm.pinggujieguo=n[a],this.ro.pinggujieguo=!0,e.abrupt("continue",29);case 43:if("tishineirong"!=a){e.next=47;break}return this.ruleForm.tishineirong=n[a],this.ro.tishineirong=!0,e.abrupt("continue",29);case 47:if("tishishijian"!=a){e.next=51;break}return this.ruleForm.tishishijian=n[a],this.ro.tishishijian=!0,e.abrupt("continue",29);case 51:if("laoshizhanghao"!=a){e.next=55;break}return this.ruleForm.laoshizhanghao=n[a],this.ro.laoshizhanghao=!0,e.abrupt("continue",29);case 55:if("laoshixingming"!=a){e.next=59;break}return this.ruleForm.laoshixingming=n[a],this.ro.laoshixingming=!0,e.abrupt("continue",29);case 59:if("touxiang"!=a){e.next=63;break}return this.ruleForm.touxiang=n[a].split(",")[0],this.ro.touxiang=!0,e.abrupt("continue",29);case 63:if("userid"!=a){e.next=67;break}return this.ruleForm.userid=n[a],this.ro.userid=!0,e.abrupt("continue",29);case 67:e.next=29;break;case 69:this.styleChange();case 70:case"end":return e.stop()}}),e,this)})));function i(i){return e.apply(this,arguments)}return i}(),methods:{tishineirongChange:function(e){this.ruleForm.tishineirong=e},styleChange:function(){this.$nextTick((function(){}))},tishishijianConfirm:function(e){console.log(e),this.ruleForm.tishishijian=e.result,this.$forceUpdate()},xuehaoChange:function(e){this.xuehaoIndex=e.target.value,this.ruleForm.xuehao=this.xuehaoOptions[this.xuehaoIndex]},touxiangTap:function(){var e=this;this.$api.upload((function(i){e.ruleForm.touxiang="upload/"+i.file,e.$forceUpdate(),e.$nextTick((function(){e.styleChange()}))}))},getUUID:function(){return(new Date).getTime()},onSubmitTap:function(){var e=(0,n.default)(regeneratorRuntime.mark((function e(){var i,r,t,n,a,o,s,d,u,l;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(this.ruleForm.tishineirong){e.next=3;break}return this.$utils.msg("提示内容不能为空"),e.abrupt("return");case 3:if(!this.cross){e.next=19;break}if(a=uni.getStorageSync("statusColumnName"),o=uni.getStorageSync("statusColumnValue"),""==a){e.next=19;break}if(i||(i=uni.getStorageSync("crossObj")),a.startsWith("[")){e.next=15;break}for(s in i)s==a&&(i[s]=o);return d=uni.getStorageSync("crossTable"),e.next=13,this.$api.update("".concat(d),i);case 13:e.next=19;break;case 15:r=Number(uni.getStorageSync("userid")),t=i["id"],n=uni.getStorageSync("statusColumnName"),n=n.replace(/\[/,"").replace(/\]/,"");case 19:if(!t||!r){e.next=41;break}return this.ruleForm.crossuserid=r,this.ruleForm.crossrefid=t,u={page:1,limit:10,crossuserid:r,crossrefid:t},e.next=25,this.$api.list("xinlitishi",u);case 25:if(l=e.sent,!(l.data.total>=n)){e.next=31;break}return this.$utils.msg(uni.getStorageSync("tips")),e.abrupt("return",!1);case 31:if(!this.ruleForm.id){e.next=36;break}return e.next=34,this.$api.update("xinlitishi",this.ruleForm);case 34:e.next=38;break;case 36:return e.next=38,this.$api.add("xinlitishi",this.ruleForm);case 38:this.$utils.msgBack("提交成功");case 39:e.next=49;break;case 41:if(!this.ruleForm.id){e.next=46;break}return e.next=44,this.$api.update("xinlitishi",this.ruleForm);case 44:e.next=48;break;case 46:return e.next=48,this.$api.add("xinlitishi",this.ruleForm);case 48:this.$utils.msgBack("提交成功");case 49:case"end":return e.stop()}}),e,this)})));function i(){return e.apply(this,arguments)}return i}(),optionsChange:function(e){this.index=e.target.value},bindDateChange:function(e){this.date=e.target.value},getDate:function(e){var i=new Date,r=i.getFullYear(),t=i.getMonth()+1,n=i.getDate();return"start"===e?r-=60:"end"===e&&(r+=2),t=t>9?t:"0"+t,n=n>9?n:"0"+n,"".concat(r,"-").concat(t,"-").concat(n)},toggleTab:function(e){this.$refs[e].show()}}};i.default=s},"39b1":function(e,i,r){"use strict";r.r(i);var t=r("37b1"),n=r.n(t);for(var a in t)"default"!==a&&function(e){r.d(i,e,(function(){return t[e]}))}(a);i["default"]=n.a},"46ca":function(e,i,r){"use strict";r.r(i);var t=r("95b9"),n=r("39b1");for(var a in n)"default"!==a&&function(e){r.d(i,e,(function(){return n[e]}))}(a);r("cddf");var o,s=r("f0c5"),d=Object(s["a"])(n["default"],t["b"],t["c"],!1,null,"3b660f4d",null,!1,t["a"],o);i["default"]=d.exports},"95b9":function(e,i,r){"use strict";var t={"xia-editor":r("064f").default,"w-picker":r("e2b1").default},n=function(){var e=this,i=e.$createElement,r=e._self._c||i;return r("v-uni-view",{staticClass:"content"},[r("v-uni-view",{style:{minHeight:"100vh",padding:"0px",borderColor:"#21d5ae",background:"url(http://codegen.caihongy.cn/20221227/38bdf285653f4e2580978aa4e42be204.gif) no-repeat center top / 100% auto,url(http://codegen.caihongy.cn/20221227/981928ff5e8b4de0bd3f18588ef6cb0f.png) fixed repeat center top,#959bd9",borderWidth:"0px 0 0",width:"100%",position:"relative",borderStyle:"dashed",height:"auto"}},[r("v-uni-form",{staticClass:"app-update-pv",style:{width:"100%",padding:"60rpx 40rpx",background:"none",height:"auto"}},[r("v-uni-view",{staticClass:" select",style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("学号")]),r("v-uni-picker",{style:{width:"100%",flex:"1",height:"auto"},attrs:{value:e.xuehaoIndex,range:e.xuehaoOptions},on:{change:function(i){arguments[0]=i=e.$handleEvent(i),e.xuehaoChange.apply(void 0,arguments)}}},[r("v-uni-view",{staticClass:"uni-input",style:{color:"#333",width:"100%",fontSize:"28rpx"}},[e._v(e._s(e.ruleForm.xuehao?e.ruleForm.xuehao:"请选择学号"))])],1)],1),r("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("学生姓名")]),r("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.xueshengxingming,placeholder:"学生姓名"},model:{value:e.ruleForm.xueshengxingming,callback:function(i){e.$set(e.ruleForm,"xueshengxingming",i)},expression:"ruleForm.xueshengxingming"}})],1),r("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("评估结果")]),r("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.pinggujieguo,placeholder:"评估结果"},model:{value:e.ruleForm.pinggujieguo,callback:function(i){e.$set(e.ruleForm,"pinggujieguo",i)},expression:"ruleForm.pinggujieguo"}})],1),r("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("提示时间")]),r("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{placeholder:"提示时间"},on:{click:function(i){arguments[0]=i=e.$handleEvent(i),e.toggleTab("tishishijian")}},model:{value:e.ruleForm.tishishijian,callback:function(i){e.$set(e.ruleForm,"tishishijian",i)},expression:"ruleForm.tishishijian"}})],1),r("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("老师账号")]),r("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.laoshizhanghao,placeholder:"老师账号"},model:{value:e.ruleForm.laoshizhanghao,callback:function(i){e.$set(e.ruleForm,"laoshizhanghao",i)},expression:"ruleForm.laoshizhanghao"}})],1),r("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("老师姓名")]),r("v-uni-input",{style:{border:"0",padding:"0px 20rpx",margin:"0px",color:"#333",borderRadius:"8rpx",flex:"1",background:"rgba(255, 255, 255, 0)",fontSize:"28rpx"},attrs:{disabled:e.ro.laoshixingming,placeholder:"老师姓名"},model:{value:e.ruleForm.laoshixingming,callback:function(i){e.$set(e.ruleForm,"laoshixingming",i)},expression:"ruleForm.laoshixingming"}})],1),r("v-uni-view",{style:{padding:"0 20rpx 40rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",margin:"0 0 32rpx",borderColor:"#c8c8ef",borderRadius:"0px",borderWidth:"0px 0px 8rpx 0px",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",display:"flex",width:"100%",lineHeight:"100rpx",borderStyle:"dotted dashed solid",height:"auto"},on:{click:function(i){arguments[0]=i=e.$handleEvent(i),e.touxiangTap.apply(void 0,arguments)}}},[r("v-uni-view",{staticClass:"title",style:{width:"160rpx",padding:"0 20rpx 0 0",fontSize:"28rpx",color:"#333",textAlign:"right"}},[e._v("头像")]),e.ruleForm.touxiang?r("v-uni-image",{staticClass:"avator",style:{width:"72rpx",margin:"12rpx 0",borderRadius:"100%",objectFit:"cover",display:"block",height:"72rpx"},attrs:{src:e.baseUrl+e.ruleForm.touxiang.split(",")[0],mode:"aspectFill"}}):r("v-uni-image",{staticClass:"avator",style:{width:"72rpx",margin:"12rpx 0",borderRadius:"100%",objectFit:"cover",display:"block",height:"72rpx"},attrs:{src:"../../static/gen/upload.png",mode:"aspectFill"}})],1),r("v-uni-view",{style:{padding:"12rpx 0",margin:"0 0 24rpx 0",borderColor:"#c8c8ef",borderWidth:"0 0 8rpx 0",background:"linear-gradient(180deg, rgba(255,255,255,1) 31%, rgba(232,232,255,1) 100%)",width:"100%",borderStyle:"solid",height:"auto"}},[r("v-uni-view",{staticClass:"title",style:{width:"100%",padding:"0 24rpx",lineHeight:"48rpx",fontSize:"28rpx",color:"#333",fontWeight:"500"}},[e._v("提示内容")]),r("xia-editor",{style:{minHeight:"240rpx",padding:"24rpx 24rpx 64rpx",boxShadow:"inset 0px 0px 0px 0px #f9edd9",borderColor:"#c8c8ef",borderRadius:"0px",color:"#555",background:"none",borderWidth:"0px 0px 0px 0px",width:"100%",borderStyle:"dotted dashed solid",height:"auto"},attrs:{placeholder:"提示内容"},on:{editorChange:function(i){arguments[0]=i=e.$handleEvent(i),e.tishineirongChange.apply(void 0,arguments)}},model:{value:e.ruleForm.tishineirong,callback:function(i){e.$set(e.ruleForm,"tishineirong",i)},expression:"ruleForm.tishineirong"}})],1),r("v-uni-view",{staticClass:"btn",style:{width:"100%",margin:"40rpx 0 0 0",justifyContent:"center",display:"flex",height:"auto"}},[r("v-uni-button",{staticClass:"bg-red",style:{padding:"0 40rpx",boxShadow:"4rpx 8rpx 0px #cfcfe3",margin:"0 40rpx 0 0",borderColor:"#9F9FEC",color:"#333",display:"inline",minWidth:"212rpx",borderRadius:"40rpx",background:"#eaeafa",borderWidth:"2rpx 8rpx 2rpx",width:"auto",lineHeight:"72rpx",fontSize:"28rpx",borderStyle:"dashed",height:"80rpx"},on:{click:function(i){arguments[0]=i=e.$handleEvent(i),e.onSubmitTap.apply(void 0,arguments)}}},[e._v("提交")])],1)],1),r("w-picker",{ref:"tishishijian",attrs:{mode:"dateTime",step:"1",current:!1,hasSecond:!1,themeColor:"#333333"},on:{confirm:function(i){arguments[0]=i=e.$handleEvent(i),e.tishishijianConfirm.apply(void 0,arguments)}}})],1)],1)},a=[];r.d(i,"b",(function(){return n})),r.d(i,"c",(function(){return a})),r.d(i,"a",(function(){return t}))},cddf:function(e,i,r){"use strict";var t=r("d438"),n=r.n(t);n.a},d438:function(e,i,r){var t=r("03e8");"string"===typeof t&&(t=[[e.i,t,""]]),t.locals&&(e.exports=t.locals);var n=r("4f06").default;n("266a8f69",t,!0,{sourceMap:!1,shadowMode:!1})}}]);

<template>
	<div>
		<div class="app-contain">
			<el-form class="userinfo_form" ref="userinfoFormRef" :model="form" label-width="$template2.back.add.form.base.labelWidth">
				<el-row>
					<el-col :span="24">
						<el-form-item label="医生账号" prop="yishengzhanghao">
							<el-input class="list_inp" v-model="user.yishengzhanghao" readonly placeholder="医生账号" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="医生密码" prop="yishengmima">
							<el-input class="list_inp" v-model="user.yishengmima" readonly placeholder="医生密码" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="医生姓名" prop="yishengxingming">
							<el-input class="list_inp" v-model="user.yishengxingming"  placeholder="医生姓名" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="照片" prop="zhaopian">
							<uploads
								action="file/upload" 
								tip="请上传照片" 
								:limit="3" 
								style="width: 100%;text-align: left;"
								:fileUrls="user.zhaopian?user.zhaopian:''" 
								@change="yishengzhaopianUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="性别" prop="xingbie">
							<el-select 
								class="list_sel" 
								v-model="user.xingbie" 
								placeholder="请选择性别"
								>
								<el-option v-for="item in yishengxingbieLists" :label="item" :value="item"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="联系电话" prop="lianxidianhua">
							<el-input class="list_inp" v-model="user.lianxidianhua"  placeholder="联系电话" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="擅长领域" prop="shanzhanglingyu">
							<el-input class="list_inp" v-model="user.shanzhanglingyu"  placeholder="擅长领域" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="收藏数量" prop="storeupnum">
							<el-input class="list_inp" v-model="user.storeupnum"  placeholder="收藏数量" clearable />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="科室" prop="keshi">
							<el-select 
								class="list_sel" 
								v-model="user.keshi" 
								placeholder="请选择科室"
								>
								<el-option v-for="item in yishengkeshiLists" :label="item" :value="item"></el-option>
							</el-select>
						</el-form-item>
					</el-col>
					<span class="userinfo_form_btn_box">
						<el-button class='userinfo_confirm' type="primary" @click="onSubmit">保存</el-button>
					</span>
				</el-row>
			</el-form>
		</div>
	</div>
</template>

<script setup>
	import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/toolUtil";
	import {
		reactive,
		ref,
		getCurrentInstance
	} from 'vue'
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const tableName = ref('yisheng')
	const user = ref({})
	const yishengxingbieLists = ref([])
	const yishengkeshiLists = ref([])
	const init = () => {
		yishengxingbieLists.value = "男,女".split(',')
		context?.$http({
			url:`option/keshi/keshi`,
			method:'get'
		}).then(res=>{
			yishengkeshiLists.value = res.data.data
		})
	}
	const yishengzhaopianUploadSuccess=(fileUrls)=> {
	    user.value.zhaopian = fileUrls;
	}
	const onSubmit = () => {
		if((!user.value.yishengzhanghao)){
			context?.$toolUtil.message(`医生账号不能为空`,'error')
			return false
		}
		if((!user.value.yishengmima)){
			context?.$toolUtil.message(`医生密码不能为空`,'error')
			return false
		}
		if((!user.value.yishengxingming)){
			context?.$toolUtil.message(`医生姓名不能为空`,'error')
			return false
		}
		if(user.value.zhaopian!=null){
			user.value.zhaopian = user.value.zhaopian.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if((user.value.lianxidianhua)&&(!context?.$toolUtil.isMobile(user.value.lianxidianhua))){
			context?.$toolUtil.message(`联系电话应输入手机格式`,'error')
			return false
		}
		if((user.value.storeupnum)&&(!context?.$toolUtil.isIntNumer(user.value.storeupnum))){
			context?.$toolUtil.message(`收藏数量应输入整数`,'error')
			return false
		}
		context?.$http({
			url: `${tableName.value}/update`,
			method: 'post',
			data: user.value
		}).then(res => {
			context?.$toolUtil.message('修改成功','success')
		})

	}
	const getInfo = () => {
		context?.$http({
			url: `${tableName.value}/session`,
			method: 'get'
		}).then(res => {
			user.value = res.data.data
			init()
		})
	}
	getInfo()
</script>

<style lang="scss" scoped>
	// 表单
	.userinfo_form {
		border: 1px solid rgba(254, 182, 203, 0.5);
		border-radius: 0px;
		padding: 40px 30px;
		margin: 0;
		background: #fff;
		// form item
		:deep(.el-form-item) {
			margin: 0 150px 20px 0;
			background: none;
			display: flex;
			// 内容盒子
			.el-form-item__content{
				display: flex;
				width: calc(100% - 120px);
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
			}
			// 输入框
			.list_inp {
				border: 0px solid rgba(255, 255, 255, 0.25);
				border-radius: 0px;
				padding: 0 10px;
				color: #666;
				background: rgba(0, 0, 0, 0.1);
				width: auto;
				line-height: 36px;
				box-sizing: border-box;
				height: 36px;
				//去掉默认样式
				.el-input__wrapper{
					border: none;
					box-shadow: none;
					background: none;
					border-radius: 0;
					height: 100%;
					padding: 0;
				}
				.is-focus {
					box-shadow: none !important;
				}
			}
			//下拉框样式
			.list_sel {
				border: 1px solid rgba(255, 255, 255, 0.25);
				border-radius: 0px;
				padding: 0 10px;
				color: #666;
				background: rgba(0, 0, 0, 0.1);
				width: auto;
				line-height: 36px;
				box-sizing: border-box;
				//去掉默认样式
				.select-trigger{
					height: 100%;
					.el-input{
						height: 100%;
						.el-input__wrapper{
							border: none;
							box-shadow: none;
							background: none;
							border-radius: 0;
							height: 100%;
						}
						.is-focus {
							box-shadow: none !important;
						}
					}
				}
			}
			//图片上传样式
			.el-upload-list  {
				//提示语
				.el-upload__tip {
					margin: 7px 0 0;
					color: #999;
					display: flex;
					font-size: 14px;
					justify-content: flex-start;
					align-items: center;
				}
				//外部盒子
				.el-upload--picture-card {
					border: 1px solid rgba(255, 255, 255, 0.25);
					cursor: pointer;
					border-radius: 0px;
					background: rgba(0, 0, 0, 0.1);
					width: 120px;
					line-height: 70px;
					text-align: center;
					height: 60px;
					//图标
					.el-icon{
						color: #999;
						font-size: 26px;
					}
				}
				.el-upload-list__item {
					border: 1px solid rgba(255, 255, 255, 0.25);
					cursor: pointer;
					border-radius: 0px;
					background: rgba(0, 0, 0, 0.1);
					width: 120px;
					line-height: 70px;
					text-align: center;
					height: 60px;
				}
			}

		}
		// 按钮盒子
		.userinfo_form_btn_box {
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			// 确定按钮
			.userinfo_confirm {
				border: 1px solid #357ebd;
				cursor: pointer;
				border-radius: 3px;
				padding: 0 24px;
				margin: 0 20px 0 0;
				outline: none;
				color: #fff;
				background: rgba(66, 139, 202, 0.55);
				width: auto;
				font-size: 14px;
				min-width: 100px;
				height: 36px;
			}
			// 确定按钮-悬浮
			.userinfo_confirm:hover {
			}
		}
	}
</style>

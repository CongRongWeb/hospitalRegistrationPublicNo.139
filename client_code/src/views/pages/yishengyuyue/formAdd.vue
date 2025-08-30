<template>
  <div
    class="app-contain"
    :style="{
      minHeight: '100vh',
      padding: '0',
      margin: '20px auto 60px',
      borderRadius: '0px',
      background: '#fff',
      width: '64%',
      position: 'relative',
      height: '100%',
    }"
  >
    <div class="bread_view">
      <el-breadcrumb separator="/" class="breadcrumb">
        <el-breadcrumb-item class="first_breadcrumb" :to="{ path: '/' }"
          >首页</el-breadcrumb-item
        >
        <el-breadcrumb-item
          class="second_breadcrumb"
          v-for="(item, index) in breadList"
          :key="index"
          >{{ item.name }}</el-breadcrumb-item
        >
      </el-breadcrumb>
    </div>
    <el-form
      ref="formRef"
      :model="form"
      class="add_form"
      label-width="120px"
      :rules="rules"
    >
      <el-row>
        <el-col :span="12">
          <el-form-item label="预约编号" prop="yuyuebianhao">
            <el-input
              class="list_inp"
              v-model="form.yuyuebianhao"
              placeholder="请输入预约编号"
              readonly
            ></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="医生账号" prop="yishengzhanghao">
            <el-input
              class="list_inp"
              v-model="form.yishengzhanghao"
              placeholder="医生账号"
              type="text"
              :readonly="!isAdd || disabledForm.yishengzhanghao ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="医生姓名" prop="yishengxingming">
            <el-input
              class="list_inp"
              v-model="form.yishengxingming"
              placeholder="医生姓名"
              type="text"
              :readonly="!isAdd || disabledForm.yishengxingming ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="科室" prop="keshi">
            <el-input
              class="list_inp"
              v-model="form.keshi"
              placeholder="科室"
              type="text"
              :readonly="!isAdd || disabledForm.keshi ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="挂号费" prop="guahaofei">
            <el-input
              class="list_inp"
              v-model.number="form.guahaofei"
              placeholder="挂号费"
              type="number"
              :readonly="!isAdd || disabledForm.guahaofei ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="可挂号人数" prop="renshu">
            <el-input
              class="list_inp"
              v-model.number="form.renshu"
              placeholder="可挂号人数"
              type="text"
              :readonly="!isAdd || disabledForm.renshu ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="预约时间" prop="yuyueshijian">
            <el-date-picker
              class="list_date"
              v-model="form.yuyueshijian"
              format="YYYY-MM-DD HH:mm:ss"
              value-format="YYYY-MM-DD HH:mm:ss"
              type="datetime"
              style="width: 100%"
              :readonly="!isAdd || disabledForm.yuyueshijian ? true : false"
              placeholder="请选择预约时间"
            />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="患者账号" prop="huanzhezhanghao">
            <el-input
              class="list_inp"
              v-model="form.huanzhezhanghao"
              placeholder="患者账号"
              type="text"
              :readonly="!isAdd || disabledForm.huanzhezhanghao ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="患者姓名" prop="huanzhexingming">
            <el-input
              class="list_inp"
              v-model="form.huanzhexingming"
              placeholder="患者姓名"
              type="text"
              :readonly="!isAdd || disabledForm.huanzhexingming ? true : false"
            />
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="叫号状态" prop="jiaohaozhuangtai">
            <el-select
              class="list_sel"
              :disabled="!isAdd || disabledForm.jiaohaozhuangtai ? true : false"
              v-model="form.jiaohaozhuangtai"
              placeholder="请选择叫号状态"
              style="width: 100%"
            >
              <el-option
                v-for="(item, index) in jiaohaozhuangtaiLists"
                :label="item"
                :value="item"
              >
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="既往病史" prop="jiwangbingshi">
            <editor
              class="list_editor"
              :value="form.jiwangbingshi"
              placeholder="请输入既往病史"
              :readonly="!isAdd || disabledForm.jiwangbingshi ? true : false"
              @change="(e) => editorChange(e, 'jiwangbingshi')"
            ></editor>
          </el-form-item>
        </el-col>
      </el-row>
      <div class="formModel_btn_box">
        <el-button class="formModel_cancel" @click="backClick">取消</el-button>
        <el-button class="formModel_confirm" @click="save" type="success">
          保存
        </el-button>
      </div>
    </el-form>
  </div>
</template>
<script setup>
import {
  ref,
  getCurrentInstance,
  watch,
  onUnmounted,
  onMounted,
  nextTick,
  computed,
} from 'vue'
import { useRoute, useRouter } from 'vue-router'
const context = getCurrentInstance()?.appContext.config.globalProperties
const route = useRoute()
const router = useRouter()
//基础信息
const tableName = 'yishengyuyue'
const formName = '医生预约'
//基础信息
const breadList = ref([
  {
    name: formName,
  },
])
//获取唯一标识
const getUUID = () => {
  return new Date().getTime()
}
//form表单
const form = ref({
  yuyuebianhao: getUUID(),
  yishengzhanghao: '',
  yishengxingming: '',
  keshi: '',
  guahaofei: '',
  renshu: '1',
  yuyueshijian: '',
  huanzhezhanghao: '',
  huanzhexingming: '',
  ispay: '未支付',
  jiwangbingshi: '',
  jiaohaozhuangtai: '未叫号',
})
const formRef = ref(null)
const id = ref(0)
const type = ref('')
const disabledForm = ref({
  yuyuebianhao: false,
  yishengzhanghao: false,
  yishengxingming: false,
  keshi: false,
  guahaofei: false,
  renshu: false,
  yuyueshijian: false,
  huanzhezhanghao: false,
  huanzhexingming: false,
  ispay: false,
  jiwangbingshi: false,
  jiaohaozhuangtai: false,
})
const isAdd = ref(false)
//表单验证
//匹配整数
const validateIntNumber = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isIntNumer(value)) {
    callback(new Error('请输入整数'))
  } else {
    callback()
  }
}
//匹配数字
const validateNumber = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isNumber(value)) {
    callback(new Error('请输入数字'))
  } else {
    callback()
  }
}
//匹配手机号码
const validateMobile = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isMobile(value)) {
    callback(new Error('请输入正确的手机号码'))
  } else {
    callback()
  }
}
//匹配电话号码
const validatePhone = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isPhone(value)) {
    callback(new Error('请输入正确的电话号码'))
  } else {
    callback()
  }
}
//匹配邮箱
const validateEmail = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isEmail(value)) {
    callback(new Error('请输入正确的邮箱地址'))
  } else {
    callback()
  }
}
//匹配身份证
const validateIdCard = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.checkIdCard(value)) {
    callback(new Error('请输入正确的身份证号码'))
  } else {
    callback()
  }
}
//匹配网站地址
const validateUrl = (rule, value, callback) => {
  if (!value) {
    callback()
  } else if (!context?.$toolUtil.isURL(value)) {
    callback(new Error('请输入正确的URL地址'))
  } else {
    callback()
  }
}
const rules = ref({
  yuyuebianhao: [],
  yishengzhanghao: [],
  yishengxingming: [],
  keshi: [],
  guahaofei: [{ validator: validateNumber, trigger: 'blur' }],
  renshu: [{ validator: validateIntNumber, trigger: 'blur' }],
  yuyueshijian: [],
  huanzhezhanghao: [],
  huanzhexingming: [],
  ispay: [],
  jiwangbingshi: [],
  jiaohaozhuangtai: [],
})
//叫号状态列表
const jiaohaozhuangtaiLists = ref([])
//methods

//methods
//获取info
const getInfo = () => {
  context
    ?.$http({
      url: `${tableName}/info/${id.value}`,
      method: 'get',
    })
    .then((res) => {
      let reg = new RegExp('../../../file', 'g')
      res.data.data.jiwangbingshi = res.data.data.jiwangbingshi.replace(
        reg,
        '../../../hospitalRegistration/file'
      )
      form.value = res.data.data
    })
}
const crossRow = ref('')
const crossTable = ref('')
const crossTips = ref('')
const crossColumnName = ref('')
const crossColumnValue = ref('')
//初始化
const init = (
  formId = null,
  formType = 'add',
  formNames = '',
  row = null,
  table = null,
  statusColumnName = null,
  tips = null,
  statusColumnValue = null
) => {
  form.value.yuyueshijian = context?.$toolUtil.getCurDateTime()
  if (formId) {
    id.value = formId
    type.value = formType
  }
  if (formType == 'add') {
    isAdd.value = true
  } else if (formType == 'info') {
    isAdd.value = false
    getInfo()
  } else if (formType == 'edit') {
    isAdd.value = true
    getInfo()
  } else if (formType == 'cross') {
    isAdd.value = true
    // getInfo()
    for (let x in row) {
      if (x == 'yuyuebianhao') {
        form.value.yuyuebianhao = row[x]
        disabledForm.value.yuyuebianhao = true
        continue
      }
      if (x == 'yishengzhanghao') {
        form.value.yishengzhanghao = row[x]
        disabledForm.value.yishengzhanghao = true
        continue
      }
      if (x == 'yishengxingming') {
        form.value.yishengxingming = row[x]
        disabledForm.value.yishengxingming = true
        continue
      }
      if (x == 'keshi') {
        form.value.keshi = row[x]
        disabledForm.value.keshi = true
        continue
      }
      if (x == 'guahaofei') {
        form.value.guahaofei = row[x]
        disabledForm.value.guahaofei = true
        continue
      }
      if (x == 'renshu') {
        form.value.renshu = row[x]
        disabledForm.value.renshu = true
        continue
      }
      if (x == 'yuyueshijian') {
        form.value.yuyueshijian = row[x]
        disabledForm.value.yuyueshijian = true
        continue
      }
      if (x == 'huanzhezhanghao') {
        form.value.huanzhezhanghao = row[x]
        disabledForm.value.huanzhezhanghao = true
        continue
      }
      if (x == 'huanzhexingming') {
        form.value.huanzhexingming = row[x]
        disabledForm.value.huanzhexingming = true
        continue
      }
      if (x == 'jiwangbingshi') {
        form.value.jiwangbingshi = row[x]
        disabledForm.value.jiwangbingshi = true
        continue
      }
      if (x == 'jiaohaozhuangtai') {
        form.value.jiaohaozhuangtai = row[x]
        disabledForm.value.jiaohaozhuangtai = true
        continue
      }
    }
    if (row) {
      crossRow.value = row
    }
    if (table) {
      crossTable.value = table
    }
    if (tips) {
      crossTips.value = tips
    }
    if (statusColumnName) {
      crossColumnName.value = statusColumnName
    }
    if (statusColumnValue) {
      crossColumnValue.value = statusColumnValue
    }
    form.value.renshu = '1'
    form.value.ispay = '未支付'
    form.value.jiaohaozhuangtai = '未叫号'
  }
  context
    ?.$http({
      url: `${context?.$toolUtil.storageGet('frontSessionTable')}/session`,
      method: 'get',
    })
    .then((res) => {
      var json = res.data.data
      if (context?.$toolUtil.storageGet('frontRole') != '管理员') {
        disabledForm.value.renshu = true
      }
      if (
        json.hasOwnProperty('huanzhezhanghao') &&
        context?.$toolUtil.storageGet('frontRole') != '管理员'
      ) {
        form.value.huanzhezhanghao = json.huanzhezhanghao
        disabledForm.value.huanzhezhanghao = true
      }
      if (
        json.hasOwnProperty('huanzhexingming') &&
        context?.$toolUtil.storageGet('frontRole') != '管理员'
      ) {
        form.value.huanzhexingming = json.huanzhexingming
        disabledForm.value.huanzhexingming = true
      }
    })
  jiaohaozhuangtaiLists.value = '已叫号,未叫号'.split(',')
}
//初始化
//取消
const backClick = () => {
  history.back()
}
//富文本数据回调
const editorChange = (e, name) => {
  form.value[name] = e
}
//提交
const save = () => {
  var table = crossTable.value
  var objcross = JSON.parse(JSON.stringify(crossRow.value))
  if (objcross != '') {
    objcross.renshu = objcross.renshu - form.value.renshu
    if (objcross.renshu < 0) {
      context?.$toolUtil.message('可挂号人数不足', 'error')
      return false
    }
  }
  let crossUserId = ''
  let crossRefId = ''
  let crossOptNum = ''
  if (type.value == 'cross') {
    if (crossColumnName.value != '') {
      if (!crossColumnName.value.startsWith('[')) {
        for (let o in objcross) {
          if (o == crossColumnName.value) {
            objcross[o] = crossColumnValue.value
          }
        }
        //修改跨表数据
        changeCrossData(objcross)
      } else {
        crossUserId = context?.$toolUtil.storageGet('userid')
        crossRefId = objcross['id']
        crossOptNum = crossColumnName.value.replace(/\[/, '').replace(/\]/, '')
      }
    }
  }
  formRef.value.validate((valid) => {
    if (valid) {
      if (crossUserId && crossRefId) {
        form.value.crossuserid = crossUserId
        form.value.crossrefid = crossRefId
        let params = {
          page: 1,
          limit: 1000,
          crossuserid: form.value.crossuserid,
          crossrefid: form.value.crossrefid,
        }
        context
          ?.$http({
            url: `${tableName}/page`,
            method: 'get',
            params: params,
          })
          .then((res) => {
            if (res.data.data.total >= crossOptNum) {
              context?.$toolUtil.message(`${crossTips.value}`, 'error')
              return false
            } else {
              context
                ?.$http({
                  url: `${tableName}/${!form.value.id ? 'save' : 'update'}`,
                  method: 'post',
                  data: form.value,
                })
                .then((res) => {
                  context?.$toolUtil.message(`操作成功`, 'success', () => {
                    //修改跨表数据
                    changeCrossData(objcross)
                    history.back()
                  })
                })
            }
          })
      } else {
        context
          ?.$http({
            url: `${tableName}/${!form.value.id ? 'save' : 'update'}`,
            method: 'post',
            data: form.value,
          })
          .then((res) => {
            context?.$toolUtil.message(`操作成功`, 'success', () => {
              //修改跨表数据
              changeCrossData(objcross)
              history.back()
            })
          })
      }
    }
  })
}
//修改跨表数据
const changeCrossData = (row) => {
  context
    ?.$http({
      url: `${crossTable.value}/update`,
      method: 'post',
      data: row,
    })
    .then((res) => {})
}
onMounted(() => {
  type.value = route.query.type ? route.query.type : 'add'
  let row = null
  let table = null
  let statusColumnName = null
  let tips = null
  let statusColumnValue = null
  if (type.value == 'cross') {
    row = context?.$toolUtil.storageGet('crossObj')
      ? JSON.parse(context?.$toolUtil.storageGet('crossObj'))
      : {}
    table = context?.$toolUtil.storageGet('crossTable')
    statusColumnName = context?.$toolUtil.storageGet('crossStatusColumnName')
    tips = context?.$toolUtil.storageGet('crossTips')
    statusColumnValue = context?.$toolUtil.storageGet('crossStatusColumnValue')
  }
  init(
    route.query.id ? route.query.id : null,
    type.value,
    '',
    row,
    table,
    statusColumnName,
    tips,
    statusColumnValue
  )
})
</script>
<style lang="scss" scoped>
// 面包屑盒子
.bread_view {
  border-radius: 0px;
  padding: 12px 20px;
  margin: 0px auto;
  background: none;
  width: 100%;
  border-color: #eee;
  border-width: 0 0 0px;
  position: relative;
  border-style: solid;
  :deep(.breadcrumb) {
    font-size: 14px;
    line-height: 1;
    .el-breadcrumb__separator {
      margin: 0 9px;
      color: #999;
      font-weight: 500;
    }
    .first_breadcrumb {
      .el-breadcrumb__inner {
        color: #333;
        display: inline-block;
      }
    }
    .second_breadcrumb {
      .el-breadcrumb__inner {
        color: #999;
        display: inline-block;
      }
    }
  }
}
// 表单
.add_form {
  border: 0px solid #2da065;
  border-radius: 0px;
  padding: 30px 7%;
  background: none;
  // form item
  :deep(.el-form-item) {
    border: 0px solid #eee;
    padding: 6px 0;
    margin: 0 0 20px 0;
    background: none;
    display: flex;
    //label
    .el-form-item__label {
      background: none;
      display: block;
      width: auto;
      min-width: 150px;
      text-align: right;
    }
    // 内容盒子
    .el-form-item__content {
      display: flex;
      width: calc(100% - 150px);
      justify-content: flex-start;
      align-items: center;
      flex-wrap: wrap;
      // 输入框
      .list_inp {
        padding: 0 10px;
        background: none;
        width: auto;
        border-color: #ccc;
        border-width: 1px;
        line-height: 36px;
        box-sizing: border-box;
        border-style: solid;
        min-width: 100%;
        height: 36px;
        //去掉默认样式
        .el-input__wrapper {
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
      //日期选择器
      .list_date {
        border-radius: 0px;
        background: none;
        width: auto;
        border-color: #ccc;
        border-width: 1px;
        line-height: 36px;
        box-sizing: border-box;
        border-style: solid;
        min-width: 100%;
        //去掉默认样式
        .el-input__wrapper {
          border: none;
          box-shadow: none;
          background: none;
          border-radius: 0;
          height: 100%;
        }
      }
      // 下拉框
      .list_sel {
        border-radius: 0px;
        padding: 0 10px;
        background: none;
        width: auto;
        border-color: #ccc;
        border-width: 1px;
        line-height: 36px;
        box-sizing: border-box;
        border-style: solid;
        min-width: 100%;
        //去掉默认样式
        .select-trigger {
          height: 100%;
          .el-input {
            height: 100%;
            .el-input__wrapper {
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
        }
      }
      // 富文本
      .list_editor {
        border-radius: 0;
        padding: 0;
        margin: 0;
        background: none;
        width: 99%;
        min-height: 250px;
        border-color: #eee;
        border-width: 0;
        border-style: solid;
        height: auto;
      }
    }
  }
}
// 按钮盒子
.formModel_btn_box {
  padding: 0 150px;
  display: flex;
  width: 100%;
  justify-content: flex-start;
  align-items: center;
  .formModel_cancel {
    border: 0px solid #27bacc;
    cursor: pointer;
    border-radius: 0px;
    padding: 0 40px;
    margin: 0 20px 0 0;
    color: #fff;
    background: #999;
    width: auto;
    font-size: 14px;
    line-height: 40px;
    transition: all 0.3s;
    height: 40px;
  }
  .formModel_cancel:hover {
  }

  .formModel_confirm {
    border: 0;
    cursor: pointer;
    border-radius: 0px;
    padding: 0 40px;
    margin: 0 20px 0 0;
    color: #fff;
    background: #113961;
    width: auto;
    font-size: 14px;
    line-height: 40px;
    transition: all 0.3s;
    height: 40px;
  }
  .formModel_confirm:hover {
  }
}
</style>

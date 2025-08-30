<template>
  <div>
    <el-dialog
      v-model="formVisible"
      :title="formTitle"
      width="80%"
      destroy-on-close
      :fullscreen="false"
    >
      <el-form
        class="formModel_form"
        ref="formRef"
        :model="form"
        label-width="$template2.back.add.form.base.labelWidth"
        :rules="rules"
      >
        <el-row>
          <el-col :span="24">
            <el-form-item label="预约编号" prop="yuyuebianhao">
              <el-input
                class="list_inp"
                v-model="form.yuyuebianhao"
                :readonly="true"
                placeholder="预约编号"
              />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="医生账号" prop="yishengzhanghao">
              <el-input
                class="list_inp"
                v-model="form.yishengzhanghao"
                placeholder="医生账号"
                type="text"
                :readonly="
                  !isAdd || disabledForm.yishengzhanghao ? true : false
                "
              />
            </el-form-item>
          </el-col>

          <el-col :span="24">
            <el-form-item label="医生姓名" prop="yishengxingming">
              <el-input
                class="list_inp"
                v-model="form.yishengxingming"
                placeholder="医生姓名"
                type="text"
                :readonly="
                  !isAdd || disabledForm.yishengxingming ? true : false
                "
              />
            </el-form-item>
          </el-col>

          <el-col :span="24">
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

          <el-col :span="24">
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

          <el-col :span="24">
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

          <el-col :span="24">
            <el-form-item label="预约时间" prop="yuyueshijian">
              <el-date-picker
                class="list_date"
                v-model="form.yuyueshijian"
                format="YYYY-MM-DD HH:mm:ss"
                value-format="YYYY-MM-DD HH:mm:ss"
                type="datetime"
                :readonly="!isAdd || disabledForm.yuyueshijian ? true : false"
                placeholder="请选择预约时间"
              />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="患者账号" prop="huanzhezhanghao">
              <el-input
                class="list_inp"
                v-model="form.huanzhezhanghao"
                placeholder="患者账号"
                type="text"
                :readonly="
                  !isAdd || disabledForm.huanzhezhanghao ? true : false
                "
              />
            </el-form-item>
          </el-col>

          <el-col :span="24">
            <el-form-item label="患者姓名" prop="huanzhexingming">
              <el-input
                class="list_inp"
                v-model="form.huanzhexingming"
                placeholder="患者姓名"
                type="text"
                :readonly="
                  !isAdd || disabledForm.huanzhexingming ? true : false
                "
              />
            </el-form-item>
          </el-col>

          <el-col :span="24">
            <el-form-item label="叫号状态" prop="jiaohaozhuangtai">
              <el-select
                class="list_sel"
                :disabled="
                  !isAdd || disabledForm.jiaohaozhuangtai ? true : false
                "
                v-model="form.jiaohaozhuangtai"
                placeholder="请选择叫号状态"
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
                :value="form.jiwangbingshi"
                placeholder="请输入既往病史"
                :readonly="!isAdd || disabledForm.jiwangbingshi ? true : false"
                class="list_editor"
                @change="(e) => editorChange(e, 'jiwangbingshi')"
              ></editor>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <template #footer v-if="isAdd || type == 'logistics' || type == 'reply'">
        <span class="formModel_btn_box">
          <el-button class="formModel_cancel" @click="closeClick"
            >取消</el-button
          >
          <el-button class="formModel_confirm" type="primary" @click="save">
            提交
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>
<script setup>
import {
  reactive,
  ref,
  getCurrentInstance,
  nextTick,
  computed,
  defineEmits,
} from 'vue'
const context = getCurrentInstance()?.appContext.config.globalProperties
const emit = defineEmits(['formModelChange'])
//基础信息
const tableName = 'yishengyuyue'
const formName = '医生预约'
//基础信息
//form表单
const form = ref({})
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
const formVisible = ref(false)
const isAdd = ref(false)
const formTitle = ref('')
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
//表单验证

const formRef = ref(null)
const id = ref(0)
const type = ref('')
//叫号状态列表
const jiaohaozhuangtaiLists = ref([])
//methods

//获取唯一标识
const getUUID = () => {
  return new Date().getTime()
}
//重置
const resetForm = () => {
  form.value = {
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
  }
}
//获取info
const getInfo = () => {
  context
    ?.$http({
      url: `${tableName}/info/${id.value}`,
      method: 'get',
    })
    .then((res) => {
      let reg = new RegExp('../../../file', 'g')
      res.data.data.jiwangbingshi = res.data.data.jiwangbingshi
        ? res.data.data.jiwangbingshi.replace(
            reg,
            '../../../hospitalRegistration/file'
          )
        : ''
      form.value = res.data.data
      formVisible.value = true
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
  resetForm()
  form.value.yuyueshijian = context?.$toolUtil.getCurDateTime()
  if (formId) {
    id.value = formId
    type.value = formType
  }
  if (formType == 'add') {
    isAdd.value = true
    formTitle.value = '新增' + formName
    formVisible.value = true
  } else if (formType == 'info') {
    isAdd.value = false
    formTitle.value = '查看' + formName
    getInfo()
  } else if (formType == 'edit') {
    isAdd.value = true
    formTitle.value = '修改' + formName
    getInfo()
  } else if (formType == 'cross') {
    isAdd.value = true
    formTitle.value = formNames
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
    formVisible.value = true
  }

  context
    ?.$http({
      url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
      method: 'get',
    })
    .then((res) => {
      var json = res.data.data
      if (context?.$toolUtil.storageGet('role') != '管理员') {
        disabledForm.value.renshu = true
      }
      if (
        json.hasOwnProperty('huanzhezhanghao') &&
        context?.$toolUtil.storageGet('role') != '管理员'
      ) {
        form.value.huanzhezhanghao = json.huanzhezhanghao
        disabledForm.value.huanzhezhanghao = true
      }
      if (
        json.hasOwnProperty('huanzhexingming') &&
        context?.$toolUtil.storageGet('role') != '管理员'
      ) {
        form.value.huanzhexingming = json.huanzhexingming
        disabledForm.value.huanzhexingming = true
      }
    })
  jiaohaozhuangtaiLists.value = '已叫号,未叫号'.split(',')
}
//初始化
//声明父级调用
defineExpose({
  init,
})
//关闭
const closeClick = () => {
  formVisible.value = false
}
//富文本
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
                  //修改跨表数据
                  changeCrossData(objcross)
                  context?.$toolUtil.message(`操作成功`, 'success', () => {
                    formVisible.value = false
                    emit('formModelChange')
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
            //修改跨表数据
            changeCrossData(objcross)
            context?.$toolUtil.message(`操作成功`, 'success', () => {
              formVisible.value = false
              emit('formModelChange')
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
</script>
<style lang="scss" scoped>
// 表单
.formModel_form {
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
    //label
    .el-form-item__label {
      color: #666;
      background: none;
      font-weight: 500;
      display: block;
      width: 150px;
      text-align: right;
      min-width: 150px;
    }
    // 内容盒子
    .el-form-item__content {
      display: flex;
      width: calc(100% - 120px);
      justify-content: flex-start;
      align-items: center;
      flex-wrap: wrap;
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
        border: 1px solid rgba(255, 255, 255, 0.25);
        border-radius: 0px;
        color: #666;
        background: rgba(0, 0, 0, 0.1);
        width: auto;
        line-height: 36px;
        box-sizing: border-box;
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
        border: 1px solid rgba(255, 255, 255, 0.25);
        border-radius: 0px;
        padding: 0 10px;
        color: #666;
        background: rgba(0, 0, 0, 0.1);
        width: auto;
        line-height: 36px;
        box-sizing: border-box;
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
        color: #666;
        background: rgba(0, 0, 0, 0.1);
        width: 100%;
        border-color: #ccc;
        border-width: 0;
        border-style: solid;
        height: auto;
      }
    }
  }
}
// 按钮盒子
.formModel_btn_box {
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  .formModel_cancel {
    border: 1px solid #d43f3a;
    cursor: pointer;
    border-radius: 3px;
    padding: 0 24px;
    margin: 0 20px 0 0;
    outline: none;
    color: #fff;
    background: rgba(217, 83, 79, 0.45);
    width: auto;
    font-size: 14px;
    min-width: 100px;
    height: 36px;
  }
  .formModel_cancel:hover {
  }

  .formModel_confirm {
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
  .formModel_confirm:hover {
  }
}
</style>

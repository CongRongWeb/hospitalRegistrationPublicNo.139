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
            <el-form-item label="医生密码" prop="yishengmima">
              <el-input
                class="list_inp"
                v-model="form.yishengmima"
                placeholder="医生密码"
                type="password"
                :readonly="!isAdd || disabledForm.yishengmima ? true : false"
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
            <el-form-item label="照片" prop="zhaopian">
              <uploads
                :disabled="!isAdd || disabledForm.zhaopian ? true : false"
                action="file/upload"
                tip="请上传照片"
                :limit="3"
                style="width: 100%; text-align: left"
                :fileUrls="form.zhaopian ? form.zhaopian : ''"
                @change="zhaopianUploadSuccess"
              >
              </uploads>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="性别" prop="xingbie">
              <el-select
                class="list_sel"
                :disabled="!isAdd || disabledForm.xingbie ? true : false"
                v-model="form.xingbie"
                placeholder="请选择性别"
              >
                <el-option
                  v-for="(item, index) in xingbieLists"
                  :label="item"
                  :value="item"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="联系电话" prop="lianxidianhua">
              <el-input
                class="list_inp"
                v-model="form.lianxidianhua"
                placeholder="联系电话"
                type="text"
                :readonly="!isAdd || disabledForm.lianxidianhua ? true : false"
              />
            </el-form-item>
          </el-col>

          <el-col :span="24">
            <el-form-item label="擅长领域" prop="shanzhanglingyu">
              <el-input
                class="list_inp"
                v-model="form.shanzhanglingyu"
                placeholder="擅长领域"
                type="text"
                :readonly="
                  !isAdd || disabledForm.shanzhanglingyu ? true : false
                "
              />
            </el-form-item>
          </el-col>

          <el-col :span="24">
            <el-form-item label="科室" prop="keshi">
              <el-select
                class="list_sel"
                :disabled="!isAdd || disabledForm.keshi ? true : false"
                v-model="form.keshi"
                placeholder="请选择科室"
              >
                <el-option
                  v-for="(item, index) in keshiLists"
                  :label="item"
                  :value="item"
                >
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="个人简介" prop="gerenjianjie">
              <editor
                :value="form.gerenjianjie"
                placeholder="请输入个人简介"
                :readonly="!isAdd || disabledForm.gerenjianjie ? true : false"
                class="list_editor"
                @change="(e) => editorChange(e, 'gerenjianjie')"
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
const tableName = 'yisheng'
const formName = '医生'
//基础信息
//form表单
const form = ref({})
const disabledForm = ref({
  yishengzhanghao: false,
  yishengmima: false,
  yishengxingming: false,
  zhaopian: false,
  xingbie: false,
  lianxidianhua: false,
  shanzhanglingyu: false,
  gerenjianjie: false,
  storeupnum: false,
  keshi: false,
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
  yishengzhanghao: [{ required: true, message: '请输入', trigger: 'blur' }],
  yishengmima: [{ required: true, message: '请输入', trigger: 'blur' }],
  yishengxingming: [{ required: true, message: '请输入', trigger: 'blur' }],
  zhaopian: [],
  xingbie: [],
  lianxidianhua: [{ validator: validateMobile, trigger: 'blur' }],
  shanzhanglingyu: [],
  gerenjianjie: [],
  storeupnum: [{ validator: validateIntNumber, trigger: 'blur' }],
  keshi: [],
})
//表单验证

const formRef = ref(null)
const id = ref(0)
const type = ref('')
//照片上传回调
const zhaopianUploadSuccess = (e) => {
  form.value.zhaopian = e
}
//性别列表
const xingbieLists = ref([])
//科室列表
const keshiLists = ref([])
//methods

//获取唯一标识
const getUUID = () => {
  return new Date().getTime()
}
//重置
const resetForm = () => {
  form.value = {
    yishengzhanghao: '',
    yishengmima: '',
    yishengxingming: '',
    zhaopian: '',
    xingbie: '',
    lianxidianhua: '',
    shanzhanglingyu: '',
    gerenjianjie: '',
    storeupnum: '0',
    keshi: '',
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
      res.data.data.gerenjianjie = res.data.data.gerenjianjie
        ? res.data.data.gerenjianjie.replace(
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
      if (x == 'yishengzhanghao') {
        form.value.yishengzhanghao = row[x]
        disabledForm.value.yishengzhanghao = true
        continue
      }
      if (x == 'yishengmima') {
        form.value.yishengmima = row[x]
        disabledForm.value.yishengmima = true
        continue
      }
      if (x == 'yishengxingming') {
        form.value.yishengxingming = row[x]
        disabledForm.value.yishengxingming = true
        continue
      }
      if (x == 'zhaopian') {
        form.value.zhaopian = row[x]
        disabledForm.value.zhaopian = true
        continue
      }
      if (x == 'xingbie') {
        form.value.xingbie = row[x]
        disabledForm.value.xingbie = true
        continue
      }
      if (x == 'lianxidianhua') {
        form.value.lianxidianhua = row[x]
        disabledForm.value.lianxidianhua = true
        continue
      }
      if (x == 'shanzhanglingyu') {
        form.value.shanzhanglingyu = row[x]
        disabledForm.value.shanzhanglingyu = true
        continue
      }
      if (x == 'gerenjianjie') {
        form.value.gerenjianjie = row[x]
        disabledForm.value.gerenjianjie = true
        continue
      }
      if (x == 'storeupnum') {
        form.value.storeupnum = row[x]
        disabledForm.value.storeupnum = true
        continue
      }
      if (x == 'keshi') {
        form.value.keshi = row[x]
        disabledForm.value.keshi = true
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
    form.value.storeupnum = '0'
    formVisible.value = true
  }

  context
    ?.$http({
      url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
      method: 'get',
    })
    .then((res) => {
      var json = res.data.data
    })
  xingbieLists.value = '男,女'.split(',')
  context
    ?.$http({
      url: `option/keshi/keshi`,
      method: 'get',
    })
    .then((res) => {
      keshiLists.value = res.data.data
    })
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
  if (form.value.zhaopian != null) {
    form.value.zhaopian = form.value.zhaopian.replace(
      new RegExp(context?.$config.url, 'g'),
      ''
    )
  }
  var table = crossTable.value
  var objcross = JSON.parse(JSON.stringify(crossRow.value))
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
      //图片上传样式
      .el-upload-list {
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
          .el-icon {
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

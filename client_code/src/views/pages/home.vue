<template>
  <div>
    <div class="home_box">
      <!-- 医生首页展示 -->
      <div class="homeList_view">
        <div class="homeList_title">医生展示</div>
        <div class="home_list_two">
          <mySwiper
            :data="yishengHomeList"
            :type="3"
            :loop="false"
            :navigation="true"
            :pagination="false"
            :paginationType="1"
            :scrollbar="false"
            :slidesPerView="5"
            :spaceBetween="20"
            :autoHeight="false"
            :centeredSlides="false"
            :freeMode="false"
            :effectType="0"
            :direction="horizontal"
            :autoplay="true"
            :slidesPerColumn="1"
          >
            <template #default="scope">
              <div
                class="home_item animation_box"
                @click="detailClick('yisheng', scope.row.id)"
              >
                <div class="home_img_box">
                  <img
                    class="home_img"
                    v-if="isHttp(scope.row.zhaopian)"
                    :src="scope.row.zhaopian.split(',')[0]"
                    alt=""
                  />
                  <img
                    class="home_img"
                    v-else
                    :src="
                      scope.row.zhaopian
                        ? $config.url + scope.row.zhaopian.split(',')[0]
                        : ''
                    "
                    alt=""
                  />
                </div>
                <div class="home_content">
                  <div class="home_title">
                    医生姓名：{{ scope.row.yishengxingming }}
                  </div>
                  <div class="home_title">
                    擅长领域：{{ scope.row.shanzhanglingyu }}
                  </div>
                </div>
              </div>
            </template>
          </mySwiper>
        </div>
        <div class="homeList_more_view" @click="moreClick('yisheng')">
          <span class="homeList_more_text">查看更多</span>
        </div>
      </div>
      <!-- 医院介绍首页展示 -->
      <div class="homeList_view">
        <div class="homeList_title">医院介绍展示</div>
        <div class="home_list_two">
          <mySwiper
            :data="yiyuanjieshaoHomeList"
            :type="3"
            :loop="false"
            :navigation="true"
            :pagination="false"
            :paginationType="1"
            :scrollbar="false"
            :slidesPerView="5"
            :spaceBetween="20"
            :autoHeight="false"
            :centeredSlides="false"
            :freeMode="false"
            :effectType="0"
            :direction="horizontal"
            :autoplay="true"
            :slidesPerColumn="1"
          >
            <template #default="scope">
              <div
                class="home_item animation_box"
                @click="detailClick('yiyuanjieshao', scope.row.id)"
              >
                <div class="home_img_box">
                  <img
                    class="home_img"
                    v-if="isHttp(scope.row.yiyuantupian)"
                    :src="scope.row.yiyuantupian.split(',')[0]"
                    alt=""
                  />
                  <img
                    class="home_img"
                    v-else
                    :src="
                      scope.row.yiyuantupian
                        ? $config.url + scope.row.yiyuantupian.split(',')[0]
                        : ''
                    "
                    alt=""
                  />
                </div>
                <div class="home_content">
                  <div class="home_title">
                    {{ scope.row.yiyuanmingcheng }}
                  </div>
                  <div class="home_title">
                    医院地址：{{ scope.row.yiyuandizhi }}
                  </div>
                </div>
              </div>
            </template>
          </mySwiper>
        </div>
        <div class="homeList_more_view" @click="moreClick('yiyuanjieshao')">
          <span class="homeList_more_text">查看更多</span>
        </div>
      </div>
      <!-- 门诊医生首页展示 -->
      <div class="homeList_view">
        <div class="homeList_title">门诊医生展示</div>
        <div class="home_list_two">
          <mySwiper
            :data="menzhenyishengHomeList"
            :type="3"
            :loop="false"
            :navigation="true"
            :pagination="false"
            :paginationType="1"
            :scrollbar="false"
            :slidesPerView="5"
            :spaceBetween="20"
            :autoHeight="false"
            :centeredSlides="false"
            :freeMode="false"
            :effectType="0"
            :direction="horizontal"
            :autoplay="true"
            :slidesPerColumn="1"
          >
            <template #default="scope">
              <div
                class="home_item animation_box"
                @click="detailClick('menzhenyisheng', scope.row.id)"
              >
                <div class="home_img_box">
                  <img
                    class="home_img"
                    v-if="isHttp(scope.row.zhaopian)"
                    :src="scope.row.zhaopian.split(',')[0]"
                    alt=""
                  />
                  <img
                    class="home_img"
                    v-else
                    :src="
                      scope.row.zhaopian
                        ? $config.url + scope.row.zhaopian.split(',')[0]
                        : ''
                    "
                    alt=""
                  />
                </div>
                <div class="home_content">
                  <div class="home_title">
                    {{ scope.row.yishengzhanghao }}
                  </div>
                  <div class="home_title">
                    挂号费：{{ scope.row.guahaofei }}
                  </div>
                </div>
              </div>
            </template>
          </mySwiper>
        </div>
        <div class="homeList_more_view" @click="moreClick('menzhenyisheng')">
          <span class="homeList_more_text">查看更多</span>
        </div>
      </div>
      <!-- 药品信息首页展示 -->
      <div class="homeList_view">
        <div class="homeList_title">药品信息展示</div>
        <div class="home_list_two">
          <mySwiper
            :data="yaopinxinxiHomeList"
            :type="3"
            :loop="false"
            :navigation="true"
            :pagination="false"
            :paginationType="1"
            :scrollbar="false"
            :slidesPerView="5"
            :spaceBetween="20"
            :autoHeight="false"
            :centeredSlides="false"
            :freeMode="false"
            :effectType="0"
            :direction="horizontal"
            :autoplay="true"
            :slidesPerColumn="1"
          >
            <template #default="scope">
              <div
                class="home_item animation_box"
                @click="detailClick('yaopinxinxi', scope.row.id)"
              >
                <div class="home_img_box">
                  <img
                    class="home_img"
                    v-if="isHttp(scope.row.yaopintupian)"
                    :src="scope.row.yaopintupian.split(',')[0]"
                    alt=""
                  />
                  <img
                    class="home_img"
                    v-else
                    :src="
                      scope.row.yaopintupian
                        ? $config.url + scope.row.yaopintupian.split(',')[0]
                        : ''
                    "
                    alt=""
                  />
                </div>
                <div class="home_content">
                  <div class="home_title">
                    {{ scope.row.yaopinmingcheng }}
                  </div>
                  <div class="home_title">规格：{{ scope.row.guige }}</div>
                </div>
              </div>
            </template>
          </mySwiper>
        </div>
        <div class="homeList_more_view" @click="moreClick('yaopinxinxi')">
          <span class="homeList_more_text">查看更多</span>
        </div>
      </div>
      <!-- 诊疗项目首页展示 -->
      <div class="homeList_view">
        <div class="homeList_title">诊疗项目展示</div>
        <div class="home_list_two">
          <mySwiper
            :data="zhenliaoxiangmuHomeList"
            :type="3"
            :loop="false"
            :navigation="true"
            :pagination="false"
            :paginationType="1"
            :scrollbar="false"
            :slidesPerView="5"
            :spaceBetween="20"
            :autoHeight="false"
            :centeredSlides="false"
            :freeMode="false"
            :effectType="0"
            :direction="horizontal"
            :autoplay="true"
            :slidesPerColumn="1"
          >
            <template #default="scope">
              <div
                class="home_item animation_box"
                @click="detailClick('zhenliaoxiangmu', scope.row.id)"
              >
                <div class="home_img_box">
                  <img
                    class="home_img"
                    v-if="isHttp(scope.row.xiangmutupian)"
                    :src="scope.row.xiangmutupian.split(',')[0]"
                    alt=""
                  />
                  <img
                    class="home_img"
                    v-else
                    :src="
                      scope.row.xiangmutupian
                        ? $config.url + scope.row.xiangmutupian.split(',')[0]
                        : ''
                    "
                    alt=""
                  />
                </div>
                <div class="home_content">
                  <div class="home_title">
                    {{ scope.row.xiangmumingcheng }}
                  </div>
                </div>
              </div>
            </template>
          </mySwiper>
        </div>
        <div class="homeList_more_view" @click="moreClick('zhenliaoxiangmu')">
          <span class="homeList_more_text">查看更多</span>
        </div>
      </div>
      <!-- 公告信息 -->
      <div class="newsList_view">
        <div class="newsList_title">公告信息</div>
        <div class="news_list_six">
          <div
            v-for="(item, index) in newsList"
            :key="index"
            :class="'news_list_six_item' + (Number(index) + 1)"
            @click="newsDetailClick(item.id)"
          >
            <div class="img_box">
              <img
                class="news_img"
                v-if="isHttp(item.picture)"
                :src="item.picture.split(',')[0]"
                alt=""
              />
              <img
                class="news_img"
                v-else
                :src="
                  item.picture ? $config.url + item.picture.split(',')[0] : ''
                "
                alt=""
              />
            </div>
            <div class="content">
              <div class="news_title">{{ item.title }}</div>
              <div class="news_text">{{ item.introduction }}</div>
              <div class="news_time">
                {{ item.addtime.split(' ')[0].split('-')[0] }}-{{
                  item.addtime.split(' ')[0].split('-')[1]
                }}-{{ item.addtime.split(' ')[0].split('-')[2] }}
              </div>
            </div>
          </div>
        </div>
        <div class="news_more_view" @click="moreClick('news')">
          <span class="news_more_text">查看更多</span>
        </div>
      </div>
    </div>
    <formModel ref="newsFormModelRef"></formModel>
  </div>
</template>

<script setup>
import { ref, getCurrentInstance } from 'vue'
import { useRouter } from 'vue-router'
const context = getCurrentInstance()?.appContext.config.globalProperties
const router = useRouter()
//医生首页展示
const yishengHomeList = ref([])
const getyishengHomeList = () => {
  context
    ?.$http({
      url: 'yisheng/list',
      method: 'get',
      params: {
        page: 1,
        limit: 10,
      },
    })
    .then((res) => {
      yishengHomeList.value = res.data.data.list
    })
}
//医院介绍首页展示
const yiyuanjieshaoHomeList = ref([])
const getyiyuanjieshaoHomeList = () => {
  context
    ?.$http({
      url: 'yiyuanjieshao/list',
      method: 'get',
      params: {
        page: 1,
        limit: 10,
      },
    })
    .then((res) => {
      yiyuanjieshaoHomeList.value = res.data.data.list
    })
}
//门诊医生首页展示
const menzhenyishengHomeList = ref([])
const getmenzhenyishengHomeList = () => {
  context
    ?.$http({
      url: 'menzhenyisheng/list',
      method: 'get',
      params: {
        page: 1,
        limit: 10,
      },
    })
    .then((res) => {
      menzhenyishengHomeList.value = res.data.data.list
    })
}
//药品信息首页展示
const yaopinxinxiHomeList = ref([])
const getyaopinxinxiHomeList = () => {
  context
    ?.$http({
      url: 'yaopinxinxi/list',
      method: 'get',
      params: {
        page: 1,
        limit: 10,
      },
    })
    .then((res) => {
      yaopinxinxiHomeList.value = res.data.data.list
    })
}
//诊疗项目首页展示
const zhenliaoxiangmuHomeList = ref([])
const getzhenliaoxiangmuHomeList = () => {
  context
    ?.$http({
      url: 'zhenliaoxiangmu/list',
      method: 'get',
      params: {
        page: 1,
        limit: 10,
      },
    })
    .then((res) => {
      zhenliaoxiangmuHomeList.value = res.data.data.list
    })
}
//公告信息弹窗
import formModel from './news/formModel'
const newsFormModelRef = ref(null)
//公告信息
const newsList = ref([])
const getNewsList = () => {
  context
    ?.$http({
      url: 'news/list',
      method: 'get',
      params: {
        page: 1,
        limit: 3,
      },
    })
    .then((res) => {
      newsList.value = res.data.data.list
    })
}
const newsDetailClick = (id = null) => {
  if (id) {
    newsFormModelRef.value.init(id)
  }
}
//判断图片链接是否带http
const isHttp = (str) => {
  return str && str.substr(0, 4) == 'http'
}
//跳转详情
const detailClick = (table, id) => {
  router.push(`/index/${table}Detail?id=${id}`)
}
const moreClick = (table) => {
  router.push(`/index/${table}List`)
}
const init = () => {
  //医生首页展示
  getyishengHomeList()
  //医院介绍首页展示
  getyiyuanjieshaoHomeList()
  //门诊医生首页展示
  getmenzhenyishengHomeList()
  //药品信息首页展示
  getyaopinxinxiHomeList()
  //诊疗项目首页展示
  getzhenliaoxiangmuHomeList()
  //公告信息
  getNewsList()
}
init()
</script>

<style lang="scss">
.home_box {
  padding: 0;
  margin: 0 auto;
  background: #fff;
  display: flex;
  width: 100%;
  justify-content: space-between;
  align-items: flex-start;
  flex-wrap: wrap;
}

// 推荐
.recomList_view {
  padding: 20px 18%;
  margin: 0 auto;
  background: url(http://localhost:8080/hospitalRegistration/file/0178925d75c04c969126514664fa9b48.png)
    no-repeat center top / 100% 100%;
  width: 100%;
  position: relative;
  order: 1;
  .recomList_title {
    padding: 0 0 20px;
    margin: 40px 0 0;
    color: #fff;
    font-weight: 600;
    width: auto;
    font-size: 27px;
    border-color: #2da065;
    border-width: 0 0 0px;
    border-style: solid;
    text-align: center;
  }
  // list
  .recommend_list_four {
    padding: 0;
    margin: 20px 0 0;
    display: flex;
    width: 100%;
    justify-content: space-between;
    align-items: flex-start;
    flex-wrap: wrap;
    height: auto;

    .recommend_item:nth-of-type(2n - 1) {
      border: 0px solid #eee;
      padding: 0px;
      margin: 0;
      overflow: hidden;
      background: #fff;
      width: calc(100% / 4 - 40px);
      position: relative;

      .recommend_img_box {
        width: 100%;
        height: 240px;
        .recommend_img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .recommend_content {
        border: 0px solid #eee;
        padding: 20px 0;
        bottom: 100%;
        display: flex;
        transition: all 0.5s;
        flex-wrap: wrap;
        box-shadow: 0 0px 0px rgba(0, 0, 0, 0.3);
        overflow: hidden;
        left: 0;
        background: rgba(210, 99, 98, 0.4);
        width: 100%;
        justify-content: center;
        align-items: flex-start;
        position: absolute;
        height: 100%;
        .recommend_title1 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title2 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title3 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title4 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title5 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_price {
          color: #f00;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_four_bottom {
          margin: 10px 0 0;
          display: flex;
          justify-content: center;
          align-items: center;
          .recommend_like {
            margin: 0 10px 0 0;
            color: #0266b5;
            display: flex;
            font-size: 14px;
            align-items: center;
            .like_icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .like_num {
              color: inherit;
            }
          }
          .recommend_collect {
            margin: 0 10px 0 0;
            color: #ee7810;
            display: flex;
            font-size: 14px;
            align-items: center;
            .el-icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .collect_num {
              color: inherit;
            }
          }
          .recommend_clickNum {
            margin: 0 10px 0 0;
            color: #4aac26;
            display: flex;
            font-size: 14px;
            align-items: center;
            .el-icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .clickNum_num {
              color: inherit;
            }
          }
        }
      }
    }
    .recommend_item:nth-of-type(2n) {
      border: 0px solid #eee;
      padding: 0px;
      margin: 0;
      overflow: hidden;
      background: none;
      width: calc(100% / 4 - 40px);
      position: relative;

      .recommend_img_box {
        width: 100%;
        height: 240px;
        .recommend_img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .recommend_content {
        border: 0px solid #eee;
        padding: 20px 0;
        bottom: 100%;
        display: flex;
        transition: all 0.5s;
        flex-wrap: wrap;
        box-shadow: 0 0px 0px rgba(0, 0, 0, 0.3);
        left: 0;
        background: rgba(210, 99, 98, 0.4);
        width: 100%;
        justify-content: center;
        align-items: flex-start;
        position: absolute;
        height: 100%;
        .recommend_title1 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title2 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title3 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title4 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_title5 {
          margin: 0 0 10px;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_price {
          color: #f00;
          width: 100%;
          line-height: 1;
          text-align: center;
        }
        .recommend_four_bottom {
          margin: 10px 0 0;
          display: flex;
          justify-content: center;
          align-items: center;
          .recommend_like {
            margin: 0 10px 0 0;
            color: #0266b5;
            display: flex;
            font-size: 14px;
            align-items: center;
            .like_icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .like_num {
              color: inherit;
            }
          }
          .recommend_collect {
            margin: 0 10px 0 0;
            color: #ee7810;
            display: flex;
            font-size: 14px;
            align-items: center;
            .el-icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .collect_num {
              color: inherit;
            }
          }
          .recommend_clickNum {
            margin: 0 10px 0 0;
            color: #4aac26;
            display: flex;
            font-size: 14px;
            align-items: center;
            .el-icon {
              margin: 0 4px 0 0;
              color: inherit;
            }
            .clickNum_num {
              color: inherit;
            }
          }
        }
      }
    }
    .recommend_item:nth-of-type(2n - 1):hover {
      cursor: pointer;
      background: #27bacc;

      .recommend_img_box {
        .recommend_img {
        }
      }
      .recommend_content {
        color: #fff;
        bottom: 0;
        .recommend_title1 {
          color: inherit;
        }
        .recommend_title2 {
          color: inherit;
        }
        .recommend_title3 {
          color: inherit;
        }
        .recommend_title4 {
          color: inherit;
        }
        .recommend_title5 {
          color: inherit;
        }
        .recommend_price {
          color: inherit;
        }
        .recommend_four_bottom {
          .recommend_like {
            color: inherit;
            .like_icon {
              color: inherit;
            }
            .like_num {
              color: inherit;
            }
          }
          .recommend_collect {
            color: inherit;
            .el-icon {
              color: inherit;
            }
            .collect_num {
              color: inherit;
            }
          }
          .recommend_clickNum {
            color: inherit;
            .el-icon {
              color: inherit;
            }
            .clickNum_num {
              color: inherit;
            }
          }
        }
      }
    }
    .recommend_item:nth-of-type(2n):hover {
      cursor: pointer;
      background: #27bacc;

      .recommend_img_box {
        .recommend_img {
        }
      }
      .recommend_content {
        color: #fff;
        bottom: 0;
        .recommend_title1 {
          color: inherit;
        }
        .recommend_title2 {
          color: inherit;
        }
        .recommend_title3 {
          color: inherit;
        }
        .recommend_title4 {
          color: inherit;
        }
        .recommend_title5 {
          color: inherit;
        }
        .recommend_price {
          color: inherit;
        }
        .recommend_four_bottom {
          color: inherit;
          .recommend_like {
            color: inherit;
            .like_icon {
              color: inherit;
            }
            .like_num {
              color: inherit;
            }
          }
          .recommend_collect {
            color: inherit;
            .el-icon {
              color: inherit;
            }
            .collect_num {
              color: inherit;
            }
          }
          .recommend_clickNum {
            color: inherit;
            .el-icon {
              color: inherit;
            }
            .clickNum_num {
              color: inherit;
            }
          }
        }
      }
    }
  }
  // list
  // animation
  .animation_box {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  .animation_box img {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box img:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  // animation
  // 更多
  .recommend_more_view {
    cursor: pointer;
    border: 0px solid #ddd;
    border-radius: 0px;
    padding: 0;
    margin: 30px auto;
    color: #fff;
    background: none;
    width: 120px;
    line-height: 34px;
    text-align: center;
    .recommend_more_text {
      padding: 0 0 26px;
      color: #fff;
      background: url(http://localhost:8080/hospitalRegistration/file/165797f6129944d98ae3ab624c0c5352.png)
        no-repeat center bottom;
      font-size: 18px;
    }
  }
}
// 推荐
// 新闻资讯
.newsList_view {
  padding: 60px 18% 40px;
  margin: 0 auto;
  background: #113961;
  width: 100%;
  position: relative;
  order: 3;
  height: auto;

  .newsList_title {
    padding: 0 0 8px;
    margin: 0 auto 20px;
    color: #fff;
    background: none;
    font-weight: 600;
    width: auto;
    font-size: 27px;
    border-color: #999;
    border-width: 0 0 0px;
    border-style: dashed;
    text-align: center;
  }
  // list
  .news_list_six {
    color: #fff;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    .news_list_six_item1 {
      margin: 0 10px 10px 0;
      overflow: hidden;
      width: calc(50% - 10px);
      position: relative;
      transition: all 0.3s;
      .img_box {
        width: 49%;
        float: left;
        height: 200px;
        .news_img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .content {
        background: none;
        width: 49%;
        float: right;
        transition: all 0.3s;
        height: 100%;
        .news_title {
          overflow: hidden;
          white-space: nowrap;
          font-weight: 600;
          width: 100%;
          font-size: 16px;
          line-height: 30px;
          text-overflow: ellipsis;
        }
        .news_text {
          overflow: hidden;
          font-size: 14px;
          line-height: 24px;
          height: 120px;
        }
        .news_time {
          color: #999;
        }
      }
    }
    .news_list_six_item1:hover {
      .img_box {
        img {
        }
      }
      .content {
        cursor: pointer;
        padding: 10px;
        transform: rotate(360deg);
        color: #333;
        background: #fff;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item2 {
      margin: 0 0 10px 10px;
      overflow: hidden;
      width: calc(50% - 10px);
      position: relative;
      transition: all 0.3s;
      .img_box {
        width: 49%;
        float: left;
        height: 200px;
        img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .content {
        background: none;
        width: 49%;
        float: right;
        transition: all 0.3s;
        height: 100%;
        .news_title {
          overflow: hidden;
          white-space: nowrap;
          font-weight: 600;
          width: 100%;
          font-size: 16px;
          line-height: 30px;
          text-overflow: ellipsis;
        }
        .news_text {
          overflow: hidden;
          font-size: 14px;
          line-height: 24px;
          height: 120px;
        }
        .news_time {
          color: #999;
        }
      }
    }
    .news_list_six_item2:hover {
      .img_box {
        img {
        }
      }
      .content {
        cursor: pointer;
        padding: 10px;
        transform: rotate(360deg);
        color: #333;
        background: #fff;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item3 {
      margin: 0 5px 10px;
      overflow: hidden;
      display: none;
      width: calc(25% - 10px);
      position: relative;
      transition: all 0.3s;
      .img_box {
        width: 100%;
        font-size: 0;
        height: 350px;
        img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .content {
        top: 100%;
        left: 0;
        background: rgba(0, 0, 0, 0.3);
        width: 100%;
        position: absolute;
        transition: all 0.3s;
        height: 100%;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item3:hover {
      .img_box {
        img {
        }
      }
      .content {
        cursor: pointer;
        padding: 10px;
        transform: rotate(360deg);
        color: #333;
        background: #fff;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item4 {
      margin: 0 5px 10px;
      overflow: hidden;
      display: none;
      width: calc(25% - 10px);
      position: relative;
      transition: all 0.3s;
      .img_box {
        width: 100%;
        font-size: 0;
        height: 350px;
        img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .content {
        top: 100%;
        left: 0;
        background: rgba(0, 0, 0, 0.3);
        width: 100%;
        position: absolute;
        transition: all 0.3s;
        height: 100%;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item4:hover {
      .img_box {
        img {
        }
      }
      .content {
        cursor: pointer;
        padding: 10px;
        transform: rotate(360deg);
        color: #333;
        background: #fff;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item5 {
      margin: 0 5px 10px;
      overflow: hidden;
      display: none;
      width: calc(25% - 10px);
      position: relative;
      transition: all 0.3s;
      .img_box {
        width: 100%;
        font-size: 0;
        height: 350px;
        img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .content {
        top: 100%;
        left: 0;
        background: rgba(0, 0, 0, 0.3);
        width: 100%;
        position: absolute;
        transition: all 0.3s;
        height: 100%;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item5:hover {
      .img_box {
        img {
        }
      }
      .content {
        cursor: pointer;
        padding: 10px;
        transform: rotate(360deg);
        color: #333;
        background: #fff;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item6 {
      margin: 0 5px 10px;
      overflow: hidden;
      display: none;
      width: calc(25% - 10px);
      position: relative;
      transition: all 0.3s;
      .img_box {
        width: 100%;
        font-size: 0;
        height: 350px;
        img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .content {
        top: 100%;
        left: 0;
        background: rgba(0, 0, 0, 0.3);
        width: 100%;
        position: absolute;
        transition: all 0.3s;
        height: 100%;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item6:hover {
      .img_box {
        img {
        }
      }
      .content {
        cursor: pointer;
        padding: 10px;
        transform: rotate(360deg);
        color: #333;
        background: #fff;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item7 {
      margin: 0 5px 10px;
      overflow: hidden;
      display: none;
      width: calc(25% - 10px);
      position: relative;
      transition: all 0.3s;
      .img_box {
        width: 100%;
        font-size: 0;
        height: 350px;
        img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .content {
        top: 100%;
        left: 0;
        background: rgba(0, 0, 0, 0.3);
        width: 100%;
        position: absolute;
        transition: all 0.3s;
        height: 100%;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item7:hover {
      .img_box {
        img {
        }
      }
      .content {
        cursor: pointer;
        padding: 10px;
        transform: rotate(360deg);
        color: #333;
        background: #fff;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item8 {
      margin: 0 5px 10px;
      overflow: hidden;
      display: none;
      width: calc(25% - 10px);
      position: relative;
      transition: all 0.3s;
      .img_box {
        width: 100%;
        font-size: 0;
        height: 350px;
        img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .content {
        top: 100%;
        left: 0;
        background: rgba(0, 0, 0, 0.3);
        width: 100%;
        position: absolute;
        transition: all 0.3s;
        height: 100%;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
    .news_list_six_item8:hover {
      .img_box {
        img {
        }
      }
      .content {
        cursor: pointer;
        padding: 10px;
        transform: rotate(360deg);
        color: #333;
        background: #fff;
        .news_title {
        }
        .news_text {
        }
        .news_time {
        }
      }
    }
  }
  // list
  // animation
  .animation_box {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  .animation_box img {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box img:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  // animation
  // 更多
  .news_more_view {
    cursor: pointer;
    border: 0px solid #ddd;
    border-radius: 0px;
    padding: 0px 0;
    margin: 20px auto;
    color: #333;
    background: none;
    width: 80px;
    line-height: 34px;
    text-align: center;
    .news_more_text {
      padding: 0 0 26px;
      color: #fff;
      background: url(http://localhost:8080/hospitalRegistration/file/165797f6129944d98ae3ab624c0c5352.png)
        no-repeat center bottom;
      font-size: 16px;
    }
  }
}
// 新闻资讯
// 首页展示
.homeList_view {
  padding: 60px 18%;
  margin: 0px 0 0;
  background: #c6d7e5;
  width: 100%;
  position: relative;
  text-align: center;
  order: 2;

  .homeList_title {
    padding: 0px;
    margin: 0;
    color: #131313;
    background: none;
    font-weight: 600;
    width: 100%;
    font-size: 27px;
    border-color: #eee;
    border-width: 0px;
    border-style: solid;
    text-align: center;
  }
  // list
  .home_list_two {
    padding: 0;
    margin: 20px auto;
    display: flex;
    width: 100%;
    flex-wrap: wrap;
    .home_item {
      margin: 0;
      background: none;
      width: 100%;
      .home_img_box {
        cursor: pointer;
        margin: 0 0 6px;
        width: 100%;
        height: 200px;
        .home_img {
          object-fit: cover;
          width: 100%;
          height: 100%;
        }
      }
      .home_content {
        .home_title {
          overflow: hidden;
          color: #256fc2;
          white-space: nowrap;
          background: none;
          font-weight: 500;
          width: 100%;
          font-size: 14px;
          line-height: 24px;
          text-overflow: ellipsis;
          text-align: center;
        }
      }
    }
  }
  // list
  // animation
  .animation_box {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  .animation_box img {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    z-index: initial;
  }
  .animation_box img:hover {
    transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
    -webkit-perspective: 1000px;
    perspective: 1000px;
    transition: 0.3s;
  }
  // animation
  // 更多
  .homeList_more_view {
    cursor: pointer;
    border: 0px solid #666;
    border-radius: 20px;
    padding: 0;
    margin: 0 auto;
    color: #999;
    background: none;
    display: inline-block;
    width: 80px;
    line-height: 24px;
    text-align: center;
    .homeList_more_text {
      padding: 0 0 26px;
      color: #131313;
      background: url(http://localhost:8080/hospitalRegistration/file/4a45637c51f249f28659a8c5ac0ef046.png)
        no-repeat center bottom;
      font-size: 16px;
    }
  }
}
// 首页展示
</style>

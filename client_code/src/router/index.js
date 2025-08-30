import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import newsList from '@/views/pages/news/list'
import yishengList from '@/views/pages/yisheng/list'
import yishengDetail from '@/views/pages/yisheng/formModel'
import yishengAdd from '@/views/pages/yisheng/formAdd'
import paibanxinxiList from '@/views/pages/paibanxinxi/list'
import paibanxinxiDetail from '@/views/pages/paibanxinxi/formModel'
import paibanxinxiAdd from '@/views/pages/paibanxinxi/formAdd'
import huanzheList from '@/views/pages/huanzhe/list'
import huanzheDetail from '@/views/pages/huanzhe/formModel'
import huanzheAdd from '@/views/pages/huanzhe/formAdd'
import huanzheRegister from '@/views/pages/huanzhe/register'
import huanzheCenter from '@/views/pages/huanzhe/center'
import storeupList from '@/views/pages/storeup/list'
import yiyuanjieshaoList from '@/views/pages/yiyuanjieshao/list'
import yiyuanjieshaoDetail from '@/views/pages/yiyuanjieshao/formModel'
import yiyuanjieshaoAdd from '@/views/pages/yiyuanjieshao/formAdd'
import keshiList from '@/views/pages/keshi/list'
import keshiDetail from '@/views/pages/keshi/formModel'
import keshiAdd from '@/views/pages/keshi/formAdd'
import menzhenyishengList from '@/views/pages/menzhenyisheng/list'
import menzhenyishengDetail from '@/views/pages/menzhenyisheng/formModel'
import menzhenyishengAdd from '@/views/pages/menzhenyisheng/formAdd'
import yishengyuyueList from '@/views/pages/yishengyuyue/list'
import yishengyuyueDetail from '@/views/pages/yishengyuyue/formModel'
import yishengyuyueAdd from '@/views/pages/yishengyuyue/formAdd'
import yishengjiuzhenList from '@/views/pages/yishengjiuzhen/list'
import yishengjiuzhenDetail from '@/views/pages/yishengjiuzhen/formModel'
import yishengjiuzhenAdd from '@/views/pages/yishengjiuzhen/formAdd'
import yaopinfenleiList from '@/views/pages/yaopinfenlei/list'
import yaopinfenleiDetail from '@/views/pages/yaopinfenlei/formModel'
import yaopinfenleiAdd from '@/views/pages/yaopinfenlei/formAdd'
import yaopinxinxiList from '@/views/pages/yaopinxinxi/list'
import yaopinxinxiDetail from '@/views/pages/yaopinxinxi/formModel'
import yaopinxinxiAdd from '@/views/pages/yaopinxinxi/formAdd'
import zhenliaoxiangmuList from '@/views/pages/zhenliaoxiangmu/list'
import zhenliaoxiangmuDetail from '@/views/pages/zhenliaoxiangmu/formModel'
import zhenliaoxiangmuAdd from '@/views/pages/zhenliaoxiangmu/formAdd'
import shujutongjiList from '@/views/pages/shujutongji/list'
import shujutongjiDetail from '@/views/pages/shujutongji/formModel'
import shujutongjiAdd from '@/views/pages/shujutongji/formAdd'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'newsList',
			component: newsList
		}
		, {
			path: 'yishengList',
			component: yishengList
		}, {
			path: 'yishengDetail',
			component: yishengDetail
		}, {
			path: 'yishengAdd',
			component: yishengAdd
		}
		, {
			path: 'paibanxinxiList',
			component: paibanxinxiList
		}, {
			path: 'paibanxinxiDetail',
			component: paibanxinxiDetail
		}, {
			path: 'paibanxinxiAdd',
			component: paibanxinxiAdd
		}
		, {
			path: 'huanzheList',
			component: huanzheList
		}, {
			path: 'huanzheDetail',
			component: huanzheDetail
		}, {
			path: 'huanzheAdd',
			component: huanzheAdd
		}
		, {
			path: 'huanzheCenter',
			component: huanzheCenter
		}
		, {
			path: 'storeupList',
			component: storeupList
		}
		, {
			path: 'yiyuanjieshaoList',
			component: yiyuanjieshaoList
		}, {
			path: 'yiyuanjieshaoDetail',
			component: yiyuanjieshaoDetail
		}, {
			path: 'yiyuanjieshaoAdd',
			component: yiyuanjieshaoAdd
		}
		, {
			path: 'keshiList',
			component: keshiList
		}, {
			path: 'keshiDetail',
			component: keshiDetail
		}, {
			path: 'keshiAdd',
			component: keshiAdd
		}
		, {
			path: 'menzhenyishengList',
			component: menzhenyishengList
		}, {
			path: 'menzhenyishengDetail',
			component: menzhenyishengDetail
		}, {
			path: 'menzhenyishengAdd',
			component: menzhenyishengAdd
		}
		, {
			path: 'yishengyuyueList',
			component: yishengyuyueList
		}, {
			path: 'yishengyuyueDetail',
			component: yishengyuyueDetail
		}, {
			path: 'yishengyuyueAdd',
			component: yishengyuyueAdd
		}
		, {
			path: 'yishengjiuzhenList',
			component: yishengjiuzhenList
		}, {
			path: 'yishengjiuzhenDetail',
			component: yishengjiuzhenDetail
		}, {
			path: 'yishengjiuzhenAdd',
			component: yishengjiuzhenAdd
		}
		, {
			path: 'yaopinfenleiList',
			component: yaopinfenleiList
		}, {
			path: 'yaopinfenleiDetail',
			component: yaopinfenleiDetail
		}, {
			path: 'yaopinfenleiAdd',
			component: yaopinfenleiAdd
		}
		, {
			path: 'yaopinxinxiList',
			component: yaopinxinxiList
		}, {
			path: 'yaopinxinxiDetail',
			component: yaopinxinxiDetail
		}, {
			path: 'yaopinxinxiAdd',
			component: yaopinxinxiAdd
		}
		, {
			path: 'zhenliaoxiangmuList',
			component: zhenliaoxiangmuList
		}, {
			path: 'zhenliaoxiangmuDetail',
			component: zhenliaoxiangmuDetail
		}, {
			path: 'zhenliaoxiangmuAdd',
			component: zhenliaoxiangmuAdd
		}
		, {
			path: 'shujutongjiList',
			component: shujutongjiList
		}, {
			path: 'shujutongjiDetail',
			component: shujutongjiDetail
		}, {
			path: 'shujutongjiAdd',
			component: shujutongjiAdd
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/huanzheRegister',
		component: huanzheRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router

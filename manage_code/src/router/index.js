	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import news from '@/views/news/list'
	import menzhenyisheng from '@/views/menzhenyisheng/list'
	import yishengyuyue from '@/views/yishengyuyue/list'
	import huanzhe from '@/views/huanzhe/list'
	import keshi from '@/views/keshi/list'
	import yaopinxinxi from '@/views/yaopinxinxi/list'
	import storeup from '@/views/storeup/list'
	import yaopinfenlei from '@/views/yaopinfenlei/list'
	import shujutongji from '@/views/shujutongji/list'
	import zhenliaoxiangmu from '@/views/zhenliaoxiangmu/list'
	import paibanxinxi from '@/views/paibanxinxi/list'
	import yishengjiuzhen from '@/views/yishengjiuzhen/list'
	import yiyuanjieshao from '@/views/yiyuanjieshao/list'
	import yisheng from '@/views/yisheng/list'
	import config from '@/views/config/list'
	import yishengRegister from '@/views/yisheng/register'
	import yishengCenter from '@/views/yisheng/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/yishengCenter',
			name: '医生个人中心',
			component: yishengCenter
		}
		,{
			path: '/news',
			name: '公告信息',
			component: news
		}
		,{
			path: '/menzhenyisheng',
			name: '门诊医生',
			component: menzhenyisheng
		}
		,{
			path: '/yishengyuyue',
			name: '医生预约',
			component: yishengyuyue
		}
		,{
			path: '/huanzhe',
			name: '患者',
			component: huanzhe
		}
		,{
			path: '/keshi',
			name: '科室',
			component: keshi
		}
		,{
			path: '/yaopinxinxi',
			name: '药品信息',
			component: yaopinxinxi
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/yaopinfenlei',
			name: '药品分类',
			component: yaopinfenlei
		}
		,{
			path: '/shujutongji',
			name: '数据统计',
			component: shujutongji
		}
		,{
			path: '/zhenliaoxiangmu',
			name: '诊疗项目',
			component: zhenliaoxiangmu
		}
		,{
			path: '/paibanxinxi',
			name: '排班信息',
			component: paibanxinxi
		}
		,{
			path: '/yishengjiuzhen',
			name: '医生就诊',
			component: yishengjiuzhen
		}
		,{
			path: '/yiyuanjieshao',
			name: '医院介绍',
			component: yiyuanjieshao
		}
		,{
			path: '/yisheng',
			name: '医生',
			component: yisheng
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		]
	},
	{
		path: '/yishengRegister',
		name: '医生注册',
		component: yishengRegister
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router

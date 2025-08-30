const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '门诊医生管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'门诊医生',
							url:'/index/menzhenyishengList'
						},
					]
				},
				{
					name: '药品信息管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'药品信息',
							url:'/index/yaopinxinxiList'
						},
					]
				},
				{
					name: '新闻资讯管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'公告信息',
							url:'/index/newsList'
						},
					]
				},
				{
					name: '诊疗项目管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'诊疗项目',
							url:'/index/zhenliaoxiangmuList'
						},
					]
				},
				{
					name: '医院介绍管理',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'医院介绍',
							url:'/index/yiyuanjieshaoList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "基于SpringBoot+Vue的口腔医院预约挂号系统"
        } 
    }
}
export default config

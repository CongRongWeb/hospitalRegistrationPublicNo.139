<template>
	<div class="home_view">
		<div class="projectTitle">欢迎使用 {{projectName}}</div>
		<div class="count_list">
			<el-collapse-transition v-if="btnAuth('yishengyuyue','首页总数')">
				<el-card v-show="countTypeList.closeyishengyuyueCountType" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								医生预约
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddenyishengyuyueCountType')" class="showIcons"
									:class="countTypeList.hiddenyishengyuyueCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closeyishengyuyueCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
							
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddenyishengyuyueCountType">
							<div class="count_title">医生预约总数</div>
							<div class="count_num">{{yishengyuyueCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('shujutongji','首页总数')">
				<el-card v-show="countTypeList.closeshujutongjiCountType" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								数据统计
							</div>
							<div class="card_head_right">
								<el-icon @click="countTypeClick('hiddenshujutongjiCountType')" class="showIcons"
									:class="countTypeList.hiddenshujutongjiCountType?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="countTypeClick('closeshujutongjiCountType')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
							
						</div>
					</template>
					<el-collapse-transition>
						<div class="count_item" v-show="countTypeList.hiddenshujutongjiCountType">
							<div class="count_title">数据统计总数</div>
							<div class="count_num">{{shujutongjiCount}}</div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
		<div class="card_list">
			<el-collapse-transition v-if="btnAuth('yishengyuyue','首页统计')">
				<el-card v-show="cardTypeList.closeyishengyuyueChartType1" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								医生预约
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenyishengyuyueChartType1')" class="showIcons"
									:class="cardTypeList.hiddenyishengyuyueChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeyishengyuyueChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenyishengyuyueChartType1">
							<div id="yishengyuyuerenshuEchart1" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('shujutongji','首页统计')">
				<el-card v-show="cardTypeList.closeshujutongjiChartType1" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								数据统计
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenshujutongjiChartType1')" class="showIcons"
									:class="cardTypeList.hiddenshujutongjiChartType1?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeshujutongjiChartType1')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenshujutongjiChartType1">
							<div id="shujutongjijiezhenrenshuEchart1" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('shujutongji','首页统计')">
				<el-card v-show="cardTypeList.closeshujutongjiChartType2" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								数据统计
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenshujutongjiChartType2')" class="showIcons"
									:class="cardTypeList.hiddenshujutongjiChartType2?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeshujutongjiChartType2')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenshujutongjiChartType2">
							<div id="shujutongjiyuyuelvEchart2" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
			<el-collapse-transition v-if="btnAuth('shujutongji','首页统计')">
				<el-card v-show="cardTypeList.closeshujutongjiChartType3" class="card_view">
					<template #header>
						<div class="index_card_head">
							<div class="card_head_title">
								数据统计
							</div>
							<div class="card_head_right">
								<el-icon @click="cardTypeClick('hiddenshujutongjiChartType3')" class="showIcons"
									:class="cardTypeList.hiddenshujutongjiChartType3?'showIcons1':''">
									<ArrowUpBold />
								</el-icon>
								<el-icon @click="cardTypeClick('closeshujutongjiChartType3')" class="closeIcons">
									<CloseBold />
								</el-icon>
							</div>
						</div>
					</template>
					<el-collapse-transition>
						<div class="card_item" v-show="cardTypeList.hiddenshujutongjiChartType3">
							<div id="shujutongjihaopinglvEchart3" style="width: 100%;height: 400px;"></div>
						</div>
					</el-collapse-transition>
				</el-card>
			</el-collapse-transition>
		</div>
	</div>
</template>

<script setup>
	import {
		inject,
		nextTick,
		ref,
		getCurrentInstance
	} from 'vue';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const projectName = context.$project.projectName
	const countTypeList = ref({
	})
	const getCountList=()=>{
		countTypeList.value.closeyishengyuyueCountType = true
		countTypeList.value.hiddenyishengyuyueCountType = true
		if(btnAuth('yishengyuyue','首页总数')){
			getyishengyuyueCount()
		}
		countTypeList.value.closeshujutongjiCountType = true
		countTypeList.value.hiddenshujutongjiCountType = true
		if(btnAuth('shujutongji','首页总数')){
			getshujutongjiCount()
		}
	}
	const yishengyuyueCount = ref(0)
	const getyishengyuyueCount = () => {
		context?.$http({
			url:'yishengyuyue/count',
			method: 'get'
		}).then(res=>{
			yishengyuyueCount.value = res.data.data
		})
	}
	const shujutongjiCount = ref(0)
	const getshujutongjiCount = () => {
		context?.$http({
			url:'shujutongji/count',
			method: 'get'
		}).then(res=>{
			shujutongjiCount.value = res.data.data
		})
	}
	const countTypeClick = (e) => {
		countTypeList.value[e] = !countTypeList.value[e]
	}
	const init=()=>{
		getCountList()
		getCardList()
	}
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
	let echarts = inject("echarts")
	const cardTypeClick = (e) =>{
		cardTypeList.value[e] = !cardTypeList.value[e]
		setTimeout(()=>{
			getCardList()
		},1000)
	}
	const cardTypeList = ref({
		closeyishengyuyueChartType1: true,
		hiddenyishengyuyueChartType1: true,
		closeshujutongjiChartType1: true,
		hiddenshujutongjiChartType1: true,
		closeshujutongjiChartType2: true,
		hiddenshujutongjiChartType2: true,
		closeshujutongjiChartType3: true,
		hiddenshujutongjiChartType3: true,
	})
	const getCardList = () => {
		if(btnAuth('yishengyuyue','首页统计')){
			getyishengyuyueChart1()
		}
		if(btnAuth('shujutongji','首页统计')){
			getshujutongjiChart1()
		}
		if(btnAuth('shujutongji','首页统计')){
			getshujutongjiChart2()
		}
		if(btnAuth('shujutongji','首页统计')){
			getshujutongjiChart3()
		}
	}
	const getyishengyuyueChart1 = () => {
		nextTick(()=>{
			var renshuEchart1 = echarts.init(document.getElementById("yishengyuyuerenshuEchart1"),'macarons');
			context?.$http({
				url: `yishengyuyue/value/yuyueshijian/renshu/日`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].yuyueshijian);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].yuyueshijian
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '预约人数统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel: {
                            rotate: 40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
				renshuEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				renshuEchart1.setOption(option);
				//根据窗口的大小变动图表
				renshuEchart1.resize();
			})
		})
	}
	const getshujutongjiChart1 = () => {
		nextTick(()=>{
			var jiezhenrenshuEchart1 = echarts.init(document.getElementById("shujutongjijiezhenrenshuEchart1"),'macarons');
			context?.$http({
				url: `shujutongji/value/yishengzhanghao/jiezhenrenshu`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].yishengzhanghao);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].yishengzhanghao
				    })
				}
				var option = {};
                option = {
                    title: {
                        text: '接诊人数统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel: {
                            rotate: 40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
				jiezhenrenshuEchart1.clear()
				// 使用刚指定的配置项和数据显示图表。
				jiezhenrenshuEchart1.setOption(option);
				//根据窗口的大小变动图表
				jiezhenrenshuEchart1.resize();
			})
		})
	}
	const getshujutongjiChart2 = () => {
		nextTick(()=>{
			var yuyuelvEchart2 = echarts.init(document.getElementById("shujutongjiyuyuelvEchart2"),'macarons');
			context?.$http({
				url: `shujutongji/value/yishengzhanghao/yuyuelv`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].yishengzhanghao);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].yishengzhanghao
				    })
				}
				var option = {};
				option = {
				    title: {
				        text: '预约率分析',
				        left: 'center'
				    },
				    tooltip: {
				      trigger: 'item',
				      formatter: '{b} : {c}'
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: xAxis
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: [{
				        data: yAxis,
				        type: 'line',
						areaStyle: {},
						smooth: true
                    }]
                };
				// 使用刚指定的配置项和数据显示图表。
				yuyuelvEchart2.clear()
				yuyuelvEchart2.setOption(option);
				//根据窗口的大小变动图表
				yuyuelvEchart2.resize();
			})
		})
	}
	const getshujutongjiChart3 = () => {
		nextTick(()=>{
        //  haopinglv
			var haopinglvEchart3 = echarts.init(document.getElementById("shujutongjihaopinglvEchart3"),'macarons');
			context?.$http({
				url: `shujutongji/value/yishengzhanghao/haopinglv`,
				method: "get",
			}).then(obj=>{
				let res = obj.data.data
				let xAxis = [];
				let yAxis = [];
				let pArray = []
				for(let i=0;i<res.length;i++){
				    xAxis.push(res[i].yishengzhanghao);
				    yAxis.push(parseFloat((res[i].total)));
				    pArray.push({
				        value: parseFloat((res[i].total)),
				        name: res[i].yishengzhanghao
				    })
				}
				var option = {};
				option = {
				    title: {
				        text: '好评率分析',
				        left: 'center'
				    },
				    tooltip: {
				      trigger: 'item',
				      formatter: '{b} : {c}'
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: xAxis
				    },
				    yAxis: {
				        type: 'value'
				    },
				    series: [{
				        data: yAxis,
				        type: 'line',
                    }]
                };
				// 使用刚指定的配置项和数据显示图表。
				haopinglvEchart3.clear()
				haopinglvEchart3.setOption(option);
				//根据窗口的大小变动图表
				haopinglvEchart3.resize();
			})
		})
	}
	init()
</script>
<style lang="scss">
	.projectTitle{
		padding: 20px 0;
		margin: 20px 0 20px;
		color: #fff;
		font-weight: 500;
		display: flex;
		width: 100%;
		font-size: 24px;
		justify-content: center;
		align-items: center;
		height: auto;
	}

	.showIcons {
		transition: transform 0.3s;
		margin-right: 10px;
	}

	.showIcons1 {
		transform: rotate(-180deg);
	}
	
	// 总数盒子
	.count_list{
		padding: 0 0 20px;
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: flex-start;
		flex-wrap: wrap;
		// 总数card
		.card_view {
			border: 1px solid rgba(254, 182, 203, 0.5);
			border-radius: 0;
			box-shadow: 0px 0px 0px rgba(0,0,0,.12);
			margin: 0 1% 20px;
			background: rgba(255, 255, 255, 0.5);
			flex: 1;
			width: 31%;
			box-sizing: border-box;
			height: auto;
			// card头部
			.el-card__header {
				border: 0px solid rgba(254, 182, 203, 0.5);
				background: rgba(255, 255, 255, 0.3);
				width: 100%;
				border-width: 0 0 1px;
				// 头部盒子
				.index_card_head {
					display: flex;
					width: 100%;
					justify-content: space-between;
					align-items: center;
					height: 10px;
					// 标题
					.card_head_title {
						color: #555;
						font-size: 14px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon {
							cursor: pointer;
							color: #666;
							font-size: 20px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				// body盒子
				.count_item{
					padding: 30px;
					text-align: center;
					// 总数标题
					.count_title{
						color: #333;
						font-size: 16px;
						line-height: 2;
					}
					// 总数数字
					.count_num{
						color: #f00;
						font-size: 30px;
						line-height: 2;
					}
				}
			}
		}
	}
	// 首页盒子
	.home_view {
		padding: 0px 20px;
		margin: 0;
		background: none;
		min-height: 100vh;
		height: auto;
	}
	// 统计图盒子
	.card_list {
		padding: 0 0 20px;
		display: flex;
		width: 100%;
		justify-content: space-between;
		align-items: flex-start;
		flex-wrap: wrap;
		// 统计图card
		.card_view {
			border: 1px solid rgba(254, 182, 203, 0.5);
			border-radius: 0;
			box-shadow: 0px 0px 0px rgba(0,0,0,.12);
			margin: 0 1% 30px;
			background: rgba(255, 255, 255, 0.5);
			width: 48%;
			box-sizing: border-box;
			height: auto;
			// 头部
			.el-card__header {
				border: 0px solid rgba(254, 182, 203, 0.5);
				background: rgba(255, 255, 255, 0.3);
				width: 100%;
				border-width: 0 0 1px;
				// 头部盒子
				.index_card_head {
					display: flex;
					width: 100%;
					justify-content: space-between;
					align-items: center;
					height: 10px;
					// 标题
					.card_head_title {
						color: #555;
						font-size: 14px;
					}
					// 按钮盒子
					.card_head_right {
						display: flex;
						align-items: center;
						// 按钮
						.el-icon{
							cursor: pointer;
							color: #666;
							font-size: 20px;
						}
					}
				}
			}
			// body
			.el-card__body {
				padding: 0;
				// body盒子
				.card_item{
					padding: 30px;
					text-align: center;
				}
			}
		}
	}
</style>

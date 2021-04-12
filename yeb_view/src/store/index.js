import Vue from 'vue'
import Vuex from 'vuex'
import {getRequest} from "../utils/api";
import SockJS from 'sockjs-client'
import Stomp from 'stompjs'

Vue.use(Vuex);
const now = new Date();

const store = new Vuex.Store({
  state: {
    routes: [],
    admins: [],
    sessions:[],
    currentAdmin: JSON.parse(window.sessionStorage.getItem('user')),
    currentSessionId: -1,
    filterKey:'',
    stomp: null
  },
  mutations: {
    init_admin(state,admin){
      state.currentAdmin = admin;
    },
    initRoutes(state,data){
      state.routes = data;
    },
    changeCurrentSessionId (state,id) {
      state.currentSessionId = id;
    },
    addMessage (state,msg) {
      state.sessions[state.currentSessionId-1].messages.push({
        content:msg,
        date: new Date(),
        self:true
      })
    },
    INIT_DATA (state) {
      //浏览器本地的历史聊天记录
      /*let data = localStorage.getItem('vue-chat-session');
      //console.log(data)
      if (data) {
        state.sessions = JSON.parse(data);
      }*/
    },
    INIT_ADMINS(state,data){
      state.admins = data;
    }
  },
  actions: {
    /*connect(context){
      context.state.stomp = Stomp.over(new SockJS('/ws/ep'));
      let token = window.sessionStorage.getItem('tokenStr');
      context.state.stomp.connect({'Auth-Token': token},success => {
        context.state.stomp.subscribe('user/queue/chat', msg => {
          console.log(msg.body);
        })
      },error => {
        console.log(error);
      })
    },*/
    initData (context) {
      //加载好友列表数据
      getRequest('/chat/admin').then(resp => {
        if(resp){
          context.commit('INIT_ADMINS',resp)
        }
      })
      //context.commit('INIT_DATA')
    }
  }
})

store.watch(function (state) {
  return state.sessions
},function (val) {
  console.log('CHANGE: ', val);
  localStorage.setItem('vue-chat-session', JSON.stringify(val));
},{
  deep:true/*这个貌似是开启watch监测的判断,官方说明也比较模糊*/
})

export default store;

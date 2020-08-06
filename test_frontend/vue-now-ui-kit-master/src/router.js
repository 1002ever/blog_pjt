import Vue from 'vue';
import Router from 'vue-router';
import Index from './pages/Index.vue';
import MyHome from './pages/MyHome.vue';
import Login from './pages/Login.vue';
import Profile from './pages/Profile.vue';
import MainNavbar from './layout/MainNavbar.vue';
import MainFooter from './layout/MainFooter.vue';
import MyBoard from './pages/MyBoard.vue';
import BoardDetail from './pages/board/BoardDetail.vue';
import MyIntroductionDetail from './pages/myblog/MyIntroductionDetail.vue';

Vue.use(Router);
const API_URL = 'http://localhost:8080/'

export default new Router({

  linkExactActiveClass: 'active',
  // computed: {
  //   curUid: sync('curUid'),
  // },
  routes: [
    {
      path: '/',
      name: 'index',
      components: { default: Index, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }
    },
    {
      path: '/myhome',
      name: 'myhome',
      components: { default: MyHome, header: MainNavbar },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }
    },
    {
      path: '/myboard',
      name: 'myboard',
      components: { default: MyBoard, header: MainNavbar },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }
    },
    {
      path: '/login',
      name: 'login',
      components: { default: Login, header: MainNavbar },
      props: {
        header: { colorOnScroll: 400 }
      }
    },
    {
      path: '/logout',
      name: 'logout',
      beforeEnter(to, from, next) {
        console.log('로그아웃 url 접근')
        next('/')
      }
    },
    {
      path: '/profile',
      name: 'profile',
      components: { default: Profile, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }
    },
    {
      path: '/board/boardno',
      // path: '/board/:id' 추후에 이걸로 수정필요,
      name: 'BoardDetail',
      components: { default: BoardDetail, header: MainNavbar, footer: MainFooter},
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }

    },
    {
      path: '/myboard/introduction/introno',
      // path: '/board/:id' 추후에 이걸로 수정필요,
      name: 'MyIntroductionDetail',
      components: { default: MyIntroductionDetail, header: MainNavbar, footer: MainFooter},
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: 'black' }
      }

    },

   
  ],
  scrollBehavior: to => {
    if (to.hash) {
      return { selector: to.hash };
    } else {
      return { x: 0, y: 0 };
    }
  }
});

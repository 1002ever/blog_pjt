<template>
  <div>
    <div class="page-header clear-filter" filter-color="orange">
      <parallax
        class="page-header-image"
        style="background-image:url('img/bg5.jpg')"
      >
      </parallax>
      <div class="container">
        <div class="photo-container">
          <img :src="this.imgPath" alt="" />
        </div>
        <h3 class="title">{{this.userData.name}}</h3>
        <p class="category">{{this.userData.email}}</p>
        <div class="row justify-content-center">
          <div class="social-description col-12 col-md-4">
            <h3>{{userData.interest1}}</h3>
            <p>제 1 관심 분야</p>
          </div>
          <div class="social-description col-12 col-md-4">
            <h3>{{userData.interest2}}</h3>
            <p>제 2 관심분야</p>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-10 d-flex justify-content-end">
          <IntroCreate/>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios'
import { sync } from 'vuex-pathify'
import IntroCreate from '@/pages/introduction/IntroCreate.vue'

// 1 ~ 5까지 랜덤 수
var rand2 = Math.floor(Math.random()*5) + 1
const API_URL = 'http://localhost:8080/'

export default {
  name: 'introduction',
  bodyClass: 'profile-page',

  data() {
    return {
      imgPath: "img/random_profile/default_profile.jpg",
      userData: "",
      description: "내 소개를 입력해주세요",
      isMyPage: false,
    }
  },
  components: {
    IntroCreate,
  },
  methods: {
    isMine(a, b) {
      return a === b
    },
  },
  computed: {
    curUid: sync('curUid'),
  },

  mounted() {
    const url = `${API_URL}account/userinfo`
    var postInfo = {
      uid: this.curUid,
    }
    console.log(postInfo.uid)
    axios.post(url, postInfo)
    .then(res => {
      this.userData = res.data
      
      if (this.userData.img !== "") {
        this.imgPath = userData.img
      }
      if (this.userData.description !== "") {
        this.description = this.userData.description
      }
      this.isMyPage = this.isMine(this.curUid, this.userData.uid)
    })
    .catch(() => {
      alert("프로필에 접근 권한이 없습니다.")
    })
  },
};
</script>
<style></style>
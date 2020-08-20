<template>
  <div>
    <div class="page-header clear-filter">
      <parallax
        class="page-header-image"
        style="background-image:url('img/bg22.jpg')"
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
    <div class="section">
      <div class="container">
        <div class="button-container">
          <ProfileUpdate :userData="userData"/>
          <DesUpdate :userData="userData"/>
        </div>
        <h3 class="title">About me</h3>
        <h5 class="description">
          {{description}}
        </h5>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios'
import { sync } from 'vuex-pathify'
import ProfileUpdate from '@/pages/ProfileUpdate.vue'
import DesUpdate from '@/pages/DesUpdate.vue'

// 1 ~ 5까지 랜덤 수
var rand2 = Math.floor(Math.random()*5) + 1

export default {
  name: 'profile',
  bodyClass: 'profile-page',

  data() {
    return {
      imgPath: "img/random_profile/default_profile.jpg",
      userData: "",
      description: "내 소개를 입력해주세요",

      API_URL: '',
    }
  },
  components: {
    ProfileUpdate,
    DesUpdate,
  },
  methods: {

  },
  computed: {
    curUid: sync('curUid'),
    DisURL: sync('DisURL'),
    LocalURL: sync('LocalURL'),
    isLocal: sync('isLocal'),
  },

  mounted() {

    if (this.isLocal){
      this.API_URL = this.LocalURL
    } else {
      this.API_URL = this.DisURL
    }
    
    const url = `${this.API_URL}account/userinfo`
    var postInfo = {
      uid: this.curUid,
    }
    console.log(postInfo.uid)

    axios.post(url, postInfo)
    .then(res => {
      this.userData = res.data
      
      if (this.userData.img !== "") {
        this.imgPath = this.userData.img
      }
      if (this.userData.description !== "") {
        this.description = this.userData.description
      }
    })
    .catch(() => {
      alert("프로필에 접근 권한이 없습니다.")
    })
  },
};
</script>
<style></style>

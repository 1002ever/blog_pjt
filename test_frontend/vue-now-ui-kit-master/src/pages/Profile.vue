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
    <div class="section">
      <div class="container">
        <div class="button-container">
          <ProfileUpdate :userData="userData"/>
          <b-button v-if="isMyPage" class="btn btn-primary btn-round btn-lg">비밀번호 변경</b-button>
        </div>
        <h3 class="title">About me</h3>
        <h5 class="description">
          내 소개를 입력하세요.
        </h5>
        <div class="row">
          <div class="col-md-6 ml-auto mr-auto">
            <h4 class="title text-center">My Portfolio</h4>
          </div>
          <tabs
            pills
            class="nav-align-center"
            tab-content-classes="gallery"
            tab-nav-classes="nav-pills-just-icons"
            type="primary"
          >
            <tab-pane title="Profile">
              <i slot="label" class="now-ui-icons design_image"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img src="img/bg6.jpg" class="img-raised" />
                    <img src="img/bg11.jpg" alt="" class="img-raised" />
                  </div>
                  <div class="col-md-6">
                    <img src="img/bg7.jpg" alt="" class="img-raised" />
                    <img src="img/bg8.jpg" alt="" class="img-raised" />
                  </div>
                </div>
              </div>
            </tab-pane>

            <tab-pane title="Home">
              <i slot="label" class="now-ui-icons location_world"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img src="img/bg1.jpg" alt="" class="img-raised" />
                    <img src="img/bg3.jpg" alt="" class="img-raised" />
                  </div>
                  <div class="col-md-6">
                    <img src="img/bg8.jpg" alt="" class="img-raised" />
                    <img src="img/bg7.jpg" alt="" class="img-raised" />
                  </div>
                </div>
              </div>
            </tab-pane>

            <tab-pane title="Messages">
              <i slot="label" class="now-ui-icons sport_user-run"></i>

              <div class="col-md-10 ml-auto mr-auto">
                <div class="row collections">
                  <div class="col-md-6">
                    <img src="img/bg3.jpg" alt="" class="img-raised" />
                    <img src="img/bg8.jpg" alt="" class="img-raised" />
                  </div>
                  <div class="col-md-6">
                    <img src="img/bg7.jpg" alt="" class="img-raised" />
                    <img src="img/bg6.jpg" class="img-raised" />
                  </div>
                </div>
              </div>
            </tab-pane>
          </tabs>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { Tabs, TabPane } from '@/components';
import axios from 'axios'
import { sync } from 'vuex-pathify'
import ProfileUpdate from '@/pages/ProfileUpdate.vue'

// 1 ~ 5까지 랜덤 수
var rand2 = Math.floor(Math.random()*5) + 1
const API_URL = 'http://localhost:8080/'

export default {
  name: 'profile',
  bodyClass: 'profile-page',

  data() {
    return {
      imgPath: "img/random_profile/default_profile.jpg",
      userData: "",
      isMyPage: false,
    }
  },
  components: {
    Tabs,
    TabPane,
    ProfileUpdate,
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
      console.log(this.userData)
      if (this.userData.img !== "") {
        this.imgPath = userData.img
      }
      this.isMyPage = this.isMine(this.curUid, this.userData.uid)
      console.log(this.isMyPage)
    })
    .catch(() => {
      alert("프로필에 접근 권한이 없습니다.")
    })
  },
};
</script>
<style></style>

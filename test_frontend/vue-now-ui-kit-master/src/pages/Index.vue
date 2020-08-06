<template>
  <div>
    <div>
        <div class="mb-4">
          <el-carousel class="page-header-image" height="650px">
            <el-carousel-item>
              <img class="d-block" src="img/header.jpg" alt="First slide" />
              <div class="carousel-caption d-none d-md-block">
                <h5>Designed By JOBIS</h5>
              </div>
            </el-carousel-item>
            <el-carousel-item>
              <img class="d-block" src="img/bg4.jpg" alt="Second slide" />
              <div class="carousel-caption d-none d-md-block">
                <h5>Designed By JOBIS</h5>
              </div>
            </el-carousel-item>
            <el-carousel-item>
              <img class="d-block" src="img/way1.jfif" alt="Third slide" />
              <div class="carousel-caption d-none d-md-block">
                <h5>Designed By JOBIS</h5>
              </div>
            </el-carousel-item>
          </el-carousel>
        </div>
    </div>
    <div class="main">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h2 class="title mb-md-1">Community</h2>
            <div class="container">
              <div class="row">
                <div class="col-md-10 d-flex justify-content-end">
                  <BoardCreate/>
                </div>
              </div>
            </div>
            <div class="col-md-10">
              <MainBoard v-for="board in boards" :key="board.boardno" :board="board"/>
            </div>
          </div>
        </div>
      </div>
    </div>
    <basic-elements></basic-elements>
    <navigation></navigation>
    <tabs-section></tabs-section>
    <progress-pagination></progress-pagination>
    <notifications></notifications>
    <typography></typography>
    <javascript-components></javascript-components>
    <carousel-section></carousel-section>
    <nucleo-icons-section></nucleo-icons-section>
    <div class="section">
      <div class="container text-center">
        <div class="row justify-content-md-center">
          <div class="col-md-12 col-lg-8">
            <h2 class="title">Completed with examples</h2>
            <h5 class="description">
              The kit comes with three pre-built pages to help you get started
              faster. You can change the text and images and you're good to go.
              More importantly, looking at them will give you a picture of what
              you can built with this powerful Bootstrap 4 ui kit.
            </h5>
          </div>
        </div>
      </div>
    </div>
    <signup-form></signup-form>
    <examples-section></examples-section>
    <download-section></download-section>
  </div>
</template>
<script>
import BasicElements from './components/BasicElementsSection';
import Navigation from './components/Navigation';
import TabsSection from './components/Tabs';
import ProgressPagination from './components/ProgressPagination';
import Notifications from './components/Notifications';
import Typography from './components/Typography';
import JavascriptComponents from './components/JavascriptComponents';
import CarouselSection from './components/CarouselSection';
import NucleoIconsSection from './components/NucleoIconsSection';
import SignupForm from './components/SignupForm';
import ExamplesSection from './components/ExamplesSection';
import DownloadSection from './components/DownloadSection';

import { Carousel, CarouselItem } from 'element-ui';
import MainBoard from '@/pages/board/MainBoard.vue';
import Button from'@/pages/board/Button.vue';
import axios from 'axios';
import BoardCreate from '@/pages/board/BoardCreate.vue';

const API_URL = 'http://localhost:8080/'

export default {
  name: 'index',
  bodyClass: 'index-page',
  components: {
    // Parallax,
    BasicElements,
    Navigation,
    TabsSection,
    ProgressPagination,
    Notifications,
    Typography,
    JavascriptComponents,
    CarouselSection,
    NucleoIconsSection,
    SignupForm,
    ExamplesSection,
    DownloadSection,

    [Carousel.name]: Carousel,
    [CarouselItem.name]: CarouselItem,
    MainBoard,
    [Button.name]: Button,
    BoardCreate,

  },
  data(){
    return {
      boards: [],
      modals: {
        classic: false,
      },
    }
  },
  methods: {
    getBoardList() {
      axios.get(`${API_URL}api/board/listAll/`)
      .then(res => {
        this.boards = res.data
      })
      .catch(err => {
        console.log(err)
      })
    }
  },
  created() {
    this.getBoardList()
  },
};
</script>
<style></style>

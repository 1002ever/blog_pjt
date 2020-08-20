<template>
  <div class="container">
    <div class="row mb-md-1">
      <div class="col-md-12 pl-0 d-flex justify-content-between">
          <h2 id="boardSubject" class="d-inline-block mb-sm-1" @click="boardDetailPush" role="button">{{topBoard.subject}}</h2>
          <h5 id="boardUid" class="d-inline-block mb-0">{{topBoard.uid}}</h5>
      </div>
    </div>
    <div class="row mt-md-1">
      <div class="col-md-12 pl-0">
        <p class="text-muted d-flex justify-content-start" @click="boardDetailPush" role="button">
          {{topBoard.content}}
        </p>
      </div>
    </div>
    <div class="row mt-0">
      <div>
        <i id="heartMainBoard" class="fas fa-heart fa-lg " ></i>
        <p class="d-inline-block text-muted pr-3 ml-2"> {{topBoard.likes}}</p>
        <p class="d-inline-block text-muted">댓글 {{commentNumber}}</p>
      </div>
    </div>
    <hr class="row">


  </div>
</template>

<script>
import axios from 'axios'
import { sync } from 'vuex-pathify'


export default {
    name: 'TopListBoard',
    props: {
      topBoard: {
        type: Object,
      }
    },
    data() {
      return {
        commentNumber: '',

        API_URL: '',
      }
    },
    methods: {
      boardDetailPush() {
        this.$router.push({name:'BoardDetail', params:{boardno :this.topBoard.boardno}})
      },
      getComment() {
        const boardno = this.topBoard.boardno
        axios.get(`${this.API_URL}comment/list/${boardno}/`)
        .then(res => {
            this.commentNumber = res.data.length
        })
        .catch(err => {
            console.log(err)
        })
        },
    },
    created() {
      this.getComment()
    },
    mounted() {
      if (this.isLocal){
      this.API_URL = this.LocalURL
      } else {
      this.API_URL = this.DisURL
      }
    },
    computed: {
        curUid: sync('curUid'),
        DisURL: sync('DisURL'),
        LocalURL: sync('LocalURL'),
        isLocal: sync('isLocal'),
    },

}
</script>

<style>
#heartMainBoard {
    color:#ff3636;
}
</style>
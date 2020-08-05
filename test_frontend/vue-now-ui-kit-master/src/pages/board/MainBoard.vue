<template>
  <div class="container">
    <div class="row mb-md-1">
      <div class="col-md-12 pl-0">
          <h2 class="d-flex justify-content-start mb-sm-1" @click="boardDetailPush" role="button">{{title}}</h2>
      </div>
    </div>
    <div class="row mt-md-1">
      <div class="col-md-12 pl-0">
        <p class="text-muted d-flex justify-content-start" @click="boardDetailPush" role="button">
          I will be the leader of a company that ends up being worth
          billions of dollars, because I got the answers...
        </p>
      </div>
    </div>
    <div class="row mt-0">
      <div>
        <i class="now-ui-icons ui-2_favourite-28 text-danger p-1"></i>
        <p class="d-inline-block text-muted pr-3"> {{likeNumber}}</p>
        <p class="d-inline-block text-muted">댓글 {{commentNumber}}</p>
      </div>
    </div>
    <hr class="row">


  </div>
</template>

<script>
export default {
    name: 'MainBoard',
    // props: {
    //   board: {
    //     type: object
    //   }
    // },
    data() {
      return {
        title: 'title',
        likeNumber: 100,
        commentNumber: 7,
      }
    },
    // methods: {
    //   boardDetailPush() {
    //     // this.$router.push({name:'BoardDetail'}, params:{id :this.board.id})
    //   }
    // },
    methods: {
      boardDetailPush(){
        this.$router.push('/board/boardno')
      }
    },

}
</script>

<style>

</style>
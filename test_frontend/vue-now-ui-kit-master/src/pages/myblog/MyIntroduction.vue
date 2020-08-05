<template>
  <div class="container">
    <div class="row mb-md-1">
      <div class="col-md-12 pl-0">
          <h2 class="d-flex justify-content-start mb-sm-1" @click="introDetailPush" role="button">{{title}}</h2>
      </div>
    </div>
    <div class="row mt-md-1">
      <div class="col-md-12 pl-0">
        <p class="text-muted d-flex justify-content-start" @click="introDetailPush" role="button">
          I will be the leader of a company that ends up being worth
          billions of dollars, because I got the answers...
        </p>
      </div>
    </div>
    <hr class="row">


  </div>
</template>

<script>
export default {
    name: 'MyIntroduction',
    // props: {
    //   board: {
    //     type: object
    //   }
    // },
    data() {
      return {
        title: 'title',
      }
    },
    // methods: {
    //   boardDetailPush() {
    //     // this.$router.push({name:'BoardDetail'}, params:{id :this.board.id})
    //   }
    // },
    methods: {
      introDetailPush(){
        this.$router.push('myboard/introduction/introno')
      }
    },

}
</script>

<style>

</style>
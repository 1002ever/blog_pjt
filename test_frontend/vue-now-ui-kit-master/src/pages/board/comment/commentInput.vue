<template>
  <div class="row">
      <div class="col-sm-6 col-lg-9">
          <fg-input placeholder="댓글을 입력해주세요."></fg-input>
      </div> 
      <div class="col-sm-3 col-lg-3"><n-button type="primary" class="mt-0 mb-0" round>등록</n-button></div>
  </div>
</template>

<script>
import Button from '@/pages/board/comment/Button.vue'
import formGroupInput from '@/pages/board/comment/formGroupInput.vue'

export default {
  name: 'commentInput',
  components: {
    [Button.name]: Button,
    [formGroupInput.name]: formGroupInput,
  },
  data() {
    return {
      input: '',
  }
}
}
</script>

<style>

</style>
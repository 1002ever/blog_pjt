<template>
  <div>
    <div class="page-header page-header-small">
      <MyPicture/>
      <MyInput class="container"/>
      <MyCheckbox/>
      <Article/>
    </div>
  </div>
</template>

<script>
import MyCheckbox from '@/pages/myblog/MyCheckbox.vue';
import MyInput from '@/pages/myblog/MyInput.vue';
import MyPicture from '@/pages/myblog/MyPicture.vue';
import Article from '@/pages/myblog/Article.vue';
import { Button, FormGroupInput } from '@/components';


export default {
  name: 'myboard',
  bodyClass: 'myboard-page',
  components: {
    MyPicture,
    MyCheckbox,
    MyInput,
    Article,
  },
  data() {

  }

}
</script>

<style>

</style>
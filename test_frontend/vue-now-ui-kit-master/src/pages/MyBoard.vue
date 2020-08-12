<template>
  <div>
    <MyPicture/>
    <MyInput class="container"/>
    <MyCheckbox/>
    <Article/>
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
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
    MyPicture,
    MyCheckbox,
    MyInput,
    Article,
  },
}
</script>

<style>

</style>
<template>
  <div>
    <div class="page-header page-header-small">
      <parallax
        class="page-header-image"
        style="background-image: url('img/way1.jfif')"
      >
      </parallax>
      <div class="content-center">
        <div class="container">
          <h1 class="title">미남이의 블로그</h1>
          <div class="text-center"> </div>
        </div>
      </div>
    </div>
   
 
    
  </div>
</template>
<script>
import { Button, FormGroupInput } from '@/components';
export default {
  name: 'myhome',
  bodyClass: 'myhome-page',
  components: {
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput
  },
  data() {
    return {
      form: {
        firstName: '',
        email: '',
        message: ''
      }
    };
  }
};
</script>
<style></style>

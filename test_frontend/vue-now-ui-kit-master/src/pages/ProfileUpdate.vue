<template>
    <div class="d-inline">

        <b-button class="btn btn-primary btn-round btn-lg" v-b-modal.modal-prevent-closing>내 정보 수정</b-button>

        <b-modal
        id="modal-prevent-closing"
        ref="modal"
        title="Profile"
        hide-footer
        >
        <form ref="form" @submit.stop.prevent="handleSubmit">
            <b-form-group
                label="NICKNAME"
                label-for="name-input"
            >
            <b-form-input
                id="name-input"
                v-model="userData.name"
                required
            ></b-form-input>
            </b-form-group>

            <b-form-group
                label="PHONE"
                label-for="phone-input"
            >
            <b-form-input
                type="text"
                id="phone-input"
                v-model="userData.phone"
                required
            ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-3" label="관심사1" label-for="inter1-input">
              <b-form-select
                id="inter1-input"
                v-model="userData.interest1"
                :options="interests"
                required
              ></b-form-select>
            </b-form-group>

            <b-form-group id="input-group-3" label="관심사2" label-for="inter1-input" description="관심사 1과 달라야 합니다">
              <b-form-select
                id="inter1-input"
                v-model="userData.interest2"
                :options="interests"
                required
              ></b-form-select>
            </b-form-group>


            <b-button class="mt-3" block @click=handleSubmit>Update</b-button>
        </form>
        </b-modal>
    </div>

</template>

<script>
import axios from 'axios'
import { sync } from 'vuex-pathify'

const API_URL = 'http://localhost:8080/'

export default {
    name: 'ProfileUpdate',

    data() {
      return {
        interests: [
          { text: '취업 관심 분야를 고르세요', value: '' },
          '서비스업',
          '제조·화학',
          'IT·웹·통신',
          '은행·금융업',
          '미디어·디자인',
          '교육업',
          '의료·제약·복지',
          '판매·유통',
          '건설업',
          '기관·협회',
        ],
      }
    },
    
    props: ['userData'],

    computed: {
        curUid: sync('curUid')
    },

    methods: {
        handleSubmit() {
            // Exit when the form isn't valid
            if (this.userData.interest1 === this.userData.interest2) {
                alert('서로 다른 관심사를 선택해주세요')
                return
            }

            var putData = {
                email: this.userData.email,
                uid: this.userData.uid,
                password: this.userData.password,
                name: this.userData.name,
                phone: this.userData.phone,
                interest1: this.userData.interest1,
                interest2: this.userData.interest2,
                description: this.userData.description,
                img: this.userData.img,    
            }

            console.log(putData)
            
            const url = `${API_URL}account/update`

            axios.put(url, putData)
            .then(res => {
                this.$nextTick(() => {
                this.$bvModal.hide('modal-prevent-closing')
                })
                console.log('profile_update_success')
                this.$router.push('/profile')
            })
            .catch(() => {
                alert('회원정보 수정 권한이 없습니다.')
                return
            })
            
        },
    }
}
</script>

<style>

</style>